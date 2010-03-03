package jetbrains.mps.internalCollections.test.basicOperations;

/*Generated by MPS */

import jetbrains.mps.internalCollections.test.closures.Util_Test;
import jetbrains.mps.internal.collections.runtime.ISequence;
import jetbrains.mps.internal.collections.runtime.Sequence;
import junit.framework.Assert;
import java.util.Collections;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import java.util.Arrays;
import jetbrains.mps.internal.collections.runtime.ArrayUtils;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.IterableUtils;

public class Sequence_Test extends Util_Test {
  public void test_sequenceMethods() throws Exception {
    ISequence<Integer> input = Sequence.fromIterable(this.input5());
    Assert.assertEquals(((Integer) 1), input.first());
    Assert.assertEquals(((Integer) 5), input.last());
    Assert.assertEquals(5, input.count());
    for (Integer i : this.input5()) {
      Assert.assertEquals(true, input.contains(i));
      Assert.assertEquals(i - 1, input.indexOf(i));
    }
    Assert.assertEquals(false, input.contains(-1));
    Assert.assertEquals(false, input.isEmpty());
    Assert.assertEquals(true, input.isNotEmpty());
    Assert.assertEquals(true, Sequence.fromIterable(Collections.emptyList()).isEmpty());
    Assert.assertEquals(false, Sequence.fromIterable(Collections.emptyList()).isNotEmpty());
  }

