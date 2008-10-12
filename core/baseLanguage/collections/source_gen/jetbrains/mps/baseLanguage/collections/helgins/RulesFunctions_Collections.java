package jetbrains.mps.baseLanguage.collections.helgins;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.dependencies.CheckingMethod;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.lang.typesystem.dependencies.InferenceMethod;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ITranslator;
import jetbrains.mps.internal.collections.runtime.ISequence;
import jetbrains.mps.internal.collections.runtime.ISequenceIterableAdapter;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;

public class RulesFunctions_Collections {

  @CheckingMethod()
  public static SNode getInput(final TypeCheckingContext typeCheckingContext, SNode op) {
    SNode input = null;
    SNode parent = SNodeOperations.getParent(op);
    if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.DotExpression")) {
      input = SLinkOperations.getTarget(parent, "operand", true);
    } else
    {
      {
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.reportTypeError(op, "not expected here", "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.helgins)", "1184783963366", intentionProvider);
      }
    }
    return input;
  }

  public static SNode getOutput(SNode op) {
    SNode output = null;
    SNode parent = SNodeOperations.getParent(op);
    if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.DotExpression")) {
      output = SLinkOperations.getTarget(parent, "operation", true);
      return output;
    } else
    {
      return null;
    }
  }

  @InferenceMethod()
  public static void setInputSequenceType(final TypeCheckingContext typeCheckingContext, SNode op, SNode target) {
    // 1. Take input expression
    // 2. Assert that it is coerceable to sequence
    // 3. Assign the sequence type to the target
    SNode input = getInput(typeCheckingContext, op);
    if ((input != null)) {
      final SNode elementType_typevar_1184784638219 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
      {
        SNode _nodeToCheck_1029348928467 = null;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createLessThanInequation(typeCheckingContext.typeOf(input, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.helgins)", "1184843134901", true), new QuotationClass_0().createNode(TypeChecker.getInstance().getEquationManager().getRepresentator(elementType_typevar_1184784638219)), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.helgins)", "1184843140648", false, 0, intentionProvider);
      }
      {
        SNode _nodeToCheck_1029348928467 = null;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createEquation(typeCheckingContext.typeOf(target, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.helgins)", "1184844094867", true), new QuotationClass_1().createNode(TypeChecker.getInstance().getEquationManager().getRepresentator(elementType_typevar_1184784638219)), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.helgins)", "1184844101686", intentionProvider);
      }
    }
  }

  @InferenceMethod()
  public static void setInputElementType(final TypeCheckingContext typeCheckingContext, SNode op, SNode target) {
    // 1. Take input expression
    // 2. Assert that it is coerceable to sequence
    // 3. Assign the sequence element type to the target
    SNode input = getInput(typeCheckingContext, op);
    if ((input != null)) {
      final SNode elementType_typevar_1184844804662 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
      {
        SNode _nodeToCheck_1029348928467 = null;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createLessThanInequation(typeCheckingContext.typeOf(input, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.helgins)", "1184844804669", true), new QuotationClass_2().createNode(TypeChecker.getInstance().getEquationManager().getRepresentator(elementType_typevar_1184844804662)), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.helgins)", "1184844804663", false, 0, intentionProvider);
      }
      {
        SNode _nodeToCheck_1029348928467 = null;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createEquation(typeCheckingContext.typeOf(target, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.helgins)", "1184844804677", true), TypeChecker.getInstance().getEquationManager().getRepresentator(elementType_typevar_1184844804662), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.helgins)", "1184844804671", intentionProvider);
      }
    }
  }

  @InferenceMethod()
  public static void isInputElementType(final TypeCheckingContext typeCheckingContext, SNode op, SNode target) {
    // 1. Take input expression
    // 2. Assert that it is coerceable to sequence
    // 3. Assert that target has sequence element type
    SNode input = getInput(typeCheckingContext, op);
    if ((input != null)) {
      final SNode elementType_typevar_1184850451264 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
      {
        SNode _nodeToCheck_1029348928467 = null;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createLessThanInequation(typeCheckingContext.typeOf(input, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.helgins)", "1184850451271", true), new QuotationClass_3().createNode(TypeChecker.getInstance().getEquationManager().getRepresentator(elementType_typevar_1184850451264)), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.helgins)", "1184850451265", false, 0, intentionProvider);
      }
      {
        SNode _nodeToCheck_1029348928467 = null;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createLessThanInequation(typeCheckingContext.typeOf(target, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.helgins)", "1184850492037", true), TypeChecker.getInstance().getEquationManager().getRepresentator(elementType_typevar_1184850451264), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.helgins)", "1184850492036", false, 0, intentionProvider);
      }
    }
  }

  public static Iterable<SNode> collectYieldStatements(SNode node) {
    Iterable<SNode> yieldStatements = ListSequence.fromList(SNodeOperations.getChildren(node)).translate(new ITranslator <SNode, SNode>() {

      public ISequence<SNode> translate(final SNode it) {
        return new ISequenceIterableAdapter <SNode>() {

          public Iterator<SNode> iterator() {
            return new YieldingIterator <SNode>() {

              private int __CP__ = 0;
              private SNode _11_yieldStmt;
              private Iterator<SNode> _11_yieldStmt_it;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 11:
                      this._11_yieldStmt_it = collectYieldStatements(it).iterator();
                    case 12:
                      if (!(this._11_yieldStmt_it.hasNext())) {
                        this.__CP__ = 3;
                        break;
                      }
                      this._11_yieldStmt = this._11_yieldStmt_it.next();
                      this.__CP__ = 13;
                      break;
                    case 4:
                      if (SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.collections.structure.TraversalYieldStatement")) {
                        this.__CP__ = 5;
                        break;
                      }
                      this.__CP__ = 7;
                      break;
                    case 7:
                      if (SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.ConceptFunction") || SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.CommentedStatementsBlock")) {
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
                      this.yield(this._11_yieldStmt);
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
    return yieldStatements;
  }

}
