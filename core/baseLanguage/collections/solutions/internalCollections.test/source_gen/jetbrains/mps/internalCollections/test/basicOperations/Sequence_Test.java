package jetbrains.mps.internalCollections.test.basicOperations;

/*Generated by MPS */

import jetbrains.mps.internalCollections.test.closures.Util_Test;
import org.junit.Test;
import jetbrains.mps.internal.collections.runtime.ISequence;
import jetbrains.mps.internal.collections.runtime.Sequence;
import junit.framework.Assert;
import java.util.Collections;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import java.util.Arrays;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ArrayUtils;

public class Sequence_Test extends Util_Test {

  @Test()
  public void test_sequenceMethods() throws Exception {
    ISequence<Integer> input = Sequence.fromIterable(this.input5());
    Assert.assertEquals(((Integer)1), input.first());
    Assert.assertEquals(((Integer)5), input.last());
    Assert.assertEquals(5, input.count());
    for(Integer i : this.input5()) {
      Assert.assertEquals(true, input.contains(i));
      Assert.assertEquals(i - 1, input.indexOf(i));
    }
    Assert.assertEquals(false, input.contains(-1));
    Assert.assertEquals(false, input.isEmpty());
    Assert.assertEquals(true, input.isNotEmpty());
    Assert.assertEquals(true, Sequence.fromIterable(Collections.emptyList()).isEmpty());
    Assert.assertEquals(false, Sequence.fromIterable(Collections.emptyList()).isNotEmpty());
  }

