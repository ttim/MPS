package treepathFeatures;

/*Generated by MPS */

import jetbrains.mps.ypath.design.IGenericParameterizedFeatureDesign;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.generator.template.ITemplateGenerator;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.ypath.design.IGenericFeatureDesign;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class SNODE_GEN_Design {
  public static class Design_Feature_child extends IGenericParameterizedFeatureDesign.Stub<SNode> implements IGenericParameterizedFeatureDesign<SNode> {
    public Iterable<SNode> getParameters(SNode nodeType) {
      return ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(nodeType, "concept", false), "linkDeclaration", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return "aggregation".equals(SPropertyOperations.getString_def(it, "metaClass", "reference"));
        }
      });
    }

    public SNode getTargetType(SNode param, SNode nodeType) {
      SNode ld = param;
      SNode trg = SLinkOperations.getTarget(ld, "target", false);
      return new SNODE_GEN_Design.Design_Feature_child.QuotationClass_d0icvv_a0c0b0().createNode(trg);
    }

    public String parameterToString(SNode param) {
      return SPropertyOperations.getString(param, "role");
    }

    public SNode getterExpression(SNode expression, SNode param, ITemplateGenerator generator) {
      SNode opExpr = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.DotExpression", null);
      SNode op;
      SLinkOperations.setTarget(opExpr, "operand", expression, true);
      if (SnodeGenUtil.singleCardinality(SPropertyOperations.getString_def(param, "sourceCardinality", "0..1"))) {
        op = SConceptOperations.createNewNode("jetbrains.mps.lang.smodel.structure.SLinkAccess", null);
        SLinkOperations.setTarget(SNodeOperations.cast(op, "jetbrains.mps.lang.smodel.structure.SLinkAccess"), "link", param, false);
      } else {
        op = SConceptOperations.createNewNode("jetbrains.mps.lang.smodel.structure.SLinkListAccess", null);
        SLinkOperations.setTarget(SNodeOperations.cast(op, "jetbrains.mps.lang.smodel.structure.SLinkListAccess"), "link", param, false);
      }
      SLinkOperations.setTarget(opExpr, "operation", op, true);
      return opExpr;
    }

    public boolean isSingleTargetCardinality(SNode param) {
      return SnodeGenUtil.singleCardinality(SPropertyOperations.getString_def(param, "sourceCardinality", "0..1"));
    }

    public static class QuotationClass_d0icvv_a0c0b0 {
      public QuotationClass_d0icvv_a0c0b0() {
      }

      public SNode createNode(Object parameter_iaikir_a0a0c0a0) {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_iaikir_a0c0a0 = null;
        {
          quotedNode_iaikir_a0c0a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
          SNode quotedNode1_iaikir_a0c0a0 = quotedNode_iaikir_a0c0a0;
          quotedNode1_iaikir_a0c0a0.setReferent("concept", (SNode) parameter_iaikir_a0a0c0a0);
          result = quotedNode1_iaikir_a0c0a0;
        }
        return result;
      }
    }
  }

  public static class Design_Feature_link extends IGenericParameterizedFeatureDesign.Stub<SNode> implements IGenericParameterizedFeatureDesign<SNode> {
    public Iterable<SNode> getParameters(SNode nodeType) {
      return ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(nodeType, "concept", false), "linkDeclaration", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SPropertyOperations.getString_def(it, "metaClass", "reference") == null || "reference".equals(SPropertyOperations.getString_def(it, "metaClass", "reference"));
        }
      });
    }

    public SNode getTargetType(SNode param, SNode nodeType) {
      SNode ld = param;
      SNode trg = SLinkOperations.getTarget(ld, "target", false);
      return new SNODE_GEN_Design.Design_Feature_link.QuotationClass_d0icvv_a0c0b1().createNode(trg);
    }

    public String parameterToString(SNode param) {
      return SPropertyOperations.getString(param, "role");
    }

    public SNode getterExpression(SNode expression, SNode param, ITemplateGenerator generator) {
      SNode opExpr = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.DotExpression", null);
      SNode op;
      SLinkOperations.setTarget(opExpr, "operand", expression, true);
      if (SnodeGenUtil.singleCardinality(SPropertyOperations.getString_def(param, "sourceCardinality", "0..1"))) {
        op = SConceptOperations.createNewNode("jetbrains.mps.lang.smodel.structure.SLinkAccess", null);
        SLinkOperations.setTarget(SNodeOperations.cast(op, "jetbrains.mps.lang.smodel.structure.SLinkAccess"), "link", param, false);
      } else {
        op = SConceptOperations.createNewNode("jetbrains.mps.lang.smodel.structure.SLinkListAccess", null);
        SLinkOperations.setTarget(SNodeOperations.cast(op, "jetbrains.mps.lang.smodel.structure.SLinkListAccess"), "link", param, false);
      }
      SLinkOperations.setTarget(opExpr, "operation", op, true);
      return opExpr;
    }

    public boolean isSingleTargetCardinality(SNode param) {
      return SnodeGenUtil.singleCardinality(SPropertyOperations.getString_def(param, "sourceCardinality", "0..1"));
    }

    public static class QuotationClass_d0icvv_a0c0b1 {
      public QuotationClass_d0icvv_a0c0b1() {
      }

      public SNode createNode(Object parameter_iaikir_a0a0c0a1) {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_iaikir_a0c0a1 = null;
        {
          quotedNode_iaikir_a0c0a1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
          SNode quotedNode1_iaikir_a0c0a1 = quotedNode_iaikir_a0c0a1;
          quotedNode1_iaikir_a0c0a1.setReferent("concept", (SNode) parameter_iaikir_a0a0c0a1);
          result = quotedNode1_iaikir_a0c0a1;
        }
        return result;
      }
    }
  }

  public static class Design_Feature_allChildren extends IGenericFeatureDesign.Stub implements IGenericFeatureDesign {
    public SNode getterExpression(SNode expression, ITemplateGenerator generator) {
      return new SNODE_GEN_Design.Design_Feature_allChildren.QuotationClass_d0icvv_a0a0a2().createNode(expression);
    }

    public static class QuotationClass_d0icvv_a0a0a2 {
      public QuotationClass_d0icvv_a0a0a2() {
      }

      public SNode createNode(Object parameter_iaikir_a0a0a0a0c) {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_iaikir_a0a0a2 = null;
        SNode quotedNode_iaikir_a0a0a0c = null;
        SNode quotedNode_iaikir_a0a0a0c_0 = null;
        {
          quotedNode_iaikir_a0a0a2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.DotExpression", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
          SNode quotedNode1_iaikir_a0a0a2 = quotedNode_iaikir_a0a0a2;
          {
            quotedNode_iaikir_a0a0a0c = (SNode) parameter_iaikir_a0a0a0a0c;
            SNode quotedNode1_iaikir_a0a0a0c;
            if (_parameterValues_129834374.contains(quotedNode_iaikir_a0a0a0c)) {
              quotedNode1_iaikir_a0a0a0c = CopyUtil.copy(quotedNode_iaikir_a0a0a0c);
            } else {
              _parameterValues_129834374.add(quotedNode_iaikir_a0a0a0c);
              quotedNode1_iaikir_a0a0a0c = quotedNode_iaikir_a0a0a0c;
            }
            if (quotedNode1_iaikir_a0a0a0c != null) {
              quotedNode_iaikir_a0a0a2.addChild("operand", HUtil.copyIfNecessary(quotedNode1_iaikir_a0a0a0c));
            }
          }
          {
            quotedNode_iaikir_a0a0a0c_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.Node_GetChildrenOperation", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
            SNode quotedNode1_iaikir_a0a0a0c_0 = quotedNode_iaikir_a0a0a0c_0;
            quotedNode_iaikir_a0a0a2.addChild("operation", quotedNode1_iaikir_a0a0a0c_0);
          }
          result = quotedNode1_iaikir_a0a0a2;
        }
        return result;
      }
    }
  }

  public static class Design_Feature_parent extends IGenericFeatureDesign.Stub implements IGenericFeatureDesign {
    public SNode getterExpression(SNode expression, ITemplateGenerator generator) {
      return new SNODE_GEN_Design.Design_Feature_parent.QuotationClass_d0icvv_a0a0a3().createNode(expression);
    }

    public static class QuotationClass_d0icvv_a0a0a3 {
      public QuotationClass_d0icvv_a0a0a3() {
      }

      public SNode createNode(Object parameter_iaikir_a0a0a0a0a0d) {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_iaikir_a0a0a3 = null;
        SNode quotedNode_iaikir_a0a0a0d = null;
        SNode quotedNode_iaikir_a0a0a0a3 = null;
        SNode quotedNode_iaikir_a0a0a0a3_0 = null;
        SNode quotedNode_iaikir_a0a0a0a0d = null;
        SNode quotedNode_iaikir_a0a0a0a0d_0 = null;
        {
          quotedNode_iaikir_a0a0a3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.GenericNewExpression", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
          SNode quotedNode1_iaikir_a0a0a3 = quotedNode_iaikir_a0a0a3;
          {
            quotedNode_iaikir_a0a0a0d = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ListCreatorWithInit", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
            SNode quotedNode1_iaikir_a0a0a0d = quotedNode_iaikir_a0a0a0d;
            {
              quotedNode_iaikir_a0a0a0a3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.DotExpression", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
              SNode quotedNode1_iaikir_a0a0a0a3 = quotedNode_iaikir_a0a0a0a3;
              {
                quotedNode_iaikir_a0a0a0a0d = (SNode) parameter_iaikir_a0a0a0a0a0d;
                SNode quotedNode1_iaikir_a0a0a0a0d;
                if (_parameterValues_129834374.contains(quotedNode_iaikir_a0a0a0a0d)) {
                  quotedNode1_iaikir_a0a0a0a0d = CopyUtil.copy(quotedNode_iaikir_a0a0a0a0d);
                } else {
                  _parameterValues_129834374.add(quotedNode_iaikir_a0a0a0a0d);
                  quotedNode1_iaikir_a0a0a0a0d = quotedNode_iaikir_a0a0a0a0d;
                }
                if (quotedNode1_iaikir_a0a0a0a0d != null) {
                  quotedNode_iaikir_a0a0a0a3.addChild("operand", HUtil.copyIfNecessary(quotedNode1_iaikir_a0a0a0a0d));
                }
              }
              {
                quotedNode_iaikir_a0a0a0a0d_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.Node_GetParentOperation", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
                SNode quotedNode1_iaikir_a0a0a0a0d_0 = quotedNode_iaikir_a0a0a0a0d_0;
                quotedNode_iaikir_a0a0a0a3.addChild("operation", quotedNode1_iaikir_a0a0a0a0d_0);
              }
              quotedNode_iaikir_a0a0a0d.addChild("initValue", quotedNode1_iaikir_a0a0a0a3);
            }
            {
              quotedNode_iaikir_a0a0a0a3_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
              SNode quotedNode1_iaikir_a0a0a0a3_0 = quotedNode_iaikir_a0a0a0a3_0;
              quotedNode_iaikir_a0a0a0d.addChild("elementType", quotedNode1_iaikir_a0a0a0a3_0);
            }
            quotedNode_iaikir_a0a0a3.addChild("creator", quotedNode1_iaikir_a0a0a0d);
          }
          result = quotedNode1_iaikir_a0a0a3;
        }
        return result;
      }
    }
  }
}
