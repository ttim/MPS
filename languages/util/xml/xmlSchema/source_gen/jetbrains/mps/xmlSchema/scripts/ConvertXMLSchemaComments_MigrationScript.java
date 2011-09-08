package jetbrains.mps.xmlSchema.scripts;

/*Generated by MPS */

import jetbrains.mps.lang.script.runtime.BaseMigrationScript;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.script.runtime.AbstractMigrationRefactoring;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConvertXMLSchemaComments_MigrationScript extends BaseMigrationScript {
  public ConvertXMLSchemaComments_MigrationScript(IOperationContext operationContext) {
    super("Convert XML Schema Comments");
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "convert SchemaCommentable";
      }

      public String getAdditionalInfo() {
        return "convert SchemaCommentable";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.xmlSchema.structure.SchemaCommentable";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        return node.getChild("comment") != null;
      }

      public void doUpdateInstanceNode(SNode node) {
        // xmlInternal.Comment 
        SNode comment = node.getChild("comment");
        // xml.BaseText 
        List<SNode> baseText = comment.getChildren("text");
        // xml.Text 
        Iterable<SNode> textParts = ListSequence.fromList(baseText).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return eq_zghlll_a0a0a0a0a0a5a4a0a0a1a0(it.getConceptFqName(), "jetbrains.mps.xml.structure.Text");
          }
        });

        SLinkOperations.setTarget(node, "sComment", SConceptOperations.createNewNode("jetbrains.mps.xmlSchema.structure.SchemaComment", null), true);
        ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(node, "sComment", true), "text", true)).addSequence(Sequence.fromIterable(textParts).select(new ISelector<SNode, SNode>() {
          public SNode select(SNode it) {
            return new ConvertXMLSchemaComments_MigrationScript.QuotationClass_zghlll_a0a0a0a0a8a4a0a0a1a0().createNode(it.getPersistentProperty("text"));
          }
        }));
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
  }

  private static boolean eq_zghlll_a0a0a0a0a0a5a4a0a0a1a0(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  public static class QuotationClass_zghlll_a0a0a0a0a8a4a0a0a1a0 {
    public QuotationClass_zghlll_a0a0a0a0a8a4a0a0a1a0() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlSchema.structure.TextLine", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setProperty("line", (String) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
