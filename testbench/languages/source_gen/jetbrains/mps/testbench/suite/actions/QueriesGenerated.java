package jetbrains.mps.testbench.suite.actions;

/*Generated by MPS */

import java.util.List;

import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.Computable;
import jetbrains.mps.project.Solution;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.testbench.suite.behavior.ModuleSuite_Behavior;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.baseLanguage.search.AllSubclassifiersScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import jetbrains.mps.util.Condition;
import jetbrains.mps.baseLanguage.behavior.Classifier_Behavior;
import jetbrains.mps.baseLanguage.search.ReachableClassifiersScope;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import java.util.Set;
import java.util.HashSet;

import jetbrains.mps.project.GlobalScope;

public class QueriesGenerated {
  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_SolutionRef_1280144168199506928(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.testbench.suite.structure.SolutionRef");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            List<Solution> allSolutions = (List<Solution>) ModuleRepositoryFacade.getInstance().getAllModules(Solution.class);
            return ListSequence.fromList(allSolutions).select(new ISelector<Solution, ModuleReference>() {
              public ModuleReference select(Solution s) {
                return s.getModuleReference();
              }
            }).toListSequence();
          }
        };
        Iterable<ModuleReference> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final ModuleReference item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode solutionRef = SConceptOperations.createNewNode("jetbrains.mps.testbench.suite.structure.SolutionRef", null);
                SPropertyOperations.set(solutionRef, "moduleFQName", (item).getModuleFqName());
                SPropertyOperations.set(solutionRef, "moduleID", (item).getModuleId().toString());
                return solutionRef;
              }

              public String getMatchingText(String pattern) {
                return (item).getModuleFqName();
              }

              public String getVisibleMatchingText(String pattern) {
                return this.getMatchingText(pattern);
              }
            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_JUnit3TestCaseRef_1280144168199520224(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.testbench.suite.structure.JUnit3TestCaseRef");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            SNode msuite = SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.testbench.suite.structure.ModuleSuite", true, false);
            final IScope mscope = ModuleSuite_Behavior.call_scope_1280144168199518341(msuite);
            return Sequence.fromIterable(ModuleSuite_Behavior.call_models_1280144168199531863(msuite)).translate(new ITranslator2<SModelDescriptor, SNode>() {
              public Iterable<SNode> translate(SModelDescriptor smd) {
                return new AllSubclassifiersScope(SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_x583g4_a0a0a0a0a0a0c0a0a0a0a2a0a1a1().createNode(), "classifier", false), smd.getSModel(), IClassifiersSearchScope.CLASS, (mscope != null ?
                  mscope :
                  operationContext.getScope()
                )).getNodes(new Condition<SNode>() {
                  public boolean met(SNode cls) {
                    return !(SPropertyOperations.getBoolean(cls, "abstractClass"));
                  }
                });
              }
            }).toListSequence();
          }
        };
        Iterable<SNode> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode tref = SConceptOperations.createNewNode("jetbrains.mps.testbench.suite.structure.JUnit3TestCaseRef", null);
                SLinkOperations.setTarget(tref, "klass", (item), false);
                model.getModelDescriptor().getModule().addDependency(SNodeOperations.getModel((item)).getModelDescriptor().getModule().getModuleReference(), false);
                model.addModelImport(SNodeOperations.getModel((item)).getSModelReference(), false);
                return tref;
              }

              public String getMatchingText(String pattern) {
                return Classifier_Behavior.call_getNestedName_8540045600162184125((item));
              }

              public String getVisibleMatchingText(String pattern) {
                return this.getMatchingText(pattern);
              }
            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_JUnit4TestCaseRef_1280144168199633207(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.testbench.suite.structure.JUnit4TestCaseRef");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            SNode msuite = SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.testbench.suite.structure.ModuleSuite", true, false);
            final IScope mscope = ModuleSuite_Behavior.call_scope_1280144168199518341(msuite);
            final SNode testAnn = SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_x583g4_a0a0c0a0a0a0a2a0a1a2().createNode(), "annotation", false);

            return Sequence.fromIterable(ModuleSuite_Behavior.call_models_1280144168199531863(msuite)).translate(new ITranslator2<SModelDescriptor, SNode>() {
              public Iterable<SNode> translate(SModelDescriptor smd) {
                return new ReachableClassifiersScope(smd.getSModel(), IClassifiersSearchScope.CLASS, (mscope != null ?
                  mscope :
                  operationContext.getScope()
                )).getNodes(new Condition<SNode>() {
                  public boolean met(SNode cls) {
                    return ListSequence.fromList(SLinkOperations.getTargets(cls, "method", true)).translate(new ITranslator2<SNode, SNode>() {
                      public Iterable<SNode> translate(SNode m) {
                        return SLinkOperations.getTargets(m, "annotation", true);
                      }
                    }).any(new IWhereFilter<SNode>() {
                      public boolean accept(SNode ani) {
                        return SLinkOperations.getTarget(ani, "annotation", false) == testAnn;
                      }
                    });
                  }
                });
              }
            }).toListSequence();
          }
        };
        Iterable<SNode> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode tref = SConceptOperations.createNewNode("jetbrains.mps.testbench.suite.structure.JUnit4TestCaseRef", null);
                SLinkOperations.setTarget(tref, "klass", (item), false);
                model.getModelDescriptor().getModule().addDependency(SNodeOperations.getModel((item)).getModelDescriptor().getModule().getModuleReference(), false);
                model.addModelImport(SNodeOperations.getModel((item)).getSModelReference(), false);
                return tref;
              }

              public String getMatchingText(String pattern) {
                return Classifier_Behavior.call_getNestedName_8540045600162184125((item));
              }

              public String getVisibleMatchingText(String pattern) {
                return this.getMatchingText(pattern);
              }
            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_TestCaseRef_1280144168199742766(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.testbench.suite.structure.TestCaseRef");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            SNode msuite = SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.testbench.suite.structure.ModuleSuite", true, false);
            return Sequence.fromIterable(ModuleSuite_Behavior.call_models_1280144168199531863(msuite)).translate(new ITranslator2<SModelDescriptor, SNode>() {
              public Iterable<SNode> translate(SModelDescriptor smd) {
                return SModelOperations.getNodes(((SModel) smd.getSModel()), "jetbrains.mps.baseLanguage.unitTest.structure.ITestCase");
              }
            }).toListSequence();
          }
        };
        Iterable<SNode> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode tref = SConceptOperations.createNewNode("jetbrains.mps.testbench.suite.structure.TestCaseRef", null);
                SLinkOperations.setTarget(tref, "testCase", (item), false);
                model.getModelDescriptor().getModule().addDependency(SNodeOperations.getModel((item)).getModelDescriptor().getModule().getModuleReference(), false);
                model.addModelImport(SNodeOperations.getModel((item)).getSModelReference(), false);
                return tref;
              }

              public String getMatchingText(String pattern) {
                return SPropertyOperations.getString((item), "name");
              }

              public String getVisibleMatchingText(String pattern) {
                return this.getMatchingText(pattern);
              }
            });
          }
        }
      }
    }
    return result;
  }

  public static class QuotationClass_x583g4_a0a0a0a0a0a0c0a0a0a0a2a0a1a1 {
    public QuotationClass_x583g4_a0a0a0a0a0a0c0a0a0a0a2a0a1a1() {
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

  public static class QuotationClass_x583g4_a0a0c0a0a0a0a2a0a1a2 {
    public QuotationClass_x583g4_a0a0c0a0a0a0a2a0a1a2() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.AnnotationInstance", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("annotation", quotedNode1_2, SModelReference.fromString("f:java_stub#83f155ff-422c-4b5a-a2f2-b459302dd215#org.junit(jetbrains.mps.baseLanguage.unitTest.libs/org.junit@java_stub)"), SNodeId.fromString("~Test")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
