package jetbrains.mps.testbench.suite.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.traceable.behavior.UnitConcept_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ISelector;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class JUnit3TestCaseRef_Behavior {
  public static void init(SNode thisNode) {
  }

  public static String virtual_fqClassName_2956932267233324537(SNode thisNode) {
    return UnitConcept_Behavior.call_getUnitName_5067982036267369911(SLinkOperations.getTarget(thisNode, "klass", false));
  }

  public static Iterable<String> virtual_testNames_4089647634160960707(SNode thisNode) {
    final SNode ignoreAnn = SLinkOperations.getTarget(new JUnit3TestCaseRef_Behavior.QuotationClass_6e9f36_a0a0a0c().createNode(), "annotation", false);

    return ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(thisNode, "klass", false), "method", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode m) {
        return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(m, "visibility", true), "jetbrains.mps.baseLanguage.structure.PublicVisibility") && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(m, "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType") && SPropertyOperations.getString(m, "name").startsWith("test") && !(ListSequence.fromList(SLinkOperations.getTargets(m, "annotation", true)).any(new IWhereFilter<SNode>() {
          public boolean accept(SNode mann) {
            return SLinkOperations.getTarget(mann, "annotation", false) == ignoreAnn;
          }
        }));
      }
    }).select(new ISelector<SNode, String>() {
      public String select(SNode m) {
        return SPropertyOperations.getString(m, "name");
      }
    });
  }

  public static class QuotationClass_6e9f36_a0a0a0c {
    public QuotationClass_6e9f36_a0a0a0c() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.AnnotationInstance", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("annotation", quotedNode1_2, SModelReference.fromString("f:java_stub#83f155ff-422c-4b5a-a2f2-b459302dd215#org.junit(jetbrains.mps.baseLanguage.unitTest.libs/org.junit@java_stub)"), SNodeId.fromString("~Ignore")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
