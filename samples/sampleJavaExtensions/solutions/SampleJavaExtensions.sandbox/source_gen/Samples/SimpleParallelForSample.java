package Samples;

/*Generated by MPS */

import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import utils.ParallelLoopException;

public class SimpleParallelForSample {
  public SimpleParallelForSample() {
  }

  public static void main(String[] args) {

    final Iterable<Integer> numbers = ListSequence.fromListAndArray(new ArrayList<Integer>(), 1, 2, 3, 4, 5);
    final String value = "Set to null and see that potential NPE is correctly detected inside the loop";

    {
      final CountDownLatch latch_e0a = new CountDownLatch(Sequence.fromIterable(numbers).count());
      final List<Exception> exceptions_e0a = new CopyOnWriteArrayList<Exception>();

      for (final int a : numbers) {

        final int localA = a;

        final Runnable runnable = new Runnable() {
          public void run() {
            try {
              SimpleParallelForSample.Logger.log("Current value: " + localA);

              // Notice there's no need to declare the InterruptedException on the main method 
              Thread.sleep(1000);
              value.length();
              SimpleParallelForSample.Logger.log("Done with " + localA);
            } catch (RuntimeException e) {
              ListSequence.fromList(exceptions_e0a).addElement(e);
            } catch (InterruptedException e) {
              ListSequence.fromList(exceptions_e0a).addElement(e);
            } finally {
              latch_e0a.countDown();
            }
          }
        };

        new Thread(runnable).start();

      }
      try {
        latch_e0a.await();
      } catch (InterruptedException e) {
        ListSequence.fromList(exceptions_e0a).addElement(e);
      }
      if (ListSequence.fromList(exceptions_e0a).isNotEmpty()) {
        throw new ParallelLoopException("Some parallel calculations failed", exceptions_e0a);
      }

    }
    // Set nowait to true to allow the main thread to continue without waiting for the tasks to finish 
    System.out.println("The main thread is done");
    System.getSecurityManager();
  }

  public static class Logger {
    public Logger() {
    }

    private static synchronized void log(String msg) {
      System.out.println(msg);
    }
  }
}
