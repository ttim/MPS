package jetbrains.mps.nodeEditor;

import jetbrains.mps.semanticModel.SemanticNode;
import jetbrains.mps.ide.command.CommandUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: Sergey Dmitriev.
 * Created Sep 16, 2003
 */
public class NodeSubstituteChooser {

  private PopupWindow myPopupWindow = null;
  private boolean isChooserActivated = false;
  private boolean isPopupActivated;

  private Point myPatternEditorLocation = new Point(10, 10);
  private Dimension myPatternEditorSize = new Dimension(50, 50);

  private AbstractEditorComponent myEditorComponent;
  private String[] myStrings;
  private NodeSubstitutePatternEditor myPatternEditor;
  private INodeSubstituteInfo myNodeSubstituteInfo;
  private List<INodeSubstituteAction> myMenuSubstituteEntries;
  private boolean myMenuEmpty;

  public NodeSubstituteChooser(AbstractEditorComponent editorComponent) {
    myEditorComponent = editorComponent;
  }

  private PopupWindow getPopupWindow() {
    if (myPopupWindow == null) {
      myPopupWindow = new PopupWindow(getEditorWindow());
    }
    return myPopupWindow;
  }

  private Window getEditorWindow() {
    Component component = myEditorComponent;
    while (!(component instanceof Window)) {
      component = component.getParent();
    }
    return (Window) component;
  }

  public void setLocationRelative(EditorCell cell) {
    Component component = cell.getEditorContext().getNodeEditorComponent();
    Point anchor = component.getLocationOnScreen();
    Point location = new Point(anchor.x + cell.getX(), anchor.y + cell.getY() + cell.getHeight());
    getPopupWindow().setLocation(location);

    myPatternEditorLocation = new Point(anchor.x + cell.getX(), anchor.y + +cell.getY());
    myPatternEditorSize = new Dimension(cell.getWidth() + 1, cell.getHeight());
  }

  public void setNodeSubstituteInfo(INodeSubstituteInfo nodeSubstituteInfo) {
    myNodeSubstituteInfo = nodeSubstituteInfo;
  }

  public void setPatternEditor(NodeSubstitutePatternEditor patternEditor) {
    myPatternEditor = patternEditor;
  }

  protected NodeSubstitutePatternEditor getPatternEditor() {
    if (myPatternEditor == null) {
      myPatternEditor = new NodeSubstitutePatternEditor();
    }
    return myPatternEditor;
  }

  public boolean isVisible() {
    return isChooserActivated;
  }

  public void setVisible(boolean b) {
    if (isChooserActivated != b) {
      if (b) {
        getPatternEditor().activate(getEditorWindow(), myPatternEditorLocation, myPatternEditorSize);
        myNodeSubstituteInfo.invalidateActions();
        rebuildMenuEntries();
        getPopupWindow().setSelectionIndex(0);
        getPopupWindow().relayout();
        getPopupWindow().setVisible(true);
        isPopupActivated = true;
      } else {
        getPopupWindow().setVisible(false);
        getPatternEditor().done();
        isPopupActivated = false;
      }
    }
    isChooserActivated = b;
  }

  private void rebuildMenuEntries() {
    myMenuEmpty = false;
    String pattern = getPatternEditor().getPattern();
    List<INodeSubstituteAction> matchingActions = myNodeSubstituteInfo.getMatchingActions(pattern);
    myMenuSubstituteEntries = new LinkedList<INodeSubstituteAction>(matchingActions);
    if (myMenuSubstituteEntries.size() == 0) {
      myMenuEmpty = true;
      myMenuSubstituteEntries.add(new AbstractNodeSubstituteAction() {
        public String getName() {
          return "No variants for \"" + getPatternEditor().getPattern() + "\"";
        }

        public SemanticNode doSubstitute(String pattern) {
          return null;
        }
      });
    }

    // cache strings
    myStrings = new String[myMenuSubstituteEntries.size()];
    for (int i = 0; i < myMenuSubstituteEntries.size(); i++) {
      INodeSubstituteAction entry = myMenuSubstituteEntries.get(i);
      myStrings[i] = entry.getName();
    }
  }

  protected String[] getStrings() {
    return myStrings;
  }

