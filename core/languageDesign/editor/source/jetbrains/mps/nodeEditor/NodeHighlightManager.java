/*
 * Copyright 2003-2010 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.nodeEditor;

import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.reloading.ReloadAdapter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.ManyToManyMap;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.EditorComponent.RebuildListener;
import jetbrains.mps.nodeEditor.inspector.InspectorEditorComponent;

import java.awt.Color;
import java.util.*;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map.Entry;

import org.jetbrains.annotations.NotNull;


public class NodeHighlightManager implements EditorMessageOwner {
  private final Object myMessagesLock = new Object();
  private final Object myRebuildCacheFlagsLock = new Object();

  @NotNull
  private EditorComponent myEditor;
  private Set<EditorMessage> myMessages = new HashSet<EditorMessage>();
  private Map<EditorMessageOwner, Set<EditorMessage>> myOwnerToMessages = new HashMap<EditorMessageOwner, Set<EditorMessage>>();
  private ManyToManyMap<EditorMessage, SNode> myMessagesToNodes = new ManyToManyMap<EditorMessage, SNode>();

  /**
   * by design my***Cache should be accessed in EDT only
   * myRebuild***CacheFlag is synchronized using myRebuildCacheFlagsLock
   */
  private Map<EditorCell, List<EditorMessage>> myMessagesCache = new HashMap<EditorCell, List<EditorMessage>>();
  private boolean myRebuildMessagesCacheFlag;
  public ReloadAdapter myHandler;
  private Collection<EditorMessageIconRenderer> myIconRenderersCache = new LinkedList();
  private boolean myRebuildIconRenderersCacheFlag;

  public NodeHighlightManager(@NotNull EditorComponent edtitor) {
    myEditor = edtitor;
    myHandler = new ReloadAdapter() {
      public void onReload() {
        clear();
      }
    };

    edtitor.addRebuildListener(new RebuildListener() {
      public void editorRebuilt(EditorComponent editor) {
        // will be executed in EDT
        for (EditorCell cell : myMessagesCache.keySet()) {
          if (!myEditor.isValid(cell)) {
            rebuildMessages();
            return;
          }
        }
      }
    });


    ClassLoaderManager.getInstance().addReloadHandler(myHandler);
  }

  /**
   * scheduling lazy rebuild of myMessagesCache and myIconRenderersCache
   * this method can be called from any thread 
   */
  public void rebuildMessages() {
    synchronized (myRebuildCacheFlagsLock) {
      myRebuildMessagesCacheFlag = true;
      myRebuildIconRenderersCacheFlag = true;
    }
  }

  private Map<EditorCell, List<EditorMessage>> getMessagesCache() {
    synchronized (myRebuildCacheFlagsLock) {
      if (!myRebuildMessagesCacheFlag) {
        return myMessagesCache;
      }
      myRebuildMessagesCacheFlag = false;
    }
    myMessagesCache.clear();
    synchronized (myMessagesLock) {
      if (myEditor.getRootCell() != null && !myMessages.isEmpty()) {
        rebuildMessages(myEditor.getRootCell());
      }
    }
    return myMessagesCache;
  }

  private void rebuildMessages(EditorCell root) {
    List<EditorMessage> messages = calculateMessages(root);
    if (!messages.isEmpty()) {
      myMessagesCache.put(root, messages);
    }

    if (root instanceof EditorCell_Collection) {
      EditorCell_Collection collection = (EditorCell_Collection) root;
      for (EditorCell cell : collection.getCells()) {
        rebuildMessages(cell);
      }
    }
  }

  public List<EditorMessage> getMessages(EditorCell cell) {
    List<EditorMessage> result = getMessagesCache().get(cell);
    if (result != null) {
      return new ArrayList<EditorMessage>(result);
    }
    return Collections.<EditorMessage>emptyList();
  }

  private List<EditorMessage> calculateMessages(EditorCell cell) {
    final SNode node = cell.getSNode();
    final List<EditorMessage> result = new ArrayList<EditorMessage>();
    if (node == null) return result;
    Set<EditorMessage> messageSet = myMessagesToNodes.getBySecond(node);
    for (EditorMessage message : messageSet) {
      if (message.acceptCell(cell, myEditor)) {
        result.add(message);
      }
    }
    if (myEditor.getRootCell() != cell || !(myEditor instanceof InspectorEditorComponent)) {
      // the condition above is because an inspector for the node
      // does not have cells for some node's children (they are edited in main editor)
      // but the cell should not be highlighted only because of this
      if (cell.isBigCell()) {
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            for (SNode child : node.getChildren()) {
              EditorCell cellForChild = myEditor.findNodeCell(child);
              if (cellForChild == null) {
                getMessagesFromDescendants(child, result);
              }
            }
          }
        });
      }
    }
    return result;
  }

  private void getMessagesFromDescendants(SNode nodeWithoutCell, List<EditorMessage> messages) {
    messages.addAll(myMessagesToNodes.getBySecond(nodeWithoutCell));
    for (SNode descendant : nodeWithoutCell.getDescendants()) {
      messages.addAll(myMessagesToNodes.getBySecond(descendant));
    }
  }

  private void addMessage(EditorMessage m) {
    EditorMessageOwner owner = m.getOwner();
    if (!myOwnerToMessages.containsKey(owner)) {
      myOwnerToMessages.put(owner, new HashSet<EditorMessage>());
    }
    myOwnerToMessages.get(owner).add(m);
    myMessages.add(m);

    myMessagesToNodes.addLink(m, m.getNode());
  }

  private boolean removeMessage(EditorMessage m) {
    if (m == null) {
      return false;
    }
    EditorMessageOwner owner = m.getOwner();
    Set<EditorMessage> messages = myOwnerToMessages.get(owner);
    if (messages != null) {
      messages.remove(m);
      if (messages.isEmpty()) {
        myOwnerToMessages.remove(owner);
      }
    }
    myMessages.remove(m);
    myEditor.getMessagesGutter().remove(m);

    myMessagesToNodes.clearFirst(m);
    return true;
  }

  public void mark(EditorMessage message, boolean repaintAndRebuild) {
    for (EditorMessage msg : getMessages()) {
      if (msg.sameAs(message)) return;
    }

    synchronized (myMessagesLock) {
      addMessage(message);
    }
    rebuildMessages();
    myEditor.getMessagesGutter().add(message);
    if (repaintAndRebuild) {
      repaintAndRebuildEditorMessages();
    }
  }

  // not used anymore?
  @Deprecated
  public void unmark(EditorMessage message) {
    unmark(message, true);
  }

  public void unmark(EditorMessage message, boolean repaintAndRebuild) {
    boolean wasRemoved;
    synchronized (myMessagesLock) {
      wasRemoved = removeMessage(message);
    }
    if (wasRemoved) {
      rebuildMessages();
    }
    myEditor.getMessagesGutter().remove(message);
    if (repaintAndRebuild) {
      repaintAndRebuildEditorMessages();
    }
  }

  private void clear() {
    synchronized (myMessagesLock) {
      for (EditorMessage m : new ArrayList<EditorMessage>(myMessages)) {
        removeMessage(m);
      }
    }
    rebuildMessages();
    repaintAndRebuildEditorMessages();
  }

  public boolean clearForOwner(EditorMessageOwner owner) {
    return clearForOwner(owner, true);
  }

  public boolean clearForOwner(EditorMessageOwner owner, boolean repaintAndRebuild) {
    boolean result = myEditor.getMessagesGutter().removeMessages(owner);
    boolean wasRemoved = false;
    synchronized (myMessagesLock) {
      if (myOwnerToMessages.containsKey(owner)) {
        ArrayList<EditorMessage> messages = new ArrayList<EditorMessage>(myOwnerToMessages.get(owner));
        for (EditorMessage m : messages) {
          wasRemoved = removeMessage(m) || wasRemoved;
        }
      }
    }
    if (wasRemoved) {
      rebuildMessages();
    }
    if (repaintAndRebuild) {
      repaintAndRebuildEditorMessages();
    }
    return result;
  }

  /**
   * perform refresh of messages visible in LeftEditorHighlighter
   * and repaint associated EditorComponent
   */
  public void repaintAndRebuildEditorMessages() {
    ModelAccess.instance().runReadInEDT(new Runnable() {
      public void run() {
        refreshLeftHighlighterMessages();
        myEditor.getExternalComponent().repaint();
      }
    });
  }

  // Should be called in EDT only
  private void refreshLeftHighlighterMessages() {
    synchronized (myRebuildCacheFlagsLock) {
      if (!myRebuildIconRenderersCacheFlag) {
        return;
      }
      myRebuildIconRenderersCacheFlag = false;
    }
    myEditor.getLeftEditorHighlighter().removeAllIconRenderers(myIconRenderersCache);
    myIconRenderersCache.clear();
    synchronized (myMessagesLock) {
      for (EditorMessage message : myMessages) {
        if (message instanceof EditorMessageIconRenderer) {
          myIconRenderersCache.add((EditorMessageIconRenderer) message);
        }
      }
    }
    myEditor.getLeftEditorHighlighter().addAllIconRenderers(myIconRenderersCache);
  }

  /**
   * TODO: modify this method to call mark(..., false)
   */
  public void mark(SNode node, Color color, String messageText, EditorMessageOwner owner) {
    if (node == null) return;
    mark(new DefaultEditorMessage(node, color, messageText, owner), true);
  }

  public void mark(List<EditorMessage> messages) {
    mark(messages, true);
  }

  private void mark(List<EditorMessage> messages, boolean repaintAndRebuild) {
    for (int i = 0; i < messages.size(); i++) {
      mark(messages.get(i), false);
    }
    if (repaintAndRebuild) {
      repaintAndRebuildEditorMessages();
    }
  }

  // not used anymore?
  @Deprecated
  public void mark(EditorMessage message) {
    mark(message, true);
  }

  public Set<EditorMessage> getMessages() {
    Set<EditorMessage> result = new HashSet<EditorMessage>();
    synchronized (myMessagesLock) {
      result.addAll(myMessages);
    }
    return result;
  }

  // not used anymore?
  @Deprecated
  public Color getColorFor(SNode node) {
    synchronized (myMessagesLock) {
      for (EditorMessage msg : myMessages) {
        if (msg.getNode() == node) return msg.getColor();
      }
    }
    return null;
  }

  public EditorMessage getMessageFor(SNode node) {
    synchronized (myMessagesLock) {
      for (EditorMessage msg : myMessages) {
        if (msg.getNode() == node) return msg;
      }
    }
    return null;
  }

  public List<EditorMessage> getMessagesFor(SNode node) {
    List<EditorMessage> result = new ArrayList<EditorMessage>();
    synchronized (myMessagesLock) {
      result.addAll(myMessagesToNodes.getBySecond(node));
    }
    return result;
  }

  public List<EditorMessage> getMessagesFor(SNode node, EditorMessageOwner owner) {
    List<EditorMessage> result = new ArrayList<EditorMessage>();
    synchronized (myMessagesLock) {
      for (EditorMessage message : myMessagesToNodes.getBySecond(node)) {
        if (message.getOwner() == owner) {
          result.add(message);
        }
      }
    }
    return result;
  }

  public void dispose() {
    ClassLoaderManager.getInstance().removeReloadHandler(myHandler);
  }

  public EditorCell getCell(EditorMessage change) {
    for (Entry<EditorCell, List<EditorMessage>> e: getMessagesCache().entrySet()) {
      if (e.getValue().contains(change)) {
        return e.getKey();
      }
    }
    return null;
  }

}