  public void test_sequenceFromClosure() throws Exception {
    Iterable<Integer> seq = new _FunctionTypes._return_P0_E0<Iterable<Integer>>() {
      public Iterable<Integer> invoke() {
        return new Iterable<Integer>() {
          public Iterator<Integer> iterator() {
            return new YieldingIterator<Integer>() {
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
                      if (!(_2_i <= 5)) {
                        this.__CP__ = 1;
                        break;
                      }
                      this.__CP__ = 4;
                      break;
                    case 5:
                      _2_i++;
                      this.__CP__ = 3;
                      break;
                    case 6:
                      this.__CP__ = 5;
                      this.yield(_2_i);
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

  public void test_sequenceInitializer() throws Exception {
    Iterable<Integer> seq = Sequence.fromClosure(new ISequenceClosure<Integer>() {
      public Iterable<Integer> iterable() {
        return new Iterable<Integer>() {
          public Iterator<Integer> iterator() {
            return new YieldingIterator<Integer>() {
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
                      if (!(_2_i <= 5)) {
                        this.__CP__ = 1;
                        break;
                      }
                      this.__CP__ = 4;
                      break;
                    case 5:
                      _2_i++;
                      this.__CP__ = 3;
                      break;
                    case 6:
                      this.__CP__ = 5;
                      this.yield(_2_i);
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

  public void test_sequenceInitializer2() throws Exception {
    Iterable<Integer> seq = Sequence.fromClosure(new ISequenceClosure<Integer>() {
      public Iterable<Integer> iterable() {
        return new Iterable<Integer>() {
          public Iterator<Integer> iterator() {
            return new YieldingIterator<Integer>() {
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
                      if (!(_2_i <= 5)) {
                        this.__CP__ = 1;
                        break;
                      }
                      this.__CP__ = 4;
                      break;
                    case 5:
                      _2_i++;
                      this.__CP__ = 3;
                      break;
                    case 6:
                      this.__CP__ = 5;
                      this.yield(_2_i);
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
    Iterable<Integer> seq3 = Sequence.fromClosure(new ISequenceClosure<Integer>() {
      public Iterable<Integer> iterable() {
        return new Iterable<Integer>() {
          public Iterator<Integer> iterator() {
            return new YieldingIterator<Integer>() {
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
                      if (!(_4_i <= 10)) {
                        this.__CP__ = 3;
                        break;
                      }
                      this.__CP__ = 6;
                      break;
                    case 7:
                      _4_i++;
                      this.__CP__ = 5;
                      break;
                    case 9:
                      if (_4_i >= 5) {
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
                      this.yield(_4_i);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 2:
                      this.__CP__ = 4;
                      break;
                    case 6:
                      this.__CP__ = 8;
                      break;
                    case 10:
                      this.__CP__ = 1;
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

  public void test_sequenceOperations() throws Exception {
    Iterable<Integer> input = this.input5();
    Assert.assertEquals(((Integer) 1), Sequence.fromIterable(input).first());
    Assert.assertEquals(((Integer) 5), Sequence.fromIterable(input).last());
    Assert.assertEquals(5, Sequence.fromIterable(input).count());
    for (Integer i : this.input5()) {
      Assert.assertEquals(true, Sequence.fromIterable(input).contains(i));
      Assert.assertEquals(i - 1, Sequence.fromIterable(input).indexOf(i));
    }
    Assert.assertEquals(false, Sequence.fromIterable(input).contains(-1));
    Assert.assertEquals(false, Sequence.fromIterable(input).isEmpty());
    Assert.assertEquals(true, Sequence.fromIterable(input).isNotEmpty());
    Assert.assertEquals(true, Sequence.fromIterable(this.inputEmpty()).isEmpty());
    Assert.assertEquals(false, Sequence.fromIterable(this.inputEmpty()).isNotEmpty());
  }

  public void test_toOperations() throws Exception {
    Iterable<Integer> input = this.input5();
    Assert.assertTrue(Arrays.equals(new int[]{1,2,3,4,5}, ArrayUtils.toIntArray(Sequence.fromIterable(input).toListSequence())));
    this.assertIterableEquals(this.expect5(), Sequence.fromIterable(input).toListSequence());
    Integer i = 1;
    for (Iterator<Integer> it = input.iterator(); it.hasNext(); i++) {
      Assert.assertEquals(i, it.next());
    }
    Assert.assertSame(6, i);
    String[] sarr = new String[]{"A","B","C"};
    Object[] oarr = new Object[]{"A","B","C"};
    List list = Arrays.asList(oarr);
    List<String> slist = ((List<String>) list);
    String[] toarray = ListSequence.fromList(slist).toGenericArray(String.class);
    for (String s : toarray) {
      Assert.assertTrue(s instanceof String);
    }
    Assert.assertTrue(Arrays.equals(sarr, oarr));
  }

  public void test_primitiveParameter() throws Exception {
    Iterable<Integer> test = Sequence.fromClosure(new ISequenceClosure<Integer>() {
      public Iterable<Integer> iterable() {
        return new Iterable<Integer>() {
          public Iterator<Integer> iterator() {
            return new YieldingIterator<Integer>() {
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
    int foo = Sequence.fromIterable(test).toGenericArray(Integer.class)[0];
    Iterable<Character> empty = Sequence.fromIterable(Collections.<Character>emptyList());
    char[] carr = ArrayUtils.toCharArray(Sequence.fromIterable(empty));
    Assert.assertEquals(0, carr.length);
  }

  public void test_singleton() throws Exception {
    Iterable<Integer> ssl = Sequence.<Integer>singleton(42);
    Assert.assertSame(1, Sequence.fromIterable(ssl).count());
    Assert.assertSame(42, Sequence.fromIterable(ssl).first());
  }

  public void test__toString() throws Exception {
    final Wrappers._int count = new Wrappers._int(1);
    Iterable<String> test = Sequence.fromClosure(new ISequenceClosure<String>() {
      public Iterable<String> iterable() {
        return new Iterable<String>() {
          public Iterator<String> iterator() {
            return new YieldingIterator<String>() {
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
                      switch (count.value++) {
                        case 3:
                          this.__CP__ = 3;
                          break __switch__;
                        case 2:
                          this.__CP__ = 4;
                          break __switch__;
                        case 1:
                          this.__CP__ = 6;
                          break __switch__;
                        default:
                          this.__CP__ = 10;
                          break __switch__;
                      }
                    case 5:
                      this.__CP__ = 4;
                      this.yield("duh");
                      return true;
                    case 7:
                      this.__CP__ = 6;
                      this.yield("foo");
                      return true;
                    case 9:
                      this.__CP__ = 8;
                      this.yield("bar");
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 10:
                      this.__CP__ = 1;
                      break;
                    case 3:
                      this.__CP__ = 5;
                      break;
                    case 4:
                      this.__CP__ = 7;
                      break;
                    case 6:
                      this.__CP__ = 9;
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
    Assert.assertEquals("[bar]", String.valueOf(test));
    Assert.assertEquals("[foo, bar]", String.valueOf(test));
    Assert.assertEquals("[duh, foo, bar]", String.valueOf(test));
  }

  public void test_asSequence() throws Exception {
    String[] arr = new String[]{"A","B","C"};
    this.assertIterableEquals(this.inputABC(), Sequence.fromArray(arr));
  }

  public void test_asSequencePrim() throws Exception {
    int[] iarr = new int[]{1,2,3,4,5};
    this.assertIterableEquals(this.input5(), ArrayUtils.fromIntegerArray(iarr));
  }

  public void test_containsAll() throws Exception {
    Iterable<Integer> seq = ArrayUtils.fromIntegerArray(new int[]{2,4,3,1,5});
    Assert.assertFalse(Sequence.fromIterable(seq).containsSequence(Sequence.fromIterable(this.input10())));
    Assert.assertTrue(Sequence.fromIterable(seq).containsSequence(Sequence.fromIterable(this.input5())));
    Iterable<Integer> seq2 = ArrayUtils.fromIntegerArray(new int[]{5,3,5,1,1,4,2,1});
    Assert.assertTrue(Sequence.fromIterable(seq2).containsSequence(Sequence.fromIterable(seq)));
    Assert.assertFalse(Sequence.fromIterable(seq).containsSequence(Sequence.fromIterable(seq2)));
  }

  public void test_join() throws Exception {
    Iterable<String> test = ListSequence.fromListAndArray(new ArrayList<String>(), "vodka", "tequila", "whisky");
    Assert.assertEquals("vodka tequila whisky", IterableUtils.join(Sequence.fromIterable(test), " "));
    Assert.assertEquals("vodka, tequila, whisky", IterableUtils.join(Sequence.fromIterable(test), ", "));
  }

  public void test_test_MPS6197() throws Exception {
    this.assertIterableEquals(ArrayUtils.fromIntegerArray(new int[]{2}), this.abc(0));
    this.assertIterableEquals(ArrayUtils.fromIntegerArray(new int[]{3}), this.abc(1));
  }

  public void test_sequenceTypeWithoutElement() throws Exception {
    Iterable<Integer> si = Sequence.fromClosure(new ISequenceClosure<Integer>() {
      public Iterable<Integer> iterable() {
        return new Iterable<Integer>() {
          public Iterator<Integer> iterator() {
            return new YieldingIterator<Integer>() {
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
                      this.__CP__ = 5;
                      this.yield(3);
                      return true;
                    case 5:
                      this.__CP__ = 6;
                      this.yield(4);
                      return true;
                    case 6:
                      this.__CP__ = 1;
                      this.yield(5);
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
    Iterable is = si;
    this.assertIterableEquals(this.input5(), is);
  }

  public Iterable<Integer> abc(final int j) {
    return Sequence.fromClosure(new ISequenceClosure<Integer>() {
      public Iterable<Integer> iterable() {
        return new Iterable<Integer>() {
          public Iterator<Integer> iterator() {
            return new YieldingIterator<Integer>() {
              private int __CP__ = 0;
              private int _3_i;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 4:
                      if (j == 0) {
                        this.__CP__ = 5;
                        break;
                      }
                      this.__CP__ = 8;
                      break;
                    case 6:
                      this.__CP__ = 1;
                      this.yield(_3_i);
                      return true;
                    case 0:
                      this.__CP__ = 4;
                      break;
                    case 5:
                      _3_i = 2;
                      this.__CP__ = 6;
                      break;
                    case 8:
                      _3_i = 3;
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
  }
}
