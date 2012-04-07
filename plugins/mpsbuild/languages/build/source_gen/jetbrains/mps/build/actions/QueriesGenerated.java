package jetbrains.mps.build.actions;

/*Generated by MPS */

import java.util.regex.Pattern;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.SideTransformPreconditionContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.NodeSetupContext;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.project.IModule;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.Computable;
import jetbrains.mps.build.behavior.BuildCompositePath_Behavior;
import jetbrains.mps.build.behavior.BuildRelativePath_Behavior;
import jetbrains.mps.build.util.Context;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.action.IChildNodeSetter;
import jetbrains.mps.smodel.action.AbstractChildNodeSetter;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.action.ModelActions;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.smodel.action.DefaultSimpleSubstituteAction;
import org.apache.commons.lang.StringUtils;
import java.util.regex.Matcher;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.action.SideTransformActionsBuilderContext;
import jetbrains.mps.smodel.action.AbstractSideTransformHintSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionWrapper;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.nodeEditor.EditorContext;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class QueriesGenerated {
  private static Pattern REGEXP_x583g4_a0a0b0b0a0a0a0c0a0c0q = Pattern.compile("[^\\$].*", 0);

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_BuildSourceMacroRelativePath_7321017245477126429(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return (SLinkOperations.getTarget(_context.getSourceNode(), "compositePart", true) == null);
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_BuildSourceProjectRelativePath_3877654905647401355(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return (SLinkOperations.getTarget(_context.getSourceNode(), "compositePart", true) == null);
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_BuildProjectDependency_4129895186893506343(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return (SLinkOperations.getTarget(_context.getSourceNode(), "artifacts", true) == null);
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_BuildSource_JavaDependencyModule_7259033139236507339(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return !(SPropertyOperations.getBoolean(_context.getSourceNode(), "reexport"));
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_BuildSource_JavaDependencyLibrary_5979287180587351156(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return !(SPropertyOperations.getBoolean(_context.getSourceNode(), "reexport"));
  }

  public static void nodeFactory_NodeSetup_BuildProject_6099797596647447257(final IOperationContext operationContext, final NodeSetupContext _context) {
    SModelDescriptor modelDescriptor = _context.getModel().getModelDescriptor();
    if (_context.getModel().isTransient() || modelDescriptor == null) {
      return;
    }
    IModule module = modelDescriptor.getModule();
    if (module == null || module.getDescriptorFile() == null) {
      return;
    }

    SPropertyOperations.set(_context.getNewNode(), "internalBaseDirectory", ".");
    SLinkOperations.setTarget(_context.getNewNode(), "scriptsDir", new QueriesGenerated.QuotationClass_x583g4_a2a6a5().createNode(), true);
  }

  public static void nodeFactory_NodeSetup_BuildSourceMacroRelativePath_7389400916848172016(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.build.structure.BuildSourceProjectRelativePath")) {
      SLinkOperations.setTarget(_context.getNewNode(), "compositePart", SNodeOperations.copyNode(SLinkOperations.getTarget(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.build.structure.BuildSourceProjectRelativePath"), "compositePart", true)), true);
    }
  }

  public static void nodeFactory_NodeSetup_BuildSourceProjectRelativePath_5481553824944787387(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.build.structure.BuildSourceMacroRelativePath")) {
      SLinkOperations.setTarget(_context.getNewNode(), "compositePart", SNodeOperations.copyNode(SLinkOperations.getTarget(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.build.structure.BuildSourceMacroRelativePath"), "compositePart", true)), true);
    }
  }

  public static void nodeFactory_NodeSetup_BuildInputSingleFile_1258644073389160371(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.build.structure.BuildInputSingleFile")) {
      SLinkOperations.setTarget(_context.getNewNode(), "path", SLinkOperations.getTarget(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.build.structure.BuildInputSingleFile"), "path", true), true);
    }
  }

  public static void nodeFactory_NodeSetup_BuildInputFiles_1258644073389160422(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.build.structure.BuildInputFiles")) {
      SLinkOperations.setTarget(_context.getNewNode(), "dir", SLinkOperations.getTarget(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.build.structure.BuildInputFiles"), "dir", true), true);
      ListSequence.fromList(SLinkOperations.getTargets(_context.getNewNode(), "selectors", true)).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.build.structure.BuildInputFiles"), "selectors", true)));
    }
  }

  public static void nodeFactory_NodeSetup_BuildProjectPart_6099797596647417251(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getNewNode(), "jetbrains.mps.lang.core.structure.INamedConcept") && SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.lang.core.structure.INamedConcept")) {
      SPropertyOperations.set(SNodeOperations.cast(_context.getNewNode(), "jetbrains.mps.lang.core.structure.INamedConcept"), "name", SPropertyOperations.getString(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.lang.core.structure.INamedConcept"), "name"));
    }
  }

  public static void nodeFactory_NodeSetup_BuildLayout_NamedContainer_6099797596647438150(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.build.structure.BuildLayout_NamedContainer")) {
      ListSequence.fromList(SLinkOperations.getTargets(_context.getNewNode(), "children", true)).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.build.structure.BuildLayout_NamedContainer"), "children", true)));
      SLinkOperations.setTarget(_context.getNewNode(), "containerName", SLinkOperations.getTarget(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.build.structure.BuildLayout_NamedContainer"), "containerName", true), true);
    }
  }

  public static void nodeFactory_NodeSetup_BuildMacro_6099797596647440631(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.build.structure.BuildMacro")) {
      SPropertyOperations.set(_context.getNewNode(), "name", SPropertyOperations.getString(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.build.structure.BuildMacro"), "name"));
    }
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_BuildCompositePath_4959435991187227346(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildCompositePath");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            return BuildCompositePath_Behavior.call_getHeadSuggestions_4959435991187212109(_context.getCurrentTargetNode(), BuildRelativePath_Behavior.call_getBasePath_4959435991187140515(SNodeOperations.getAncestor(_context.getCurrentTargetNode(), "jetbrains.mps.build.structure.BuildRelativePath", false, false), Context.defaultContext()));
          }
        };
        Iterable<String> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final String item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SPropertyOperations.set(_context.getCurrentTargetNode(), "head", (item));
                return null;
              }
            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_BuildLayout_Copy_5248329904287920296(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildLayout_Copy");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        SNode wrappedConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildInputFileSet");
        IChildNodeSetter setter = new AbstractChildNodeSetter() {
          public SNode wrapNode(SNode nodeToWrap, SModel model) {
            SNode cp = SConceptOperations.createNewNode("jetbrains.mps.build.structure.BuildLayout_Copy", null);
            SLinkOperations.setTarget(cp, "fileset", nodeToWrap, true);
            return cp;
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

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_BuildString_631271972589842683(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildString");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        SNode wrappedConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildStringPart");
        IChildNodeSetter setter = new AbstractChildNodeSetter() {
          public SNode wrapNode(SNode nodeToWrap, SModel model) {
            SNode res = SConceptOperations.createNewNode("jetbrains.mps.build.structure.BuildString", null);
            ListSequence.fromList(SLinkOperations.getTargets(res, "parts", true)).addElement(nodeToWrap);
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

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_BuildStringPart_4903714810883808412(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildVarRefStringPart");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            Scope scope = Scope.getScope(((_context.getCurrentTargetNode() != null) ?
              _context.getCurrentTargetNode() :
              _context.getParentNode()
            ), null, SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildMacro"));
            if (scope == null) {
              return null;
            }
            return ListSequence.fromList(scope.getAvailableElements(null)).where(new IWhereFilter<SNode>() {
              public boolean accept(SNode it) {
                return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.structure.BuildVariableMacro");
              }
            }).select(new ISelector<SNode, SNode>() {
              public SNode select(SNode it) {
                return SNodeOperations.cast(it, "jetbrains.mps.build.structure.BuildVariableMacro");
              }
            }).toListSequence();
          }
        };
        Iterable<SNode> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode res = SNodeFactoryOperations.createNewNode(model, "jetbrains.mps.build.structure.BuildVarRefStringPart", null);
                SLinkOperations.setTarget(res, "macro", (item), false);
                return res;
              }

              public String getMatchingText(String pattern) {
                return "$" + SPropertyOperations.getString((item), "name");
              }

              public String getVisibleMatchingText(String pattern) {
                return this.getMatchingText(pattern);
              }
            });
          }
        }
      }
    }
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildTextStringPart");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (outputConcept == null || SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        ListSequence.fromList(result).addElement(new DefaultSimpleSubstituteAction(outputConcept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
          public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
            SNode buildText = SNodeFactoryOperations.createNewNode(model, "jetbrains.mps.build.structure.BuildTextStringPart", null);
            SPropertyOperations.set(buildText, "text", pattern);
            return buildText;
          }

          public String getMatchingText(String pattern) {
            if (StringUtils.isEmpty(pattern)) {
              return "text";
            }
            {
              Pattern _pattern_0 = REGEXP_x583g4_a0a0b0b0a0a0a0c0a0c0q;
              Matcher _matcher_0 = _pattern_0.matcher(pattern);
              if (_matcher_0.find()) {
                return pattern;
              }
            }
            return null;
          }

          public String getVisibleMatchingText(String pattern) {
            return this.getMatchingText(pattern);
          }
        });
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_BuildSource_JavaFiles_1500819558096177294(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildSource_JavaFiles");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        SNode wrappedConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildInputSingleFolder");
        IChildNodeSetter setter = new AbstractChildNodeSetter() {
          public SNode wrapNode(SNode nodeToWrap, SModel model) {
            SNode n = SModelOperations.createNewNode(model, "jetbrains.mps.build.structure.BuildSource_JavaFiles", null);
            SLinkOperations.setTarget(n, "resset", nodeToWrap, true);
            return n;
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

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_BuildSource_JavaDependencyJar_3717132724152602155(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildSource_JavaDependencyJar");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        SNode wrappedConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildSource_JavaJar");
        IChildNodeSetter setter = new AbstractChildNodeSetter() {
          public SNode wrapNode(SNode nodeToWrap, SModel model) {
            SNode n = SModelOperations.createNewNode(model, "jetbrains.mps.build.structure.BuildSource_JavaDependencyJar", null);
            SLinkOperations.setTarget(n, "jar", nodeToWrap, true);
            return n;
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

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_BuildSource_JavaLibraryCP_3717132724152913086(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildSource_JavaLibraryCP");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        SNode wrappedConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildSource_JavaCP");
        IChildNodeSetter setter = new AbstractChildNodeSetter() {
          public SNode wrapNode(SNode nodeToWrap, SModel model) {
            SNode n = SModelOperations.createNewNode(model, "jetbrains.mps.build.structure.BuildSource_JavaLibraryCP", null);
            SLinkOperations.setTarget(n, "classpath", nodeToWrap, true);
            return n;
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

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BuildCompositePath_8618885170173707589(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildCompositePath");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SNodeFactoryOperations.setNewChild(_context.getSourceNode(), "tail", "jetbrains.mps.build.structure.BuildCompositePath");
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "/";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BuildSourceMacroRelativePath_7321017245476976345(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildSourceMacroRelativePath");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SNodeFactoryOperations.setNewChild(_context.getSourceNode(), "compositePart", "jetbrains.mps.build.structure.BuildCompositePath");
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "/";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BuildSourceProjectRelativePath_3877654905647401341(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildSourceProjectRelativePath");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SNodeFactoryOperations.setNewChild(_context.getSourceNode(), "compositePart", "jetbrains.mps.build.structure.BuildCompositePath");
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "/";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BuildStringPart_4903714810883831023(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      final String[] lastPattern = new String[1];
      List<INodeSubstituteAction> list = ModelActions.createChildSubstituteActions(_context.getSourceNode(), null, SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildStringPart"), new AbstractChildNodeSetter() {
        public SNode doExecute(SNode parentNode, SNode oldChild, SNode newChild, IScope p3) {
          return substitute(newChild, lastPattern[0]);
        }

        private SNode substitute(SNode result, String pattern) {
          return SNodeOperations.insertNextSiblingChild(_context.getSourceNode(), result);
        }
      }, operationContext);
      for (final INodeSubstituteAction action : list) {
        ListSequence.fromList(result).addElement(new NodeSubstituteActionWrapper(action) {
          @Override
          public SNode substitute(@Nullable EditorContext context, String pattern) {
            lastPattern[0] = pattern;
            return super.substitute(context, pattern);
          }
        });
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BuildProjectDependency_4129895186893506280(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildProjectDependency");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SNodeFactoryOperations.setNewChild(_context.getSourceNode(), "artifacts", "jetbrains.mps.build.structure.BuildSourcePath");
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "(";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }

        public String getDescriptionText(String pattern) {
          return "custom artifacts location";
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BuildSource_JavaDependencyModule_7259033139236507338(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildSource_JavaDependencyModule");
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

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BuildSource_JavaDependencyLibrary_5979287180587351142(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildSource_JavaDependencyLibrary");
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

  public static class QuotationClass_x583g4_a2a6a5 {
    public QuotationClass_x583g4_a2a6a5() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.structure.BuildSourceProjectRelativePath", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