  @Test()
  public void test_sequenceFromClosure() throws Exception {
    Iterable<Integer> seq = new _FunctionTypes._return_P0_E0 <Iterable<Integer>>() {

      public Iterable<Integer> invoke() {
        return new Iterable <Integer>() {

          public Iterator<Integer> iterator() {
            return new YieldingIterator <Integer>() {

              private int __CP__ = 0;
              private int _2_i;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      this._2_i = 1;
                    case 3:
                      if (!(this._2_i <= 5)) {
                        this.__CP__ = 1;
                        break;
                      }
                      this.__CP__ = 4;
                      break;
                    case 5:
                      this._2_i = this._2_i + 1;
                      this.__CP__ = 3;
                      break;
                    case 6:
                      this.__CP__ = 5;
                      this.yield(this._2_i);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 4:
                      this.__CP__ = 6;
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

    }.invoke();
    this.assertIterableEquals(this.expect5(), seq);
  }

  @Test()
  public void test_sequenceInitializer() throws Exception {
    Iterable<Integer> seq = Sequence.fromClosure(new ISequenceClosure <Integer>() {

      public Iterable<Integer> iterable() {
        return new Iterable <Integer>() {

          public Iterator<Integer> iterator() {
            return new YieldingIterator <Integer>() {

              private int __CP__ = 0;
              private int _2_i;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      this._2_i = 1;
                    case 3:
                      if (!(this._2_i <= 5)) {
                        this.__CP__ = 1;
                        break;
                      }
                      this.__CP__ = 4;
                      break;
                    case 5:
                      this._2_i = this._2_i + 1;
                      this.__CP__ = 3;
                      break;
                    case 6:
                      this.__CP__ = 5;
                      this.yield(this._2_i);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 4:
                      this.__CP__ = 6;
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
    this.assertIterableEquals(this.expect5(), seq);
  }

  @Test()
  public void test_sequenceInitializer2() throws Exception {
    Iterable<Integer> seq = Sequence.fromClosure(new ISequenceClosure <Integer>() {

      public Iterable<Integer> iterable() {
        return new Iterable <Integer>() {

          public Iterator<Integer> iterator() {
            return new YieldingIterator <Integer>() {

              private int __CP__ = 0;
              private int _2_i;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      this._2_i = 1;
                    case 3:
                      if (!(this._2_i <= 5)) {
                        this.__CP__ = 1;
                        break;
                      }
                      this.__CP__ = 4;
                      break;
                    case 5:
                      this._2_i++ ;
                      this.__CP__ = 3;
                      break;
                    case 6:
                      this.__CP__ = 5;
                      this.yield(this._2_i);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 4:
                      this.__CP__ = 6;
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
    this.assertIterableEquals(this.expect5(), seq);
    Iterable<Integer> seq2 = Sequence.fromIterable(Collections.<Integer>emptyList());
    Assert.assertTrue(Sequence.fromIterable(seq2).isEmpty());
    Iterable<Integer> seq3 = Sequence.fromClosure(new ISequenceClosure <Integer>() {

      public Iterable<Integer> iterable() {
        return new Iterable <Integer>() {

          public Iterator<Integer> iterator() {
            return new YieldingIterator <Integer>() {

              private int __CP__ = 0;
              private int _4_i;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 4:
                      this._4_i = 1;
                    case 5:
                      if (!(this._4_i <= 10)) {
                        this.__CP__ = 3;
                        break;
                      }
                      this.__CP__ = 6;
                      break;
                    case 7:
                      this._4_i++ ;
                      this.__CP__ = 5;
                      break;
                    case 9:
                      if (this._4_i >= 5) {
                        this.__CP__ = 10;
                        break;
                      }
                      this.__CP__ = 7;
                      break;
                    case 3:
                      if (false) {
                        this.__CP__ = 2;
                        break;
                      }
                      this.__CP__ = 1;
                      break;
                    case 8:
                      this.__CP__ = 9;
                      this.yield(this._4_i);
                      return true;
                    case 2:
                      this.__CP__ = 4;
                      break;
                    case 6:
                      this.__CP__ = 8;
                      break;
                    case 10:
                      this.__CP__ = 1;
                      break;
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
    this.assertIterableEquals(this.expect5(), seq3);
  }

  @Test()
  public void test_sequenceOperations() throws Exception {
    Iterable<Integer> input = this.input5();
    Assert.assertEquals(((Integer)1), Sequence.fromIterable(input).first());
    Assert.assertEquals(((Integer)5), Sequence.fromIterable(input).last());
    Assert.assertEquals(5, Sequence.fromIterable(input).count());
    for(Integer i : this.input5()) {
      Assert.assertEquals(true, Sequence.fromIterable(input).contains(i));
      Assert.assertEquals(i - 1, Sequence.fromIterable(input).indexOf(i));
    }
    Assert.assertEquals(false, Sequence.fromIterable(input).contains(-1));
    Assert.assertEquals(false, Sequence.fromIterable(input).isEmpty());
    Assert.assertEquals(true, Sequence.fromIterable(input).isNotEmpty());
    Assert.assertEquals(true, Sequence.fromIterable(this.inputEmpty()).isEmpty());
    Assert.assertEquals(false, Sequence.fromIterable(this.inputEmpty()).isNotEmpty());
  }

  @Test()
  public void test_toOperations() throws Exception {
    Iterable<Integer> input = this.input5();
    Assert.assertTrue(Arrays.equals(new Integer[]{1,2,3,4,5}, ListSequence.fromIterable(input).toGenericArray(Integer.class)));
    this.assertIterableEquals(this.expect5(), Sequence.fromIterable(input).toListSequence());
    Integer i = 1;
    for(Iterator<Integer> it = input.iterator() ; it.hasNext() ; i = i + 1) {
      Assert.assertEquals(i, it.next());
    }
    Assert.assertSame(6, i);
    String[] sarr = new String[]{"A","B","C"};
    Object[] oarr = new Object[]{"A","B","C"};
    List list = Arrays.asList(oarr);
    List<String> slist = ((List<String>)list);
    String[] toarray = ListSequence.fromList(slist).toGenericArray(String.class);
    for(String s : toarray) {
      Assert.assertTrue(s instanceof String);
    }
    Assert.assertTrue(Arrays.equals(sarr, oarr));
  }

  @Test()
  public void test_primitiveParameter() throws Exception {
    Iterable<Integer> test = Sequence.fromClosure(new ISequenceClosure <Integer>() {

      public Iterable<Integer> iterable() {
        return new Iterable <Integer>() {

          public Iterator<Integer> iterator() {
            return new YieldingIterator <Integer>() {

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
                      this.yield(1);
                      return true;
                    case 3:
                      this.__CP__ = 4;
                      this.yield(2);
                      return true;
                    case 4:
                      this.__CP__ = 1;
                      this.yield(3);
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
    Assert.assertEquals(3, Sequence.fromIterable(test).count());
    Iterable<Integer> TEST = test;
    test = TEST;
    int[] iarr = ArrayUtils.toIntArray(Sequence.fromIterable(test));
    int foo = ListSequence.fromIterable(test).toGenericArray(Integer.class)[0];
    Iterable<Character> empty = Sequence.fromIterable(Collections.<Character>emptyList());
    char[] carr = ArrayUtils.toCharArray(Sequence.fromIterable(empty));
    Assert.assertEquals(0, carr.length);
  }

  @Test()
  public void test_singleton() throws Exception {
    Iterable<Integer> ssl = Sequence.<Integer>singleton(42);
    Assert.assertSame(1, Sequence.fromIterable(ssl).count());
    Assert.assertSame(42, Sequence.fromIterable(ssl).first());
  }

}
