package jetbrains.mps.bootstrap.editorLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SConceptOperations;
import java.awt.Color;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.EditorSettings;
import java.awt.Font;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class EditorCellModel_Behavior {
  public static Class[] PARAMETERS_1216737839993 = {SNode.class};
  public static Class[] PARAMETERS_1220339714057 = {SNode.class};
  public static Class[] PARAMETERS_1220339738643 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_useHorizontalInspector_1213877396707(SNode thisNode) {
    return true;
  }

  public static String call_getCellModelKind_1216811674575(SNode thisNode) {
    String result = SPropertyOperations.getString(SNodeOperations.getConceptDeclaration(thisNode), "name");
    if (result.startsWith("CellModel_")) {
      result = result.substring("CellModel_".length());
    }
    return result;
  }

  public static String virtual_getCellId_1216737839993(SNode thisNode) {
    return EditorCellModel_Behavior.call_getCellModelKind_1216811674575(thisNode) + "_" + thisNode.getId();
  }

  public static String call_getFactoryMethodName_1216812165609(SNode thisNode) {
    return "create" + EditorCellModel_Behavior.call_getCellModelKind_1216811674575(thisNode) + thisNode.getId();
  }

  public static SNode virtual_getParent_1219419981626(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "styleClass", false);
  }

  public static boolean call_isSelectable_1219420196673(SNode thisNode) {
    SNode firstItem = ListSequence.fromList(IStyleContainer_Behavior.call_getClassItems_1219419901278(thisNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.SelectableStyleSheetItem"))).first();
    if ((firstItem == null)) {
      return true;
    }
    return SPropertyOperations.getBoolean(firstItem, "flag");
  }

  public static Color call_getForegroundColor_1220960215403(SNode thisNode) {
    SNode firstItem = ListSequence.fromList(IStyleContainer_Behavior.call_getClassItems_1219419901278(thisNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.ForegroundColorStyleClassItem"))).first();
    if ((firstItem == null) || SPropertyOperations.getString_def(firstItem, "color", null) == null || SPropertyOperations.hasValue(firstItem, "color", "query", null)) {
      return null;
    }
    Class<MPSColors> classColors = MPSColors.class;
    try {
      return (Color)classColors.getField(SPropertyOperations.getString_def(firstItem, "color", null)).get(null);
    } catch (Throwable t) {
      t.printStackTrace();
      return null;
    }
  }

  public static Color call_getBackgroundColor_1220969182195(SNode thisNode) {
    SNode firstItem = ListSequence.fromList(IStyleContainer_Behavior.call_getClassItems_1219419901278(thisNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.BackgroundColorStyleClassItem"))).first();
    if ((firstItem == null) || SPropertyOperations.getString_def(firstItem, "color", null) == null || SPropertyOperations.hasValue(firstItem, "color", "query", null)) {
      return null;
    }
    Class<MPSColors> classColors = MPSColors.class;
    try {
      return (Color)classColors.getField(SPropertyOperations.getString_def(firstItem, "color", null)).get(null);
    } catch (Throwable t) {
      t.printStackTrace();
      return null;
    }
  }

  public static Color call_getTextBackgroundColor_1220972190901(SNode thisNode) {
    SNode firstItem = ListSequence.fromList(IStyleContainer_Behavior.call_getClassItems_1219419901278(thisNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.TextBackgroundColorStyleClassItem"))).first();
    if ((firstItem == null) || SPropertyOperations.getString_def(firstItem, "color", null) == null || SPropertyOperations.hasValue(firstItem, "color", "query", null)) {
      return null;
    }
    Class<MPSColors> classColors = MPSColors.class;
    try {
      return (Color)classColors.getField(SPropertyOperations.getString_def(firstItem, "color", null)).get(null);
    } catch (Throwable t) {
      t.printStackTrace();
      return null;
    }
  }

  public static boolean call_isUnderlined_1221220594206(SNode thisNode) {
    SNode firstItem = ListSequence.fromList(IStyleContainer_Behavior.call_getClassItems_1219419901278(thisNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.UnderlinedStyleClassItem"))).first();
    if ((firstItem == null)) {
      return false;
    }
    return SPropertyOperations.hasValue(firstItem, "underlined", "2", "0");
  }

  public static int call_getFontSize_1221216397365(SNode thisNode) {
    SNode firstItem = ListSequence.fromList(IStyleContainer_Behavior.call_getClassItems_1219419901278(thisNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.FontSizeStyleClassItem"))).first();
    if ((firstItem == null)) {
      return EditorSettings.getInstance().getDefaultEditorFont().getSize();
    }
    return SPropertyOperations.getInteger(firstItem, "value");
  }

  public static int call_getFontStyle_1221053923273(SNode thisNode) {
    SNode firstItem = ListSequence.fromList(IStyleContainer_Behavior.call_getClassItems_1219419901278(thisNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.FontStyleStyleClassItem"))).first();
    if ((firstItem == null) || SPropertyOperations.getString_def(firstItem, "style", null) == null || SPropertyOperations.hasValue(firstItem, "style", "QUERY", null)) {
      return Font.PLAIN;
    }
    Class<MPSFonts> classFonts = MPSFonts.class;
    try {
      return (Integer)classFonts.getField(SPropertyOperations.getString_def(firstItem, "style", null)).get(null);
    } catch (Throwable t) {
      t.printStackTrace();
      return Font.PLAIN;
    }
  }

  public static String call_getOpeningTag_1220340471382(SNode thisNode) {
    return EditorCellModel_Behavior.call_getOpeningPrefix_1220340126255(thisNode) + EditorCellModel_Behavior.call_getOpeningText_1220339714057(thisNode);
  }

  public static String call_getClosingTag_1220340488560(SNode thisNode) {
    return EditorCellModel_Behavior.call_getClosingText_1220339738643(thisNode);
  }

  public static String virtual_getOpeningText_1220339714057(SNode thisNode) {
    return "";
  }

  public static String virtual_getClosingText_1220339738643(SNode thisNode) {
    return "";
  }

  public static String call_getOpeningPrefix_1220340126255(SNode thisNode) {
    String result = "";
    if ((SLinkOperations.getTarget(thisNode, "renderingCondition", true) != null)) {
      result += "?";
    }
    boolean hasActionStuff = false;
    if ((SLinkOperations.getTarget(thisNode, "menuDescriptor", true) != null) || (SLinkOperations.getTarget(thisNode, "keyMap", false) != null) || (SLinkOperations.getTarget(thisNode, "actionMap", false) != null)) {
      hasActionStuff = true;
    }
    if (SNodeOperations.isInstanceOf(thisNode, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNodeList") && (SLinkOperations.getTarget(thisNode, "elementMenuDescriptor", true) != null)) {
      hasActionStuff = true;
    }
    if (hasActionStuff) {
      result += "^";
    }
    if (SPropertyOperations.hasValue(thisNode, "attractsFocus", "1", "0")) {
      result += "F";
    }
    if (SPropertyOperations.hasValue(thisNode, "attractsFocus", "2", "0")) {
      result += "FE";
    }
    return result;
  }

  public static String call_getCellId_1216737839993(SNode thisNode) {
    return (String)BehaviorManager.getInstance().invoke(Object.class, thisNode, "virtual_getCellId_1216737839993", PARAMETERS_1216737839993);
  }

  public static String call_getOpeningText_1220339714057(SNode thisNode) {
    return (String)BehaviorManager.getInstance().invoke(Object.class, thisNode, "virtual_getOpeningText_1220339714057", PARAMETERS_1220339714057);
  }

  public static String call_getClosingText_1220339738643(SNode thisNode) {
    return (String)BehaviorManager.getInstance().invoke(Object.class, thisNode, "virtual_getClosingText_1220339738643", PARAMETERS_1220339738643);
  }

  public static String callSuper_getCellId_1216737839993(SNode thisNode, String callerConceptFqName) {
    return (String)BehaviorManager.getInstance().invokeSuper(Object.class, thisNode, callerConceptFqName, "virtual_getCellId_1216737839993", PARAMETERS_1216737839993);
  }

  public static String callSuper_getOpeningText_1220339714057(SNode thisNode, String callerConceptFqName) {
    return (String)BehaviorManager.getInstance().invokeSuper(Object.class, thisNode, callerConceptFqName, "virtual_getOpeningText_1220339714057", PARAMETERS_1220339714057);
  }

  public static String callSuper_getClosingText_1220339738643(SNode thisNode, String callerConceptFqName) {
    return (String)BehaviorManager.getInstance().invokeSuper(Object.class, thisNode, callerConceptFqName, "virtual_getClosingText_1220339738643", PARAMETERS_1220339738643);
  }

}
