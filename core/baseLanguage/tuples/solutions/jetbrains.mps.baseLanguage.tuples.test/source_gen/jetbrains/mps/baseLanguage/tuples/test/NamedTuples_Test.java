package jetbrains.mps.baseLanguage.tuples.test;

/*Generated by MPS */

import junit.framework.TestCase;
import junit.framework.Assert;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.baseLanguage.tuples.shared.GlobalSharedPair;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ArrayUtils;
import jetbrains.mps.internal.collections.runtime.IterableUtils;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;

public class NamedTuples_Test extends TestCase {
  public void test_createAndAssign() throws Exception {
    // this test no longer applies 
    if (true) {
      return;
    }
    Data tpl = new Data("ABC", "XYZ");
    Assert.assertEquals("ABC", tpl.foo());
    Assert.assertEquals("XYZ", tpl.bar());
    Data tpl2 = tpl;
    Assert.assertEquals("ABC", tpl2.foo());
    Assert.assertEquals("XYZ", tpl2.bar());
    tpl.foo("abc");
    tpl.bar("xyz");
    Assert.assertEquals("abc", tpl.foo());
    Assert.assertEquals("xyz", tpl.bar());
    Assert.assertEquals("ABC", tpl2.foo());
    Assert.assertEquals("XYZ", tpl2.bar());
    tpl2 = tpl;
    Assert.assertEquals("abc", tpl2.foo());
    Assert.assertEquals("xyz", tpl2.bar());
    tpl = new Data(tpl.bar(), tpl.foo());
    Assert.assertEquals("abc", tpl.bar());
    Assert.assertEquals("xyz", tpl.foo());
    tpl2 = new Data("abc", "xyz");
    Assert.assertEquals("abc", tpl2.foo());
    Assert.assertEquals("xyz", tpl2.bar());
  }

  public void test_returnValue() throws Exception {
    Data data = this.getData();
    Assert.assertEquals("ABC", data.foo());
    Assert.assertEquals("XYZ", data.bar());
  }

  public void test_sequenceOfTuples() throws Exception {
    Iterable<Data> seq = this.getSequence();
    for (Data tpl : Sequence.<Data>fromIterable(seq)) {
      Assert.assertTrue("abc".equalsIgnoreCase(tpl.foo()));
      Assert.assertTrue("xyz".equalsIgnoreCase(tpl.bar()));
    }
  }

  public void test_assignToIndexedTupleType() throws Exception {
    Tuples._2<String, String> itpl = this.getData();
    Assert.assertEquals("ABC", itpl._0());
    Assert.assertEquals("XYZ", itpl._1());
  }

  public void test_patternMatching() throws Exception {
    String foo;
    String bar;
    {
      Tuples._2<String, String> _tmp_w279bq_c0e0 = this.getData();
      foo = _tmp_w279bq_c0e0._0();
      bar = _tmp_w279bq_c0e0._1();
    }
    Assert.assertEquals("ABC", foo);
    Assert.assertEquals("XYZ", bar);
  }

  public void test_equalsOperator() throws Exception {
    Data tpl1 = this.getData();
    Data tpl2 = this.getData();
    Assert.assertFalse(((Object) tpl1) == ((Object) tpl2));
    Assert.assertTrue(MultiTuple.eq(tpl1, tpl2));
    Assert.assertFalse(!(MultiTuple.eq(tpl1, tpl2)));
    tpl2 = new Data(tpl2.bar(), tpl2.foo());
    Assert.assertFalse(MultiTuple.eq(tpl1, tpl2));
    Assert.assertTrue(!(MultiTuple.eq(tpl1, tpl2)));
  }

  public void test_boolean() throws Exception {
    Bool truth = new Bool(true);
    Assert.assertTrue((boolean) truth.isTrue());
  }

  public void test_filter() throws Exception {
    Iterable<Data> seq = this.getSequence();
    Sequence.<Data>fromIterable(seq).any(new IWhereFilter<Data>() {
      public boolean accept(Data it) {
        return it.foo() == it.bar();
      }
    });
  }

  public void test_pair() throws Exception {
    Pair<Integer, String> p = new Pair<Integer, String>(1, "a");
    Assert.assertSame(1, p.first());
    Assert.assertEquals("a", p.second());
    Pair<Integer, String> pp = p;
    // <node> 
    Assert.assertSame(1, pp.first());
    Assert.assertEquals("a", pp.second());
  }

  public void test_valueOfAssignment() throws Exception {
    Pair<String, Integer> pair = new Pair<String, Integer>("foo", 13);
    String res = pair.first("bar");
    Assert.assertEquals("bar", res);
    int i = pair.second(99);
    Assert.assertSame(99, i);
  }

