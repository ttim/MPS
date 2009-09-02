package jetbrains.mps.baseLanguage.unitTest.runtime;

/*Generated by MPS */

import java.io.FilterOutputStream;
import java.io.PrintStream;
import java.io.IOException;

public class CommandOutputStream extends FilterOutputStream {
  private int lastChar;
  private PrintStream printOut;

  public CommandOutputStream(PrintStream out) {
    super(out);
    this.printOut = out;
  }

  public void write(int b) throws IOException {
    this.lastChar = b;
    this.out.write(b);
  }

  public void write(byte[] b) throws IOException {
    if (b.length > 0) {
      this.lastChar = b[b.length - 1];
    }
    this.out.write(b);
  }

  public void write(byte[] b, int off, int len) throws IOException {
    int lastIndex = off + len - 1;
    if (0 <= lastIndex && lastIndex < b.length) {
      this.lastChar = b[lastIndex];
    }
    this.out.write(b, off, len);
  }

  public void writeCommand(String command) {
    if (this.lastChar != '\n' && this.lastChar != '\r') {
      this.printOut.println();
    }
    this.printOut.println(command);
    this.lastChar = '\n';
  }
}
