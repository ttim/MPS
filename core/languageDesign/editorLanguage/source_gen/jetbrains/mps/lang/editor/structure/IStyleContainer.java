package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.INodeAdapter;
import java.util.Iterator;
import java.util.List;

public interface IStyleContainer extends INodeAdapter {
  public static final String concept = "jetbrains.mps.lang.editor.structure.IStyleContainer";
  public static String STYLE_ITEM = "styleItem";

  public int getStyleItemsCount();

  public Iterator<StyleClassItem> styleItems();

  public List<StyleClassItem> getStyleItems();

  public void addStyleItem(StyleClassItem node);

  public void insertStyleItem(StyleClassItem prev, StyleClassItem node);

}
