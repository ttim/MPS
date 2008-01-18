package jetbrains.mps.ide;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.ide.command.CommandProcessor;

/**
 * Created by IntelliJ IDEA.
* User: Cyril.Konopko
* Date: 11.01.2008
* Time: 19:03:10
* To change this template use File | Settings | File Templates.
*/
public abstract class ChooseItemComponent<Item> extends JPanel {
  private JTextField myTextField;
  private Map<String, Set<Item>> myItemsMap = new HashMap<String, Set<Item>>();
  private List<String> myNames = new ArrayList<String>();
  private boolean myShowAllOnEmptyText = false;
  private JList myList = new JList(new DefaultListModel());
  private String myHeader;
  private JComponent myHeaderLabel;
  private JPanel myMainPanel;
  private @Nullable JFrame myContainingFrame;

  public ChooseItemComponent(String header) {
    this(header, false);
  }

  public ChooseItemComponent(String header, boolean showAllOnEmptyText) {

    myHeader = header;
    myShowAllOnEmptyText = showAllOnEmptyText;

    setLayout(new BorderLayout());
    myHeaderLabel = new JPanel(new BorderLayout(10, 0));
    myHeaderLabel.add(new JLabel(myHeader), BorderLayout.WEST);
    myMainPanel = new JPanel(new GridLayout(2, 1));
    myMainPanel.add(myHeaderLabel);
    myMainPanel.add(myTextField = new JTextField(""));
    add(myMainPanel, BorderLayout.NORTH);
    myList.setFocusable(false);
    myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    setListCellRenderer(new ChooseItemWindowCellRenderer<Item>(this));
    myList.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          final Item selectedItem = (Item) myList.getSelectedValue();
          if (selectedItem == null) return;
          CommandProcessor.instance().executeLightweightCommand(new Runnable() {
            public void run() {
              doChoose(selectedItem);
            }
          });
          askForDispose();
        }
      }
    });
    add(new JScrollPane(myList), BorderLayout.CENTER);


    myMainPanel.registerKeyboardAction(new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        final Item selectedItem = (Item) myList.getSelectedValue();
        if (selectedItem == null) return;
        CommandProcessor.instance().executeCommand(new Runnable() {
          public void run() {
            doChoose(selectedItem);
          }
        });
        askForDispose();
      }
    }, KeyStroke.getKeyStroke("ENTER"), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    myMainPanel.registerKeyboardAction(new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        for (String name : myNames) {
          if (name != null && name.startsWith(myTextField.getText())) {
            myTextField.setText(name.toString());
            return;
          }
        }
      }
    }, KeyStroke.getKeyStroke("control SPACE"), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    myMainPanel.registerKeyboardAction(new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        int index = myList.getSelectedIndex();
        if (index == -1) return;
        myList.setSelectedIndex(Math.max((index - 1), 0));
        myList.ensureIndexIsVisible(myList.getSelectedIndex());
      }
    }, KeyStroke.getKeyStroke("UP"), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    myMainPanel.registerKeyboardAction(new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        int index = myList.getSelectedIndex();
        if (index == -1) return;
        myList.setSelectedIndex(Math.min((index + 1), myList.getModel().getSize() - 1));
        myList.ensureIndexIsVisible(myList.getSelectedIndex());
      }
    }, KeyStroke.getKeyStroke("DOWN"), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    myTextField.getDocument().addDocumentListener(new DocumentListener() {
      public void insertUpdate(DocumentEvent e) {
        updateState();
      }

      public void removeUpdate(DocumentEvent e) {
        updateState();
      }

      public void changedUpdate(DocumentEvent e) {
        updateState();
      }
    });
  }

  public void askForDispose() {
    if (myContainingFrame != null) {
      myContainingFrame.dispose();
    }
  }

  public abstract void doChoose(Item item);

  public void setListCellRenderer(ListCellRenderer cellRenderer) {
     if (cellRenderer != null) {
      myList.setCellRenderer(cellRenderer);
    }
  }

  protected String getItemPresentation(Item item) {
    return item.toString();
  }

  protected String getItemDescription(Item item) {
    return null;
  }

  protected Icon getItemIcon(Item item) {
    if (item instanceof SNode) {
      SNode node = (SNode) item;
      return IconManager.getIconFor(node);
    }
    return null;
  }

  protected Color getItemColor(Item item) {
    return Color.BLACK;
  }

  public JPanel getMainPanel() {
    return myMainPanel;
  }

  public JComponent getHeaderLabel() {
    return myHeaderLabel;
  }

  public JTextField getTextField() {
    return myTextField;
  }

  public JList getList() {
    return myList;
  }

  public List<String> getNames() {
    return myNames;
  }

  public Map<String, Set<Item>> getItemsMap() {
    return myItemsMap;
  }

  public void setContainingFrame(@Nullable ChooseItemWindow<Item> containingFrame) {
    myContainingFrame = containingFrame;
  }

  public void putItem(String name, Item item) {
    if (!myItemsMap.containsKey(name)) {
      myItemsMap.put(name, new HashSet<Item>());
    }
    myItemsMap.get(name).add(item);
  }

  public void makeNamesConsistent() {
    myNames.addAll(myItemsMap.keySet());
    Collections.sort(myNames);
  }

  public Pattern getItemPattern() {
    StringBuilder b = getExactItemPatternBuilder(myTextField.getText());
    b.append(".*");
    Pattern p = Pattern.compile(b.toString());
    return p;
  }


  protected void updateState() {
    DefaultListModel model = (DefaultListModel) myList.getModel();
    model.clear();
    boolean isMatchesSomething = false;
    if (myTextField.getText().length() > 0) {
      Matcher itemMatcher = getItemPattern().matcher("");
      outerLoop:
      for (String name : myNames) {
        itemMatcher.reset(name);
        if (itemMatcher.matches()) {
          if (!isMatchesSomething) {
            myTextField.setBackground(Color.WHITE);
            isMatchesSomething = true;
          }
          for (Item i : myItemsMap.get(name)) {
            model.addElement(i);
            if (model.size() > 42) break outerLoop;
          }
        }
      }
    } else if (myShowAllOnEmptyText) {
      myTextField.setBackground(Color.WHITE);
      isMatchesSomething = true;
      outerLoop:
      for (String name : myNames) {
        for (Item i : myItemsMap.get(name)) {
          model.addElement(i);
          if (model.size() > 42) break outerLoop;
        }
      }
    }

    if (!isMatchesSomething) {
      myTextField.setBackground(new Color(255, 220, 220));
    }

    Item oldSelection = (Item) myList.getSelectedValue();
    if ((oldSelection == null || !model.contains(oldSelection)) && model.size() > 0) {
      oldSelection = (Item) model.getElementAt(0);
    }

    myList.setSelectedValue(oldSelection, true);
  }

  public static StringBuilder getExactItemPatternBuilder(String text) {
    StringBuilder b = new StringBuilder();
    int state = 0;
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);

      switch (state) {
        case 0: // no quoting
          if (c == '*') {
            b.append(".*");
          } else if (c == '?') {
            b.append(".");
          } else if (c == '.') {
            b.append("[^\\.]*\\.");
          } else if (c == '@') {
            b.append("[^\\@\\.]*\\@");
          } else if (Character.isLetterOrDigit(c) || c == '_') {
            b.append(c);
            state = 2;
          } else {
            b.append("\\Q");
            b.append(c);
            state = 1;
          }
          break;
        case 1: // quoting
          if (c == '*') {
            b.append("\\E");
            b.append(".*");
            state = 0;
          } else if (c == '?') {
            b.append("\\E");
            b.append(".");
            state = 0;
          } else if (c == '.') {
            b.append("\\E");
            b.append("[^\\.]*\\.");
            state = 0;
          } else if (c == '@') {
            b.append("\\E");
            b.append("[^\\@\\.]*\\@");
            state = 0;
          } else if (Character.isLetterOrDigit(c) || c == '_') {
            b.append("\\E");
            b.append(c);
            state = 2;
          } else {
            b.append(c);
          }
          break;
        case 2: // Sequence of letters, digits and underscores
          if (c == '*') {
            b.append(".*");
            state = 0;
          } else if (c == '?') {
            b.append(".");
            state = 0;
          } else if (c == '.') {
            b.append("[^\\.]*\\.");
            state = 0;
          } else if (c == '@') {
            b.append("[^\\@\\.]*\\@");
            state = 0;
          } else if (Character.isUpperCase(c)) {
            b.append("[a-z0-9_]*");
            b.append(c);
          } else if (Character.isLetterOrDigit(c) || c == '_') {
            b.append(c);
          } else {
            b.append("\\Q");
            b.append(c);
            state = 1;
          }
          break;
      }
    }
    if (state == 1) {
      b.append("\\E");
    }
    return b;
  }
}
