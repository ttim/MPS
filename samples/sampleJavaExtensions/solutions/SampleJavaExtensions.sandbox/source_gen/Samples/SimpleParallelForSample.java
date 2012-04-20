package Samples;

/*Generated by MPS */

import java.util.concurrent.CountDownLatch;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Collections;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import utils.ParallelLoopException;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;

public class SimpleParallelForSample {
  public SimpleParallelForSample() {
  }

  public static void main(String[] args) {

    final Iterable<Integer> numbers = SimpleParallelForSample.createNumbers();
    final String value = null;

    {
      final CountDownLatch latch = new CountDownLatch(Sequence.fromIterable(numbers).count());
      final List<Exception> exceptions = new CopyOnWriteArrayList<Exception>();

      for (final int a : Collections.unmodifiableList(ListSequence.fromListWithValues(new ArrayList<Integer>(), numbers))) {

        final int localA = a;

        Runnable runnable = new Runnable() {
          public void run() {
            try {
              log("Current value: " + localA);
              sleep(localA);
              value.length();
              log("Done with " + localA);
            } catch (RuntimeException e) {
              ListSequence.fromList(exceptions).addElement(e);
            } finally {
              latch.countDown();
            }
          }
        };

        new Thread(runnable).start();

      }
      try {
        latch.await();
      } catch (InterruptedException e) {
        ListSequence.fromList(exceptions).addElement(e);
      }
      if (ListSequence.fromList(exceptions).isNotEmpty()) {
        throw new ParallelLoopException("Some parallel calculations failed", exceptions);
      }

    }
  }

  private static Iterable<Integer> createNumbers() {
    return Sequence.fromClosure(new ISequenceClosure<Integer>() {
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
                } while (true);
                return false;
              }
            };
          }
        };
      }
    });
  }

  private static void sleep(long milis) {
    try {
      Thread.sleep(milis * 1000);
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
  }

  private static void log(String msg) {
    System.out.println(msg);
  }
}
