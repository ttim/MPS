package jetbrains.mps.internal.collections.runtime;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.closures.runtime.AdapterClass;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.Comparator;

public interface ISequence<T> extends Iterable<T>, IEnumerable<T> {
  public ISequence<T> where(@AdapterClass(value = "IWhereFilter") _FunctionTypes._return_P1_E0<? extends Boolean, ? super T> filter);
  public T findFirst(@AdapterClass(value = "IWhereFilter") _FunctionTypes._return_P1_E0<? extends Boolean, ? super T> filter);
  public T findLast(@AdapterClass(value = "IWhereFilter") _FunctionTypes._return_P1_E0<? extends Boolean, ? super T> filter);
  public boolean any(@AdapterClass(value = "IWhereFilter") _FunctionTypes._return_P1_E0<? extends Boolean, ? super T> filter);
  public boolean all(@AdapterClass(value = "IWhereFilter") _FunctionTypes._return_P1_E0<? extends Boolean, ? super T> filter);
  public <U> ISequence<U> translate(@AdapterClass(value = "ITranslator2") _FunctionTypes._return_P1_E0<? extends Iterable<U>, ? super T> translator);
  public <U> ISequence<U> select(@AdapterClass(value = "ISelector") _FunctionTypes._return_P1_E0<? extends U, ? super T> selector);
  public ISequence<T> sort(@AdapterClass(value = "ISelector") _FunctionTypes._return_P1_E0<? extends Comparable<?>, ? super T> selector, boolean ascending);
  public ISequence<T> alsoSort(@AdapterClass(value = "ISelector") _FunctionTypes._return_P1_E0<? extends Comparable<?>, ? super T> selector, boolean ascending);
  public ISequence<T> sort(Comparator<T> comparator, boolean ascending);
  public ISequence<T> distinct();
  public void visitAll(@AdapterClass(value = "IVisitor") _FunctionTypes._void_P1_E0<? super T> visitor);
  public ISequence<T> take(int length);
  public ISequence<T> skip(int length);
  public ISequence<T> cut(int length);
  public ISequence<T> tail(int length);
  public ISequence<T> page(int skip, int skipplustake);
  public ISequence<T> concat(ISequence<T> that);
  public ISequence<T> intersect(ISequence<T> that);
  public ISequence<T> subtract(ISequence<T> that);
  public ISequence<T> union(ISequence<T> that);
  public ISequence<T> disjunction(ISequence<T> that);
  public ISequence<T> reverse();
  public boolean contains(T t);
  public boolean containsSequence(ISequence<T> that);
  public int indexOf(T t);
  public int lastIndexOf(T t);
  public int count();
  public boolean isEmpty();
  public boolean isNotEmpty();
  public T first();
  public T last();
  public T reduceLeft(@AdapterClass(value = "ILeftCombinator") _FunctionTypes._return_P2_E0<? extends T, ? super T, ? super T> comb);
  public T reduceRight(@AdapterClass(value = "IRightCombinator") _FunctionTypes._return_P2_E0<? extends T, ? super T, ? super T> comb);
  public <S> S foldLeft(S seed, @AdapterClass(value = "ILeftCombinator") _FunctionTypes._return_P2_E0<? extends S, ? super S, ? super T> comb);
  public <S> S foldRight(S seed, @AdapterClass(value = "IRightCombinator") _FunctionTypes._return_P2_E0<? extends S, ? super T, ? super S> comb);
  public Iterable<T> toIterable();
  public IListSequence<T> toListSequence();
  public T[] toGenericArray();
  public T[] toGenericArray(Class<T> runtimeClass);
}
