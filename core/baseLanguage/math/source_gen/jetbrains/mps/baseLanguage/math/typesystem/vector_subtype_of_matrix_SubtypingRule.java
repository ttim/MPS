package jetbrains.mps.baseLanguage.math.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class vector_subtype_of_matrix_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {
  public vector_subtype_of_matrix_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode vectorType, TypeCheckingContext typeCheckingContext) {
    return new vector_subtype_of_matrix_SubtypingRule.QuotationClass_0764_0().createNode(SLinkOperations.getTarget(vectorType, "elementType", true), "" + SPropertyOperations.getInteger(vectorType, "height"), typeCheckingContext);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.math.structure.VectorType";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean isWeak() {
    return false;
  }

  public static class QuotationClass_0764_0 {
    public QuotationClass_0764_0() {
    }

    public SNode createNode(Object parameter_0764_0, Object parameter_0764_1, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_0764_0 = null;
      SNode quotedNode_0764_1 = null;
      {
        quotedNode_0764_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_0764_0 = quotedNode_0764_0;
        quotedNode1_0764_0.setProperty("columns", "1");
        quotedNode1_0764_0.setProperty("rows", (String) parameter_0764_1);
        {
          quotedNode_0764_1 = (SNode) parameter_0764_0;
          SNode quotedNode1_0764_1;
          if (_parameterValues_129834374.contains(quotedNode_0764_1)) {
            quotedNode1_0764_1 = CopyUtil.copy(quotedNode_0764_1);
          } else {
            _parameterValues_129834374.add(quotedNode_0764_1);
            quotedNode1_0764_1 = quotedNode_0764_1;
          }
          if (quotedNode1_0764_1 != null) {
            quotedNode_0764_0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_0764_1, typeCheckingContext));
          }
        }
        result = quotedNode1_0764_0;
      }
      return result;
    }

    public SNode createNode(Object parameter_0764_0, Object parameter_0764_1) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_0764_0 = null;
      SNode quotedNode_0764_1 = null;
      {
        quotedNode_0764_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_0764_0 = quotedNode_0764_0;
        quotedNode1_0764_0.setProperty("columns", "1");
        quotedNode1_0764_0.setProperty("rows", (String) parameter_0764_1);
        {
          quotedNode_0764_1 = (SNode) parameter_0764_0;
          SNode quotedNode1_0764_1;
          if (_parameterValues_129834374.contains(quotedNode_0764_1)) {
            quotedNode1_0764_1 = CopyUtil.copy(quotedNode_0764_1);
          } else {
            _parameterValues_129834374.add(quotedNode_0764_1);
            quotedNode1_0764_1 = quotedNode_0764_1;
          }
          if (quotedNode1_0764_1 != null) {
            quotedNode_0764_0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_0764_1));
          }
        }
        result = quotedNode1_0764_0;
      }
      return result;
    }
  }
}
