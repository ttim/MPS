package jetbrains.mps.build.gentest.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.baseLanguage.behavior.Classifier_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import jetbrains.mps.baseLanguage.search.ReachableClassifiersScope;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import jetbrains.mps.project.GlobalScope;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class TestCollector {
  private Iterable<SModel> models;

  public TestCollector(Iterable<SModel> models) {
    this.models = models;
  }

  public Iterable<String> collectTests() {
    return Sequence.fromIterable(models).translate(new ITranslator2<SModel, SNode>() {
      public Iterable<SNode> translate(SModel model) {
        return SModelOperations.getRoots(model, "jetbrains.mps.baseLanguage.structure.ClassConcept");
      }
    }).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode cls) {
        return isJunit38Test(cls) || isJUnit4Test(cls);
      }
    }).select(new ISelector<SNode, String>() {
      public String select(SNode cls) {
        return INamedConcept_Behavior.call_getFqName_1213877404258(cls);
      }
    });
  }

  private boolean isJunit38Test(SNode maybetest) {
    boolean isdesc = Classifier_Behavior.call_isDescendant_7165541881557222913(maybetest, getTestCaseClass(SNodeOperations.getModel(maybetest)));
    boolean hasann = hasAnnotation(maybetest, getIgnoreAnnotation(SNodeOperations.getModel(maybetest)), getMPSLaunchAnnotation(SNodeOperations.getModel(maybetest)));
    return isdesc && !(hasann) && hasJUnit38TestMethods(maybetest);
  }

  private boolean hasJUnit38TestMethods(final SNode maybetest) {
    return ListSequence.fromList(SLinkOperations.getTargets(maybetest, "method", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode meth) {
        return "public".equals(SConceptPropertyOperations.getString(SLinkOperations.getTarget(meth, "visibility", true), "alias")) && SPropertyOperations.getString(meth, "name").startsWith("test");
      }
    }).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode meth) {
        return !(hasAnnotation(meth, getIgnoreAnnotation(SNodeOperations.getModel(maybetest))));
      }
    });
  }

  private boolean isJUnit4Test(SNode maybetest) {
    return !(hasAnnotation(getIgnoreAnnotation(SNodeOperations.getModel(maybetest)), getMPSLaunchAnnotation(SNodeOperations.getModel(maybetest)))) && hasJUnit4TestMethods(maybetest);
  }

  private boolean hasJUnit4TestMethods(final SNode maybetest) {
    return ListSequence.fromList(SLinkOperations.getTargets(maybetest, "method", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode meth) {
        return "public".equals(SConceptPropertyOperations.getString(SLinkOperations.getTarget(meth, "visibility", true), "alias")) && hasAnnotation(meth, getTestAnnotation(SNodeOperations.getModel(maybetest)));
      }
    }).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode meth) {
        return !(hasAnnotation(meth, getIgnoreAnnotation(SNodeOperations.getModel(maybetest))));
      }
    });
  }

  private boolean hasAnnotation(final SNode hasann, SNode... annotation) {
    return Sequence.fromIterable(Sequence.fromArray(annotation)).any(new IWhereFilter<SNode>() {
      public boolean accept(final SNode ann) {
        return ListSequence.fromList(SLinkOperations.getTargets(hasann, "annotation", true)).any(new IWhereFilter<SNode>() {
          public boolean accept(SNode anninst) {
            return SLinkOperations.getTarget(anninst, "annotation", false) == ann;
          }
        });
      }
    });
  }

  private SNode getTestCaseClass(SModel context) {
    final String testCase = INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(new TestCollector.QuotationClass_rpw6il_a0a0a0a6().createNode(), "classifier", false));
    return SNodeOperations.cast(ListSequence.fromList(this.allClassifiers(context)).findFirst(new IWhereFilter<SNode>() {
      public boolean accept(SNode cls) {
        return INamedConcept_Behavior.call_getFqName_1213877404258(cls).equals(testCase);
      }
    }), "jetbrains.mps.baseLanguage.structure.ClassConcept");
  }

  private SNode getTestAnnotation(SModel context) {
    final String testAnn = INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(new TestCollector.QuotationClass_rpw6il_a0a0a0a7().createNode(), "classifier", false));
    return ListSequence.fromList(this.allAnnotations(context)).findFirst(new IWhereFilter<SNode>() {
      public boolean accept(SNode ann) {
        return INamedConcept_Behavior.call_getFqName_1213877404258(ann).equals(testAnn);
      }
    });
  }

  private SNode getIgnoreAnnotation(SModel context) {
    final String ignoreAnn = INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(new TestCollector.QuotationClass_rpw6il_a0a0a0a8().createNode(), "classifier", false));
    return ListSequence.fromList(this.allAnnotations(context)).findFirst(new IWhereFilter<SNode>() {
      public boolean accept(SNode ann) {
        return INamedConcept_Behavior.call_getFqName_1213877404258(ann).equals(ignoreAnn);
      }
    });
  }

  private SNode getMPSLaunchAnnotation(SModel context) {
    final String mpslaunchAnn = INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(new TestCollector.QuotationClass_rpw6il_a0a0a0a9().createNode(), "classifier", false));
    return ListSequence.fromList(this.allAnnotations(context)).findFirst(new IWhereFilter<SNode>() {
      public boolean accept(SNode ann) {
        return INamedConcept_Behavior.call_getFqName_1213877404258(ann).equals(mpslaunchAnn);
      }
    });
  }

  protected List<SNode> allClassifiers(SModel context) {
    return (List<SNode>) new ReachableClassifiersScope(context, IClassifiersSearchScope.CLASS, GlobalScope.getInstance()).getClassifiers();
  }

  protected List<SNode> allAnnotations(SModel context) {
    return (List<SNode>) new ReachableClassifiersScope(context, IClassifiersSearchScope.ANNOTATION, GlobalScope.getInstance()).getClassifiers();
  }

  public static class QuotationClass_rpw6il_a0a0a0a6 {
    public QuotationClass_rpw6il_a0a0a0a6() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#83f155ff-422c-4b5a-a2f2-b459302dd215#junit.framework(jetbrains.mps.baseLanguage.unitTest.libs/junit.framework@java_stub)"), SNodeId.fromString("~TestCase")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_rpw6il_a0a0a0a7 {
    public QuotationClass_rpw6il_a0a0a0a7() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#83f155ff-422c-4b5a-a2f2-b459302dd215#org.junit(jetbrains.mps.baseLanguage.unitTest.libs/org.junit@java_stub)"), SNodeId.fromString("~Test")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_rpw6il_a0a0a0a8 {
    public QuotationClass_rpw6il_a0a0a0a8() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#83f155ff-422c-4b5a-a2f2-b459302dd215#org.junit(jetbrains.mps.baseLanguage.unitTest.libs/org.junit@java_stub)"), SNodeId.fromString("~Ignore")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_rpw6il_a0a0a0a9 {
    public QuotationClass_rpw6il_a0a0a0a9() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("r:f144b87b-8ea5-4a8a-bb79-78fd4663e93c(jetbrains.mps.baseLanguage.util.plugin.run)"), SNodeId.fromString("8492459591399146889")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
