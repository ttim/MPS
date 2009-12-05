package jetbrains.mps.baseLanguage.scripts;

/*Generated by MPS */

import jetbrains.mps.lang.script.runtime.BaseMigrationScript;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.script.runtime.AbstractMigrationRefactoring;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class BaseLanguageMigration_MigrationScript extends BaseMigrationScript {
  public BaseLanguageMigration_MigrationScript(IOperationContext operationContext) {
    super("BaseLanguage migration");
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "convert commented statements";
      }

      public String getAdditionalInfo() {
        return "convert commented statements";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.CommentedStatement";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        return true;
      }

      public void doUpdateInstanceNode(SNode node) {
        SNode comment = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.SingleLineComment", null);
        SNode statementCommentPart = SLinkOperations.addNewChild(comment, "commentPart", "jetbrains.mps.baseLanguage.structure.StatementCommentPart");
        SNodeOperations.replaceWithAnother(node, comment);
        SLinkOperations.setTarget(statementCommentPart, "commentedStatement", SLinkOperations.getTarget(node, "statement", true), true);
      }

      public boolean isShowAsIntention() {
        return true;
      }
    });
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "convert remark statements";
      }

      public String getAdditionalInfo() {
        return "convert remark statements";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.RemarkStatement";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        return true;
      }

      public void doUpdateInstanceNode(SNode node) {
        SNode comment = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.SingleLineComment", null);
        SNodeOperations.replaceWithAnother(node, comment);
        if (StringUtils.isNotEmpty(SPropertyOperations.getString(node, "value"))) {
          SNode textCommentPart = SLinkOperations.addNewChild(comment, "commentPart", "jetbrains.mps.baseLanguage.structure.TextCommentPart");
          SPropertyOperations.set(textCommentPart, "text", SPropertyOperations.getString(node, "value"));
        }
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "ConvertToIncrements";
      }

      public String getAdditionalInfo() {
        return "ConvertToIncrements";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.AssignmentExpression";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "lValue", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"))) {
          return false;
        }
        SNode declaration = SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(node, "lValue", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"), "variableDeclaration", false);
        if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "rValue", true), "jetbrains.mps.baseLanguage.structure.PlusExpression"))) {
          return false;
        }
        SNode plusExpr = SNodeOperations.cast(SLinkOperations.getTarget(node, "rValue", true), "jetbrains.mps.baseLanguage.structure.PlusExpression");
        if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(plusExpr, "leftExpression", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"))) {
          return false;
        }
        if (SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(plusExpr, "leftExpression", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"), "variableDeclaration", false) != declaration) {
          return false;
        }
        if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(plusExpr, "rightExpression", true), "jetbrains.mps.baseLanguage.structure.IntegerConstant"))) {
          return false;
        }
        if (SPropertyOperations.getInteger(SNodeOperations.cast(SLinkOperations.getTarget(plusExpr, "rightExpression", true), "jetbrains.mps.baseLanguage.structure.IntegerConstant"), "value") != 1) {
          return false;
        }
        return true;
      }

      public void doUpdateInstanceNode(SNode node) {
        SNode declaration = SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(node, "lValue", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"), "variableDeclaration", false);
        SNode ref = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.LocalVariableReference", null);
        SLinkOperations.setTarget(ref, "variableDeclaration", declaration, false);
        SNode inc = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.PostfixIncrementExpression", null);
        SLinkOperations.setTarget(inc, "expression", ref, true);
        SNodeOperations.replaceWithAnother(node, inc);
      }

      public boolean isShowAsIntention() {
        return true;
      }
    });
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "ConvertToDecrements";
      }

      public String getAdditionalInfo() {
        return "ConvertToDecrements";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.AssignmentExpression";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "lValue", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"))) {
          return false;
        }
        SNode declaration = SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(node, "lValue", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"), "variableDeclaration", false);
        if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "rValue", true), "jetbrains.mps.baseLanguage.structure.MinusExpression"))) {
          return false;
        }
        SNode minusExpr = SNodeOperations.cast(SLinkOperations.getTarget(node, "rValue", true), "jetbrains.mps.baseLanguage.structure.MinusExpression");
        if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(minusExpr, "leftExpression", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"))) {
          return false;
        }
        if (SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(minusExpr, "leftExpression", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"), "variableDeclaration", false) != declaration) {
          return false;
        }
        if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(minusExpr, "rightExpression", true), "jetbrains.mps.baseLanguage.structure.IntegerConstant"))) {
          return false;
        }
        if (SPropertyOperations.getInteger(SNodeOperations.cast(SLinkOperations.getTarget(minusExpr, "rightExpression", true), "jetbrains.mps.baseLanguage.structure.IntegerConstant"), "value") != 1) {
          return false;
        }
        return true;
      }

      public void doUpdateInstanceNode(SNode node) {
        SNode declaration = SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(node, "lValue", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"), "variableDeclaration", false);
        SNode ref = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.LocalVariableReference", null);
        SLinkOperations.setTarget(ref, "variableDeclaration", declaration, false);
        SNode dec = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.PostfixDecrementExpression", null);
        SLinkOperations.setTarget(dec, "expression", ref, true);
        SNodeOperations.replaceWithAnother(node, dec);
      }

      public boolean isShowAsIntention() {
        return true;
      }
    });
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "String classifiers";
      }

      public String getAdditionalInfo() {
        return "String classifiers";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.ClassifierType";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        return SLinkOperations.getTarget(node, "classifier", false) == SLinkOperations.getTarget(new _Quotations.QuotationClass_1().createNode(), "classifier", false);
      }

      public void doUpdateInstanceNode(SNode node) {
        SNodeOperations.replaceWithNewChild(node, "jetbrains.mps.baseLanguage.structure.StringType");
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
  }
}
