package jetbrains.mps.graphLayout.planarization;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;

public class SubsequenceFinder {
  private static int showInfo = 0;

  public SubsequenceFinder() {
  }

  public static List<Tuples._2<Integer, Integer>> getCyclicSubsequence(List<Object> sample, List<Object> cyclic) {
    List<Object> copy = ListSequence.fromList(new LinkedList<Object>());
    ListSequence.fromList(copy).addSequence(ListSequence.fromList(cyclic));
    int size = ListSequence.fromList(copy).count();
    Object[] s = ListSequence.fromList(sample).toGenericArray(Object.class);
    List<Tuples._2<Integer, Integer>> pos = null;
    int max = -1;
    for (int i = 0; i < size; i++) {
      Object[] p = ListSequence.fromList(copy).toGenericArray(Object.class);
      List<Tuples._2<Integer, Integer>> pairs = getSubsequence(s, p);
      if (max < ListSequence.fromList(pairs).count()) {
        max = ListSequence.fromList(pairs).count();
        List<Tuples._2<Integer, Integer>> realPos = ListSequence.fromList(new LinkedList<Tuples._2<Integer, Integer>>());
        for (Tuples._2<Integer, Integer> pair : ListSequence.fromList(pairs)) {
          int real = (int) pair._1() + i;
          if (real >= size) {
            real -= size;
          }
          ListSequence.fromList(realPos).addElement(MultiTuple.<Integer,Integer>from((int) pair._0(), real));
        }
        pos = realPos;
      }
      ListSequence.fromList(copy).addElement(ListSequence.fromList(copy).removeElementAt(0));
    }
    return pos;
  }

  public static List<Tuples._2<Integer, Integer>> getSubsequence(Object[] s, Object[] p) {
    // finds greatest common subsequence of arrays s and p 
    // here one element of p can correspond to many elements of s 
    int[][] maxSeq = new int[s.length + 1][p.length + 1];
    for (int sn = 0; sn < s.length; sn++) {
      for (int pn = 0; pn < p.length; pn++) {
        int prev = Math.max(maxSeq[sn][pn + 1], maxSeq[sn + 1][pn]);
        maxSeq[sn + 1][pn + 1] = prev;
        if (s[sn].equals(p[pn])) {
          maxSeq[sn + 1][pn + 1] = Math.max(prev, maxSeq[sn][pn + 1] + 1);
        }
      }
    }
    if (showInfo > 0) {
      for (int i = 0; i <= s.length; i++) {
        for (int j = 0; j <= p.length; j++) {
          System.out.print(maxSeq[i][j] + " ");
        }
        System.out.println();
      }
    }
    int max = 0;
    int pMax = -1;
    for (int pn = 1; pn <= p.length; pn++) {
      int curMax = maxSeq[s.length][pn];
      if (curMax > max) {
        pMax = pn;
        max = curMax;
      }
    }
    List<Tuples._2<Integer, Integer>> pos = ListSequence.fromList(new LinkedList<Tuples._2<Integer, Integer>>());
    int curP = pMax;
    int curS = s.length;
    while (max != 0) {
      if (max == maxSeq[curS - 1][curP]) {
        curS--;
      } else {
        if (s[curS - 1] == p[curP - 1]) {
          ListSequence.fromList(pos).insertElement(0, MultiTuple.<Integer,Integer>from(curS - 1, curP - 1));
          max--;
        } else {
          curP--;
        }
      }
    }
    return pos;
  }
}
