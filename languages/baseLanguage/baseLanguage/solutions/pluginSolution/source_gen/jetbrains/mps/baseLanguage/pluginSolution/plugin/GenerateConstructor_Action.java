package jetbrains.mps.baseLanguage.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.nodeEditor.EditorContext;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.project.Project;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class GenerateConstructor_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(GenerateConstructor_Action.class);

  public GenerateConstructor_Action() {
    super("Constructor", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "GenerateConstructor", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("node", event.getData(MPSCommonDataKeys.NODE));
    MapSequence.fromMap(_params).put("editorContext", event.getData(MPSEditorDataKeys.EDITOR_CONTEXT));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      SNode classConcept = SNodeOperations.getAncestor(((SNode) ((SNode) MapSequence.fromMap(_params).get("node"))), "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false);
      SNode superclass;
      SNodePointer[] ctors = null;
      boolean needsShowConstructorsDialog = false;
      SNodePointer[] selectedConstructors = null;
      SNodePointer[] selectedFields = null;
      superclass = SNodeOperations.as(SLinkOperations.getTarget(SLinkOperations.getTarget(classConcept, "superclass", true), "classifier", false), "jetbrains.mps.baseLanguage.structure.ClassConcept");
      if (superclass == null) {
        superclass = SNodeOperations.getNode("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)", "~Object");
      }
      if (ListSequence.fromList(SLinkOperations.getTargets(superclass, "constructor", true)).count() > 1) {
        needsShowConstructorsDialog = true;
        ctors = ListSequence.fromList(SLinkOperations.getTargets(superclass, "constructor", true)).select(new ISelector<SNode, SNodePointer>() {
          public SNodePointer select(SNode it) {
            return new SNodePointer(it);
          }
        }).toGenericArray(SNodePointer.class);
      } else {
        selectedConstructors = new SNodePointer[]{new SNodePointer(ListSequence.fromList(SLinkOperations.getTargets(superclass, "constructor", true)).first())};
      }
      if (needsShowConstructorsDialog) {
        SelectConstructorsDialog selectConstructorsDialog = new SelectConstructorsDialog(ctors, ((EditorContext) MapSequence.fromMap(_params).get("editorContext")).getOperationContext().getProject());
        selectConstructorsDialog.setTitle("Choose Super Class Constructor");
        selectConstructorsDialog.show();

        if (!(selectConstructorsDialog.isOK())) {
          return;
        }
        List<SNodePointer> selectedElements = selectConstructorsDialog.getSelectedElements();
        selectedConstructors = (selectedElements != null ?
          selectedElements.toArray(new SNodePointer[selectedElements.size()]) :
          new SNodePointer[0]
        );
      }

      boolean needsShowFieldsDialog = false;
      SNodePointer[] fields = null;
      if (ListSequence.fromList(SLinkOperations.getTargets(classConcept, "field", true)).isNotEmpty()) {
        needsShowFieldsDialog = true;
        fields = ListSequence.fromList(SLinkOperations.getTargets(classConcept, "field", true)).select(new ISelector<SNode, SNodePointer>() {
          public SNodePointer select(SNode it) {
            return new SNodePointer(it);
          }
        }).toGenericArray(SNodePointer.class);
      } else {
        selectedFields = new SNodePointer[0];
      }
      if (needsShowFieldsDialog) {
        SelectFieldsDialog selectFieldsDialog = new SelectFieldsDialog(fields, true, ((EditorContext) MapSequence.fromMap(_params).get("editorContext")).getOperationContext().getProject());
        selectFieldsDialog.setTitle("Choose Fields to Initialize by Constructor");
        selectFieldsDialog.show();

        if (!(selectFieldsDialog.isOK())) {
          return;
        }
        selectedFields = Sequence.fromIterable(((Iterable<SNodePointer>) selectFieldsDialog.getSelectedElements())).toGenericArray(SNodePointer.class);

      }
      SNode constructorDeclaration = null;
      Project project = ((EditorContext) MapSequence.fromMap(_params).get("editorContext")).getOperationContext().getProject();
      for (SNodePointer ptr : selectedConstructors) {
        SNode selectedSuperConstructor = SNodeOperations.cast(ptr.getNode(), "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration");
        SNode constructor = SNodeFactoryOperations.addNewChild(classConcept, "constructor", "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration");
        constructorDeclaration = constructor;
        SNodeFactoryOperations.setNewChild(constructor, "body", "jetbrains.mps.baseLanguage.structure.StatementList");
        if (ListSequence.fromList(SLinkOperations.getTargets(selectedSuperConstructor, "parameter", true)).isNotEmpty()) {
          SNode invocation = SNodeFactoryOperations.addNewChild(SLinkOperations.getTarget(constructor, "body", true), "statement", "jetbrains.mps.baseLanguage.structure.SuperConstructorInvocation");
          SLinkOperations.setTarget(invocation, "baseMethodDeclaration", selectedSuperConstructor, false);
          for (SNode superParam : SLinkOperations.getTargets(selectedSuperConstructor, "parameter", true)) {
            SNode parameter = SNodeFactoryOperations.addNewChild(constructor, "parameter", "jetbrains.mps.baseLanguage.structure.ParameterDeclaration");
            SPropertyOperations.set(parameter, "name", SPropertyOperations.getString(superParam, "name"));
            SLinkOperations.setTarget(parameter, "type", SNodeOperations.copyNode(SLinkOperations.getTarget(superParam, "type", true)), true);
            SNode paramReference = SNodeFactoryOperations.addNewChild(invocation, "actualArgument", "jetbrains.mps.baseLanguage.structure.ParameterReference");
            SLinkOperations.setTarget(paramReference, "variableDeclaration", parameter, false);
          }
        }
        for (SNodePointer fieldPtr : selectedFields) {
          SNode field = SNodeOperations.cast(fieldPtr.getNode(), "jetbrains.mps.baseLanguage.structure.FieldDeclaration");
          SNode parameterDeclaration = new GenerateConstructor_Action.QuotationClass_oh4di0_a0a1a5a71a0a2().createNode(SNodeOperations.copyNode(SLinkOperations.getTarget(field, "type", true)), GenerateGettersAndSettersUtil.getParameterNameForField(field, project));
          ListSequence.fromList(SLinkOperations.getTargets(constructor, "parameter", true)).addElement(parameterDeclaration);
          SNode expressionStatement = SNodeFactoryOperations.addNewChild(SLinkOperations.getTarget(constructor, "body", true), "statement", "jetbrains.mps.baseLanguage.structure.ExpressionStatement");
          SNode assignmentExpression = SNodeFactoryOperations.setNewChild(expressionStatement, "expression", "jetbrains.mps.baseLanguage.structure.AssignmentExpression");
          SLinkOperations.setTarget(assignmentExpression, "lValue", new GenerateConstructor_Action.QuotationClass_oh4di0_a2a5a5a71a0a2().createNode(field), true);
          SLinkOperations.setTarget(assignmentExpression, "rValue", new GenerateConstructor_Action.QuotationClass_oh4di0_a2a6a5a71a0a2().createNode(parameterDeclaration), true);
        }
      }
      if (constructorDeclaration != null) {
        ((EditorContext) MapSequence.fromMap(_params).get("editorContext")).select(constructorDeclaration);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "GenerateConstructor", t);
      }
    }
  }

  public static class QuotationClass_oh4di0_a0a1a5a71a0a2 {
    public QuotationClass_oh4di0_a0a1a5a71a0a2() {
    }

    public SNode createNode(Object parameter_5, Object parameter_6) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ParameterDeclaration", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        quotedNode1_3.setProperty("name", (String) parameter_6);
        {
          quotedNode_2 = (SNode) parameter_5;
          SNode quotedNode1_4;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_4 = HUtil.copyIfNecessary(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_4 = quotedNode_2;
          }
          if (quotedNode1_4 != null) {
            quotedNode_1.addChild("type", HUtil.copyIfNecessary(quotedNode1_4));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }

  public static class QuotationClass_oh4di0_a2a5a5a71a0a2 {
    public QuotationClass_oh4di0_a2a5a5a71a0a2() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("variableDeclaration", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_oh4di0_a2a6a5a71a0a2 {
    public QuotationClass_oh4di0_a2a6a5a71a0a2() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ParameterReference", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("variableDeclaration", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