  public boolean processKeyPressed(KeyEvent keyEvent) {

    if (getPatternEditor().processKeyPressed(keyEvent)) {
      if (isPopupActivated) {
        rebuildMenuEntries();
        getPopupWindow().relayout();
        repaintPopupMenu();
      }
      return true;
    }

    if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
      setVisible(false);
      return true;
    }

    if (isPopupActivated) {
      return menu_processKeyPressed(keyEvent);
    }

    if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER || (keyEvent.getKeyCode() == KeyEvent.VK_SPACE && keyEvent.isControlDown())) {
      String pattern = getPatternEditor().getPattern();
      List<INodeSubstituteAction> matchingActions = myNodeSubstituteInfo.getMatchingActions(pattern);
      if (matchingActions.size() == 1) {
        setVisible(false);
        CommandUtil.substituteNode(matchingActions.get(0), pattern, myNodeSubstituteInfo, myEditorComponent.getContext());
      }
      return true;
    }
    return false;
  }

  private boolean menu_processKeyPressed(KeyEvent keyEvent) {
    String[] strings = getStrings();
    if (strings.length > 0) {
      if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
        getPopupWindow().setSelectionIndex(getPopupWindow().getSelectionIndex() - 1);
        repaintPopupMenu();
        if (!myMenuEmpty) {
          myPatternEditor.setText(getPopupWindow().getSelectedText());
          myPatternEditor.setCaretPosition(getPopupWindow().getSelectedText().length());
        }
        return true;
      }
      if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
        getPopupWindow().setSelectionIndex(getPopupWindow().getSelectionIndex() + 1);
        repaintPopupMenu();
        if (!myMenuEmpty) {
          myPatternEditor.setText(getPopupWindow().getSelectedText());
          myPatternEditor.setCaretPosition(getPopupWindow().getSelectedText().length());
        }
        return true;
      }
    }

    if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER || (keyEvent.getKeyCode() == KeyEvent.VK_SPACE && keyEvent.isControlDown())) {
      if (!myMenuEmpty) {
        String pattern = getPatternEditor().getPattern();
        INodeSubstituteAction entry = myMenuSubstituteEntries.get(myPopupWindow.getSelectionIndex());
        setVisible(false);
        CommandUtil.substituteNode(entry, pattern, myNodeSubstituteInfo, myEditorComponent.getContext());
      }
      return true;
    }
    return false;
  }

  private void repaintPopupMenu() {
    if (isPopupActivated) {
      getPopupWindow().repaint();
    }
  }

  private class PopupWindow extends JWindow {
    private int selectionIndex = 0;

    public PopupWindow(Window owner) {
      super(owner);
    }

    public int getSelectionIndex() {
      return selectionIndex;
    }

    public void setSelectionIndex(int index) {
      if (index < 0) {
        index = 0;
      }
      if (index >= getStrings().length) {
        index = getStrings().length - 1;
      }
      this.selectionIndex = index;
    }

    public void relayout() {
      setSelectionIndex(getSelectionIndex());
      String[] types = getStrings();
      int h = 0;
      int w = getWidth();
      for (int i = 0; i < types.length; i++) {
        String type = types[i];
        TextLine textLine = new TextLine(type, this);
        textLine.relayout();
        h += textLine.getHeight();
        w = Math.max(w, textLine.getWidth());
      }
      setSize(w, h);
    }

    public String getSelectedText() {
      String[] types = getStrings();
      return types[selectionIndex];
    }

    public void paint(Graphics g) {
      Rectangle bounds = g.getClipBounds();
      g.setColor(Color.CYAN);
      g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
      g.setColor(Color.GRAY);
      g.drawRect(bounds.x, bounds.y, bounds.width - 1, bounds.height - 1);

      String[] types = getStrings();
      int shiftX = 0;
      int shiftY = 0;
      for (int i = 0; i < types.length; i++) {
        String type = types[i];
        TextLine textLine = new TextLine(type, this);
        textLine.setSelectedBackgroundColor(Color.blue);
        textLine.setSelectedTextColor(Color.white);
        textLine.setTextColor(Color.black);
        textLine.setSelectedBorderColor(null);
        textLine.setBorderColor(null);
        textLine.setCaretEnabled(false);
        textLine.relayout();
        textLine.paint(g, shiftX, shiftY, i == selectionIndex, false);
        shiftY += textLine.getHeight();
      }
    }
  }
}
