package jetbrains.mps.closures.test;

/*Generated by MPS */

import junit.framework.TestCase;
import jetbrains.mps.baseLanguage.closures.util.Constants;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import junit.framework.Assert;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.baseLanguage.closures.runtime._UnrestrictedFunctionTypes;
import jetbrains.mps.baseLanguage.closures.runtime.Result;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import jetbrains.mps.internal.collections.runtime.ITranslator2;

public class ClassifierAdapters_Test extends TestCase {
  public void test_interfaceAsFunctionType() throws Exception {
    Worker wrk = new Worker() {
      public String doWork(Integer d) {
        return "Done: " + Integer.valueOf(d);
      }
    };
    if (!(Constants.ONLY_CLOSURE_LITERAL_AS_FUNCTION_TYPE)) {
      assert false : "Fix the test";
      /*
        _FunctionTypes._return_P1_E0<? extends String, ? super Integer> ft = wrk;
        int res = 1234;
        Assert.assertEquals("Done: 1234", ft.invoke(res));
      */
    }
  }

  public void test_functionTypeAsInterface() throws Exception {
    _FunctionTypes._return_P1_E0<? extends String, ? super Integer> cls = new _FunctionTypes._return_P1_E0<String, Integer>() {
      public String invoke(Integer foo) {
        return "Done: " + foo;
      }
    };
    if (!(Constants.ONLY_CLOSURE_LITERAL_AS_FUNCTION_TYPE)) {
      assert false : "Fix the test";
      /*
        Worker wrk = cls;
        Assert.assertEquals("Done: 4321", wrk.doWork(4321));
      */
    }
  }

  public void test_closureLiteralAsInterface() throws Exception {
    Worker wrk = new Worker() {
      public String doWork(Integer foo) {
        return "Done: " + foo;
      }
    };
    Assert.assertEquals("Done: 4321", wrk.doWork(4321));
  }

