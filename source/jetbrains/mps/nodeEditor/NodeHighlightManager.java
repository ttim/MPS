package jetbrains.mps.nodeEditor;

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.ide.NodeGutterMessage;

import java.util.Set;
import java.util.HashSet;
import java.awt.*;


/**
 * @author Kostik
 */
public class NodeHighlightManager implements IGutterMessageOwner {
  public static final Color DEFAULT_BACKGROUND = new Color(0, 0, 0, 0);

  private AbstractEditorComponent myEditor;
  private Set<MyMessage> myMessages = new HashSet<MyMessage>();

  public NodeHighlightManager(AbstractEditorComponent edtitor) {
    myEditor = edtitor;
  }

  public void clear() {
    myEditor.getMessagesGutter().removeMessages(this);
    myMessages.clear();
  }

  public void mark(SNode node, Color color, String messageText) {
    MyMessage message = new MyMessage(node, color, messageText);

    for (MyMessage msg : myMessages) {
      if (msg.getNode() == node) return;
    }

    myMessages.add(message);
    myEditor.getMessagesGutter().add(message, this);
    myEditor.getMessagesGutter().repaint();
  }

  public Color getColorFor(SNode node) {
    for (MyMessage msg : myMessages) {
      if (msg.getNode() == node) return msg.getColor();
    }
    return DEFAULT_BACKGROUND;
  }

  private class MyMessage extends NodeGutterMessage {
    private Color myColor;
    private String myMessage;

    public MyMessage(SNode node, Color color, String message) {
      super(myEditor, node);
      myColor = color;
      myMessage = message;
    }

    public String getMessage() {
      return myMessage;
    }

    public Color getColor() {
      return myColor;
    }
  }
}
