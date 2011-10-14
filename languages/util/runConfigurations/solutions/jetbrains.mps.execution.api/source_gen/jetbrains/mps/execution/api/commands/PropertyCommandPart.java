package jetbrains.mps.execution.api.commands;

/*Generated by MPS */

import org.apache.commons.lang.StringUtils;

public class PropertyCommandPart extends AbstractCommandPart implements CommandPart {
  public PropertyCommandPart(String key, String value) {
    if (StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(value)) {
      addCommands("-D" + key + "=" + value);
    }
  }
}
