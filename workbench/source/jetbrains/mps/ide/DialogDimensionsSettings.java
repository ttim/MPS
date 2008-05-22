package jetbrains.mps.ide;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import jetbrains.mps.ide.DialogDimensionsSettings.MyState;

import java.awt.Dimension;
import java.util.HashMap;


@State(
  name = "DialogDimensionsSettings",
  storages = {
  @Storage(
    id = "other",
    file = "$APP_CONFIG$/mpsDialogDimensionSettings.xml"
  )}
)
@Deprecated
public class DialogDimensionsSettings implements PersistentStateComponent<MyState> {
  public static DialogDimensionsSettings getInstance() {
    return ApplicationManager.getApplication().getComponent(DialogDimensionsSettings.class);
  }

  private MyState myState = new MyState();

  protected DialogDimensions getDimensionSettings(Class<? extends BaseDialog> cls) {
    return myState.myDialogsDimensions.get(cls.getName());
  }

  protected void saveDimensionSettings(int left, int top, int width, int height, Class<? extends BaseDialog> cls) {
    DialogDimensions dialogDimensions = new DialogDimensions(left, top, width, height);
    myState.myDialogsDimensions.put(cls.getName(), dialogDimensions);
  }

  public MyState getState() {
    return myState;
  }

  public void loadState(MyState state) {
    myState = state;
  }

  public static class DialogDimensions {
    public int myTop;
    public int myLeft;
    public int myWidth;
    public int myHeight;

    public DialogDimensions() {
    }

    public DialogDimensions(int left, int top, int width, int height) {
      myHeight = height;
      myWidth = width;
      myLeft = left;
      myTop = top;
    }

    public Dimension getDimensions() {
      return new Dimension(myWidth, myHeight);
    }

    public int getTop() {
      return myTop;
    }

    public void setTop(int top) {
      myTop = top;
    }

    public int getLeft() {
      return myLeft;
    }

    public void setLeft(int left) {
      myLeft = left;
    }

    public int getWidth() {
      return myWidth;
    }

    public void setWidth(int width) {
      myWidth = width;
    }

    public int getHeight() {
      return myHeight;
    }

    public void setHeight(int height) {
      myHeight = height;
    }
  }

  public static class MyState {
    private HashMap<String, DialogDimensions> myDialogsDimensions = new HashMap<String, DialogDimensions>();

    public HashMap<String, DialogDimensions> getDialogsDimensions() {
      return myDialogsDimensions;
    }

    public void setDialogsDimensions(HashMap<String, DialogDimensions> dialogsDimensions) {
      myDialogsDimensions = dialogsDimensions;
    }
  }
}
