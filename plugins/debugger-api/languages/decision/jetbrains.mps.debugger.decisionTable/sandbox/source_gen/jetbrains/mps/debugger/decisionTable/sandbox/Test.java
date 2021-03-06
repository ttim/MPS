package jetbrains.mps.debugger.decisionTable.sandbox;

/*Generated by MPS */

import jetbrains.mps.debugger.decisionTable.runtime.IDecisionTable;

public class Test {
  public Test() {
  }

  public static void main(String[] args) {
    IDecisionTable table = new IDecisionTable() {
      public boolean check_caseX_0(int argument) {
        return argument > 0;
      }

      public boolean check_caseX_1(int argument) {
        return argument <= 0;
      }

      public boolean check_caseY_0(int argument) {
        return argument > 0;
      }

      public boolean check_caseY_1(int argument) {
        return argument <= 0;
      }

      public int decide(int x, int y) {
        if (check_caseX_0(x)) {
          if (check_caseY_0(y)) {
            return 1;
          }
          if (check_caseY_1(y)) {
            return 2;
          }
        }
        if (check_caseX_1(x)) {
          if (check_caseY_0(y)) {
            return 2;
          }
          if (check_caseY_1(y)) {
            return 3;
          }
        }
        return 0;
      }
    };
    System.out.println("(1,1) -> " + table.decide(1, 1));
    System.out.println("(1,-1) -> " + table.decide(1, -1));
    System.out.println("(-1,1) -> " + table.decide(-1, 1));
    System.out.println("(-1,-1) -> " + table.decide(-1, -1));
  }
}
