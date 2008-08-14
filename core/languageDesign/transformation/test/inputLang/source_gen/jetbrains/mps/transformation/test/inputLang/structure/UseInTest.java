package jetbrains.mps.transformation.test.inputLang.structure;

/*Generated by MPS */

import java.util.List;
import java.util.LinkedList;

public enum UseInTest {
  test1("test1", "test1"),
  getPrevInputTest("getPrevInputTest", "getPrevInputTest"),
  reduceInheritors("reduceInheritors", "reduceInheritors"),
  reduceExpressionToStatement("reduceExpressionToStatement", "reduceExpressionToStatement"),
  dontApplyReductionTwice("dontApplyReductionTwice", "dontApplyReductionTwice"),
  weaveManyToSingularChild("weaveManyToSingularChild", "weaveManyToSingularChild"),
  none("none", "none");

  private String myName;
  private String myValue;

UseInTest(String name, String value) {
    this.myName = name;
    this.myValue = value;
  }

  public static List<UseInTest> getConstants() {
    List<UseInTest> list = new LinkedList<UseInTest>();
    list.add(UseInTest.test1);
    list.add(UseInTest.getPrevInputTest);
    list.add(UseInTest.reduceInheritors);
    list.add(UseInTest.reduceExpressionToStatement);
    list.add(UseInTest.dontApplyReductionTwice);
    list.add(UseInTest.weaveManyToSingularChild);
    list.add(UseInTest.none);
    return list;
  }

  public static UseInTest getDefault() {
    return UseInTest.none;
  }

  public static UseInTest parseValue(String value) {
    if (value == null) {
      return UseInTest.getDefault();
    }
    if (value.equals(UseInTest.test1.getValueAsString())) {
      return UseInTest.test1;
    }
    if (value.equals(UseInTest.getPrevInputTest.getValueAsString())) {
      return UseInTest.getPrevInputTest;
    }
    if (value.equals(UseInTest.reduceInheritors.getValueAsString())) {
      return UseInTest.reduceInheritors;
    }
    if (value.equals(UseInTest.reduceExpressionToStatement.getValueAsString())) {
      return UseInTest.reduceExpressionToStatement;
    }
    if (value.equals(UseInTest.dontApplyReductionTwice.getValueAsString())) {
      return UseInTest.dontApplyReductionTwice;
    }
    if (value.equals(UseInTest.weaveManyToSingularChild.getValueAsString())) {
      return UseInTest.weaveManyToSingularChild;
    }
    if (value.equals(UseInTest.none.getValueAsString())) {
      return UseInTest.none;
    }
    return UseInTest.getDefault();
  }


  public String getName() {
    return this.myName;
  }

  public String getValueAsString() {
    return this.myValue;
  }

  public String getValue() {
    return this.myValue;
  }

}
