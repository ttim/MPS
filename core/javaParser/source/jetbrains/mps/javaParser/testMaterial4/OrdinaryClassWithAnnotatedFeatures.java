package jetbrains.mps.javaParser.testMaterial4;

import org.jetbrains.annotations.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 28.12.2009
 * Time: 18:13:37
 * To change this template use File | Settings | File Templates.
 */
public class OrdinaryClassWithAnnotatedFeatures {
  @NotNull
  public void foo(@NotNull Object param) {
    @NotNull Object a = null;
  }

  public @OrdinaryAnnotation(foo = 45) class FooBar {

  }
}
