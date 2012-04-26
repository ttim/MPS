package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInequationReplacementRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.typesystem.runtime.IsApplicable2Status;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.pattern.GeneratedMatchingPattern;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import java.util.Iterator;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.lang.pattern.IMatchingPattern;
import java.util.List;
import java.util.ArrayList;

public class subtypesOfClassifierTypeWWildcards_InequationReplacementRule extends AbstractInequationReplacementRule_Runtime {
  public subtypesOfClassifierTypeWWildcards_InequationReplacementRule() {
  }

  public boolean isApplicableCustom(SNode subtype, SNode supertype, IsApplicable2Status status) {
    return !(SNodeOperations.isInstanceOf(subtype, "jetbrains.mps.baseLanguage.closures.structure.FunctionType"));
  }

  public void processInequation(final SNode subtype, final SNode supertype, final EquationInfo equationInfo, final TypeCheckingContext typeCheckingContext, IsApplicable2Status status, final boolean inequalityIsWeak, final boolean inequalityIsLessThan) {
    {
      final SNode t = subtype;
      typeCheckingContext.whenConcrete(t, new Runnable() {
        public void run() {
          {
            GeneratedMatchingPattern pattern_n8ubly_a0a0 = new subtypesOfClassifierTypeWWildcards_InequationReplacementRule.Pattern_1s2zdh_a0a0a0a0a1(SLinkOperations.getTarget(supertype, "classifier", false));
            SNode coercedNode_n8ubly_a0a0 = TypeChecker.getInstance().getRuntimeSupport().coerce_(typeCheckingContext.getExpandedNode(t), pattern_n8ubly_a0a0, inequalityIsWeak);
            if (coercedNode_n8ubly_a0a0 != null) {
              {
                Iterator<SNode> typeParam_it = ListSequence.fromList(SLinkOperations.getTargets(coercedNode_n8ubly_a0a0, "parameter", true)).iterator();
                Iterator<SNode> myParam_it = ListSequence.fromList(SLinkOperations.getTargets(supertype, "parameter", true)).iterator();
                SNode typeParam_var;
                SNode myParam_var;
                while (typeParam_it.hasNext() && myParam_it.hasNext()) {
                  typeParam_var = typeParam_it.next();
                  myParam_var = myParam_it.next();
                  final SNode finalTypeParam = typeParam_var;
                  {
                    SNode _nodeToCheck_1029348928467 = equationInfo.getNodeWithError();
                    EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "4186504230211332093", 0, null);
                    _info_12389875345.getOuterRulesIdFromInfo(equationInfo);
                    typeCheckingContext.createGreaterThanInequality((SNode) myParam_var, (SNode) finalTypeParam, false, true, _info_12389875345);
                  }
                  final SNode finalMyParam = myParam_var;
                  {
                    final SNode concreteParam = finalMyParam;
                    typeCheckingContext.whenConcrete(concreteParam, new Runnable() {
                      public void run() {
                        if (!(SNodeOperations.isInstanceOf(typeCheckingContext.getExpandedNode(concreteParam), "jetbrains.mps.baseLanguage.structure.WildCardType") || SNodeOperations.isInstanceOf(typeCheckingContext.getExpandedNode(concreteParam), "jetbrains.mps.baseLanguage.structure.UpperBoundType") || SNodeOperations.isInstanceOf(typeCheckingContext.getExpandedNode(concreteParam), "jetbrains.mps.baseLanguage.structure.LowerBoundType"))) {
                          {
                            SNode _nodeToCheck_1029348928467 = equationInfo.getNodeWithError();
                            EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "4186504230211332124", 0, null);
                            _info_12389875345.getOuterRulesIdFromInfo(equationInfo);
                            typeCheckingContext.createGreaterThanInequality((SNode) finalTypeParam, (SNode) typeCheckingContext.getExpandedNode(concreteParam), false, true, _info_12389875345);
                          }
                        }
                      }
                    }, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "4186504230211332105", false, false);
                  }
                }
              }
            } else {
              SNode nodeWithError = equationInfo.getNodeWithError();
              {
                MessageTarget errorTarget = new NodeMessageTarget();
                IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(nodeWithError, BaseConcept_Behavior.call_getDetailedPresentation_2354269628709769373(subtype) + " is not a subtype of " + BaseConcept_Behavior.call_getDetailedPresentation_2354269628709769373(supertype), "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1227259028675", null, errorTarget);
                HUtil.addAdditionalRuleIdsFromInfo(_reporter_2309309498, equationInfo);
              }
            }
          }
        }
      }, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1220523357849", false, true);
    }
  }

  public boolean checkInequation(final SNode subtype, final SNode supertype, final EquationInfo equationInfo, IsApplicable2Status status, final boolean inequalityIsWeak, final boolean inequalityIsLessThan) {
    boolean result_14532009 = true;
    {
      final SNode t = subtype;
      {
        GeneratedMatchingPattern pattern_a0a0 = new subtypesOfClassifierTypeWWildcards_InequationReplacementRule.Pattern_1s2zdh_a0a0a0a0a1a2(SLinkOperations.getTarget(supertype, "classifier", false));
        SNode coercedNode_a0a0 = TypeChecker.getInstance().getRuntimeSupport().coerce_(t, pattern_a0a0, inequalityIsWeak);
        if (coercedNode_a0a0 != null) {
          {
            Iterator<SNode> typeParam_it = ListSequence.fromList(SLinkOperations.getTargets(coercedNode_a0a0, "parameter", true)).iterator();
            Iterator<SNode> myParam_it = ListSequence.fromList(SLinkOperations.getTargets(supertype, "parameter", true)).iterator();
            SNode typeParam_var;
            SNode myParam_var;
            while (typeParam_it.hasNext() && myParam_it.hasNext()) {
              typeParam_var = typeParam_it.next();
              myParam_var = myParam_it.next();
              final SNode finalTypeParam = typeParam_var;
              result_14532009 = result_14532009 && TypeChecker.getInstance().getSubtypingManager().isSubtype((SNode) finalTypeParam, (SNode) myParam_var, true);
              final SNode finalMyParam = myParam_var;
              {
                final SNode concreteParam = finalMyParam;
                if (!(SNodeOperations.isInstanceOf(concreteParam, "jetbrains.mps.baseLanguage.structure.WildCardType") || SNodeOperations.isInstanceOf(concreteParam, "jetbrains.mps.baseLanguage.structure.UpperBoundType") || SNodeOperations.isInstanceOf(concreteParam, "jetbrains.mps.baseLanguage.structure.LowerBoundType"))) {
                  result_14532009 = result_14532009 && TypeChecker.getInstance().getSubtypingManager().isSubtype((SNode) concreteParam, (SNode) finalTypeParam, true);
                }
              }
            }
          }
        } else {
          SNode nodeWithError = equationInfo.getNodeWithError();
          result_14532009 = false;
        }
      }
    }
    return result_14532009;
  }

  public boolean isWeak() {
    return true;
  }

  public IsApplicableStatus isApplicableSubtypeAndPattern(SNode node) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableSubtypeConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public IsApplicableStatus isApplicableSupertypeAndPattern(SNode node) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableSupertypeConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public String getApplicableSubtypeConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.Type";
  }

  public String getApplicableSupertypeConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.ClassifierType";
  }

  public static class Pattern_1s2zdh_a0a0a0a0a1 extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ List<SNode> patternVar_l;
    /*package*/ SNode patternVar_ignored;
    /*package*/ Object AntiquotationField_n8ubly_a0a0a0a0a;

    public Pattern_1s2zdh_a0a0a0a0a1(Object parameter_n8ubly_a0a0a0a0a) {
      this.AntiquotationField_n8ubly_a0a0a0a0a = parameter_n8ubly_a0a0a0a0a;
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_subtypesOfClassifierTypeWWildcards_n8ubly_a0a0a0a;
        nodeToMatch_subtypesOfClassifierTypeWWildcards_n8ubly_a0a0a0a = nodeToMatch;
        if (!("jetbrains.mps.baseLanguage.structure.ClassifierType".equals(nodeToMatch_subtypesOfClassifierTypeWWildcards_n8ubly_a0a0a0a.getConceptFqName()))) {
          return false;
        }
        {
          SNode referent;
          referent = (SNode) this.AntiquotationField_n8ubly_a0a0a0a0a;
          if (nodeToMatch_subtypesOfClassifierTypeWWildcards_n8ubly_a0a0a0a.getReferent("classifier") != referent) {
            return false;
          }
        }
        {
          String childRole_subtypesOfClassifierTypeWWildcards_n8ubly_ = "parameter";
          this.patternVar_l = ListSequence.fromList(new ArrayList<SNode>());
          patternVar_ignored = null;
          for (SNode childVar : nodeToMatch_subtypesOfClassifierTypeWWildcards_n8ubly_a0a0a0a.getChildren(childRole_subtypesOfClassifierTypeWWildcards_n8ubly_)) {
            patternVar_ignored = childVar;
            ListSequence.fromList(this.patternVar_l).addElement(childVar);
          }
        }
      }
      return true;
    }

    public boolean hasAntiquotations() {
      return true;
    }

    public void fillFieldValuesFrom(GeneratedMatchingPattern pattern) {
      if (pattern != null && pattern.getClass() == this.getClass()) {
        patternVar_l = (List<SNode>) pattern.getFieldValue("patternVar_l");
        patternVar_ignored = (SNode) pattern.getFieldValue("patternVar_ignored");
      }
    }

    public Object getFieldValue(String fieldName) {
      if ("patternVar_l".equals(fieldName)) {
        return patternVar_l;
      }
      if ("patternVar_ignored".equals(fieldName)) {
        return patternVar_ignored;
      }
      return null;
    }

    public void performActions(Object o) {
    }
  }

  public static class Pattern_1s2zdh_a0a0a0a0a1a2 extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ List<SNode> patternVar_l;
    /*package*/ SNode patternVar_ignored;
    /*package*/ Object AntiquotationField_n8ubly_a0a0a0a0a_0;

    public Pattern_1s2zdh_a0a0a0a0a1a2(Object parameter_n8ubly_a0a0a0a0a_0) {
      this.AntiquotationField_n8ubly_a0a0a0a0a_0 = parameter_n8ubly_a0a0a0a0a_0;
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_null_a0a0a0a;
        nodeToMatch_null_a0a0a0a = nodeToMatch;
        if (!("jetbrains.mps.baseLanguage.structure.ClassifierType".equals(nodeToMatch_null_a0a0a0a.getConceptFqName()))) {
          return false;
        }
        {
          SNode referent;
          referent = (SNode) this.AntiquotationField_n8ubly_a0a0a0a0a_0;
          if (nodeToMatch_null_a0a0a0a.getReferent("classifier") != referent) {
            return false;
          }
        }
        {
          String childRole_null_ = "parameter";
          this.patternVar_l = ListSequence.fromList(new ArrayList<SNode>());
          patternVar_ignored = null;
          for (SNode childVar : nodeToMatch_null_a0a0a0a.getChildren(childRole_null_)) {
            patternVar_ignored = childVar;
            ListSequence.fromList(this.patternVar_l).addElement(childVar);
          }
        }
      }
      return true;
    }

    public boolean hasAntiquotations() {
      return true;
    }

    public void fillFieldValuesFrom(GeneratedMatchingPattern pattern) {
      if (pattern != null && pattern.getClass() == this.getClass()) {
        patternVar_l = (List<SNode>) pattern.getFieldValue("patternVar_l");
        patternVar_ignored = (SNode) pattern.getFieldValue("patternVar_ignored");
      }
    }

    public Object getFieldValue(String fieldName) {
      if ("patternVar_l".equals(fieldName)) {
        return patternVar_l;
      }
      if ("patternVar_ignored".equals(fieldName)) {
        return patternVar_ignored;
      }
      return null;
    }

    public void performActions(Object o) {
    }
  }
}
