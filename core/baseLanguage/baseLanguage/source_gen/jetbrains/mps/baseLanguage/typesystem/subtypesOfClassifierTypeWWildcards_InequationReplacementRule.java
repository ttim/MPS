package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInequationReplacementRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import java.util.Iterator;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.lang.pattern.util.MatchingUtil;
import jetbrains.mps.smodel.SModelUtil_new;

public class subtypesOfClassifierTypeWWildcards_InequationReplacementRule extends AbstractInequationReplacementRule_Runtime {

  public subtypesOfClassifierTypeWWildcards_InequationReplacementRule() {
  }

  public void processInequation(final SNode subtype, final SNode supertype, final EquationInfo equationInfo, final TypeCheckingContext typeCheckingContext) {
    {
      final SNode t = subtype;
      typeCheckingContext.whenConcrete(t, new Runnable() {

        public void run() {
          {
            _Patterns.Pattern_9 pattern_0 = new _Patterns.Pattern_9(SLinkOperations.getTarget(supertype, "classifier", false));
            SNode coercedNode_0 = TypeChecker.getInstance().getRuntimeSupport().coerce_(typeCheckingContext.getEquationManager().getRepresentator(t), pattern_0, typeCheckingContext);
            if (coercedNode_0 != null) {
              {
                SNode typeParam;
                SNode myParam;
                Iterator<SNode> typeParam_iterator = SLinkOperations.getTargets(coercedNode_0, "parameter", true).iterator();
                Iterator<SNode> myParam_iterator = SLinkOperations.getTargets(supertype, "parameter", true).iterator();
                while (true) {
                  if (!(typeParam_iterator.hasNext())) {
                    break;
                  }
                  if (!(myParam_iterator.hasNext())) {
                    break;
                  }
                  typeParam = typeParam_iterator.next();
                  myParam = myParam_iterator.next();
                  {
                    final SNode finalTypeParam = typeParam;
                    {
                      SNode _nodeToCheck_1029348928467 = equationInfo.getNodeWithError();
                      BaseIntentionProvider intentionProvider = null;
                      typeCheckingContext.createLessThanInequation(finalTypeParam, myParam, _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1220535076789", false, 0, intentionProvider);
                    }
                    {
                      final SNode concreteParam = myParam;
                      typeCheckingContext.whenConcrete(concreteParam, new Runnable() {

                        public void run() {
                          if (!(SNodeOperations.isInstanceOf(typeCheckingContext.getEquationManager().getRepresentator(concreteParam), "jetbrains.mps.baseLanguage.structure.WildCardType") || SNodeOperations.isInstanceOf(typeCheckingContext.getEquationManager().getRepresentator(concreteParam), "jetbrains.mps.baseLanguage.structure.UpperBoundType"))) {
                            {
                              SNode _nodeToCheck_1029348928467 = equationInfo.getNodeWithError();
                              BaseIntentionProvider intentionProvider = null;
                              typeCheckingContext.createEquation(finalTypeParam, typeCheckingContext.getEquationManager().getRepresentator(concreteParam), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1220523357903", intentionProvider);
                            }
                          }
                        }

                      }, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1220523357880", false);
                    }
                  }
                }
              }
            } else
            {
              SNode nodeWithError = equationInfo.getNodeWithError();
              SNode methodCall = null;
              if (SNodeOperations.isInstanceOf(nodeWithError, "jetbrains.mps.baseLanguage.structure.IMethodCall")) {
                methodCall = nodeWithError;
              } else if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(nodeWithError), "jetbrains.mps.baseLanguage.structure.IMethodCall")) {
                methodCall = SNodeOperations.getParent(nodeWithError);
              }
              if (methodCall != null) {
                SNode classifier = SNodeOperations.getAncestor(SLinkOperations.getTarget(methodCall, "baseMethodDeclaration", false), "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
                {
                  BaseIntentionProvider intentionProvider = null;
                  intentionProvider = new BaseIntentionProvider("r:54d81703-6667-41d9-9b36-3b9bc0cce7a3(jetbrains.mps.baseLanguage.typesystem@17_0).ChooseAppropriateMethodDeclaration_QuickFix", true);
                  intentionProvider.putArgument("methodCall", methodCall);
                  intentionProvider.putArgument("classifier", classifier);
                  IErrorTarget errorTarget = new NodeErrorTarget();
                  typeCheckingContext.reportTypeError(nodeWithError, BaseConcept_Behavior.call_getPresentation_1213877396640(subtype) + " is not a subtype of " + BaseConcept_Behavior.call_getPresentation_1213877396640(supertype), "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1227259028675", intentionProvider, errorTarget);
                }
              } else
              {
                {
                  BaseIntentionProvider intentionProvider = null;
                  IErrorTarget errorTarget = new NodeErrorTarget();
                  typeCheckingContext.reportTypeError(nodeWithError, BaseConcept_Behavior.call_getPresentation_1213877396640(subtype) + " is not a subtype of " + BaseConcept_Behavior.call_getPresentation_1213877396640(supertype), "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1220523357915", intentionProvider, errorTarget);
                }
              }
            }
          }
        }

      }, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1220523357849", false);
    }
  }

  public boolean checkInequation(final SNode subtype, final SNode supertype, final EquationInfo equationInfo) {
    boolean result_14532009 = true;
    {
      final SNode t = subtype;
      {
        _Patterns.Pattern_9 pattern_1 = new _Patterns.Pattern_9(SLinkOperations.getTarget(supertype, "classifier", false));
        SNode coercedNode_1 = TypeChecker.getInstance().getRuntimeSupport().coerce_(t, pattern_1);
        if (coercedNode_1 != null) {
          {
            SNode typeParam;
            SNode myParam;
            Iterator<SNode> typeParam_iterator = SLinkOperations.getTargets(coercedNode_1, "parameter", true).iterator();
            Iterator<SNode> myParam_iterator = SLinkOperations.getTargets(supertype, "parameter", true).iterator();
            while (true) {
              if (!(typeParam_iterator.hasNext())) {
                break;
              }
              if (!(myParam_iterator.hasNext())) {
                break;
              }
              typeParam = typeParam_iterator.next();
              myParam = myParam_iterator.next();
              {
                final SNode finalTypeParam = typeParam;
                result_14532009 = result_14532009 && TypeChecker.getInstance().getSubtypingManager().isSubtype(finalTypeParam, myParam, true);
                {
                  final SNode concreteParam = myParam;
                  if (!(SNodeOperations.isInstanceOf(concreteParam, "jetbrains.mps.baseLanguage.structure.WildCardType") || SNodeOperations.isInstanceOf(concreteParam, "jetbrains.mps.baseLanguage.structure.UpperBoundType"))) {
                    result_14532009 = result_14532009 && MatchingUtil.matchNodes(finalTypeParam, concreteParam);
                  }
                }
              }
            }
          }
        } else
        {
          SNode nodeWithError = equationInfo.getNodeWithError();
          SNode methodCall = null;
          if (SNodeOperations.isInstanceOf(nodeWithError, "jetbrains.mps.baseLanguage.structure.IMethodCall")) {
            methodCall = nodeWithError;
          } else if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(nodeWithError), "jetbrains.mps.baseLanguage.structure.IMethodCall")) {
            methodCall = SNodeOperations.getParent(nodeWithError);
          }
          if (methodCall != null) {
            SNode classifier = SNodeOperations.getAncestor(SLinkOperations.getTarget(methodCall, "baseMethodDeclaration", false), "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
            result_14532009 = false;
          } else
          {
            result_14532009 = false;
          }
        }
      }
    }
    return result_14532009;
  }

  public boolean isWeak() {
    return true;
  }

  public boolean isApplicableSubtype(SNode node) {
    return SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableSubtypeConceptFQName());
  }

  public boolean isApplicableSupertype(SNode node) {
    return SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableSupertypeConceptFQName());
  }

  public String getApplicableSubtypeConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.Type";
  }

  public String getApplicableSupertypeConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.ClassifierType";
  }

}