  public void test_yieldClosureLiteralAsInterface() throws Exception {
    NumberGenerator ng = new NumberGenerator() {
      public Iterable<Integer> generate() {
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
                } while (true);
                return false;
              }
            };
          }
        };
      }
    };
    Integer[] exp = new Integer[]{1, 2, 3};
    int i = 0;
    for (Integer in : ng.generate()) {
      Assert.assertEquals(exp[i], in);
      i++;
    }
  }

  public void test_genericInterfaceAdapter() throws Exception {
    Generator<Integer> g = new Generator<Integer>() {
      public Iterable<Integer> generate() {
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
                } while (true);
                return false;
              }
            };
          }
        };
      }
    };
    Integer exp = 1;
    for (Integer i : g.generate()) {
      Assert.assertEquals(exp, i);
      exp++;
    }
    Assert.assertEquals(exp, (Integer) 4);
  }

  public void test_instanceMethodCall() throws Exception {
    Assert.assertEquals("1234", this.makeWork(new Worker() {
      public String doWork(Integer i) {
        return String.valueOf(i);
      }
    }, 1234));
    Assert.assertEquals("4321", this.makeWork(new Worker() {
      public String doWork(Integer i) {
        return String.valueOf(i);
      }
    }, 4321));
  }

  public void test_exceptions() throws Exception {
    try {
      this.process(new Processor() {
        public int process(String instr) throws ProcessingException {
          if (Integer.parseInt(instr) < 0) {
            throw new ProcessingException();
          }
          return 1;
        }
      }, "-1");
      Assert.fail();
    } catch (ProcessingException e) {
      // expected exception 
    }
  }

  public void test_closureLiteralAsComparator() throws Exception {
    List<Integer> list = ListSequence.<Integer>fromList(new ArrayList<Integer>());
    ListSequence.<Integer>fromList(list).addSequence(ListSequence.<Integer>fromList(Arrays.asList(new Integer[]{4, 3, 5, 1, 2})));
    // =================================================================== 
    // The following is a hack! 
    // In reality we could only substitute an interface that has a single method. 
    // This example works only because java.util.Comparator defines compare() before equals() 
    // Why declare equals() in an interface escapes me: it's already there and declaring it in an interface doesn't change anything 
    // Besides, overriding only equals() without overriding also hashCode() is simply plain wrong. 
    // =================================================================== 
    Collections.sort(list, new Comparator<Object>() {
      public int compare(Object a, Object b) {
        return a.hashCode() - b.hashCode();
      }
    });
    Assert.assertEquals(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}), list);
  }

  public void test_closureLiteralAsParameterToConstructor() throws Exception {
    final Wrappers._int foo = new Wrappers._int(-1);
    Thread trd = new Thread(new Runnable() {
      public void run() {
        foo.value = 42;
      }
    });
    trd.start();
    try {
      trd.join();
    } finally {
      Assert.assertEquals(42, foo.value);
    }
  }

  public void test_closureLiteralAsParameterToAnonymousClass() throws Exception {
    final Wrappers._int foo = new Wrappers._int(-1);
    Thread trd = new Thread(new Runnable() {
      public void run() {
        foo.value = 42;
      }
    });
    trd.start();
    try {
      trd.join();
    } finally {
      Assert.assertEquals(42, foo.value);
    }
  }

  public void test_wrongParametersNumber() throws Exception {
    this.acceptWorker(new Worker() {
      public String doWork(Integer i) {
        return String.valueOf(i);
      }
    });
  }

  public void test__returnWorker() throws Exception {
    Worker wrk = this.returnWorker();
  }

  public void test__returnProcessor() throws Exception {
    Processor prc = this.returnProcessor();
    try {
      prc.process("foobar");
      Assert.fail();
    } catch (ProcessingException e) {
      // expected exception 
    }
  }

  public void test_mps5315() throws Exception {
    /*
      _FunctionTypes._void_P2_E0<? super Integer, ? super String> cls = new _FunctionTypes._void_P2_E0<Integer, String>() {
        public void invoke(Integer foo, String bar) {
        }
      };
      cls.invoke();
    */
  }

  public void test_mps5316() throws Exception {
    /*
      this.acceptWorker();
    */
  }

  public void test_compactInvoke() throws Exception {
    final Wrappers._int count = new Wrappers._int(0);
    _FunctionTypes._return_P0_E0<? extends Integer> cl = new _FunctionTypes._return_P0_E0<Integer>() {
      public Integer invoke() {
        return count.value++;
      }
    };
    cl.invoke();
    Assert.assertSame(1, count.value);
    new _FunctionTypes._return_P0_E0<Integer>() {
      public Integer invoke() {
        return count.value++;
      }
    }.invoke();
    Assert.assertSame(2, count.value);
    _UnrestrictedFunctionTypes._return_terminate_P0_E0<? extends Integer, ? extends Integer> ucl = new _UnrestrictedFunctionTypes._return_terminate_P0_E0<Integer, Integer>() {
      public Result<Integer, Integer> invokeUnrestricted() {
        return Result.TERMINATE(count.value++);
      }
    };
    {
      Result<? extends Integer, ?> __result__ = ucl.invokeUnrestricted();
      switch (__result__.getOutcome()) {
        case RETURN_VALUE:
          //  fall through 
        case RETURN_VOID:
          return;
        case BREAK:
          break;
        case TERMINATE_VALUE:
          break;
        default:
          break;
      }
    }
    Assert.assertSame(3, count.value);
    {
      Result<? extends Integer, ?> __result__ = new _UnrestrictedFunctionTypes._return_terminate_P0_E0<Integer, Integer>() {
        public Result<Integer, Integer> invokeUnrestricted() {
          return Result.TERMINATE(count.value++);
        }
      }.invokeUnrestricted();
      switch (__result__.getOutcome()) {
        case RETURN_VALUE:
          //  fall through 
        case RETURN_VOID:
          return;
        case BREAK:
          break;
        case TERMINATE_VALUE:
          break;
        default:
          break;
      }
    }
    Assert.assertSame(4, count.value);
    // testing compilation 
    new _FunctionTypes._return_P0_E0<Object>() {
      public Object invoke() {
        return null;
      }
    }.invoke();
    new _FunctionTypes._return_P0_E0<Object>() {
      public Object invoke() {
        return null;
      }
    }.invoke();
    new _FunctionTypes._return_P0_E0<Iterable<Object>>() {
      public Iterable<Object> invoke() {
        return new Iterable<Object>() {
          public Iterator<Object> iterator() {
            return new YieldingIterator<Object>() {
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
                      this.yield(null);
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
    }.invoke();
  }

  public void test_mps7619() throws Exception {
    IFilter flt = this.filter();
    Assert.assertFalse(flt.filter(null));
  }

  public void test_translate() throws Exception {
    Iterable<_FunctionTypes._return_P0_E0<? extends String>> seq = Sequence.<_FunctionTypes._return_P0_E0<? extends String>>fromClosure(new ISequenceClosure<_FunctionTypes._return_P0_E0<? extends String>>() {
      public Iterable<_FunctionTypes._return_P0_E0<? extends String>> iterable() {
        return new Iterable<_FunctionTypes._return_P0_E0<? extends String>>() {
          public Iterator<_FunctionTypes._return_P0_E0<? extends String>> iterator() {
            return new YieldingIterator<_FunctionTypes._return_P0_E0<? extends String>>() {
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
                      this.yield(new _FunctionTypes._return_P0_E0<String>() {
                        public String invoke() {
                          return "ABC";
                        }
                      });
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
    Iterable<String> res = Sequence.<_FunctionTypes._return_P0_E0<? extends String>>fromIterable(seq).<String>translate(new ITranslator2<_FunctionTypes._return_P0_E0<? extends String>, String>() {
      public Iterable<String> translate(_FunctionTypes._return_P0_E0<? extends String> s) {
        return Sequence.<String>singleton(s.invoke());
      }
    });
    Assert.assertSame(1, Sequence.<String>fromIterable(res).count());
    Assert.assertEquals("ABC", Sequence.<String>fromIterable(res).first());
  }

  public void test_mps9190() throws Exception {
    try {
      this.acceptFunction(new _FunctionTypes._return_P1_E0<Object, String>() {
        public Object invoke(String s) {
          if (s.length() == 3) {
            throw new RuntimeException();
          }
          return null;
        }
      });
      Assert.fail();
    } catch (RuntimeException e) {
      // expected exception 
    }
  }

  public void acceptWorker(Worker one, Worker two) {
  }

  public void acceptWorker(Worker one) {
  }

  public String makeWork(Worker wrk, Integer i) {
    return wrk.doWork(i);
  }

  public int process(Processor prc, String instr) throws ProcessingException {
    return prc.process(instr);
  }

  public Worker returnWorker() {
    return new Worker() {
      public String doWork(Integer i) {
        return String.valueOf(i);
      }
    };
  }

  public Processor returnProcessor() {
    return new Processor() {
      public int process(String str) throws ProcessingException {
        throw new ProcessingException(str);
      }
    };
  }

  public IFilter filter() {
    return new IFilter() {
      public boolean filter(String name) {
        return false;
      }
    };
  }

  public Object acceptFunction(_FunctionTypes._return_P1_E0<? extends Object, ? super String> fff) {
    return fff.invoke("foo");
  }
}
