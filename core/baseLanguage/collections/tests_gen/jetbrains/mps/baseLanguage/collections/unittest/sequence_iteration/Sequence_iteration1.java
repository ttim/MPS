package jetbrains.mps.baseLanguage.collections.unittest.sequence_iteration;

/*Generated by MPS */

import junit.framework.TestCase;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import junit.framework.Assert;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;

public class Sequence_iteration1 extends TestCase {

  public void test_shortSequence1() {
    // sequence with no memory
    Iterable<String> ss = Sequence.fromClosure(new ISequenceClosure <String>() {

      public Iterable<String> iterable() {
        return new Iterable <String>() {

          public Iterator<String> iterator() {
            return new YieldingIterator <String>() {

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
                      this.yield("0");
                      return true;
                    case 3:
                      this.__CP__ = 4;
                      this.yield("1");
                      return true;
                    case 4:
                      this.__CP__ = 5;
                      this.yield("2");
                      return true;
                    case 5:
                      this.__CP__ = 6;
                      this.yield("3");
                      return true;
                    case 6:
                      this.__CP__ = 1;
                      this.yield("4");
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
    int count = 0;
    for(String s : Sequence.fromIterable(ss)) {
      Assert.assertEquals("" + count, s);
      count = count + 1;
    }
    Assert.assertEquals(count, 5);
    for(String s : Sequence.fromIterable(ss)) {
      Assert.assertEquals("" + (count - 5), s);
      count = count + 1;
    }
    Assert.assertEquals(count, 10);
  }

  public void test_shortSequence2() {
    // sequence with memory
    final Wrappers._int yield_count = new Wrappers._int(0);
    Iterable<String> ss = Sequence.fromClosure(new ISequenceClosure <String>() {

      public Iterable<String> iterable() {
        return new Iterable <String>() {

          public Iterator<String> iterator() {
            return new YieldingIterator <String>() {

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
                      this._2_i = 0;
                    case 3:
                      if (!(this._2_i < 5)) {
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
                      this.__CP__ = 7;
                      this.yield("" + yield_count.value);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 4:
                      this.__CP__ = 6;
                      break;
                    case 7:
                      yield_count.value = yield_count.value + 1;
                      this.__CP__ = 5;
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
    int count = 0;
    for(String s : Sequence.fromIterable(ss)) {
      Assert.assertEquals("" + count, s);
      count = count + 1;
    }
    Assert.assertEquals(count, 5);
    Assert.assertEquals(yield_count.value, 5);
    for(String s : Sequence.fromIterable(ss)) {
      Assert.assertEquals("" + count, s);
      count = count + 1;
    }
    Assert.assertEquals(count, 10);
    Assert.assertEquals(yield_count.value, 10);
  }

  public void test_longSequence1() {
    // sequence with no memory
    final int sequence_size = 1234;
    Iterable<String> ss = Sequence.fromClosure(new ISequenceClosure <String>() {

      public Iterable<String> iterable() {
        return new Iterable <String>() {

          public Iterator<String> iterator() {
            return new YieldingIterator <String>() {

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
                      this._2_i = 0;
                    case 3:
                      if (!(this._2_i < sequence_size)) {
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
                      this.yield("" + this._2_i);
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
    int count = 0;
    for(String s : Sequence.fromIterable(ss)) {
      Assert.assertEquals("" + count, s);
      count = count + 1;
    }
    Assert.assertEquals(count, sequence_size);
    for(String s : Sequence.fromIterable(ss)) {
      Assert.assertEquals("" + (count - sequence_size), s);
      count = count + 1;
    }
    Assert.assertEquals(count, sequence_size * 2);
  }

  public void test_longSequence2() {
    // sequence with memory
    final int sequence_size = 1234;
    final Wrappers._int yield_count = new Wrappers._int(0);
    Iterable<String> ss = Sequence.fromClosure(new ISequenceClosure <String>() {

      public Iterable<String> iterable() {
        return new Iterable <String>() {

          public Iterator<String> iterator() {
            return new YieldingIterator <String>() {

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
                      this._2_i = 0;
                    case 3:
                      if (!(this._2_i < sequence_size)) {
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
                      this.__CP__ = 7;
                      this.yield("" + yield_count.value);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 4:
                      this.__CP__ = 6;
                      break;
                    case 7:
                      yield_count.value = yield_count.value + 1;
                      this.__CP__ = 5;
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
    int count = 0;
    for(String s : Sequence.fromIterable(ss)) {
      Assert.assertEquals("" + count, s);
      count = count + 1;
    }
    Assert.assertEquals(count, sequence_size);
    Assert.assertEquals(yield_count.value, sequence_size);
    for(String s : Sequence.fromIterable(ss)) {
      Assert.assertEquals("" + count, s);
      count = count + 1;
    }
    Assert.assertEquals(count, sequence_size * 2);
    Assert.assertEquals(yield_count.value, sequence_size * 2);
  }

}
