package jetbrains.mps.baseLanguage.tuples.test;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;

public class Data extends MultiTuple._2<String, String> {

  public Data() {
    super();
  }
  public Data(String foo, String bar) {
    super(foo, bar);
  }

  @SuppressWarnings(value = "unchecked")
  public Data foo(String value) {
    return (Data)super._0(value);
  }

  @SuppressWarnings(value = "unchecked")
  public Data bar(String value) {
    return (Data)super._1(value);
  }

  public String foo() {
    return super._0();
  }

  public String bar() {
    return super._1();
  }

  @SuppressWarnings(value = "unchecked")
  public Data assignFrom(Tuples._2<String, String> from) {
    return (Data)super.assign(from);
  }

}