  public void test_vararg1() throws Exception {
    String string = this.getString(new Pair<String, String>("a", "A"), new Pair<String, String>("b", "B"), new Pair<String, String>("c", "C"));
    Assert.assertEquals("a=A, b=B, c=C", string);
  }

  public void test_vararg3() throws Exception {
    String string = this.getString(new GlobalSharedPair<String, String>("a", "A"), new GlobalSharedPair<String, String>("b", "B"), new GlobalSharedPair<String, String>("c", "C"));
    Assert.assertEquals("a=A, b=B, c=C", string);
  }

  public void test_listOfTuples() throws Exception {
    List<Pair<String, Long>> lot = ListSequence.<Pair<String, Long>>fromList(new ArrayList<Pair<String, Long>>());
    ListSequence.<Pair<String, Long>>fromList(lot).addElement(new Pair<String, Long>("A", 1L));
    ListSequence.<Pair<String, Long>>fromList(lot).addElement(new Pair<String, Long>("B", 2L));
    Assert.assertSame(2, ListSequence.<Pair<String, Long>>fromList(lot).count());
    Assert.assertEquals("B", ListSequence.<Pair<String, Long>>fromList(lot).getElement(1).first());
  }

  public void test_arrayOfTuples() throws Exception {
    Pair<String, Long>[] arr1 = ArrayUtils.asArray(new Pair<String, Long>("A", 1L), new Pair<String, Long>("B", 2L));
    Pair<String, Long>[] arr2 = (Pair<String, Long>[]) ArrayUtils.newArrayInstance(Pair.class, 2);
    for (int idx = 0; idx < arr1.length; idx++) {
      arr2[idx] = arr1[idx];
    }
    Assert.assertEquals(arr1[0], arr2[0]);
    Assert.assertSame(1L, arr2[0].second());
    Assert.assertEquals("B", arr2[1].first());
  }

  public void test_tupleDecl() throws Exception {
    Pair<Integer, String> pair;
    pair = new Pair<Integer, String>(-1, "Z");
    Assert.assertNotNull(pair);
    Assert.assertEquals("Z", pair.second());
  }

  public void test_record() throws Exception {
    Record r = new Record("Foo", 567, 0.5f);
    Assert.assertEquals("Foo:567:0.5", r.toString());
  }

  public void test_mps11134() throws Exception {
    IntPair ip = new IntPair(7, 7);
    Assert.assertTrue((int) ip.a() == (int) ip.b());
    IntPair ip2 = new IntPair(9999 + 1, 10001 - 1);
    Assert.assertTrue((int) ip2.a() == (int) ip2.b());
  }

  public void test_nulls() throws Exception {
    IntPair pair = null;
    Assert.assertNull(pair);
    pair = new IntPair(1, 2);
    Assert.assertNotNull(pair);
  }

  public void test_implementsInterface() throws Exception {
    Sample sample = new Sample(42);
    Assert.assertSame(42, sample.get());
    Assert.assertEquals("<42>", sample.getSample());
    ISample s = sample;
    Assert.assertEquals("<42>", s.getSample());
  }

  public String getString(Pair<String, String>... tuples) {
    return IterableUtils.join(Sequence.<Pair<String, String>>fromIterable(Sequence.fromArray(tuples)).<String>select(new ISelector<Pair<String, String>, String>() {
      public String select(Pair<String, String> t) {
        return t.first() + "=" + t.second();
      }
    }), ", ");
  }

  public String getString(GlobalSharedPair<String, String>... tuples) {
    return IterableUtils.join(Sequence.<GlobalSharedPair<String, String>>fromIterable(Sequence.fromArray(tuples)).<String>select(new ISelector<GlobalSharedPair<String, String>, String>() {
      public String select(GlobalSharedPair<String, String> t) {
        return t.first() + "=" + t.second();
      }
    }), ", ");
  }

  public Data getData() {
    return new Data("ABC", "XYZ");
  }

  public Iterable<Data> getSequence() {
    return Sequence.<Data>fromClosure(new ISequenceClosure<Data>() {
      public Iterable<Data> iterable() {
        return new Iterable<Data>() {
          public Iterator<Data> iterator() {
            return new YieldingIterator<Data>() {
              private int __CP__ = 0;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      this.__CP__ = 3;
                      this.yield(new Data("ABC", "XYZ"));
                      return true;
                    case 3:
                      this.__CP__ = 1;
                      this.yield(new Data("abc", "xyz"));
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    default:
                      break __loop__;
                  }
                } while (true);
                return false;
              }
            };
          }
        };
      }
    });
  }
}
