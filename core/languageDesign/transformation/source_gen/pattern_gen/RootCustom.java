package pattern_gen;

/*Generated by MPS */


public class RootCustom {
  public RootCustom() {
  }

  public void main() {
    {
      int e = 5;
      int i = 1;
      i *= 287;
      e *= (i + 5);
      i = e * i;

      if (!(e != 10 || i != 43)) {
        boolean res = true;
        for (int qq = 0; qq < 10; qq++) {
          res = !(!(res) || !((i - e > qq)));
        }
      }

      {
        // myWork1true 
        int var12 = 175 * (1 + e);
      }

    }
  }
}
