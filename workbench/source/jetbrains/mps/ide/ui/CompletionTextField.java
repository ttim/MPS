package jetbrains.mps.ide.ui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public abstract class CompletionTextField extends JTextField {
  private PopupHint myHint = new PopupHint();
  private Window myContainerWindow;
  private ComponentListener myListener = new ComponentAdapter() {
    public void componentMoved(ComponentEvent e) {
      myHint.updateBounds();
    }
  };
  private MouseListener myMouseListener = new MouseAdapter() {
    public void mousePressed(MouseEvent e) {
      myHint.hide();
      e.consume();
    }
  };

  private UpAction myUpAction = new UpAction();
  private DownAction myDownAction = new DownAction();

  public CompletionTextField() {
    super(20);

    getDocument().addDocumentListener(new DocumentListener() {
      public void insertUpdate(DocumentEvent e) {
        updatePopup();
      }

      public void removeUpdate(DocumentEvent e) {
        if (isCanShowCompletionOnRemove()) {
          updatePopup();
        }
        updateActions();
      }

      public void changedUpdate(DocumentEvent e) {
        updatePopup();
      }

      private void updatePopup() {
        if (myHint.isVisible() || canShowPopupAutomatically()) {
          updateCompletion();
        }
        updateActions();
      }
    });

    addCaretListener(new CaretListener() {
      public void caretUpdate(CaretEvent e) {
        if (isFocusOwner() && myHint.isVisible()) {
          updateCompletion();
        }
      }
    });


    addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && e.getModifiers() == 0 && myHint.isVisible()) {
          myHint.complete();
          e.consume();
        }
      }
    });

    registerKeyboardAction(myUpAction, KeyStroke.getKeyStroke("UP"), WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    registerKeyboardAction(myDownAction, KeyStroke.getKeyStroke("DOWN"), WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    registerKeyboardAction(new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        myHint.show();
        updateCompletion();
      }
    }, KeyStroke.getKeyStroke("control SPACE"), WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE && myHint.isVisible()) {
          myHint.hide();
          e.consume();
        }
      }
    });

    addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent e) {
        myHint.hide();
      }
    });

    updateActions();
  }

  protected boolean canShowPopupAutomatically() {
    return true;
  }

  public void setHideComplitionOnClick(boolean hide) {
    if (hide) {
      addMouseListener(myMouseListener);
      getParent().addMouseListener(myMouseListener);
    } else {
      removeMouseListener(myMouseListener);
      getParent().removeMouseListener(myMouseListener);
    }
  }
  
  public void addNotify() {
    super.addNotify();
    myContainerWindow = SwingUtilities.getWindowAncestor(this);
    myContainerWindow.addComponentListener(myListener);
  }

  public void removeNotify() {
    myContainerWindow.removeComponentListener(myListener);
    super.removeNotify();
  }

  protected abstract List<String> getProposals(String text);

  private String getTextPrefix() {
    try {
      if (getCaretPosition() >= getText().length()) {
        return getText();
      }
      return getText(0, getCaretPosition());
    } catch (BadLocationException e) {
      throw new RuntimeException(e);
    }
  }

  public boolean isValid() {
    return true;
  }

  public boolean completionIsVisible() {
    return myHint.isVisible();
  }

  public void showCompletion() {
    updateCompletion();
  }

  private void updateCompletion() {
    if (isValid()) {
      setForeground(Color.BLACK);
    } else {
      setForeground(Color.RED);
    }

    if (!isShowing()) {
      return;
    }

    List<String> proposals = getProposals(getTextPrefix());

    if (proposals.isEmpty()) {
      myHint.hide();
      return;
    }

    if (proposals.contains(getTextPrefix())) {
      myHint.hide();
      return;
    }

    if (!myHint.isVisible()) {
      myHint.show();
    }

    myHint.setProposals(proposals);
  }

  protected boolean isCanShowCompletionOnRemove() {
    return true;
  }

  private void updateActions() {
    myUpAction.setEnabled(myHint.isVisible());
    myDownAction.setEnabled(myHint.isVisible() || canShowPopupAutomatically());

    System.out.println("up enabled = " + myUpAction.isEnabled());
    System.out.println("down enabled = " + myDownAction.isEnabled());
  }

  private class PopupHint {
    private JWindow myWindow;
    private JScrollPane myScroller;
    private JList myList;

    private PopupHint() {
    }

    boolean isVisible() {
      return myWindow != null;
    }

    void show() {
      if (myWindow != null) {
        return;
      }

      Window windowAncestor = SwingUtilities.getWindowAncestor(CompletionTextField.this);

      myWindow = new JWindow(windowAncestor);
      myWindow.setFocusableWindowState(false);

      myWindow.setLayout(new BorderLayout());
      myList = new JList();
      myScroller = new JScrollPane(myList);

      myList.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          if (e.getClickCount() == 2 && myList.getSelectedValue() != null) {
            setText((String) myList.getSelectedValue());
          }
        }
      });

      myWindow.add(myScroller);

      updateBounds();

      myWindow.setVisible(true);

      updateActions();
    }

    void updateBounds() {
      if (myWindow == null) return;

      Point loc = getLocationOnScreen();
      myWindow.setBounds(
        loc.x,
        loc.y + getHeight(),
        getWidth(),
        myScroller.getPreferredSize().height
      );
    }

    void setProposals(List<String> proposals) {
      DefaultListModel model = new DefaultListModel();
      for (String proposal : proposals) {
        model.addElement(proposal);
      }

      myList.setModel(model);
    }

    void hide() {
      if (myWindow != null) {
        myWindow.dispose();
        myWindow = null;
      }

      updateActions();
    }

    void up() {
      if (!isVisible()) {
        return;
      }

      if (myList.getSelectedIndex() == -1) {
        myList.setSelectedIndex(0);
      } else {
        myList.setSelectedIndex(Math.max(0, myList.getSelectedIndex() - 1));
      }
      myList.ensureIndexIsVisible(myList.getSelectedIndex());


    }

    void down() {
      if (!isVisible()) {
        return;
      }
      if (myList.getSelectedIndex() == -1) {
        myList.setSelectedIndex(0);
      } else {
        myList.setSelectedIndex(Math.min(myList.getModel().getSize() - 1, myList.getSelectedIndex() + 1));
      }
      myList.ensureIndexIsVisible(myList.getSelectedIndex());
    }

    void complete() {
      if (!isVisible()) {
        return;
      }

      if (myList.getSelectedIndex() == -1) {
        return;
      } else {
        setText(myList.getSelectedValue().toString());
        setCaretPosition(getText().length());
      }
    }
  }

  private class DownAction extends AbstractAction {
    public void actionPerformed(ActionEvent e) {
      if (myHint.isVisible()) {
        myHint.down();
      } else {
        if (canShowPopupAutomatically()) {
          myHint.show();
          updateCompletion();
        }
      }
    }
  }

  private class UpAction extends AbstractAction {
    public void actionPerformed(ActionEvent e) {
      if (myHint.isVisible()) {
        myHint.up();
      }
    }
  }

}
