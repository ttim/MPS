package jetbrains.mps.ui.modeling.pluginSolution.plugin;

/*Generated by MPS */


public interface IObjectsProvider<T, U> {
  public Object info();
  public T create(U context);
  public Iterable<T> getObjects();
}
