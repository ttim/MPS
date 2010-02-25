package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.baseLanguage.behavior.IOperation_Behavior;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class typeof_GetIteratorOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_GetIteratorOperation_InferenceRule() {
  }

  public void applyRule(final SNode iterator, final TypeCheckingContext typeCheckingContext) {
    final SNode elementType_typevar_1237470428123 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = IOperation_Behavior.call_getOperand_1213877410070(iterator);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1237470396562", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequationStrong((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1237470398548", true), (SNode) new typeof_GetIteratorOperation_InferenceRule.QuotationClass_7319_l523emneb35k().createNode(typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1237470428123), typeCheckingContext), false, _info_12389875345);
    }
    do {
      SNode matchedNode_5569_ftpum028 = typeCheckingContext.typeOf(IOperation_Behavior.call_getOperand_1213877410070(iterator), "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240152232529", true);
      {
        boolean matches_5569_ftpum02a = false;
        {
          SNode matchingNode_5569_ftpum02a = typeCheckingContext.typeOf(IOperation_Behavior.call_getOperand_1213877410070(iterator), "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240152232529", true);
          if (matchingNode_5569_ftpum02a != null) {
            matches_5569_ftpum02a = SModelUtil_new.isAssignableConcept(matchingNode_5569_ftpum02a.getConceptFqName(), "jetbrains.mps.baseLanguage.collections.structure.ListType");
          }
        }
        if (matches_5569_ftpum02a) {
          {
            SNode _nodeToCheck_1029348928467 = iterator;
            BaseIntentionProvider intentionProvider = null;
            EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240152280223", 0, intentionProvider);
            typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240152280231", true), (SNode) new typeof_GetIteratorOperation_InferenceRule.QuotationClass_7319_l523emneb38q().createNode(typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1237470428123), typeCheckingContext), _info_12389875345);
          }
          break;
        }
      }
      {
        boolean matches_5569_ftpum76c = false;
        {
          SNode matchingNode_5569_ftpum76c = typeCheckingContext.typeOf(IOperation_Behavior.call_getOperand_1213877410070(iterator), "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240152232529", true);
          if (matchingNode_5569_ftpum76c != null) {
            matches_5569_ftpum76c = SModelUtil_new.isAssignableConcept(matchingNode_5569_ftpum76c.getConceptFqName(), "jetbrains.mps.baseLanguage.collections.structure.SetType");
          }
        }
        if (matches_5569_ftpum76c) {
          {
            SNode _nodeToCheck_1029348928467 = iterator;
            BaseIntentionProvider intentionProvider = null;
            EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240152294406", 0, intentionProvider);
            typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240152294414", true), (SNode) new typeof_GetIteratorOperation_InferenceRule.QuotationClass_7319_l523emneb3bw().createNode(typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1237470428123), typeCheckingContext), _info_12389875345);
          }
          break;
        }
      }
      {
        SNode _nodeToCheck_1029348928467 = iterator;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240152278173", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240152278181", true), (SNode) new typeof_GetIteratorOperation_InferenceRule.QuotationClass_7319_l523emneb3f2().createNode(typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1237470428123), typeCheckingContext), _info_12389875345);
      }
    } while(false);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.GetIteratorOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_7319_l523emneb35k {
    public QuotationClass_7319_l523emneb35k() {
    }

    public SNode createNode(Object parameter_7319_l523emneao4i, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7319_l523emneao38 = null;
      SNode quotedNode_7319_l523emneao39 = null;
      {
        quotedNode_7319_l523emneao38 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7319_l523emneao38 = quotedNode_7319_l523emneao38;
        {
          quotedNode_7319_l523emneao39 = (SNode) parameter_7319_l523emneao4i;
          SNode quotedNode1_7319_l523emneao39;
          if (_parameterValues_129834374.contains(quotedNode_7319_l523emneao39)) {
            quotedNode1_7319_l523emneao39 = CopyUtil.copy(quotedNode_7319_l523emneao39);
          } else {
            _parameterValues_129834374.add(quotedNode_7319_l523emneao39);
            quotedNode1_7319_l523emneao39 = quotedNode_7319_l523emneao39;
          }
          if (quotedNode1_7319_l523emneao39 != null) {
            quotedNode_7319_l523emneao38.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_7319_l523emneao39, typeCheckingContext));
          }
        }
        result = quotedNode1_7319_l523emneao38;
      }
      return result;
    }

    public SNode createNode(Object parameter_7319_l523emneao4i) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7319_l523emneao38 = null;
      SNode quotedNode_7319_l523emneao39 = null;
      {
        quotedNode_7319_l523emneao38 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7319_l523emneao38 = quotedNode_7319_l523emneao38;
        {
          quotedNode_7319_l523emneao39 = (SNode) parameter_7319_l523emneao4i;
          SNode quotedNode1_7319_l523emneao39;
          if (_parameterValues_129834374.contains(quotedNode_7319_l523emneao39)) {
            quotedNode1_7319_l523emneao39 = CopyUtil.copy(quotedNode_7319_l523emneao39);
          } else {
            _parameterValues_129834374.add(quotedNode_7319_l523emneao39);
            quotedNode1_7319_l523emneao39 = quotedNode_7319_l523emneao39;
          }
          if (quotedNode1_7319_l523emneao39 != null) {
            quotedNode_7319_l523emneao38.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_7319_l523emneao39));
          }
        }
        result = quotedNode1_7319_l523emneao38;
      }
      return result;
    }
  }

  public static class QuotationClass_7319_l523emneb38q {
    public QuotationClass_7319_l523emneb38q() {
    }

    public SNode createNode(Object parameter_7319_l523emneao5u, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7319_l523emneao3j = null;
      SNode quotedNode_7319_l523emneao3k = null;
      {
        quotedNode_7319_l523emneao3j = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ContainerIteratorType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7319_l523emneao3j = quotedNode_7319_l523emneao3j;
        {
          quotedNode_7319_l523emneao3k = (SNode) parameter_7319_l523emneao5u;
          SNode quotedNode1_7319_l523emneao3k;
          if (_parameterValues_129834374.contains(quotedNode_7319_l523emneao3k)) {
            quotedNode1_7319_l523emneao3k = CopyUtil.copy(quotedNode_7319_l523emneao3k);
          } else {
            _parameterValues_129834374.add(quotedNode_7319_l523emneao3k);
            quotedNode1_7319_l523emneao3k = quotedNode_7319_l523emneao3k;
          }
          if (quotedNode1_7319_l523emneao3k != null) {
            quotedNode_7319_l523emneao3j.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_7319_l523emneao3k, typeCheckingContext));
          }
        }
        result = quotedNode1_7319_l523emneao3j;
      }
      return result;
    }

    public SNode createNode(Object parameter_7319_l523emneao5u) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7319_l523emneao3j = null;
      SNode quotedNode_7319_l523emneao3k = null;
      {
        quotedNode_7319_l523emneao3j = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ContainerIteratorType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7319_l523emneao3j = quotedNode_7319_l523emneao3j;
        {
          quotedNode_7319_l523emneao3k = (SNode) parameter_7319_l523emneao5u;
          SNode quotedNode1_7319_l523emneao3k;
          if (_parameterValues_129834374.contains(quotedNode_7319_l523emneao3k)) {
            quotedNode1_7319_l523emneao3k = CopyUtil.copy(quotedNode_7319_l523emneao3k);
          } else {
            _parameterValues_129834374.add(quotedNode_7319_l523emneao3k);
            quotedNode1_7319_l523emneao3k = quotedNode_7319_l523emneao3k;
          }
          if (quotedNode1_7319_l523emneao3k != null) {
            quotedNode_7319_l523emneao3j.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_7319_l523emneao3k));
          }
        }
        result = quotedNode1_7319_l523emneao3j;
      }
      return result;
    }
  }

  public static class QuotationClass_7319_l523emneb3bw {
    public QuotationClass_7319_l523emneb3bw() {
    }

    public SNode createNode(Object parameter_7319_l523emneao6z, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7319_l523emneao3s = null;
      SNode quotedNode_7319_l523emneao3t = null;
      {
        quotedNode_7319_l523emneao3s = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ContainerIteratorType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7319_l523emneao3s = quotedNode_7319_l523emneao3s;
        {
          quotedNode_7319_l523emneao3t = (SNode) parameter_7319_l523emneao6z;
          SNode quotedNode1_7319_l523emneao3t;
          if (_parameterValues_129834374.contains(quotedNode_7319_l523emneao3t)) {
            quotedNode1_7319_l523emneao3t = CopyUtil.copy(quotedNode_7319_l523emneao3t);
          } else {
            _parameterValues_129834374.add(quotedNode_7319_l523emneao3t);
            quotedNode1_7319_l523emneao3t = quotedNode_7319_l523emneao3t;
          }
          if (quotedNode1_7319_l523emneao3t != null) {
            quotedNode_7319_l523emneao3s.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_7319_l523emneao3t, typeCheckingContext));
          }
        }
        result = quotedNode1_7319_l523emneao3s;
      }
      return result;
    }

    public SNode createNode(Object parameter_7319_l523emneao6z) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7319_l523emneao3s = null;
      SNode quotedNode_7319_l523emneao3t = null;
      {
        quotedNode_7319_l523emneao3s = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ContainerIteratorType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7319_l523emneao3s = quotedNode_7319_l523emneao3s;
        {
          quotedNode_7319_l523emneao3t = (SNode) parameter_7319_l523emneao6z;
          SNode quotedNode1_7319_l523emneao3t;
          if (_parameterValues_129834374.contains(quotedNode_7319_l523emneao3t)) {
            quotedNode1_7319_l523emneao3t = CopyUtil.copy(quotedNode_7319_l523emneao3t);
          } else {
            _parameterValues_129834374.add(quotedNode_7319_l523emneao3t);
            quotedNode1_7319_l523emneao3t = quotedNode_7319_l523emneao3t;
          }
          if (quotedNode1_7319_l523emneao3t != null) {
            quotedNode_7319_l523emneao3s.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_7319_l523emneao3t));
          }
        }
        result = quotedNode1_7319_l523emneao3s;
      }
      return result;
    }
  }

  public static class QuotationClass_7319_l523emneb3f2 {
    public QuotationClass_7319_l523emneb3f2() {
    }

    public SNode createNode(Object parameter_7319_l523emneao7a, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7319_l523emneao3y = null;
      SNode quotedNode_7319_l523emneao3z = null;
      {
        quotedNode_7319_l523emneao3y = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.IteratorType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7319_l523emneao3y = quotedNode_7319_l523emneao3y;
        {
          quotedNode_7319_l523emneao3z = (SNode) parameter_7319_l523emneao7a;
          SNode quotedNode1_7319_l523emneao3z;
          if (_parameterValues_129834374.contains(quotedNode_7319_l523emneao3z)) {
            quotedNode1_7319_l523emneao3z = CopyUtil.copy(quotedNode_7319_l523emneao3z);
          } else {
            _parameterValues_129834374.add(quotedNode_7319_l523emneao3z);
            quotedNode1_7319_l523emneao3z = quotedNode_7319_l523emneao3z;
          }
          if (quotedNode1_7319_l523emneao3z != null) {
            quotedNode_7319_l523emneao3y.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_7319_l523emneao3z, typeCheckingContext));
          }
        }
        result = quotedNode1_7319_l523emneao3y;
      }
      return result;
    }

    public SNode createNode(Object parameter_7319_l523emneao7a) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7319_l523emneao3y = null;
      SNode quotedNode_7319_l523emneao3z = null;
      {
        quotedNode_7319_l523emneao3y = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.IteratorType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7319_l523emneao3y = quotedNode_7319_l523emneao3y;
        {
          quotedNode_7319_l523emneao3z = (SNode) parameter_7319_l523emneao7a;
          SNode quotedNode1_7319_l523emneao3z;
          if (_parameterValues_129834374.contains(quotedNode_7319_l523emneao3z)) {
            quotedNode1_7319_l523emneao3z = CopyUtil.copy(quotedNode_7319_l523emneao3z);
          } else {
            _parameterValues_129834374.add(quotedNode_7319_l523emneao3z);
            quotedNode1_7319_l523emneao3z = quotedNode_7319_l523emneao3z;
          }
          if (quotedNode1_7319_l523emneao3z != null) {
            quotedNode_7319_l523emneao3y.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_7319_l523emneao3z));
          }
        }
        result = quotedNode1_7319_l523emneao3y;
      }
      return result;
    }
  }
}
