package jetbrains.mps.ide;

import jetbrains.mps.components.DefaultExternalizableComponent;
import jetbrains.mps.components.Externalizable;

import java.util.HashMap;
import java.awt.Dimension;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 22.09.2005
 * Time: 19:06:56
 * To change this template use File | Settings | File Templates.
 */
public class DialogDimensionsSettings extends DefaultExternalizableComponent {
  private
  @Externalizable
  HashMap<String, DialogDimensions> myDialogsDimensions = new HashMap<String, DialogDimensions>();

  protected DialogDimensions getDimensionSettings(Class<? extends BaseDialog> cls) {
    return myDialogsDimensions.get(cls.getName());
  }

  protected void saveDimensionSettings(int left, int top, int width, int height, Class<? extends BaseDialog> cls) {
    DialogDimensions dialogDimensions = new DialogDimensions(left, top, width, height);
    myDialogsDimensions.put(cls.getName(), dialogDimensions);
  }

  public static class DialogDimensions {
    public int myTop;
    public int myLeft;
    public int myWidth;
    public int myHeight;

    public DialogDimensions(int left, int top, int width, int height) {
      myHeight = height;
      myWidth = width;
      myLeft = left;
      myTop = top;
    }

    public Dimension getDimensions() {
      return new Dimension(myWidth, myHeight);
    }
  }
}
