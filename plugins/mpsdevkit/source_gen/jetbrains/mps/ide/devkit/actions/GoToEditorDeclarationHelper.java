package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.*;
import jetbrains.mps.util.Computable;
import javax.swing.JOptionPane;

import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;

public class GoToEditorDeclarationHelper {
  public GoToEditorDeclarationHelper() {
  }

  public static SNode getOrCreateEditorForConcept(final SModelDescriptor languageEditor, final SNode concept, final SNode node, final IScope scope) {
    SNode editorDeclaration = ModelAccess.instance().runReadAction(new Computable<SNode>() {
      public SNode compute() {
        return findEditorDeclaration(languageEditor.getSModel(), concept);
      }
    });
    if (editorDeclaration != null) {
      return editorDeclaration;
    }
    String message = ModelAccess.instance().runReadAction(new Computable<String>() {
      public String compute() {
        return "Concept \"" + node.getConceptFqName() + "\" has no editor.\n" + "Create new editor?";
      }
    });
    int option = JOptionPane.showConfirmDialog(null, message, "Editor not found", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (option != JOptionPane.YES_OPTION) {
      return null;
    }
    return ModelAccess.instance().runWriteActionInCommand(new Computable<SNode>() {
      public SNode compute() {
        return GoToEditorDeclarationHelper.createEditorDeclaration(concept, languageEditor, scope);
      }
    }, null);
  }

  public static SModelDescriptor getOrCreateEditorAspect(final Language language, final SNode concept, final IScope scope) {
    final SModelDescriptor languageEditor = LanguageAspect.EDITOR.get(language);
    if (languageEditor != null) {
      return languageEditor;
    }
    String message = "Language \"" + language.getModuleFqName() + "\" has no editor model.\n" + "Create new editor model?";
    int option = JOptionPane.showConfirmDialog(null, message, "Editor not found", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (option != JOptionPane.YES_OPTION) {
      return null;
    }
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        LanguageAspect.EDITOR.createNew(language);
        GoToEditorDeclarationHelper.createEditorDeclaration(concept, LanguageAspect.EDITOR.get(language), scope);
      }
    });
    return LanguageAspect.EDITOR.get(language);
  }

  public static SNode findEditorDeclaration(SModel editorModel, final SNode conceptDeclaration) {
    return ListSequence.fromList(SModelOperations.getRoots(editorModel, "jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration")).findFirst(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SLinkOperations.getTarget(it, "conceptDeclaration", false) == conceptDeclaration;
      }
    });
  }

  public static SNode createEditorDeclaration(SNode conceptDeclaration, SModelDescriptor editorModelDescriptor, IScope scope) {
    SModel editorModel = editorModelDescriptor.getSModel();
    SNode result = SNodeFactoryOperations.createNewNode(editorModel, "jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration", null);
    SLinkOperations.setTarget(result, "conceptDeclaration", conceptDeclaration, false);
    SModelOperations.addRootNode(editorModel, result);
    return result;
  }
}
