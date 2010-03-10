package jetbrains.mps.workbench.dialogs.project.components.parts.lists;

/*Generated by MPS */

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Collection;

/*package*/ class SortedList<T> extends AbstractList<T> {
  private ListsFactory.ListComparator<T> myComparator;
  private ArrayList<T> myList = new ArrayList<T>();

  public SortedList(ListsFactory.ListComparator<T> comparator) {
    this.myComparator = comparator;
  }

  public int size() {
    return this.myList.size();
  }

  public T get(int index) {
    return this.myList.get(index);
  }

  @Override
  public int indexOf(Object o) {
    ListIterator<T> e = SortedList.this.listIterator();
    if (o == null) {
      while (e.hasNext()) {
        if (e.next() == null) {
          return e.previousIndex();
        }
      }
    } else {
      while (e.hasNext()) {
        if (this.myComparator.isEqual((T) o, e.next())) {
          return e.previousIndex();
        }
      }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
    ListIterator<T> e = SortedList.this.listIterator(SortedList.this.size());
    if (o == null) {
      while (e.hasPrevious()) {
        if (e.previous() == null) {
          return e.nextIndex();
        }
      }
    } else {
      while (e.hasPrevious()) {
        if (this.myComparator.isEqual((T) o, e.previous())) {
          return e.nextIndex();
        }
      }
    }
    return -1;
  }

  @Override
  public T remove(int index) {
    return this.myList.remove(index);
  }

  public void add(int index, T element) {
    SortedList.this.add(element);
  }

  public boolean add(T o) {
    int index = this.myList.size();
    for (int i = 0; i < this.myList.size(); i++) {
      if (this.myComparator.compare(this.myList.get(i), o) > 0) {
        index = i;
        break;
      }
    }
    if (index != 0) {
      if (this.myComparator.isEqual(o, this.myList.get(index - 1))) {
        return false;
      }
    }
    this.myList.add(index, o);
    return true;
  }

  public boolean addAll(Collection<? extends T> c) {
    for (T element : c) {
      SortedList.this.add(element);
    }
    return true;
  }

  public boolean addAll(int index, Collection<? extends T> c) {
    return SortedList.this.addAll(c);
  }
}
