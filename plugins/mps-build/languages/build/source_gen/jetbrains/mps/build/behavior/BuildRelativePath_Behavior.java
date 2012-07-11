package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.Context;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.build.util.MacroHelper;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class BuildRelativePath_Behavior {
  private static Class[] PARAMETERS_4959435991187140515 = {SNode.class, Context.class};

  public static void init(SNode thisNode) {
  }

  @Nullable
  public static String virtual_getBasePath_4959435991187140515(SNode thisNode, Context context) {
    return null;
  }

  public static String virtual_getLocalPath_5481553824944787364(SNode thisNode, Context context) {
    String basePath = BuildRelativePath_Behavior.call_getBasePath_4959435991187140515(thisNode, context);
    if (basePath == null) {
      return null;
    }
    if (!(basePath.endsWith("/"))) {
      basePath = basePath + "/";
    }
    return basePath + BuildRelativePath_Behavior.call_getPathTail_1258644073389171001(thisNode);
  }

  public static String call_getPathTail_1258644073389171001(SNode thisNode) {
    if ((SLinkOperations.getTarget(thisNode, "compositePart", true) == null)) {
      return "";
    }
    return BuildCompositePath_Behavior.call_getPath_8618885170173674800(SLinkOperations.getTarget(thisNode, "compositePart", true));
  }

  public static String virtual_getLastSegment_1368030936106771141(SNode thisNode, MacroHelper helper) {
    return ((SLinkOperations.getTarget(thisNode, "compositePart", true) != null) ?
      BuildCompositePath_Behavior.call_getLastSegment_1368030936106771152(SLinkOperations.getTarget(thisNode, "compositePart", true), helper) :
      null
    );
  }

  public static SNode virtual_getParent_8654221991637145399(SNode thisNode) {
    if (BuildRelativePath_Behavior.isEmptyTail_8654221991637157686(SLinkOperations.getTarget(thisNode, "compositePart", true))) {
      return null;
    }
    SNode copy = SNodeOperations.copyNode(thisNode);
    SNode cp = SLinkOperations.getTarget(copy, "compositePart", true);
    if (BuildRelativePath_Behavior.isEmptyTail_8654221991637157686(SLinkOperations.getTarget(cp, "tail", true))) {
      SLinkOperations.setTarget(copy, "compositePart", null, true);
    } else {
      SNode prev = cp;
      cp = BuildRelativePath_Behavior.next_8654221991637156927(cp);
      while (cp != null) {
        SNode next = BuildRelativePath_Behavior.next_8654221991637156927(cp);
        if (next != null) {
          prev = cp;
          cp = next;
        } else {
          break;
        }
      }
      SLinkOperations.setTarget(prev, "tail", null, true);
    }
    return copy;
  }

  public static String call_getBasePath_4959435991187140515(SNode thisNode, Context context) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildRelativePath"), "virtual_getBasePath_4959435991187140515", PARAMETERS_4959435991187140515, new Object[]{context});
  }

  public static String callSuper_getBasePath_4959435991187140515(SNode thisNode, String callerConceptFqName, Context context) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildRelativePath"), callerConceptFqName, "virtual_getBasePath_4959435991187140515", PARAMETERS_4959435991187140515, new Object[]{context});
  }

  public static SNode next_8654221991637156927(SNode cp) {
    if ((SLinkOperations.getTarget(cp, "tail", true) == null)) {
      return null;
    }
    if (isEmpty_wij6l5_a0b0i(SPropertyOperations.getString(SLinkOperations.getTarget(cp, "tail", true), "head"))) {
      return BuildRelativePath_Behavior.next_8654221991637156927(SLinkOperations.getTarget(cp, "tail", true));
    }
    return SLinkOperations.getTarget(cp, "tail", true);
  }

  public static boolean isEmptyTail_8654221991637157686(SNode cp) {
    return cp == null || isEmpty_wij6l5_a0a0a0j(SPropertyOperations.getString(cp, "head")) && BuildRelativePath_Behavior.isEmptyTail_8654221991637157686(SLinkOperations.getTarget(cp, "tail", true));
  }

  public static boolean isEmpty_wij6l5_a0b0i(String str) {
    return str == null || str.length() == 0;
  }

  public static boolean isEmpty_wij6l5_a0a0a0j(String str) {
    return str == null || str.length() == 0;
  }
}
