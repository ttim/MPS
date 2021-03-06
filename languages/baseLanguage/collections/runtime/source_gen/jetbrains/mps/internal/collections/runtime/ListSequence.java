package jetbrains.mps.internal.collections.runtime;

/*Generated by MPS */

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;
import jetbrains.mps.baseLanguage.closures.runtime.AdapterClass;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.Collections;
import jetbrains.mps.internal.collections.runtime.impl.NullListSequence;
import java.util.Arrays;

public class ListSequence<T> extends CollectionSequence<T> implements IListSequence<T>, List<T>, Serializable {
  private static final long serialVersionUID = 8593660517992105071L;

  private List<T> list;

  protected ListSequence(List<T> list) {
    setList(list);
  }

  protected ListSequence(ListSequence<T> other) {
    setList(new ArrayList<T>(other.getList()));
  }

  public void add(int index, T element) {
    getList().add(index, element);
  }

  public boolean addAll(int index, Collection<? extends T> c) {
    return getList().addAll(index, c);
  }

  @Override
  public int indexOf(Object o) {
    return getList().indexOf(o);
  }

  @Override
  public boolean isEmpty() {
    return getList().isEmpty();
  }

  public T get(int index) {
    return getList().get(index);
  }

  public int lastIndexOf(Object o) {
    return getList().lastIndexOf(o);
  }

  public ListIterator<T> listIterator() {
    return getList().listIterator();
  }

  public ListIterator<T> listIterator(int index) {
    return getList().listIterator(index);
  }

  public T remove(int index) {
    return getList().remove(index);
  }

  public T set(int index, T element) {
    return getList().set(index, element);
  }

  public List<T> subList(int fromIndex, int toIndex) {
    return getList().subList(fromIndex, toIndex);
  }

  @Override
  public T first() {
    if (getList().size() > 0) {
      return getList().get(0);
    }
    if (Sequence.NULL_WHEN_EMPTY) {
      return null;
    } else {
      throw new IndexOutOfBoundsException("Empty list");
    }
  }

  @Override
  public T last() {
    if (getList().size() > 0) {
      return getList().get(getList().size() - 1);
    }
    if (Sequence.NULL_WHEN_EMPTY) {
      return null;
    } else {
      throw new IndexOutOfBoundsException("Empty list");
    }
  }

  @Override
  public boolean isNotEmpty() {
    return !((getList().isEmpty()));
  }

  public T removeElementAt(int idx) {
    if (Sequence.NULL_WHEN_EMPTY) {
      if (size() == 0 && (idx == 0 || idx == -1)) {
        return null;
      }
    }
    return remove(idx);
  }

  public T removeLastElement() {
    if (Sequence.NULL_WHEN_EMPTY) {
      if (size() == 0) {
        return null;
      }
    }
    return remove(size() - 1);
  }

  public T insertElement(int idx, T t) {
    if (Sequence.IGNORE_NULL_VALUES) {
      if (t == null) {
        return null;
      }
    }
    add(idx, t);
    return t;
  }

  public T getElement(int idx) {
    if (Sequence.NULL_WHEN_EMPTY) {
      if (size() == 0 && (idx == 0 || idx == -1)) {
        return null;
      }
    }
    return get(idx);
  }

  public T setElement(int idx, T t) {
    if (Sequence.IGNORE_NULL_VALUES) {
      if (t == null) {
        return null;
      }
    }
    if (Sequence.NULL_WHEN_EMPTY) {
      if (size() == 0 && (idx == 0 || idx == -1)) {
        return null;
      }
    }
    set(idx, t);
    return t;
  }

  @Override
  public IListSequence<T> addSequence(ISequence<? extends T> seq) {
    return (IListSequence<T>) super.addSequence(seq);
  }

  @Override
  public IListSequence<T> removeSequence(ISequence<? extends T> seq) {
    return (IListSequence<T>) super.removeSequence(seq);
  }

  @Override
  public IListSequence<T> removeWhere(@AdapterClass(value = "IWhereFilter") _FunctionTypes._return_P1_E0<? extends Boolean, ? super T> filter) {
    return (IListSequence<T>) super.removeWhere(filter);
  }

  public IListSequence<T> reversedList() {
    ListSequence<T> reversed = new ListSequence<T>(this);
    reversed._reverse();
    return reversed;
  }

  public IListSequence<T> subListSequence(int fromIdx, int upToIdx) {
    return new ListSequence<T>(getList().subList(fromIdx, upToIdx));
  }

  public IListSequence<T> headListSequence(int upToIdx) {
    return new ListSequence<T>(getList().subList(0, upToIdx));
  }

