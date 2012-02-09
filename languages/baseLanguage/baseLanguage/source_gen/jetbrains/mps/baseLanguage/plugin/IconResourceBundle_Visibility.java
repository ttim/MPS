package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.resourceBundles.IconResourceBundle;
import java.util.Map;
import javax.swing.Icon;
import java.util.HashMap;

public class IconResourceBundle_Visibility implements IconResourceBundle {
  private static IconResourceBundle_Visibility INSTANCE = new IconResourceBundle_Visibility();

  private Map<String, Icon> icons = new HashMap<String, Icon>() {
    {
      put("PACKAGE_LOCAL", IconContainer.ICON_a0_0);
      put("PUBLIC", IconContainer.ICON_a1_0);
      put("PRIVATE", IconContainer.ICON_a2_0);
      put("PROTECTED", IconContainer.ICON_a3);
    }
  };

  public IconResourceBundle_Visibility() {
  }

  public Iterable<String> getKeys() {
    return icons.keySet();
  }

  public Icon getResource(String key) {
    return icons.get(key);
  }

  public static IconResourceBundle_Visibility getInstance() {
    return INSTANCE;
  }
}
