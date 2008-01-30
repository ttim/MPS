package jetbrains.mps.closures.test;

/*Generated by MPS */

import junit.framework.TestCase;
import jetbrains.mps.closures.test._FunctionTypes._Integer;
import jetbrains.mps.closures.test._FunctionTypes._Number;
import jetbrains.mps.closures.test._FunctionTypes._Integer_from_Integer;
import jetbrains.mps.closures.test._FunctionTypes._Integer_from_Object;
import jetbrains.mps.closures.test._FunctionTypes._Number_from_String;

public class FunctionTypes_Test extends TestCase {

  public void test_functionTypeAdapter_simple() throws Exception {
    _Integer fun1 = new _FunctionTypes._Integer() {

      public Integer invoke() {
        return 1;
      }

    };
    _Integer fun2 = fun1;
    this.accept_int(fun1);
    this.accept_int(fun2);
    this.accept_Integer(fun2);
    this.accept_Number(new _FunctionTypes._Integer_to_Number_adapter(fun2));
    this.accept_int(new _FunctionTypes._Integer() {

      public Integer invoke() {
        return 1;
      }

    });
    this.accept_Integer(new _FunctionTypes._Integer() {

      public Integer invoke() {
        return (Integer)1;
      }

    });
    this.accept_Number(new _FunctionTypes._Integer_to_Number_adapter(new _FunctionTypes._Integer() {

      public Integer invoke() {
        return (Integer)1;
      }

    }));
  }

  public void test_functionTypeAdapter_complex() throws Exception {
    this.accept_int_from_int(new _FunctionTypes._Integer_from_Integer() {

      public Integer invoke(Integer i) {
        return i.intValue();
      }

    });
    this.accept_int_from_Integer(new _FunctionTypes._Integer_from_Integer() {

      public Integer invoke(Integer i) {
        return Integer.valueOf(i);
      }

    });
    this.accept_Integer_from_Object(new _FunctionTypes._Integer_from_Object() {

      public Integer invoke(Object o) {
        return o.hashCode();
      }

    });
    this.accept_Number_from_String(new _FunctionTypes._Integer_from_String_to_Number_from_String_adapter(new _FunctionTypes._Integer_from_String() {

      public Integer invoke(String s) {
        return s.length();
      }

    }));
    this.accept_Number_from_String(new _FunctionTypes._Integer_from_Object_to_Number_from_String_adapter(new _FunctionTypes._Integer_from_Object() {

      public Integer invoke(Object o) {
        return o.hashCode();
      }

    }));
  }

  public void accept_int(_Integer fun) {
  }

  public void accept_Integer(_Integer fun) {
  }

  public void accept_Number(_Number fun) {
  }

  public void accept_int_from_int(_Integer_from_Integer fun) {
  }

  public void accept_int_from_Integer(_Integer_from_Integer fun) {
  }

  public void accept_Integer_from_Object(_Integer_from_Object fun) {
  }

  public void accept_Number_from_String(_Number_from_String fun) {
  }

}
