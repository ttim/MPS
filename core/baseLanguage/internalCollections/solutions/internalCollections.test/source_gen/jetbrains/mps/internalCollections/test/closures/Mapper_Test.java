package jetbrains.mps.internalCollections.test.closures;

/*Generated by MPS */

import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IMapper;
import jetbrains.mps.internal.collections.runtime.SequenceIterableAdapter;
import java.util.Iterator;
import jetbrains.mps.closures.runtime.YieldingIterator;
import java.util.Arrays;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class Mapper_Test extends Util_Test {

  public void test_mapMethod() throws Exception {
    Sequence<Integer> seq = Sequence.fromIterable(this.input5());
    Sequence<Integer> test = seq.map(new IMapper <Integer, Integer>() {

      public Sequence<Integer> map(final Integer it1) {
        return new SequenceIterableAdapter <Integer>() {

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
                      this.yield(it1);
                      return true;
                    case 3:
                      this.__CP__ = 1;
                      this.yield(it1 * 2);
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
    Iterable<Integer> expected = Arrays.asList(1, 2, 2, 4, 3, 6, 4, 8, 5, 10);
    this.assertIterableEquals(expected, test.toIterable());
  }

  public void test_mapperVar() throws Exception {
    Sequence<Integer> seq = Sequence.fromIterable(this.input5());
    IMapper<Integer, Integer> mapper = new IMapper <Integer, Integer>() {

      public Sequence<Integer> map(final Integer i) {
        return new SequenceIterableAdapter <Integer>() {

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
                      this.yield(i);
                      return true;
                    case 3:
                      this.__CP__ = 1;
                      this.yield(i * 2);
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

    };
    Iterable<Integer> expected = Arrays.asList(1, 2, 2, 4, 3, 6, 4, 8, 5, 10);
    this.assertIterableEquals(expected, seq.map(mapper).toIterable());
    this.assertIterableEquals(expected, seq.map(mapper).toIterable());
  }

  public void test_mappingOperation() throws Exception {
    Iterable<Integer> test = Sequence.fromIterable(this.input5()).map(new IMapper <Integer, Integer>() {

      public Sequence<Integer> map(final Integer i) {
        return new SequenceIterableAdapter <Integer>() {

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
                      this.yield(i);
                      return true;
                    case 3:
                      this.__CP__ = 1;
                      this.yield(i * 2);
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
    this.assertIterableEquals(Arrays.asList(1, 2, 2, 4, 3, 6, 4, 8, 5, 10), test);
  }

  public void test_weirdness() throws Exception {
    Iterable<Integer> input = Arrays.asList(1, 12, 3, 14, 5);
    /*
      Object output = Sequence.fromIterable(input).map(new IMapper <Integer, String>() {

        public Sequence<String> map(final Integer it2) {
          return new SequenceIterableAdapter <String>() {

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
                        this.__CP__ = 1;
                        this.yield(String.valueOf(it2));
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

      }).where(new IWhereFilter <String>() {

        public boolean accept(String it3) {
          return false;
        }

      });
      Sequence output2 = Sequence.fromIterable(input).map(new IMapper <Integer, String>() {

        public Sequence<String> map(final Integer it2) {
          return new SequenceIterableAdapter <String>() {

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
                        this.__CP__ = 1;
                        this.yield(String.valueOf(it2));
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

      }).where(new IWhereFilter <String>() {

        public boolean accept(String it3) {
          return false;
        }

      });
      Sequence<?> output3 = Sequence.fromIterable(input).map(new IMapper <Integer, String>() {

        public Sequence<String> map(final Integer it2) {
          return new SequenceIterableAdapter <String>() {

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
                        this.__CP__ = 1;
                        this.yield(String.valueOf(it2));
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

      }).where(new IWhereFilter <String>() {

        public boolean accept(String it3) {
          return false;
        }

      });
      Sequence.fromIterable(input).map(new IMapper <Integer, String>() {

        public Sequence<String> map(final Integer it2) {
          return new SequenceIterableAdapter <String>() {

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
                        this.__CP__ = 1;
                        this.yield(String.valueOf(it2));
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

      }).where(new IWhereFilter <String>() {

        public boolean accept(String it3) {
          return false;
        }

      });
    */
  }

}
