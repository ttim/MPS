package jetbrains.mpslite.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Map;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.MapSequence;

public class ConcreteChildPart_Behavior {
  public static void init(SNode thisNode) {
  }

  public static void virtual_fillConceptStructure_1238593834306(SNode thisNode, SNode concept, Map<SNode, SNode> conceptsToTargets, Map<SNode, SNode> partsToLinks) {
    SNode linkDeclaration = SLinkOperations.addNewChild(concept, "linkDeclaration", "jetbrains.mps.lang.structure.structure.LinkDeclaration");
    SPropertyOperations.set(linkDeclaration, "metaClass", "aggregation");
    SPropertyOperations.set(linkDeclaration, "role", SPropertyOperations.getString(thisNode, "name"));
    if (SPropertyOperations.getBoolean(thisNode, "multiple")) {
      SPropertyOperations.set(linkDeclaration, "sourceCardinality", "0..n");
    } else {
      SPropertyOperations.set(linkDeclaration, "sourceCardinality", "0..1");
    }
    SLinkOperations.setTarget(linkDeclaration, "target", AbstractConceptReference_Behavior.call_getConcept_1238594571574(SLinkOperations.getTarget(thisNode, "conceptReference", true), conceptsToTargets), false);
    MapSequence.fromMap(partsToLinks).put(thisNode, linkDeclaration);
  }
}
