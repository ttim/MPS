package jetbrains.mps.baseLanguage.overloadedOerators.sandbox.test;

/*Generated by MPS */


public class ComplexOperators {
  public ComplexOperators() {
  }

  public static Complex apply_PlusExpression_Complex_Complex(Complex left, Complex right) {
    Complex res = new Complex();
    res.set(left.getRe() + right.getRe(), left.getIm() + right.getIm());
    return res;
  }

  public static Complex apply_MulExpression_Complex_Complex(Complex left, Complex right) {
    Complex res = new Complex();
    res.set(left.getRe() * right.getRe() - left.getIm() * right.getIm(), left.getRe() * right.getIm() + left.getIm() * right.getRe());
    return res;
  }
}
