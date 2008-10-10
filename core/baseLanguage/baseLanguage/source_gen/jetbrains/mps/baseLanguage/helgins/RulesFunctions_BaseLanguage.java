package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.dependencies.InferenceMethod;
import jetbrains.mps.helgins.inference.TypeCheckingContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ITranslator;
import jetbrains.mps.internal.collections.runtime.ISequence;
import jetbrains.mps.internal.collections.runtime.ISequenceIterableAdapter;

import java.util.Iterator;
import jetbrains.mps.closures.runtime.YieldingIterator;
import java.util.Map;
import java.util.List;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class RulesFunctions_BaseLanguage {
  public static boolean TRACE_METHOD_TYPES = false;

  @InferenceMethod()
  public static void comparisonOp(final TypeCheckingContext typeCheckingContext, SNode binOp) {
    {
      SNode _nodeToCheck_1029348928467 = null;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(typeCheckingContext.typeOf(SLinkOperations.getTarget(binOp, "rightExpression", true), "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1176897133366", true), SLinkOperations.getTarget(new QuotationClass_18().createNode(), "descriptor", false), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1176897142200", false, 500, intentionProvider);
    }
    {
      SNode _nodeToCheck_1029348928467 = null;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(typeCheckingContext.typeOf(SLinkOperations.getTarget(binOp, "leftExpression", true), "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1176897185028", true), SLinkOperations.getTarget(new QuotationClass_19().createNode(), "descriptor", false), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1176897185023", false, 500, intentionProvider);
    }
    {
      SNode _nodeToCheck_1029348928467 = null;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createEquation(typeCheckingContext.typeOf(binOp, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1203512292516", true), new QuotationClass_20().createNode(), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1203512292514", intentionProvider);
    }
  }

  @InferenceMethod()
  public static void numericOp(final TypeCheckingContext typeCheckingContext, final SNode binOp) {
    final SNode rightExpressionType_typevar_1185962758265 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
    final SNode leftExpressionType_typevar_1185962769627 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = null;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getEquationManager().getRepresentator(rightExpressionType_typevar_1185962758265), typeCheckingContext.typeOf(SLinkOperations.getTarget(binOp, "rightExpression", true), "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1185962985524", true), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1185962983223", intentionProvider);
    }
    {
      SNode _nodeToCheck_1029348928467 = null;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getEquationManager().getRepresentator(leftExpressionType_typevar_1185962769627), typeCheckingContext.typeOf(SLinkOperations.getTarget(binOp, "leftExpression", true), "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1185963005725", true), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1185963003424", intentionProvider);
    }
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(binOp, "rightExpression", true);
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getEquationManager().getRepresentator(rightExpressionType_typevar_1185962758265), SLinkOperations.getTarget(new QuotationClass_21().createNode(), "descriptor", false), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1176908856117", false, 500, intentionProvider);
    }
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(binOp, "leftExpression", true);
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getEquationManager().getRepresentator(leftExpressionType_typevar_1185962769627), SLinkOperations.getTarget(new QuotationClass_22().createNode(), "descriptor", false), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1176908902743", false, 500, intentionProvider);
    }
    {
      final SNode _representatorVar3 = TypeChecker.getInstance().getEquationManager().getRepresentator(leftExpressionType_typevar_1185962769627);
      TypeChecker.getInstance().getRuntimeSupport().whenConcrete(_representatorVar3, new Runnable() {

        public void run() {
          {
            final SNode _representatorVar4 = TypeChecker.getInstance().getEquationManager().getRepresentator(rightExpressionType_typevar_1185962758265);
            TypeChecker.getInstance().getRuntimeSupport().whenConcrete(_representatorVar4, new Runnable() {

              public void run() {
                {
                  SNode _nodeToCheck_1029348928467 = null;
                  BaseIntentionProvider intentionProvider = null;
                  TypeChecker.getInstance().getRuntimeSupport().createEquation(typeCheckingContext.typeOf(binOp, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1203512296348", true), Queries.getBinaryOperationType(TypeChecker.getInstance().getEquationManager().getRepresentator(leftExpressionType_typevar_1185962769627), TypeChecker.getInstance().getEquationManager().getRepresentator(rightExpressionType_typevar_1185962758265)), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1203512296346", intentionProvider);
                }
              }

            }, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1185963100352");
          }
        }

      }, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1185963072800");
    }
  }

  public static Iterable<SNode> collectReturnStatements(SNode node) {
    Iterable<SNode> returnStatements = ListSequence.fromList(SNodeOperations.getChildren(node)).translate(new ITranslator <SNode, SNode>() {

      public ISequence<SNode> translate(final SNode it) {
        return new ISequenceIterableAdapter<SNode>() {

          public Iterator<SNode> iterator() {
            return new YieldingIterator <SNode>() {

              private int __CP__ = 0;
              private SNode _11_returnStmt;
              private Iterator<SNode> _11_returnStmt_it;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 11:
                      this._11_returnStmt_it = collectReturnStatements(it).iterator();
                    case 12:
                      if (!(this._11_returnStmt_it.hasNext())) {
                        this.__CP__ = 3;
                        break;
                      }
                      this._11_returnStmt = this._11_returnStmt_it.next();
                      this.__CP__ = 13;
                      break;
                    case 4:
                      if (SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.ReturnStatement")) {
                        this.__CP__ = 5;
                        break;
                      }
                      this.__CP__ = 7;
                      break;
                    case 7:
                      if (SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.ConceptFunction") || SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.CommentedStatementsBlock") || SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.IStatementListContainer") || SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.AnonymousClass")) {
                        this.__CP__ = 8;
                        break;
                      }
                      this.__CP__ = 10;
                      break;
                    case 3:
                      if (false) {
                        this.__CP__ = 2;
                        break;
                      }
                      this.__CP__ = 1;
                      break;
                    case 6:
                      this.__CP__ = 3;
                      this.yield(it);
                      return true;
                    case 14:
                      this.__CP__ = 12;
                      this.yield(this._11_returnStmt);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 2:
                      this.__CP__ = 4;
                      break;
                    case 5:
                      this.__CP__ = 6;
                      break;
                    case 8:
                      // don't look inside closures and other code-blocks
                      // don't look inside commented statements
                      // don't look inside anything that implements IStatementListContainer (for extensibility)
                      // don't look inside anonymous classes
                      this.__CP__ = 1;
                      break;
                    case 10:
                      this.__CP__ = 11;
                      break;
                    case 13:
                      this.__CP__ = 14;
                      break;
                    default:
                      break __loop__;
                  }
                } while(true);
                return false;
              }

            };
          }

        };
      }

    });
    return returnStatements;
  }

  @InferenceMethod()
  public static void inference_matchConcreteTypesWithTypeVariables(final TypeCheckingContext typeCheckingContext, SNode genericClassifier, SNode instanceType, Map<SNode, List<SNode>> mmap) {
    if ((genericClassifier != null) && mmap != null && !(mmap.isEmpty())) {
      {
        Pattern_8 pattern_2 = new Pattern_8(genericClassifier);
        SNode coercedNode_2 = TypeChecker.getInstance().getRuntimeSupport().coerce(instanceType, pattern_2);
        if (coercedNode_2 != null) {
          List<SNode> actualParams = pattern_2.PatternVar0;
          int idx = 0;
          for(SNode tvd : SLinkOperations.getTargets(genericClassifier, "typeVariableDeclaration", true)) {
            if (idx < actualParams.size()) {
              List<SNode> nodes = mmap.get(tvd);
              if (nodes != null) {
                SNode tvar = ListSequence.fromList(nodes).getElement(0);
                if (TRACE_METHOD_TYPES) {
                  System.out.println("-2- " + BaseConcept_Behavior.call_getPresentation_1213877396640(tvar) + " :==: " + BaseConcept_Behavior.call_getPresentation_1213877396640(ListSequence.fromList(nodes).getElement(0)));
                }
                {
                  SNode _nodeToCheck_1029348928467 = null;
                  BaseIntentionProvider intentionProvider = null;
                  TypeChecker.getInstance().getRuntimeSupport().createEquation(tvar, actualParams.get(idx), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1203433378489", intentionProvider);
                }
              }
            }
            idx = idx + 1;
          }
        } else
        {
        }
      }
    }
  }

  @InferenceMethod()
  public static void inference_equateParametersAndReturnType(final TypeCheckingContext typeCheckingContext, final SNode mc, SNode returnType, Map<SNode, List<SNode>> mmap) {
    List<SNode> parameterDeclarations = SLinkOperations.getTargets(SLinkOperations.getTarget(mc, "baseMethodDeclaration", false), "parameter", true);
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(ListSequence.fromList(parameterDeclarations).last(), "type", true), "jetbrains.mps.baseLanguage.structure.VariableArityType")) {
      Iterator<SNode> formalIterator = ListSequence.fromList(parameterDeclarations).iterator();
      Iterator<SNode> actualIterator = ListSequence.fromList(SLinkOperations.getTargets(mc, "actualArgument", true)).iterator();
      SNode formalParam = null;
      SNode actualParam = null;
      while (true) {
        if (!(actualIterator.hasNext())) {
          break;
        }
        if (!(formalIterator.hasNext())) {
          break;
        }
        formalParam = formalIterator.next();
        if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(formalParam, "type", true), "jetbrains.mps.baseLanguage.structure.VariableArityType")) {
          break;
        }
        actualParam = actualIterator.next();
        SNode matchedType = inference_matchTypeWithTypeVariables(SLinkOperations.getTarget(formalParam, "type", true), mmap);
        {
          SNode _nodeToCheck_1029348928467 = actualParam;
          BaseIntentionProvider intentionProvider = null;
          intentionProvider = new BaseIntentionProvider("r:5c653028-76bb-4190-877c-234af600138c(jetbrains.mps.baseLanguage.helgins@3_0).ChooseAppropriateMethodDeclaration_QuickFix", true);
          intentionProvider.putArgument("methodCall", mc);
          intentionProvider.putArgument("classifier", SNodeOperations.getAncestor(SLinkOperations.getTarget(mc, "baseMethodDeclaration", false), "jetbrains.mps.baseLanguage.structure.Classifier", false, false));
          TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(typeCheckingContext.typeOf(actualParam, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1219947530380", true), matchedType, _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1219947530376", false, 2, intentionProvider);
        }
      }
      do {
        SNode matchedNode_3 = SLinkOperations.getTarget(formalParam, "type", true);
        {
          boolean matches_3 = false;
          {
            SNode matchingNode_3 = SLinkOperations.getTarget(formalParam, "type", true);
            if (matchingNode_3 != null) {
              matches_3 = SModelUtil_new.isAssignableConcept(matchingNode_3.getConceptFqName(), "jetbrains.mps.baseLanguage.structure.VariableArityType");
            }
          }
          if (matches_3) {
            {
              SNode componentType = SLinkOperations.getTarget(matchedNode_3, "componentType", true);
              final SNode matchedType = inference_matchTypeWithTypeVariables(componentType, mmap);
              if (SLinkOperations.getCount(mc, "actualArgument") == ListSequence.fromList(parameterDeclarations).count()) {
                // the actual parameter may appear to be an array instead of vararg
                final SNode actual = actualIterator.next();
                {
                  final SNode actualType = typeCheckingContext.typeOf(actual, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1220347108709", true);
                  TypeChecker.getInstance().getRuntimeSupport().whenConcrete(actualType, new Runnable() {

                    public void run() {
                      if (SNodeOperations.isInstanceOf(TypeChecker.getInstance().getEquationManager().getRepresentator(actualType), "jetbrains.mps.baseLanguage.structure.ArrayType")) {
                        {
                          SNode _nodeToCheck_1029348928467 = actual;
                          BaseIntentionProvider intentionProvider = null;
                          intentionProvider = new BaseIntentionProvider("r:5c653028-76bb-4190-877c-234af600138c(jetbrains.mps.baseLanguage.helgins@3_0).ChooseAppropriateMethodDeclaration_QuickFix", true);
                          intentionProvider.putArgument("methodCall", mc);
                          intentionProvider.putArgument("classifier", SNodeOperations.getAncestor(SLinkOperations.getTarget(mc, "baseMethodDeclaration", false), "jetbrains.mps.baseLanguage.structure.Classifier", false, false));
                          TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(SLinkOperations.getTarget(TypeChecker.getInstance().getEquationManager().getRepresentator(actualType), "componentType", true), matchedType, _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1220347279318", false, 2, intentionProvider);
                        }
                      } else
                      {
                        SNode _nodeToCheck_1029348928467 = actual;
                        BaseIntentionProvider intentionProvider = null;
                        intentionProvider = new BaseIntentionProvider("r:5c653028-76bb-4190-877c-234af600138c(jetbrains.mps.baseLanguage.helgins@3_0).ChooseAppropriateMethodDeclaration_QuickFix", true);
                        intentionProvider.putArgument("methodCall", mc);
                        intentionProvider.putArgument("classifier", SNodeOperations.getAncestor(SLinkOperations.getTarget(mc, "baseMethodDeclaration", false), "jetbrains.mps.baseLanguage.structure.Classifier", false, false));
                        TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getEquationManager().getRepresentator(actualType), matchedType, _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1220347200873", false, 2, intentionProvider);
                      }
                    }

                  }, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1220347102532");
                }
              } else
              {
                // in this case the actual parameter is definitely a vararg
                while (actualIterator.hasNext()) {
                  SNode actual = actualIterator.next();
                  {
                    SNode _nodeToCheck_1029348928467 = actual;
                    BaseIntentionProvider intentionProvider = null;
                    intentionProvider = new BaseIntentionProvider("r:5c653028-76bb-4190-877c-234af600138c(jetbrains.mps.baseLanguage.helgins@3_0).ChooseAppropriateMethodDeclaration_QuickFix", true);
                    intentionProvider.putArgument("methodCall", mc);
                    intentionProvider.putArgument("classifier", SNodeOperations.getAncestor(SLinkOperations.getTarget(mc, "baseMethodDeclaration", false), "jetbrains.mps.baseLanguage.structure.Classifier", false, false));
                    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(typeCheckingContext.typeOf(actual, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1219947702426", true), matchedType, _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1219947702422", false, 2, intentionProvider);
                  }
                }
              }
            }
            break;
          }
        }
      } while(false);
    } else
    {
      {
        SNode arg;
        SNode param;
        Iterator<SNode> arg_iterator = SLinkOperations.getTargets(mc, "actualArgument", true).iterator();
        Iterator<SNode> param_iterator = SLinkOperations.getTargets(SLinkOperations.getTarget(mc, "baseMethodDeclaration", false), "parameter", true).iterator();
        while (true) {
          if (!(arg_iterator.hasNext())) {
            break;
          }
          if (!(param_iterator.hasNext())) {
            break;
          }
          arg = arg_iterator.next();
          param = param_iterator.next();
          {
            SNode matchedType = inference_matchTypeWithTypeVariables(SLinkOperations.getTarget(param, "type", true), mmap);
            {
              SNode _nodeToCheck_1029348928467 = arg;
              BaseIntentionProvider intentionProvider = null;
              intentionProvider = new BaseIntentionProvider("r:5c653028-76bb-4190-877c-234af600138c(jetbrains.mps.baseLanguage.helgins@3_0).ChooseAppropriateMethodDeclaration_QuickFix", true);
              intentionProvider.putArgument("methodCall", mc);
              intentionProvider.putArgument("classifier", SNodeOperations.getAncestor(SLinkOperations.getTarget(mc, "baseMethodDeclaration", false), "jetbrains.mps.baseLanguage.structure.Classifier", false, false));
              TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(typeCheckingContext.typeOf(arg, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1203441371331", true), matchedType, _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1203441371327", false, 2, intentionProvider);
            }
          }
        }
      }
    }
    if (returnType != null) {
      SNode matchedType = inference_matchTypeWithTypeVariables(returnType, mmap);
      {
        SNode _nodeToCheck_1029348928467 = null;
        BaseIntentionProvider intentionProvider = null;
        TypeChecker.getInstance().getRuntimeSupport().createEquation(typeCheckingContext.typeOf(mc, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1203441371361", true), matchedType, _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1203441371359", intentionProvider);
      }
    }
  }

  @InferenceMethod()
  public static void inference_equateMatchingTypeVariables(final TypeCheckingContext typeCheckingContext, Map<SNode, List<SNode>> mmap) {
    if (mmap != null) {
      for(Map.Entry<SNode, List<SNode>> e : mmap.entrySet()) {
        List<SNode> nodes = e.getValue();
        SNode prev = null;
        for(SNode tvar : nodes) {
          if (prev != null && prev != tvar) {
            if (TRACE_METHOD_TYPES) {
              System.out.println("-3- " + BaseConcept_Behavior.call_getPresentation_1213877396640(prev) + " :==: " + BaseConcept_Behavior.call_getPresentation_1213877396640(tvar));
            }
            {
              SNode _nodeToCheck_1029348928467 = null;
              BaseIntentionProvider intentionProvider = null;
              TypeChecker.getInstance().getRuntimeSupport().createEquation(prev, tvar, _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1203452876024", intentionProvider);
            }
          }
          prev = tvar;
        }
        if (TRACE_METHOD_TYPES) {
          if ((prev != null)) {
            final SNode var = prev;
            final SNode prevVar_typevar_1204114618000 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
            {
              SNode _nodeToCheck_1029348928467 = null;
              BaseIntentionProvider intentionProvider = null;
              TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getEquationManager().getRepresentator(prevVar_typevar_1204114618000), prev, _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1204114618001", intentionProvider);
            }
            {
              final SNode _representatorVar5 = TypeChecker.getInstance().getEquationManager().getRepresentator(prevVar_typevar_1204114618000);
              TypeChecker.getInstance().getRuntimeSupport().whenConcrete(_representatorVar5, new Runnable() {

                public void run() {
                  System.out.println("-4- " + BaseConcept_Behavior.call_getPresentation_1213877396640(var) + " :==: " + BaseConcept_Behavior.call_getPresentation_1213877396640(TypeChecker.getInstance().getEquationManager().getRepresentator(prevVar_typevar_1204114618000)));
                }

              }, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1204114618006");
            }
          }
        }
      }
    }
  }

  /* package */static SNode inference_matchTypeWithTypeVariables(SNode type, Map<SNode, List<SNode>> mmap) {
    SNode resType = SNodeOperations.copyNode(type);
    if (SNodeOperations.isInstanceOf(resType, "jetbrains.mps.baseLanguage.structure.TypeVariableReference")) {
      final SNode tvar_typevar_1203439588896 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
      SNode tvd = SLinkOperations.getTarget(resType, "typeVariableDeclaration", false);
      inference_mapTypeVariable(tvd, TypeChecker.getInstance().getEquationManager().getRepresentator(tvar_typevar_1203439588896), mmap);
      resType = TypeChecker.getInstance().getEquationManager().getRepresentator(tvar_typevar_1203439588896);
    } else
    {
      inference_mapTypeVariables(resType, mmap);
    }
    return resType;
  }

  private static void inference_mapTypeVariables(SNode type, Map<SNode, List<SNode>> mmap) {
    if (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.TypeVariableReference")) {
      final SNode tvar_typevar_1203431658168 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
      SNode tvd = SLinkOperations.getTarget(type, "typeVariableDeclaration", false);
      inference_mapTypeVariable(tvd, TypeChecker.getInstance().getEquationManager().getRepresentator(tvar_typevar_1203431658168), mmap);
      SNodeOperations.replaceWithAnother(type, TypeChecker.getInstance().getEquationManager().getRepresentator(tvar_typevar_1203431658168));
    } else
    {
      List<SNode> children = new ArrayList<SNode>(SNodeOperations.getChildren(type));
      for(SNode chld : children) {
        inference_mapTypeVariables(chld, mmap);
      }
    }
  }

  private static void inference_mapTypeVariable(SNode tvd, SNode tvar, Map<SNode, List<SNode>> mmap) {
    putTypeVariable(tvd, tvar, mmap);
  }

  private static void putTypeVariable(SNode tvd, SNode tvar, Map<SNode, List<SNode>> mmap) {
    List<SNode> nodes = mmap.get(tvd);
    if (nodes == null) {
      nodes = new ArrayList<SNode>();
      mmap.put(tvd, nodes);
    }
    ListSequence.fromList(nodes).addElement(tvar);
  }

  public static boolean isWithinStatic(SNode node) {
    SNode staticAncestor = SNodeOperations.getAncestorWhereConceptInList(node, new String[]{"jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration","jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration"}, false, false);
    if (staticAncestor != null) {
      return true;
    }
    SNode statementList = SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.StatementList", false, false);
    SNode prevStatementList = null;
    while ((statementList != null)) {
      prevStatementList = statementList;
      statementList = SNodeOperations.getAncestor(statementList, "jetbrains.mps.baseLanguage.structure.StatementList", false, false);
    }
    if ((prevStatementList != null)) {
      do {
        SNode matchedNode_4 = SNodeOperations.getParent(prevStatementList);
        {
          boolean matches_4 = false;
          {
            SNode matchingNode_4 = SNodeOperations.getParent(prevStatementList);
            if (matchingNode_4 != null) {
              matches_4 = SModelUtil_new.isAssignableConcept(matchingNode_4.getConceptFqName(), "jetbrains.mps.baseLanguage.structure.ClassConcept");
            }
          }
          if (matches_4) {
            return SLinkOperations.getTarget(matchedNode_4, "staticInitializer", true) == prevStatementList;
          }
        }
      } while(false);
    }
    return false;
  }

  /* package */static void check(Set<SNode> throwables, SNode mainNode) {
    for(SNode livingThrowable : new HashSet<SNode>(throwables)) {
      if (TypeChecker.getInstance().getSubtypingManager().isSubtype(livingThrowable, new QuotationClass_85().createNode()) || TypeChecker.getInstance().getSubtypingManager().isSubtype(livingThrowable, new QuotationClass_84().createNode())) {
        throwables.remove(livingThrowable);
      }
    }
    if (throwables.isEmpty()) {
      return;
    }
    List<SNode> statementLists = SNodeOperations.getAncestors(mainNode, "jetbrains.mps.baseLanguage.structure.StatementList", false);
    for(SNode statementList : statementLists) {
      SNode parent = SNodeOperations.getParent(statementList);
      if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.TryStatement") && SLinkOperations.getTarget(parent, "body", true) == statementList) {
        SNode tryStatement = parent;
        for(SNode catchClause : SLinkOperations.getTargets(tryStatement, "catchClause", true)) {
          SNode throwableType = SLinkOperations.getTarget(SLinkOperations.getTarget(catchClause, "throwable", true), "type", true);
          for(SNode livingThrowable : new HashSet<SNode>(throwables)) {
            if (TypeChecker.getInstance().getSubtypingManager().isSubtype(livingThrowable, throwableType)) {
              throwables.remove(livingThrowable);
            }
          }
        }
      }
      if (throwables.isEmpty()) {
        return;
      }
      if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.TryCatchStatement") && SLinkOperations.getTarget(parent, "body", true) == statementList) {
        SNode tryCatchStatement = parent;
        for(SNode catchClause : SLinkOperations.getTargets(tryCatchStatement, "catchClause", true)) {
          SNode throwableType = SLinkOperations.getTarget(SLinkOperations.getTarget(catchClause, "throwable", true), "type", true);
          for(SNode livingThrowable : new HashSet<SNode>(throwables)) {
            if (TypeChecker.getInstance().getSubtypingManager().isSubtype(livingThrowable, throwableType)) {
              throwables.remove(livingThrowable);
            }
          }
        }
      }
      if (throwables.isEmpty()) {
        return;
      }
      if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration") && SLinkOperations.getTarget(parent, "body", true) == statementList) {
        SNode baseMethodDeclaration = parent;
        for(SNode throwableType : SLinkOperations.getTargets(baseMethodDeclaration, "throwsItem", true)) {
          for(SNode livingThrowable : new HashSet<SNode>(throwables)) {
            if (TypeChecker.getInstance().getSubtypingManager().isSubtype(livingThrowable, throwableType)) {
              throwables.remove(livingThrowable);
            }
          }
        }
        if (!(throwables.isEmpty())) {
          String errorString = "uncaught exceptions:";
          for(SNode exc : throwables) {
            errorString = errorString + " " + exc;
          }
          {
            BaseIntentionProvider intentionProvider = null;
            intentionProvider = new BaseIntentionProvider("r:5c653028-76bb-4190-877c-234af600138c(jetbrains.mps.baseLanguage.helgins@3_0).AddExceptionToMethodSignature_QuickFix", false);
            intentionProvider.putArgument("throwableType", throwables.iterator().next());
            TypeChecker.getInstance().reportTypeError(mainNode, errorString, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1210182111558", intentionProvider);
          }
        }
        return;
      }
    }
  }

}
