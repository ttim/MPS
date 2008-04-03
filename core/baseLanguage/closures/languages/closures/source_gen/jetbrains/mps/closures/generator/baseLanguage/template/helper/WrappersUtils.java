package jetbrains.mps.closures.generator.baseLanguage.template.helper;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import java.util.Iterator;
import jetbrains.mps.generator.template.ITemplateGenerator;

public class WrappersUtils {

  public static List<SNode> collectLocalVariableDeclarationsToWrap(SNode closure) {
    List<SNode> lvdecls = new ArrayList<SNode>();
    for(SNode desc : SNodeOperations.getDescendants(closure, null, false)) {
      if (SNodeOperations.isInstanceOf(desc, "jetbrains.mps.baseLanguage.structure.LocalVariableReference") && closure == SNodeOperations.getAncestor(desc, "jetbrains.mps.closures.structure.ClosureLiteral", false, false)) {
        SNode lvd = SLinkOperations.getTarget(desc, "variableDeclaration", false);
        if (closure != SNodeOperations.getAncestor(lvd, "jetbrains.mps.closures.structure.ClosureLiteral", false, false)) {
          if (!(lvdecls.contains(SLinkOperations.getTarget(desc, "variableDeclaration", false)))) {
            lvdecls.add(SLinkOperations.getTarget(desc, "variableDeclaration", false));
          }
        }
      }
    }
with_decls:
    for(Iterator<SNode> it = lvdecls.iterator() ; it.hasNext() ; ) {
      SNode lvd = it.next();
      SNode sl = SNodeOperations.getAncestor(lvd, "jetbrains.mps.baseLanguage.structure.StatementList", false, false);
      for(SNode desc : SNodeOperations.getDescendants(sl, null, false)) {
        if (SNodeOperations.isInstanceOf(desc, "jetbrains.mps.baseLanguage.structure.LocalVariableReference") && SLinkOperations.getTarget(desc, "variableDeclaration", false) == lvd) {
          if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(desc, null, false, false), "jetbrains.mps.baseLanguage.structure.AssignmentExpression") && SLinkOperations.getTarget(SNodeOperations.getParent(desc, null, false, false), "lValue", true) == desc) {
            continue with_decls;
          }
        }
      }
      // didn't find any assignment with the var reference in the lvalue
      it.remove();
    }
    return lvdecls;
  }

  public static void putPrepData(SNode sn, Object data, ITemplateGenerator generator) {
    System.out.println("--> PUT " + data + " (" + sn.getPresentation() + ") ID=" + sn.getId());
    generator.getGeneratorSessionContext().putSessionObject("wrappers_data_" + ((SNode)sn).getId(), data);
    sn.putUserObject("wrappers_data_", data);
  }

  public static Object getPrepData(SNode sn, ITemplateGenerator generator) {
    Object sessionData = generator.getGeneratorSessionContext().getSessionObject("wrappers_data_" + ((SNode)sn).getId());
    if (sessionData == null) {
      sessionData = sn.getUserObject("wrappers_data_");
    }
    if (sessionData != null) {
      System.out.println("--> GET " + sessionData + " (" + sn.getPresentation() + ") ID=" + sn.getId());
    }
    return sessionData;
  }

  public static void copyPrepData(SNode from, SNode to, ITemplateGenerator generator) {
    WrappersUtils.copyPrepDataNoRecursion(from, to, generator);
    List<SNode> toDescendants = new ArrayList<SNode>(SNodeOperations.getDescendants(to, null, false));
    List<SNode> fromDescendats = new ArrayList<SNode>(SNodeOperations.getDescendants(from, null, false));
    int idx = 0;
    for(SNode fromDesc : SNodeOperations.getDescendants(from, null, false)) {
      WrappersUtils.copyPrepDataNoRecursion(fromDesc, toDescendants.get(idx), generator);
      idx = idx + 1;
    }
  }

  private static void copyPrepDataNoRecursion(SNode from, SNode to, ITemplateGenerator generator) {
    Object data = WrappersUtils.getPrepData(from, generator);
    if (data != null) {
      WrappersUtils.putPrepData(to, data, generator);
    }
  }

}