  public IListSequence<T> tailListSequence(int fromIdx) {
    return new ListSequence<T>(getList().subList(fromIdx, getList().size()));
  }

  @Override
  public IListSequence<T> asUnmodifiable() {
    return new ListSequence<T>(Collections.unmodifiableList(getList()));
  }

  @Override
  public IListSequence<T> asSynchronized() {
    return new ListSequence<T>(CollectionUtils.synchronizedList(getList()));
  }

  @SuppressWarnings(value = "unchecked")
  public T[] toGenericArray() {
    return (T[]) getList().toArray();
  }

  @SuppressWarnings(value = "unchecked")
  public T[] toGenericArray(Class<T> runtimeClass) {
    T[] arr = (T[]) ArrayUtils.newArrayInstance(runtimeClass, getList().size());
    return getList().toArray(arr);
  }

  public List<T> toList() {
    return this;
  }

  @Override
  public IListSequence<T> toListSequence() {
    return this;
  }

  /*package*/ void _reverse() {
    Collections.reverse(getList());
  }

  @Override
  protected List<T> getCollection() {
    return list;
  }

  protected List<T> getList() {
    return list;
  }

  private void setList(List<T> list) {
    this.list = list;
  }

  public static <U> IListSequence<U> fromArray(U... array) {
    if (Sequence.USE_NULL_SEQUENCE) {
      if (array == null) {
        return NullListSequence.instance();
      }
    }
    return ListSequence.fromListAndArray(new ArrayList<U>(), array);
  }

  public static <U> IListSequence<U> fromList(List<U> list) {
    if (Sequence.USE_NULL_SEQUENCE) {
      if (list == null) {
        return NullListSequence.instance();
      }
    }
    if (list instanceof IListSequence<?>) {
      return (IListSequence<U>) list;
    }
    return new ListSequence<U>(list);
  }

  public static <U> IListSequence<U> fromListAndArray(List<U> list, U... array) {
    if (Sequence.NULL_ARRAY_IS_SINGLETON) {
      if (array == null) {
        array = (U[]) Sequence.nullSingletonArray();
      }
    }
    if (Sequence.USE_NULL_SEQUENCE) {
      if (list == null && array == null) {
        return NullListSequence.instance();
      } else
      if (list == null) {
        list = new ArrayList<U>();
      } else
      if (array == null) {
        if (list instanceof IListSequence<?>) {
          return (IListSequence<U>) list;
        }
        return new ListSequence<U>(list);
      }
    }
    List<U> input = Arrays.asList(array);
    if (Sequence.IGNORE_NULL_VALUES) {
      for (U u : input) {
        if (u != null) {
          list.add(u);
        }
      }
    } else {
      list.addAll(input);
    }
    if (list instanceof IListSequence<?>) {
      return (IListSequence<U>) list;
    }
    return new ListSequence<U>(list);
  }

  public static <U> IListSequence<U> fromIterable(Iterable<U> it) {
    if (Sequence.USE_NULL_SEQUENCE) {
      if (it == null) {
        return NullListSequence.instance();
      }
    }
    if (it instanceof IListSequence<?>) {
      return (IListSequence<U>) it;
    }
    List<U> list = new ArrayList<U>();
    if (Sequence.IGNORE_NULL_VALUES) {
      for (U u : it) {
        if (u != null) {
          list.add(u);
        }
      }
    } else
    if (it instanceof Collection<?>) {
      list.addAll((Collection<? extends U>) it);
    } else {
      for (U u : it) {
        list.add(u);
      }
    }
    return new ListSequence<U>(list);
  }

  public static <U> IListSequence<U> fromListWithValues(List<U> list, Iterable<? extends U> it) {
    List<U> tmp = list;
    if (Sequence.USE_NULL_SEQUENCE) {
      if (list == null && it == null) {
        return NullListSequence.instance();
      } else
      if (list == null) {
        tmp = new ArrayList<U>();
      } else
      if (it == null) {
        return ListSequence.fromList(list);
      }
    }
    if (Sequence.IGNORE_NULL_VALUES) {
      for (U u : it) {
        if (u != null) {
          tmp.add(u);
        }
      }
    } else
    if (it instanceof Collection<?>) {
      tmp.addAll((Collection<? extends U>) it);
    } else {
      for (U u : it) {
        tmp.add(u);
      }
    }
    if (tmp instanceof IListSequence<?>) {
      return (IListSequence<U>) tmp;
    }
    return new ListSequence<U>(tmp);
  }
}
