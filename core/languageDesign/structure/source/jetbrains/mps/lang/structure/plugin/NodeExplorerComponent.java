/*
 * Copyright 2003-2009 JetBrains s.r.o.
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
package jetbrains.mps.lang.structure.plugin;

import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.typesystem.uiActions.PresentationManager;
import jetbrains.mps.ide.projectPane.Icons;
import jetbrains.mps.ide.ui.MPSTree;
import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.ide.ui.TextTreeNode;
import jetbrains.mps.ide.ui.ErrorState;
import jetbrains.mps.ide.ui.smodel.SNodeTreeNode;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.ProjectOperationContext;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.constraints.ConstraintsChecker;
import jetbrains.mps.nodeEditor.EditorMessage;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;

import com.intellij.util.containers.HashMap;

public class NodeExplorerComponent {
  private MyTree myTree = new MyTree();
  private SNodePointer myNode;
  private JScrollPane myScrollPane;

  public NodeExplorerComponent() {
    myScrollPane = new JScrollPane(myTree);
    myTree.setRootVisible(true);
  }

  public JComponent getComponent() {
    return myScrollPane;
  }

  public void showNode(SNode node, MPSProject project) {
    myNode = node == null ? null : new SNodePointer(node);
    myTree.setOperationContext(new ProjectOperationContext(project));
    myTree.rebuildNow();
  }

  public void clear() {
    myNode = null;
    myTree.rebuildLater();
  }

  private class MyTree extends MPSTree {
    private IOperationContext myOperationContext;
    private AncestorNodeContext myAncestorNodeContext;

    protected MPSTreeNode rebuild() {
      myAncestorNodeContext = new AncestorNodeContext(myNode, myOperationContext);
      if (myNode == null || myNode.getNode() == null) {
        return new TextTreeNode("no node");
      } else {
        myAncestorNodeContext.collectModelConstraintsErrors();
        TextTreeNode textTreeNode = new TextTreeNode("node");
        SNodeTreeNode sNodeTreeNode = new MySNodeTreeNode(myNode.getNode(), myOperationContext, myAncestorNodeContext);
        textTreeNode.add(sNodeTreeNode);
        return textTreeNode;
      }
    }

    public void setOperationContext(IOperationContext operationContext) {
      myOperationContext = operationContext;
    }


  }

  private class AncestorNodeContext {
    private Map<SNode, Set<EditorMessage>> myModelConstraintsMessages = new HashMap<SNode, Set<EditorMessage>>();
    private Map<SNode, Set<EditorMessage>> myModelConstraintsMessagesOfDescendants = new HashMap<SNode, Set<EditorMessage>>();
    private SNodePointer myNode;
    private IOperationContext myOperationContext;

    public AncestorNodeContext(SNode ancestorNode, IOperationContext operationContext) {
      myNode = new SNodePointer(ancestorNode);
      myOperationContext = operationContext;
    }

    public AncestorNodeContext(SNodePointer ancestorNode, IOperationContext operationContext) {
      myNode = ancestorNode;
      myOperationContext = operationContext;
    }

    private void collectModelConstraintsErrors() {
      Set<EditorMessage> messages = new ConstraintsChecker().messagesForNodeAndDescendants(myNode.getNode(), myOperationContext);
      for (EditorMessage message : messages) {
        SNode node = message.getNode();
        if (node != null) {
          Set<EditorMessage> existingMessages = myModelConstraintsMessages.get(node);
          if (existingMessages == null) {
            existingMessages = new HashSet<EditorMessage>();
            myModelConstraintsMessages.put(node, existingMessages);
          }
          existingMessages.add(message);
          while (node.getParent() != null) {
            node = node.getParent();
            Set<EditorMessage> existingMessagesOfDescendants = myModelConstraintsMessagesOfDescendants.get(node);
            if (existingMessagesOfDescendants == null) {
              existingMessagesOfDescendants = new HashSet<EditorMessage>();
              myModelConstraintsMessagesOfDescendants.put(node, existingMessagesOfDescendants);
            }
            existingMessagesOfDescendants.add(message);
          }
        }
      }
    }
  }

  private class MySNodeTreeNode extends SNodeTreeNode {
    AncestorNodeContext myAncestorNodeContext;

    public MySNodeTreeNode(SNode node, IOperationContext operationContext, AncestorNodeContext ancestorNodeContext) {
      super(node, operationContext);
      myAncestorNodeContext = ancestorNodeContext;
      collectModelConstraintsErrors();
    }

    public MySNodeTreeNode(SNode node, String role, IOperationContext operationContext, AncestorNodeContext ancestorNodeContext) {
      super(node, role, operationContext);
      myAncestorNodeContext = ancestorNodeContext;
      collectModelConstraintsErrors();
    }


    private void collectModelConstraintsErrors() {
      Set<EditorMessage> messages = myAncestorNodeContext.myModelConstraintsMessages.get(getSNode());
      if (messages == null) {
        messages = new HashSet<EditorMessage>();
      }
      Set<EditorMessage> descendantsMessages = myAncestorNodeContext.myModelConstraintsMessagesOfDescendants.get(getSNode());
      if (descendantsMessages == null) {
        descendantsMessages = new HashSet<EditorMessage>();
      }
      setErrorState(messages.isEmpty() && descendantsMessages.isEmpty() ? ErrorState.NONE : ErrorState.ERROR);
      if (messages.isEmpty()) {
        setTooltipText(null);
      } else {
        String result = "<html>";
        for (EditorMessage editorMessage : messages) {
          result += editorMessage.getMessage() + "<br>";
        }
        setTooltipText(result);
      }
    }

    protected void doUpdatePresentation() {
      super.doUpdatePresentation();
      String string = getText();
      String typeInfo = " {" + PresentationManager.toString(TypeChecker.getInstance().getTypeOf(getSNode())) + "}";
      setText(string + typeInfo);
    }

    protected void doInit() {
      this.removeAllChildren();

      add(new TextTreeNode("Concept = " + getSNode().getConceptFqName()));

      if (getSNode() == null) return;
      for (SNode childNode : getSNode().getChildren()) {
        add(new MySNodeTreeNode(childNode, childNode.getRole_(), getOperationContext(), myAncestorNodeContext));
      }
      add(new MyPropertiesNode(getSNode(), getOperationContext()));
      add(new MyReferentsNode(getSNode(), getOperationContext()));
      myInitialized = true;
    }
  }

  private class MyReferentsNode extends TextTreeNode {
    private SNodePointer myNode;
    private boolean myIsInitialized = false;

    public MyReferentsNode(SNode node, IOperationContext operationContext) {
      super("referents", operationContext);
      myNode = new SNodePointer(node);
    }

    protected void doInit() {
      for (SReference reference : myNode.getNode().getReferences()) {
        SNode referent = reference.getTargetNode();
        if (referent != null) {
          AncestorNodeContext ancestorNodeContext = new AncestorNodeContext(referent, getOperationContext());
          ancestorNodeContext.collectModelConstraintsErrors();
          add(new MySNodeTreeNode(referent, reference.getRole(), getOperationContext(), ancestorNodeContext));
        }
      }
      myIsInitialized = true;
    }

    public boolean isInitialized() {
      return myIsInitialized;
    }
  }

  private class MyPropertiesNode extends TextTreeNode {
    private SNodePointer myNode;
    private boolean myIsInitialized = false;

    public MyPropertiesNode(SNode node, IOperationContext operationContext) {
      super("properties", operationContext);
      myNode = new SNodePointer(node);
    }

    protected void doInit() {
      SNode node = myNode.getNode();
      for (String propertyName : node.getProperties().keySet()) {
        String value = node.getProperty(propertyName);
        add(new TextTreeNode(propertyName + " : " + value) {
          {
            setIcon(Icons.DEFAULT_ICON);
          }
        });
      }
      myIsInitialized = true;
    }

    public boolean isInitialized() {
      return myIsInitialized;
    }
  }
}
