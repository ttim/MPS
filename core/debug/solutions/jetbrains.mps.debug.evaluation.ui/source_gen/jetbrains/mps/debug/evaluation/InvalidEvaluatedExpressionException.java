package jetbrains.mps.debug.evaluation;

/*Generated by MPS */



/**
 * Thrown when we can not find a class, method or field user whants to evaluate -- so users expression is invalid.
 */
public class InvalidEvaluatedExpressionException extends EvaluationException {
  public InvalidEvaluatedExpressionException() {
    super();
  }

  public InvalidEvaluatedExpressionException(String message) {
    super(message);
  }

  public InvalidEvaluatedExpressionException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidEvaluatedExpressionException(Throwable cause) {
    super(cause);
  }
}
