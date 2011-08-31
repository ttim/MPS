package treepathFeatures;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.List;
import jetbrains.mps.ypath.runtime.TreeTraversalFactory;

public class SnodeDemo {
  public static void main(String[] args) {
    final SNode foo = null;
    ListSequence.<SNode>fromList((SLinkOperations.getTargets(foo, "implements", true))).<SNode>translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(final SNode it) {
        return new Iterable<SNode>() {
          public Iterator<SNode> iterator() {
            return new YieldingIterator<SNode>() {
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
                      this.yield(SLinkOperations.getTarget(it, "intfc", false));
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
    }).<SNode>translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(final SNode it) {
        return new Iterable<SNode>() {
          public Iterator<SNode> iterator() {
            return new YieldingIterator<SNode>() {
              private int __CP__ = 0;
              private SNode _2__zzz_;
              private Iterator<SNode> _2__zzz__it;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      this._2__zzz__it = ListSequence.<SNode>fromList(SLinkOperations.getTargets(it, "extends", true)).iterator();
                    case 3:
                      if (!(this._2__zzz__it.hasNext())) {
                        this.__CP__ = 1;
                        break;
                      }
                      this._2__zzz_ = this._2__zzz__it.next();
                      this.__CP__ = 4;
                      break;
                    case 5:
                      this.__CP__ = 3;
                      this.yield(_2__zzz_);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 4:
                      this.__CP__ = 5;
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
    // The following ypath construct should result in the same expression as above 
    Sequence.<SNode>fromIterable(Sequence.<SNode>fromClosure(new ISequenceClosure<SNode>() {
      public Iterable<SNode> iterable() {
        SNode _zzz_ = foo;
        return SLinkOperations.getTargets(_zzz_, "implements", true);
      }
    })).<SNode>translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(final SNode it) {
        return new Iterable<SNode>() {
          public Iterator<SNode> iterator() {
            return new YieldingIterator<SNode>() {
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
                      this.yield(SLinkOperations.getTarget(it, "intfc", false));
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
    }).<SNode>translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(final SNode it) {
        return new Iterable<SNode>() {
          public Iterator<SNode> iterator() {
            return new YieldingIterator<SNode>() {
              private int __CP__ = 0;
              private SNode _2__yyy_;
              private Iterator<SNode> _2__yyy__it;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      this._2__yyy__it = ListSequence.<SNode>fromList(SLinkOperations.getTargets(it, "extends", true)).iterator();
                    case 3:
                      if (!(this._2__yyy__it.hasNext())) {
                        this.__CP__ = 1;
                        break;
                      }
                      this._2__yyy_ = this._2__yyy__it.next();
                      this.__CP__ = 4;
                      break;
                    case 5:
                      this.__CP__ = 3;
                      this.yield(_2__yyy_);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 4:
                      this.__CP__ = 5;
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
    // Another pair of tests 
    ListSequence.<SNode>fromList(ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SLinkOperations.getTarget(foo, "extends", false))).<SNode>translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(final SNode it) {
        return new Iterable<SNode>() {
          public Iterator<SNode> iterator() {
            return new YieldingIterator<SNode>() {
              private int __CP__ = 0;
              private SNode _2_p;
              private Iterator<SNode> _2_p_it;
              private SNode _5_c;
              private Iterator<SNode> _5_c_it;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      this._2_p_it = ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SNodeOperations.getParent(it)).iterator();
                    case 3:
                      if (!(this._2_p_it.hasNext())) {
                        this.__CP__ = 1;
                        break;
                      }
                      this._2_p = this._2_p_it.next();
                      this.__CP__ = 4;
                      break;
                    case 5:
                      this._5_c_it = ListSequence.<SNode>fromList(SNodeOperations.getChildren(_2_p)).iterator();
                    case 6:
                      if (!(this._5_c_it.hasNext())) {
                        this.__CP__ = 3;
                        break;
                      }
                      this._5_c = this._5_c_it.next();
                      this.__CP__ = 7;
                      break;
                    case 8:
                      if (it == _5_c) {
                        this.__CP__ = 9;
                        break;
                      }
                      this.__CP__ = 10;
                      break;
                    case 10:
                      this.__CP__ = 6;
                      this.yield(_5_c);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 4:
                      this.__CP__ = 5;
                      break;
                    case 7:
                      this.__CP__ = 8;
                      break;
                    case 9:
                      this.__CP__ = 1;
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
    ListSequence.<SNode>fromList(ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SLinkOperations.getTarget(foo, "extends", false))).<SNode>translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(final SNode it) {
        return new Iterable<SNode>() {
          public Iterator<SNode> iterator() {
            return new YieldingIterator<SNode>() {
              private int __CP__ = 0;
              private SNode _5__yyy_;
              private Iterator<SNode> _5__yyy__it;
              private SNode _2__zzz_;
              private Iterator<SNode> _2__zzz__it;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      this._2__zzz__it = ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SNodeOperations.getParent(it)).iterator();
                    case 3:
                      if (!(this._2__zzz__it.hasNext())) {
                        this.__CP__ = 1;
                        break;
                      }
                      this._2__zzz_ = this._2__zzz__it.next();
                      this.__CP__ = 4;
                      break;
                    case 5:
                      this._5__yyy__it = SNodeOperations.getChildren(_2__zzz_).iterator();
                    case 6:
                      if (!(this._5__yyy__it.hasNext())) {
                        this.__CP__ = 3;
                        break;
                      }
                      this._5__yyy_ = this._5__yyy__it.next();
                      this.__CP__ = 7;
                      break;
                    case 8:
                      if (it == _5__yyy_) {
                        this.__CP__ = 9;
                        break;
                      }
                      this.__CP__ = 10;
                      break;
                    case 10:
                      this.__CP__ = 6;
                      this.yield(_5__yyy_);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 4:
                      this.__CP__ = 5;
                      break;
                    case 7:
                      this.__CP__ = 8;
                      break;
                    case 9:
                      this.__CP__ = 1;
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
    // And another one 
    /*
      //  way too complicated 
      ListSequence.<SNode>fromList(ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), foo)).<SNode>translate(new ITranslator2<SNode, SNode>() {
        public Iterable<SNode> translate(SNode it) {
          return new _FunctionTypes._return_P1_E0<Iterable<SNode>, SNode>() {
            public Iterable<SNode> invoke(final SNode _zzz_) {
              return new Iterable<SNode>() {
                public Iterator<SNode> iterator() {
                  return new YieldingIterator<SNode>() {
                    private int __CP__ = 0;
                    private SNode _2__yyy_;
                    private Iterator<SNode> _2__yyy__it;

                    protected boolean moveToNext() {
__loop__:
                      do {
__switch__:
                        switch (this.__CP__) {
                          case -1:
                            assert false : "Internal error";
                            return false;
                          case 2:
                            this._2__yyy__it = ListSequence.<SNode>fromList(SNodeOperations.getChildren(_zzz_)).iterator();
                          case 3:
                            if (!(this._2__yyy__it.hasNext())) {
                              this.__CP__ = 1;
                              break;
                            }
                            this._2__yyy_ = this._2__yyy__it.next();
                            this.__CP__ = 4;
                            break;
                          case 5:
                            this.__CP__ = 6;
                            this.yield(_2__yyy_);
                            return true;
                          case 0:
                            this.__CP__ = 2;
                            break;
                          case 4:
                            this.__CP__ = 5;
                            break;
                          case 6:
                            invoke(_2__yyy_);
                            this.__CP__ = 3;
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
          }.invoke(it);
        }
      });
    */
    Sequence.<SNode>fromClosure(new ISequenceClosure<SNode>() {
      public Iterable<SNode> iterable() {
        return new Iterable<SNode>() {
          public Iterator<SNode> iterator() {
            return new YieldingIterator<SNode>() {
              private int __CP__ = 0;
              private SNode _3__zzz_;
              private List<SNode> _5__yyy_;
              private SNode _9__xxx_;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 6:
                      if (ListSequence.<SNode>fromList(_5__yyy_).isNotEmpty()) {
                        this.__CP__ = 7;
                        break;
                      }
                      this.__CP__ = 1;
                      break;
                    case 10:
                      this.__CP__ = 11;
                      this.yield(_9__xxx_);
                      return true;
                    case 0:
                      this._3__zzz_ = foo;
                      this.__CP__ = 1;
                      break;
                    case 3:
                      this._5__yyy_ = ListSequence.<SNode>fromList(new ArrayList<SNode>());
                      ListSequence.<SNode>fromList(_5__yyy_).addSequence(ListSequence.<SNode>fromList(SNodeOperations.getChildren(_3__zzz_)));
                      this.__CP__ = 6;
                      break;
                    case 7:
                      this._9__xxx_ = ListSequence.<SNode>fromList(_5__yyy_).first();
                      ListSequence.<SNode>fromList(_5__yyy_).removeElement(_9__xxx_);
                      this.__CP__ = 10;
                      break;
                    case 11:
                      ListSequence.<SNode>fromList(_5__yyy_).addSequence(ListSequence.<SNode>fromList(SNodeOperations.getChildren(_9__xxx_)));
                      this.__CP__ = 6;
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
    // Following is just a test 
    Sequence.<SNode>fromIterable(Sequence.<SNode>fromClosure(new ISequenceClosure<SNode>() {
      public Iterable<SNode> iterable() {
        SNode _zzz_ = foo;
        return SLinkOperations.getTargets(_zzz_, "implements", true);
      }
    })).<SNode>translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(final SNode it) {
        return new Iterable<SNode>() {
          public Iterator<SNode> iterator() {
            return new YieldingIterator<SNode>() {
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
                      this.yield(SLinkOperations.getTarget(it, "intfc", false));
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
    TreeTraversalFactory.Traverse(new SNODE().startTraversal(foo), TreeTraversalFactory.Axis("CHILDREN"), SNODE.child("implements"));
    TreeTraversalFactory.Traverse(new SNODE().startTraversal(foo), TreeTraversalFactory.Axis("ANCESTORS"));
    Sequence.<SNode>fromClosure(new ISequenceClosure<SNode>() {
      public Iterable<SNode> iterable() {
        return new Iterable<SNode>() {
          public Iterator<SNode> iterator() {
            return new YieldingIterator<SNode>() {
              private int __CP__ = 0;
              private SNode _3__zzz_;
              private List<SNode> _7__yyy_;
              private SNode _11__xxx_;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 8:
                      if (ListSequence.<SNode>fromList(_7__yyy_).isNotEmpty()) {
                        this.__CP__ = 9;
                        break;
                      }
                      this.__CP__ = 1;
                      break;
                    case 4:
                      this.__CP__ = 5;
                      this.yield(_3__zzz_);
                      return true;
                    case 12:
                      this.__CP__ = 13;
                      this.yield(_11__xxx_);
                      return true;
                    case 0:
                      this._3__zzz_ = foo;
                      this.__CP__ = 4;
                      break;
                    case 5:
                      this._7__yyy_ = ListSequence.<SNode>fromList(new ArrayList<SNode>());
                      ListSequence.<SNode>fromList(_7__yyy_).addSequence(ListSequence.<SNode>fromList(SNodeOperations.getChildren(_3__zzz_)));
                      this.__CP__ = 8;
                      break;
                    case 9:
                      this._11__xxx_ = ListSequence.<SNode>fromList(_7__yyy_).first();
                      ListSequence.<SNode>fromList(_7__yyy_).removeElement(_11__xxx_);
                      this.__CP__ = 12;
                      break;
                    case 13:
                      ListSequence.<SNode>fromList(_7__yyy_).addSequence(ListSequence.<SNode>fromList(SNodeOperations.getChildren(_11__xxx_)));
                      this.__CP__ = 8;
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
    TreeTraversalFactory.Traverse(new SNODE().startTraversal(foo), TreeTraversalFactory.Axis("SELF_FOLLOWING_SIBLINGS"));
    TreeTraversalFactory.Traverse(new SNODE().startTraversal(foo), TreeTraversalFactory.Axis("CHILDREN"));
    TreeTraversalFactory.Traverse(new SNODE().startTraversal(foo), TreeTraversalFactory.Axis("CHILDREN"));
    Sequence.<SNode>fromClosure(new ISequenceClosure<SNode>() {
      public Iterable<SNode> iterable() {
        SNode _zzz_ = foo;
        return SNodeOperations.getChildren(_zzz_);
      }
    });
    // !@#$& 
  }
}
