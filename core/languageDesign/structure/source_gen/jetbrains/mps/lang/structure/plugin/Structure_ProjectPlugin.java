package jetbrains.mps.lang.structure.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.projectplugins.BaseProjectPlugin;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.workbench.editors.MPSEditorOpener;
import jetbrains.mps.workbench.editors.MPSEditorOpenHandler;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.structure.behavior.IConceptAspect_Behavior;
import jetbrains.mps.ide.conceptEditor.ConceptEditorOpenHelper;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.ide.IEditor;
import java.util.List;
import jetbrains.mps.plugins.pluginparts.tool.BaseGeneratedTool;
import com.intellij.openapi.project.Project;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class Structure_ProjectPlugin extends BaseProjectPlugin {
  public void initEditors(MPSProject project) {
    MPSEditorOpener opener = project.getProject().getComponent(MPSEditorOpener.class);
    opener.registerOpenHandler(new MPSEditorOpenHandler() {
      public SNode getBaseNode(IOperationContext context, SNode node) {
        SNode baseNode = null;
        if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.IConceptAspect")) {
          baseNode = IConceptAspect_Behavior.call_getBaseConcept_2621449412040133768(SNodeOperations.cast(node, "jetbrains.mps.lang.structure.structure.IConceptAspect"));
        }
        if (baseNode == null) {
          baseNode = ConceptEditorOpenHelper.getBaseNode(context, node);
        }
        if (baseNode == null) {
          return null;
        }
        // We should be sure that node and base node are inside the same module.  
        // Otherwise, tabbed editor for base node will be opened, but there will be no tab for "node" 
        // So, the user will not be able to open node by a double-click 
        SModelDescriptor baseModelDesIcriptor = baseNode.getModel().getModelDescriptor();
        SModelDescriptor mainModelDescriptor = SNodeOperations.getModel(node).getModelDescriptor();
        if (mainModelDescriptor == null) {
          return null;
        }
        if (mainModelDescriptor.getModules().size() != 1) {
          return null;
        }
        IModule baseModule = baseModelDesIcriptor.getModule();
        IModule mainModule = mainModelDescriptor.getModule();
        if (mainModule instanceof Generator) {
          mainModule = ((Generator) mainModule).getSourceLanguage();
        }
        if (baseModule != mainModule) {
          return null;
        }
        if (!(ConceptEditorOpenHelper.canOpen(context, baseNode))) {
          return null;
        }
        return baseNode;
      }

      public boolean canOpen(IOperationContext context, SNode node) {
        return node.isInstanceOfConcept("jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration");
      }

      public IEditor open(IOperationContext context, SNode node) {
        return new ConceptDeclaration_TabbedEditor(context, node);
      }
    }, this);
  }

  public List<BaseGeneratedTool> initAllTools(Project project) {
    List<BaseGeneratedTool> tools = ListSequence.fromList(new ArrayList<BaseGeneratedTool>());
    ListSequence.fromList(tools).addElement(new StructureView_Tool(project));
    return tools;
  }
}
