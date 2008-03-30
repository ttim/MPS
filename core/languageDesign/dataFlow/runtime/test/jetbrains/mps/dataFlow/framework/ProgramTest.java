package jetbrains.mps.dataFlow.framework;

import org.junit.Test;
import org.junit.Assert;
import jetbrains.mps.dataFlow.framework.SimpleProgramBuilder;
import jetbrains.mps.dataFlow.framework.Program;

public class ProgramTest {

  @Test
  public void simpleProgramBuilding() {    
    Program program = new SimpleProgramBuilder()
      .emitRead("x")
      .emitWrite("y")
      .buildProgram();

    Assert.assertEquals(
      "0: read x\n" +
      "1: write y\n" +
      "2: end\n",
      
      program.toString()
    );
  }

  @Test
  public void programWithTryFinally() {
    Program program = new SimpleProgramBuilder()
      .emitTry()
      .emitRead("x")
      .emitFinally()
      .emitRead("x")
      .emitEndTry()
      .buildProgram();


    Assert.assertEquals(
      "0: try\n" +
      "1: read x\n" +
      "2: finally\n" +
      "3: read x\n" +
      "4: endTry\n" +
      "5: end\n",
      program.toString()
    );
  }

  @Test(expected = IllegalStateException.class)
  public void danglingTry() {
    new SimpleProgramBuilder()
      .emitTry()
      .buildProgram();
  }

  @Test(expected = IllegalStateException.class)
  public void unexpectedFinally() {
    new SimpleProgramBuilder()
        .emitFinally()
        .buildProgram();
  }

  @Test(expected = IllegalStateException.class)
  public void unexpectedEndTry() {
    new SimpleProgramBuilder()
        .emitEndTry()
        .buildProgram();
  }
}
