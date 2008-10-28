package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.INamedConcept;

public interface IFeature extends INamedConcept {
  public static final String concept = "jetbrains.mps.ypath.structure.IFeature";
  public static final String WRITABLE = "writable";
  public static final String DEFAULT = "default";
  public static final String ASCENDING = "ascending";
  public static final String OPPOSITE = "opposite";

  public boolean getWritable();

  public void setWritable(boolean value);

  public boolean getDefault();

  public void setDefault(boolean value);

  public boolean getAscending();

  public void setAscending(boolean value);

  public IFeature getOpposite();

  public void setOpposite(IFeature node);

}
