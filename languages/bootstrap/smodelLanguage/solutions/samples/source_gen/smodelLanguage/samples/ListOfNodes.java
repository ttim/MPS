package smodelLanguage.samples;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.SequenceOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import smodelLanguage.samples.zPredicate1;

/* package */class ListOfNodes {

  /* package */void newList(SNode e1, SNode e2) {
    List<SNode> list = ListOperations.createList(new SNode[]{e1,e2});
  }
  /* package */void first(SNode sl) {
    SequenceOperations.getFirst(SLinkOperations.getTargets(sl, "statement", true));
    Iterable<SNode> nodes = SequenceOperations.where(SLinkOperations.getTargets(sl, "statement", true), new zPredicate1(this, null));
  }
}
