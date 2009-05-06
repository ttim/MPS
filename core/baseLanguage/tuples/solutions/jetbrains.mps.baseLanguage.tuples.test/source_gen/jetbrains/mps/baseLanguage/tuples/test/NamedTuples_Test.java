package jetbrains.mps.baseLanguage.tuples.test;

/*Generated by MPS */

import junit.framework.TestCase;
import org.junit.Test;
import junit.framework.Assert;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.baseLanguage.tuples.util.SharedPair;
import jetbrains.mps.baseLanguage.tuples.shared.GlobalSharedPair;
import jetbrains.mps.internal.collections.runtime.IterableUtils;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;

public class NamedTuples_Test extends TestCase {

  @Test()
  public void test_createAndAssign() throws Exception {
    Data tpl = new Data("ABC", "XYZ");
    Assert.assertEquals("ABC", tpl.foo());
    Assert.assertEquals("XYZ", tpl.bar());
    Data tpl2 = new Data().assignFrom(tpl);
    Assert.assertEquals("ABC", tpl2.foo());
    Assert.assertEquals("XYZ", tpl2.bar());
    tpl.foo("abc");
    tpl.bar("xyz");
    Assert.assertEquals("abc", tpl.foo());
    Assert.assertEquals("xyz", tpl.bar());
    Assert.assertEquals("ABC", tpl2.foo());
    Assert.assertEquals("XYZ", tpl2.bar());
    tpl2.assignFrom(tpl);
    Assert.assertEquals("abc", tpl2.foo());
    Assert.assertEquals("xyz", tpl2.bar());
    tpl.assignFrom(new Data(tpl.bar(), tpl.foo()));
    Assert.assertEquals("abc", tpl.bar());
    Assert.assertEquals("xyz", tpl.foo());
    tpl2.assignFrom(new Data("abc", "xyz"));
    Assert.assertEquals("abc", tpl2.foo());
    Assert.assertEquals("xyz", tpl2.bar());
  }

  @Test()
  public void test_returnValue() throws Exception {
    Data data = new Data().assignFrom(this.getData());
    Assert.assertEquals("ABC", data.foo());
    Assert.assertEquals("XYZ", data.bar());
  }

  @Test()
  public void test_sequenceOfTuples() throws Exception {
    Iterable<Data> seq = this.getSequence();
    for(Data tpl : Sequence.fromIterable(seq)) {
      Assert.assertTrue("abc".equalsIgnoreCase(tpl.foo()));
      Assert.assertTrue("xyz".equalsIgnoreCase(tpl.bar()));
    }
  }

  @Test()
  public void test_assignToIndexedTupleType() throws Exception {
    Tuples._2<String, String> itpl = MultiTuple.<String, String>empty2().assign(this.getData());
    Assert.assertEquals("ABC", itpl._0());
    Assert.assertEquals("XYZ", itpl._1());
  }

  @Test()
  public void test_patternMatching() throws Exception {
    String foo;
    String bar;
    {
      Tuples._2<String, String> _tmp6211_0 = this.getData();
      foo = _tmp6211_0._0();
      bar = _tmp6211_0._1();
    }
    Assert.assertEquals("ABC", foo);
    Assert.assertEquals("XYZ", bar);
  }

  @Test()
  public void test_equalsOperator() throws Exception {
    Data tpl1 = new Data().assignFrom(this.getData());
    Data tpl2 = new Data().assignFrom(this.getData());
    Assert.assertFalse(((Object)tpl1) == ((Object)tpl2));
    Assert.assertTrue(MultiTuple.eq(tpl1, tpl2));
    Assert.assertFalse(!(MultiTuple.eq(tpl1, tpl2)));
    tpl2.assignFrom(new Data(tpl2.bar(), tpl2.foo()));
    Assert.assertFalse(MultiTuple.eq(tpl1, tpl2));
    Assert.assertTrue(!(MultiTuple.eq(tpl1, tpl2)));
  }

