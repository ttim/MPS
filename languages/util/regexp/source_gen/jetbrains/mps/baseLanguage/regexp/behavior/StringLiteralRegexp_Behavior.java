package jetbrains.mps.baseLanguage.regexp.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class StringLiteralRegexp_Behavior {
  private static Class[] PARAMETERS_1222431822198 = {SNode.class, List.class};
  private static Class[] PARAMETERS_4759120547781297313 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String virtual_getString_1222432436326(SNode thisNode, List<SNode> vars) {
    return StringLiteralRegexp_Behavior.call_toRegexp_8330008649152995372(thisNode, SPropertyOperations.getString(thisNode, "text"));
  }

  public static boolean virtual_isValid_4759120547781297301(SNode thisNode) {
    if (isEmpty_mq2s4l_a0a0c(SPropertyOperations.getString(thisNode, "text"))) {
      return false;
    }
    return StringLiteralRegexp_Behavior.call_toRegexp_8330008649152995372(thisNode, SPropertyOperations.getString(thisNode, "text")) != null;
  }

  public static String call_toRegexp_8330008649152995372(SNode thisNode, String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '\\') {
        sb.append(c);
        if (++i >= s.length()) {
          return null;
        }
        c = s.charAt(i);
        if (c == 'u') {
          sb.append(c);
          for (int e = 0; e < 4; e++) {
            if (++i >= s.length()) {
              return null;
            }
            c = s.charAt(i);
            if (!(StringLiteralRegexp_Behavior.isHexChar_8949395081772969908(c))) {
              return null;
            }
            sb.append(c);
          }
        } else if (Character.isDigit(c)) {
          sb.append(c);
          for (int e = 0; e < 2; e++) {
            if (++i >= s.length()) {
              return null;
            }
            c = s.charAt(i);
            if (!(Character.isDigit(c))) {
              return null;
            }
            sb.append(c);
          }
        } else if (c == 'n' || c == 't' || c == 'b' || c == 'f' || c == 'r' || c == '"' || c == '\'' || c == '\\') {
          sb.append(c);
        } else {
          return null;
        }
      } else if (c < 32) {
        return null;
      } else if (c < 128) {
        if (c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}' || c == '+' || c == '*' || c == '?' || c == '|' || c == '^' || c == '.' || c == '$') {
          sb.append('\\');
        }
        sb.append(c);
      } else {
        sb.append("\\u");
        String val = Integer.toString(c, 16);
        sb.append("0000".substring(val.length()) + val);
      }
    }
    return sb.toString();
  }

  public static String call_getString_1222431822198(SNode thisNode, List<SNode> vars) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.StringLiteralRegexp"), "virtual_getString_1222432436326", PARAMETERS_1222431822198, new Object[]{vars});
  }

  public static boolean call_isValid_4759120547781297313(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.StringLiteralRegexp"), "virtual_isValid_4759120547781297301", PARAMETERS_4759120547781297313, new Object[]{});
  }

  public static String callSuper_getString_1222431822198(SNode thisNode, String callerConceptFqName, List<SNode> vars) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.StringLiteralRegexp"), callerConceptFqName, "virtual_getString_1222432436326", PARAMETERS_1222431822198, new Object[]{vars});
  }

  public static boolean callSuper_isValid_4759120547781297313(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.regexp.structure.StringLiteralRegexp"), callerConceptFqName, "virtual_isValid_4759120547781297301", PARAMETERS_4759120547781297313, new Object[]{});
  }

  public static boolean isHexChar_8949395081772969908(char c) {
    return Character.isDigit(c) || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
  }

  public static boolean isEmpty_mq2s4l_a0a0c(String str) {
    return str == null || str.length() == 0;
  }
}
