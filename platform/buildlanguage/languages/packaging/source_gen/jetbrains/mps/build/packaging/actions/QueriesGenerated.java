package jetbrains.mps.build.packaging.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstitutePreconditionContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.build.packaging.behavior.Module_Behavior;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.io.File;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.build.packaging.behavior.MPSLayout_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;

public class QueriesGenerated {

  public static boolean nodeSubstituteActionsBuilder_Precondition_TargetDeclaration_1224177706747(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.build.packaging.structure.Antcall") && (SLinkOperations.getTarget(_context.getParentNode(), "project", false) != null);
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Module_1203607567791(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.packaging.structure.Module");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Calculable calc = new Calculable() {

          public Object calculate() {
            return Module_Behavior.getAllAvailableModules_1222444746697();
          }

        };
        Iterable<IModule> queryResult = (Iterable)calc.calculate();
        if (queryResult != null) {
          for(final IModule item : queryResult) {
            result.add(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode newNode = SConceptOperations.createNewNode("jetbrains.mps.build.packaging.structure.Module", null);
                SPropertyOperations.set(newNode, "id", (item).getModuleId().toString());
                SPropertyOperations.set(newNode, "name", (item).getModuleReference().getModuleFqName());
                return newNode;
              }

            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_PathComponent_1220977388727(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.packaging.structure.PathComponent");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Calculable calc = new Calculable() {

          public Object calculate() {
            SNode compositePathComponent = _context.getParentNode();
            String base = SPropertyOperations.getString(SLinkOperations.getTarget(SNodeOperations.getParent(compositePathComponent), "macro", true), "path");
            for(SNode path : Sequence.fromIterable(SLinkOperations.getTargets(compositePathComponent, "pathComponent", true))) {
              if (path == _context.getCurrentTargetNode()) {
                break;
              }
              base += "/" + SPropertyOperations.getString(path, "path");
            }
            if (base.equals("")) {
              base = ".";
            }
            File baseDir = new File(base);
            File[] suggestFiles = baseDir.listFiles();
            boolean isFile = SPropertyOperations.getBoolean(SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.build.packaging.structure.AbstractProjectComponent", true, false), "file");
            List<String> suggestStrings = ListSequence.<String>fromArray();
            for(File f : suggestFiles) {
              if (f.exists() && (isFile || f.isDirectory())) {
                ListSequence.fromList(suggestStrings).addElement(f.getName());
              }
            }
            return suggestStrings;
          }

        };
        Iterable<String> queryResult = (Iterable)calc.calculate();
        if (queryResult != null) {
          for(final String item : queryResult) {
            result.add(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode pathComponent = SConceptOperations.createNewNode("jetbrains.mps.build.packaging.structure.PathComponent", null);
                SPropertyOperations.set(pathComponent, "path", (item));
                return pathComponent;
              }

            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_MacroReference_1220979539658(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.packaging.structure.MacroReference");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Calculable calc = new Calculable() {

          public Object calculate() {
            return MPSLayout_Behavior.call_getAllMacroNames_1220980057360(SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.build.packaging.structure.MPSLayout", true, true), SConceptPropertyOperations.getBoolean(_context.getParentNode(), "canStartFromBasedir"));
          }

        };
        Iterable<String> queryResult = (Iterable)calc.calculate();
        if (queryResult != null) {
          for(final String item : queryResult) {
            result.add(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode macro = SConceptOperations.createNewNode("jetbrains.mps.build.packaging.structure.MacroReference", null);
                SPropertyOperations.set(macro, "name", (item));
                return macro;
              }

            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_TargetDeclaration_1224177681541(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.buildlanguage.structure.TargetReference");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Calculable calc = new Calculable() {

          public Object calculate() {
            return SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getParentNode(), "project", false), "target", true);
          }

        };
        Iterable<SNode> queryResult = (Iterable)calc.calculate();
        if (queryResult != null) {
          for(final SNode item : queryResult) {
            result.add(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode reference = SConceptOperations.createNewNode("jetbrains.mps.buildlanguage.structure.TargetReference", null);
                SLinkOperations.setTarget(reference, "targetDeclaration", (item), false);
                return reference;
              }

            });
          }
        }
      }
    }
    return result;
  }

}