  @Test()
  public void test_boolean() throws Exception {
    Bool truth = new Bool(true);
    Assert.assertTrue(truth.isTrue());
  }

  @Test()
  public void test_filter() throws Exception {
    Iterable<Data> seq = this.getSequence();
    Sequence.fromIterable(seq).any(new IWhereFilter <Data>() {

      public boolean accept(Data it) {
        return it.foo() == it.bar();
      }
    });
  }

  @Test()
  public void test_pair() throws Exception {
    Pair<Integer, String> p = new Pair<Integer, String>(1, "a");
    Assert.assertSame(1, p.first());
    Assert.assertEquals("a", p.second());
    Pair<Integer, String> pp = new Pair<Integer, String>().assignFrom(p);
    Assert.assertFalse(((Object)p) == ((Object)pp));
    Assert.assertSame(1, pp.first());
    Assert.assertEquals("a", pp.second());
  }

  @Test()
  public void test_valueOfAssignment() throws Exception {
    Pair<String, Integer> pair = new Pair<String, Integer>("foo", 13);
    String res = pair.first("bar");
    Assert.assertEquals("bar", res);
    int i = pair.second(99);
    Assert.assertSame(99, i);
  }

  @Test()
  public void test_sharedPair() throws Exception {
    SharedPair<Integer, String> p = new SharedPair<Integer, String>(1, "a");
    Assert.assertSame(1, p.first());
    Assert.assertEquals("a", p.second());
    SharedPair<Integer, String> pp = new SharedPair<Integer, String>().assignFrom(p);
    Assert.assertFalse(((Object)p) == ((Object)pp));
    Assert.assertSame(1, pp.first());
    Assert.assertEquals("a", pp.second());
  }

  @Test()
  public void test_vararg1() throws Exception {
    String string = this.getString(new Pair<String, String>("a", "A"), new Pair<String, String>("b", "B"), new Pair<String, String>("c", "C"));
    Assert.assertEquals("a=A, b=B, c=C", string);
  }

  @Test()
  public void test_vararg2() throws Exception {
    String string = this.getString(new SharedPair<String, String>("a", "A"), new SharedPair<String, String>("b", "B"), new SharedPair<String, String>("c", "C"));
    Assert.assertEquals("a=A, b=B, c=C", string);
  }

  @Test()
  public void test_vararg3() throws Exception {
    String string = this.getString(new GlobalSharedPair<String, String>("a", "A"), new GlobalSharedPair<String, String>("b", "B"), new GlobalSharedPair<String, String>("c", "C"));
    Assert.assertEquals("a=A, b=B, c=C", string);
  }

  public String getString(SharedPair<String, String>... tuples) {
    return IterableUtils.join(Sequence.fromIterable(Sequence.fromArray(tuples)).select(new ISelector <SharedPair<String, String>, String>() {

      public String select(SharedPair<String, String> t) {
        return t.first() + "=" + t.second();
      }
    }), ", ");
  }

  public String getString(Pair<String, String>... tuples) {
    return IterableUtils.join(Sequence.fromIterable(Sequence.fromArray(tuples)).select(new ISelector <Pair<String, String>, String>() {

      public String select(Pair<String, String> t) {
        return t.first() + "=" + t.second();
      }
    }), ", ");
  }

  public String getString(GlobalSharedPair<String, String>... tuples) {
    return IterableUtils.join(Sequence.fromIterable(Sequence.fromArray(tuples)).select(new ISelector <GlobalSharedPair<String, String>, String>() {

      public String select(GlobalSharedPair<String, String> t) {
        return t.first() + "=" + t.second();
      }
    }), ", ");
  }

  public Data getData() {
    return new Data("ABC", "XYZ");
  }

  public Iterable<Data> getSequence() {
    return Sequence.fromClosure(new ISequenceClosure <Data>() {

      public Iterable<Data> iterable() {
        return new Iterable <Data>() {

          public Iterator<Data> iterator() {
            return new YieldingIterator <Data>() {

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
                } while(true);
                return false;
              }
            };
          }
        };
      }
    });
  }

}
