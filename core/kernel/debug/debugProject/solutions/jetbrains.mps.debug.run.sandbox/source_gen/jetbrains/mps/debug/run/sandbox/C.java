package jetbrains.mps.debug.run.sandbox;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class C {
  private static Integer myStatic239 = 239;
  private static Integer myStatic239_2 = 239;

  private Integer my239 = 239;

  public C() {
    int y = 0;
    y++;
  }

  public int getZero() {
    return 0;
  }

  public static void main(String[] args) {
    int i = 0;
    i++;
    i--;
    i++;
    i = 0;
    List<Integer> list = ListSequence.fromList(new ArrayList<Integer>());
    ListSequence.fromList(list).addElement(1);
    ListSequence.fromList(list).addElement(1);
    ListSequence.fromList(list).where(new IWhereFilter<Integer>() {
      public boolean accept(Integer it) {
        System.out.print(it);
        return it == 1;
      }
    }).first();
    new C();
  }

  private static int getOne() {
    return 1;
  }
}
