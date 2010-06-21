package jetbrains.mps.debug.runtime.java.programState.proxies;

/**
 * Created by IntelliJ IDEA.
 * Date: 21.06.2010
 * Time: 16:57:39
 * To change this template use File | Settings | File Templates.
 */
public abstract class ValueWrapperFactory {
  public boolean canWrapValue(JavaValue value) {
    return false;
  }

  public abstract ValueWrapper createValueWrapper(JavaValue value);

}
