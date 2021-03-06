package jetbrains.mps.internal.collections.runtime;

/*Generated by MPS */

import java.util.Set;

public interface ISetSequence<T> extends ICollectionSequence<T>, Set<T> {
  public T addElement(T t);
  public T removeElement(T t);
  public ISetSequence<T> addSequence(ISequence<? extends T> seq);
  public ISetSequence<T> removeSequence(ISequence<? extends T> seq);
  public ISetSequence<T> asUnmodifiable();
  public ISetSequence<T> asSynchronized();
  public Set<T> toSet();
  public T[] toGenericArray();
  public T[] toGenericArray(Class<T> runtimeClass);
}
