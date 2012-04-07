package jetbrains.mps.ide.java.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.nodeEditor.EditorContext;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GenerateMainMethod_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(GenerateMainMethod_Action.class);

  public GenerateMainMethod_Action() {
    super("main(Strins[] args)", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    SNode classConcept = GenerateMainMethod_Action.this.getClassConcept(_params);
    return !(ListSequence.fromList(SLinkOperations.getTargets(classConcept, "staticMethod", true)).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return "main".equals(SPropertyOperations.getString(it, "name")) && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(it, "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType") && (int) ListSequence.fromList(SLinkOperations.getTargets(it, "parameter", true)).count() == 1 && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(ListSequence.fromList(SLinkOperations.getTargets(it, "parameter", true)).first(), "type", true), "jetbrains.mps.baseLanguage.structure.ArrayType");
      }
    })) && !(SNodeOperations.isInstanceOf(classConcept, "jetbrains.mps.baseLanguage.structure.AnonymousClass"));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "GenerateMainMethod", t);
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
      SNode classConcept = GenerateMainMethod_Action.this.getClassConcept(_params);
      SNode methodNode = new GenerateMainMethod_Action.QuotationClass_8edthv_a0a1a0a3().createNode();
      ListSequence.fromList(SLinkOperations.getTargets(classConcept, "staticMethod", true)).addElement(methodNode);
      ((EditorContext) MapSequence.fromMap(_params).get("editorContext")).select(SLinkOperations.getTarget(methodNode, "body", true));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "GenerateMainMethod", t);
      }
    }
  }

  private SNode getClassConcept(final Map<String, Object> _params) {
    return SNodeOperations.getAncestor(((SNode) ((SNode) MapSequence.fromMap(_params).get("node"))), "jetbrains.mps.baseLanguage.structure.ClassConcept", true, false);
  }

  public static class QuotationClass_8edthv_a0a1a0a3 {
    public QuotationClass_8edthv_a0a1a0a3() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      SNode quotedNode_4 = null;
      SNode quotedNode_5 = null;
      SNode quotedNode_6 = null;
      SNode quotedNode_7 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_8 = quotedNode_1;
        quotedNode1_8.setProperty("name", "main");
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.VoidType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_9 = quotedNode_2;
          quotedNode_1.addChild("returnType", quotedNode1_9);
        }
        {
          quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.PublicVisibility", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_10 = quotedNode_3;
          quotedNode_1.addChild("visibility", quotedNode1_10);
        }
        {
          quotedNode_4 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StatementList", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_11 = quotedNode_4;
          quotedNode_1.addChild("body", quotedNode1_11);
        }
        {
          quotedNode_5 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ParameterDeclaration", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_12 = quotedNode_5;
          quotedNode1_12.setProperty("name", "args");
          {
            quotedNode_6 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ArrayType", null, GlobalScope.getInstance(), false);
            SNode quotedNode1_13 = quotedNode_6;
            {
              quotedNode_7 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringType", null, GlobalScope.getInstance(), false);
              SNode quotedNode1_14 = quotedNode_7;
              quotedNode_6.addChild("componentType", quotedNode1_14);
            }
            quotedNode_5.addChild("type", quotedNode1_13);
          }
          quotedNode_1.addChild("parameter", quotedNode1_12);
        }
        result = quotedNode1_8;
      }
      return result;
    }
  }
}
