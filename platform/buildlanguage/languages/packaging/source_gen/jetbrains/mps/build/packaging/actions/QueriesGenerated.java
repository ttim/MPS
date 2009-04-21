package jetbrains.mps.build.packaging.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstitutePreconditionContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.build.packaging.behavior.Module_Behavior;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.io.File;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.build.packaging.behavior.IMacroHolder_Behavior;
import jetbrains.mps.smodel.action.DefaultSimpleSubstituteAction;

public class QueriesGenerated {

  public static boolean nodeSubstituteActionsBuilder_Precondition_TargetDeclaration_1224177706747(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.build.packaging.structure.Antcall") && (SLinkOperations.getTarget(SNodeOperations.cast(_context.getParentNode(), "jetbrains.mps.build.packaging.structure.Antcall"), "project", false) != null);
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Module_1203607567791(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.<INodeSubstituteAction>fromArray();
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
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode newNode = SConceptOperations.createNewNode("jetbrains.mps.build.packaging.structure.Module", null);
                SPropertyOperations.set(newNode, "id", (item).getModuleId().toString());
                SPropertyOperations.set(newNode, "name", Module_Behavior.extractModuleProperName_1235487584035((item)));
                return newNode;
              }

              public String getDescriptionText(String pattern) {
                return "mps module";
              }
            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_PathComponent_1220977388727(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.<INodeSubstituteAction>fromArray();
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.packaging.structure.PathComponent");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Calculable calc = new Calculable() {

          public Object calculate() {
            SNode compositePathComponent = SNodeOperations.cast(_context.getParentNode(), "jetbrains.mps.build.packaging.structure.CompositePathComponent");
            String base = SPropertyOperations.getString(SLinkOperations.getTarget(SNodeOperations.cast(SNodeOperations.getParent(compositePathComponent), "jetbrains.mps.build.packaging.structure.Path"), "macro", true), "path");
            if (base == null) {
              base = "";
            }
            for(SNode path : ListSequence.fromList(SLinkOperations.getTargets(compositePathComponent, "pathComponent", true))) {
              if (path == _context.getCurrentTargetNode()) {
                break;
              }
              base += "/" + SPropertyOperations.getString(path, "path");
            }
            File baseDir = new File(base);
            File[] suggestFiles = baseDir.listFiles();
            if (suggestFiles == null) {
              suggestFiles = File.listRoots();
              if (suggestFiles.length == 1 && suggestFiles[0].getAbsolutePath().equals("/")) {
                suggestFiles = suggestFiles[0].listFiles();
              }
            }
            SNode abstractProjectComponent = SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.build.packaging.structure.AbstractProjectComponent", true, false);
            boolean isFile = (abstractProjectComponent == null ?
              true :
              SConceptPropertyOperations.getBoolean(abstractProjectComponent, "acceptFiles")
            );
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
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode pathComponent = SConceptOperations.createNewNode("jetbrains.mps.build.packaging.structure.PathComponent", null);
                SPropertyOperations.set(pathComponent, "path", "" + ((item)));
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
    List<INodeSubstituteAction> result = ListSequence.<INodeSubstituteAction>fromArray();
    final String no_macro;
    {
      Calculable calc = new Calculable() {

        public Object calculate() {
          return "no macro";
        }
      };
      no_macro = (String)calc.calculate();
    }
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.packaging.structure.MacroReference");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Calculable calc = new Calculable() {

          public Object calculate() {
            List<String> allMacroNames = IMacroHolder_Behavior.call_getAllMacroNames_1234975567387(SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.build.packaging.structure.MPSLayout", true, false), SConceptPropertyOperations.getBoolean(SNodeOperations.cast(_context.getParentNode(), "jetbrains.mps.build.packaging.structure.IPath"), "canStartFromBasedir"));
            ListSequence.fromList(allMacroNames).addElement(no_macro);
            return allMacroNames;
          }
        };
        Iterable<String> queryResult = (Iterable)calc.calculate();
        if (queryResult != null) {
          for(final String item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode macro = SConceptOperations.createNewNode("jetbrains.mps.build.packaging.structure.MacroReference", null);
                if ((item).equals(no_macro)) {
                  SPropertyOperations.set(macro, "name", "");
                } else
                {
                  SPropertyOperations.set(macro, "name", "" + ((item)));
                }
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
    List<INodeSubstituteAction> result = ListSequence.<INodeSubstituteAction>fromArray();
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.buildlanguage.structure.TargetReference");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Calculable calc = new Calculable() {

          public Object calculate() {
            return SLinkOperations.getTargets(SLinkOperations.getTarget(SNodeOperations.cast(_context.getParentNode(), "jetbrains.mps.build.packaging.structure.Antcall"), "project", false), "target", true);
          }
        };
        Iterable<SNode> queryResult = (Iterable)calc.calculate();
        if (queryResult != null) {
          for(final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

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

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_IStringExpression_1240313281121(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.<INodeSubstituteAction>fromArray();
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.packaging.structure.IStringExpression");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (outputConcept == null || SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        ListSequence.fromList(result).addElement(new DefaultSimpleSubstituteAction(outputConcept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

          public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
            SNode string = SConceptOperations.createNewNode("jetbrains.mps.build.packaging.structure.SimpleString", null);
            SPropertyOperations.set(string, "name", pattern);
            return string;
          }

          public boolean hasSubstitute() {
            return true;
          }

          public boolean canSubstitute_internal(String pattern, boolean strictly) {
            return true;
          }

          public String getDescriptionText(String pattern) {
            return "simple string";
          }

          public String getMatchingText(String pattern) {
            return "*";
          }

          public String getVisibleMatchingText(String pattern) {
            return this.getMatchingText(pattern);
          }
        });
      }
    }
    return result;
  }

}
