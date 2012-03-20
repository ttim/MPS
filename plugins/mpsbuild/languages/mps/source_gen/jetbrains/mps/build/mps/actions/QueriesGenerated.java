package jetbrains.mps.build.mps.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.SideTransformPreconditionContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.action.IChildNodeSetter;
import jetbrains.mps.smodel.action.AbstractChildNodeSetter;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.action.ModelActions;
import jetbrains.mps.smodel.action.DefaultSimpleSubstituteAction;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.smodel.action.SideTransformActionsBuilderContext;
import jetbrains.mps.smodel.action.AbstractSideTransformHintSubstituteAction;

public class QueriesGenerated {
  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_BuildMps_ModuleDependencyOnModule_5253498789149547751(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return !(SPropertyOperations.getBoolean(_context.getSourceNode(), "reexport"));
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_BuildMps_ModuleDependencyOnModuleById_4278635856200761057(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return !(SPropertyOperations.getBoolean(_context.getSourceNode(), "reexport"));
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_BuildMps_ModuleDependencyOnJavaModule_3189788309731933940(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return !(SPropertyOperations.getBoolean(_context.getSourceNode(), "reexport"));
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_BuildMps_Module_3189788309731994251(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return (SLinkOperations.getTarget(_context.getSourceNode(), "path", true) == null);
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_BuildMps_DevKit_322010710375870611(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return (SLinkOperations.getTarget(_context.getSourceNode(), "path", true) == null);
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_BuildMps_ModuleSource_3189788309731979156(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.mps.structure.BuildMps_ModuleJavaSource");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        SNode wrappedConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildInputResourceSet");
        IChildNodeSetter setter = new AbstractChildNodeSetter() {
          public SNode wrapNode(SNode nodeToWrap, SModel model) {
            SNode res = SModelOperations.createNewNode(model, "jetbrains.mps.build.mps.structure.BuildMps_ModuleJavaSource", null);
            SLinkOperations.setTarget(res, "sources", nodeToWrap, true);
            return res;
          }

          public boolean returnSmallPart(SNode nodeToWrap) {
            return false;
          }

          public SNode doExecute(SNode pn, SNode oc, SNode nc, IScope sc) {
            SNode wrappedNode = this.wrapNode(nc, nc.getModel());
            _context.getChildSetter().execute(_context.getParentNode(), _context.getCurrentTargetNode(), wrappedNode, operationContext.getScope());
            if (this.returnSmallPart(nc)) {
              return nc;
            } else {
              return wrappedNode;
            }
          }
        };
        ListSequence.fromList(result).addSequence(ListSequence.fromList(ModelActions.createChildSubstituteActions(_context.getParentNode(), _context.getCurrentTargetNode(), wrappedConcept, setter, operationContext)));
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_BuildMps_AbstractModule_322010710376066509(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.mps.structure.BuildMps_AbstractModule");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (outputConcept == null || SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        ListSequence.fromList(result).addElement(new DefaultSimpleSubstituteAction(outputConcept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
          public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
            SNode lang = SNodeFactoryOperations.createNewNode(model, "jetbrains.mps.build.mps.structure.BuildMps_Language", null);
            SNodeFactoryOperations.setNewChild(lang, "path", "jetbrains.mps.build.structure.BuildSourcePath");
            return lang;
          }

          public String getMatchingText(String pattern) {
            return "mps language from file";
          }

          public String getVisibleMatchingText(String pattern) {
            return this.getMatchingText(pattern);
          }
        });
      }
    }
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.mps.structure.BuildMps_AbstractModule");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (outputConcept == null || SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        ListSequence.fromList(result).addElement(new DefaultSimpleSubstituteAction(outputConcept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
          public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
            SNode lang = SNodeFactoryOperations.createNewNode(model, "jetbrains.mps.build.mps.structure.BuildMps_Solution", null);
            SNodeFactoryOperations.setNewChild(lang, "path", "jetbrains.mps.build.structure.BuildSourcePath");
            return lang;
          }

          public String getMatchingText(String pattern) {
            return "mps solution from file";
          }

          public String getVisibleMatchingText(String pattern) {
            return this.getMatchingText(pattern);
          }
        });
      }
    }
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.mps.structure.BuildMps_AbstractModule");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (outputConcept == null || SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        ListSequence.fromList(result).addElement(new DefaultSimpleSubstituteAction(outputConcept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
          public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
            SNode lang = SNodeFactoryOperations.createNewNode(model, "jetbrains.mps.build.mps.structure.BuildMps_DevKit", null);
            SNodeFactoryOperations.setNewChild(lang, "path", "jetbrains.mps.build.structure.BuildSourcePath");
            return lang;
          }

          public String getMatchingText(String pattern) {
            return "mps devkit from file";
          }

          public String getVisibleMatchingText(String pattern) {
            return this.getMatchingText(pattern);
          }
        });
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BuildMps_ModuleDependencyOnModule_5253498789149547745(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModule");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SPropertyOperations.set(_context.getSourceNode(), "reexport", "" + true);
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "(reexport)";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BuildMps_ModuleDependencyOnModuleById_4278635856200761056(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModuleById");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SPropertyOperations.set(_context.getSourceNode(), "reexport", "" + true);
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "(reexport)";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BuildMps_ModuleDependencyOnJavaModule_3189788309731933926(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnJavaModule");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SPropertyOperations.set(_context.getSourceNode(), "reexport", "" + true);
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "(reexport)";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BuildMps_Module_3189788309731994246(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.mps.structure.BuildMps_Module");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SNodeFactoryOperations.setNewChild(_context.getSourceNode(), "path", "jetbrains.mps.build.structure.BuildSourcePath");
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "load from";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BuildMps_DevKit_322010710375870610(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.mps.structure.BuildMps_Module");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SNodeFactoryOperations.setNewChild(_context.getSourceNode(), "path", "jetbrains.mps.build.structure.BuildSourcePath");
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "load from";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }
}
