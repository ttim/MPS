package jetbrains.mps.closures.test;

/*Generated by MPS */

import junit.framework.TestCase;
import jetbrains.mps.closures.test._FunctionTypes._void_from_List_of_Integer;
import jetbrains.mps.closures.test._FunctionTypes._Iterable_of_Integer;
import java.util.List;
import java.util.ArrayList;
import junit.framework.Assert;

public class ClosuresBase_Test extends TestCase {

  public void assertResultsEqual(_void_from_List_of_Integer expected, _Iterable_of_Integer test) {
    List expectedList = new ArrayList();
    expected.invoke(expectedList);
    List testList = new ArrayList();
    for(Object o : test.invoke()) {
      testList.add(o);
    }
    Assert.assertEquals(expectedList, testList);
  }

}
