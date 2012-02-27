package jetbrains.mps.internal.collections.runtime;

/*Generated by MPS */

import java.util.Collection;
import java.io.Serializable;
import jetbrains.mps.baseLanguage.closures.runtime.AdapterClass;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.Iterator;
import java.util.Collections;
import jetbrains.mps.internal.collections.runtime.impl.NullCollectionSequence;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public abstract class CollectionSequence<T> extends Sequence<T> implements ICollectionSequence<T>, Collection<T>, Serializable {
  private static final long serialVersionUID = -195412084368027561L;

  protected CollectionSequence() {
  }

  public T addElement(T t) {
    if (Sequence.IGNORE_NULL_VALUES) {
      if (t == null) {
        return null;
      }
    }
    if (getCollection().add(t)) {
      return t;
    }
    return null;
  }

  public T removeElement(T t) {
    if (remove((Object) t)) {
      return t;
    }
    return null;
  }

  public ICollectionSequence<T> addSequence(ISequence<? extends T> seq) {
    if (Sequence.USE_NULL_SEQUENCE) {
      if (seq == null) {
        return this;
      }
    }
    if (seq.toIterable() instanceof Collection) {
      getCollection().addAll((Collection<? extends T>) seq.toIterable());
    } else {
      for (T t : seq.toIterable()) {
        getCollection().add(t);
      }
    }
    return this;
  }

  public ICollectionSequence<T> removeSequence(ISequence<? extends T> seq) {
    if (Sequence.USE_NULL_SEQUENCE) {
      if (seq == null) {
        return this;
      }
    }
    if (seq.toIterable() instanceof Collection) {
      getCollection().removeAll((Collection<? extends T>) seq.toIterable());
    } else {
      for (T t : seq.toIterable()) {
        getCollection().remove(t);
      }
    }
    return this;
  }

  public ICollectionSequence<T> removeWhere(@AdapterClass(value = "IWhereFilter") _FunctionTypes._return_P1_E0<? extends Boolean, ? super T> filter) {
    for (Iterator<T> it = getCollection().iterator(); it.hasNext();) {
      if (filter.invoke(it.next())) {
        it.remove();
      }
    }
    return this;
  }

  public boolean add(T e) {
    if (IGNORE_NULL_VALUES) {
      if (e == null) {
        return false;
      }
    }
    return getCollection().add(e);
  }

  public boolean addAll(Collection<? extends T> c) {
    return getCollection().addAll(c);
  }

  public void clear() {
    getCollection().clear();
  }

  public boolean contains(Object o) {
    return getCollection().contains(o);
  }

  public boolean containsAll(Collection<?> c) {
    return getCollection().containsAll(c);
  }

  @Override
  public boolean isEmpty() {
    return getCollection().isEmpty();
  }

  public boolean remove(Object o) {
    if (IGNORE_NULL_VALUES) {
      if (o == null) {
        return false;
      }
    }
    return getCollection().remove(o);
  }

  public boolean removeAll(Collection<?> c) {
    return getCollection().removeAll(c);
  }

  public boolean retainAll(Collection<?> c) {
    return getCollection().retainAll(c);
  }

  public int size() {
    return getCollection().size();
  }

  public Object[] toArray() {
    return getCollection().toArray();
  }

  public <U> U[] toArray(U[] a) {
    return getCollection().toArray(a);
  }

  public Iterator<T> iterator() {
    return getCollection().iterator();
  }

  public ICollectionSequence<T> asUnmodifiable() {
    final Collection<T> unmodifiableCollection = Collections.unmodifiableCollection(getCollection());
    return new CollectionSequence<T>() {
      protected Collection<T> getCollection() {
        return unmodifiableCollection;
      }
    };
  }

  public ICollectionSequence<T> asSynchronized() {
    final Collection<T> synchronizedCollection = CollectionUtils.synchronizedCollection(getCollection());
    return new CollectionSequence<T>() {
      protected Collection<T> getCollection() {
        return synchronizedCollection;
      }
    };
  }

  @Override
  public int count() {
    return getCollection().size();
  }

  @Override
  public boolean containsSequence(ISequence<T> that) {
    if (that instanceof CollectionSequence<?>) {
      return getCollection().containsAll(((CollectionSequence<?>) that).getCollection());
    }
    return super.containsSequence(that);
  }

  @SuppressWarnings(value = "unchecked")
  @Override
  public boolean equals(Object o) {
    if (o instanceof CollectionSequence) {
      Collection<T> thatColl = ((CollectionSequence<T>) o).getCollection();
      Collection<T> thisColl = getCollection();
      if (thisColl == thatColl) {
        return true;
      }
      return (thisColl != null ?
        thisColl.equals(thatColl) :
        false
      );
    }
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return getCollection().hashCode();
  }

  protected abstract Collection<T> getCollection();

  public static <U> ICollectionSequence<U> fromCollection(final Collection<U> coll) {
    if (USE_NULL_SEQUENCE) {
      if (coll == null) {
        return NullCollectionSequence.instance();
      }
    }
    if (coll instanceof ICollectionSequence<?>) {
      return (ICollectionSequence<U>) coll;
    }
    return new CollectionSequence<U>() {
      protected Collection<U> getCollection() {
        return coll;
      }
    };
  }

  public static <U> ICollectionSequence<U> fromCollectionWithValues(Collection<U> coll, Iterable<? extends U> it) {
    Collection<U> tmp = coll;
    if (USE_NULL_SEQUENCE) {
      if (coll == null && it == null) {
        return NullCollectionSequence.instance();
      } else
      if (coll == null) {
        tmp = new ArrayList<U>();
      } else
      if (it == null) {
        return CollectionSequence.fromCollection(coll);
      }
    }
    if (IGNORE_NULL_VALUES) {
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
    if (tmp instanceof ICollectionSequence<?>) {
      return (ICollectionSequence<U>) tmp;
    }
    final Collection<U> myColl = tmp;
    return new CollectionSequence<U>() {
      protected Collection<U> getCollection() {
        return myColl;
      }
    };
  }

  public static <U> ICollectionSequence<U> fromCollectionAndArray(Collection<U> coll, U... array) {
    if (NULL_ARRAY_IS_SINGLETON) {
      if (array == null) {
        array = (U[]) Sequence.nullSingletonArray();
      }
    }
    if (USE_NULL_SEQUENCE) {
      if (coll == null && array == null) {
        return NullCollectionSequence.instance();
      } else
      if (coll == null) {
        coll = new ArrayList<U>();
      } else
      if (array == null) {
        if (coll instanceof ICollectionSequence<?>) {
          return (ICollectionSequence<U>) coll;
        }
        final Collection<U> myColl = coll;
        return new CollectionSequence<U>() {
          protected Collection<U> getCollection() {
            return myColl;
          }
        };
      }
    }
    List<U> input = Arrays.asList(array);
    if (IGNORE_NULL_VALUES) {
      for (U u : input) {
        if (u != null) {
          coll.add(u);
        }
      }
    } else {
      coll.addAll(input);
    }
    if (coll instanceof ICollectionSequence<?>) {
      return (ICollectionSequence<U>) coll;
    }
    final Collection<U> myColl = coll;
    return new CollectionSequence<U>() {
      protected Collection<U> getCollection() {
        return myColl;
      }
    };
  }
}
