package jetbrains.mps.debug.evaluation;

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