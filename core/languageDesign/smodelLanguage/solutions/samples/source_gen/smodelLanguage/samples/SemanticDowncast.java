package smodelLanguage.samples;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import java.util.List;

/* package */class SemanticDowncast {

  /* package */void invoke_getID_method_1(SNode ifStatement) {
    String id_verbose = ((SNode)ifStatement).getId();
    String id_briefly = ifStatement.getId();
  }

  /* package */void invoke_getID_method_2(SNode ifStatement) {
    String id_verbose = ((SNode)((SNode)SLinkOperations.getTarget(ifStatement, "condition", true))).getId();
    String id_better1 = SLinkOperations.getTarget(ifStatement, "condition", true).getId();
    String id_better2 = SLinkOperations.getTarget(ifStatement, "condition", true).getId();
    SLinkOperations.getTarget(ifStatement, "condition", true).getId();
  }

  /* package */void countChildren(SNode methodCall) {
    int count_verbose_not_efficient = ((List<SNode>)SLinkOperations.getTargets(methodCall, "actualArgument", true)).size();
    int count_not_efficient = SLinkOperations.getTargets(methodCall, "actualArgument", true).size();
    int count_best = SLinkOperations.getCount(methodCall, "actualArgument");
    SLinkOperations.getTargets(methodCall, "actualArgument", true).size();
  }

}
