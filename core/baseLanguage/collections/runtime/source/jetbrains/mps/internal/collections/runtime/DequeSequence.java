package jetbrains.mps.internal.collections.runtime;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import jetbrains.mps.internal.collections.runtime.backports.Deque;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.internal.collections.runtime.impl.NullDequeSequence;

public class DequeSequence<T> extends QueueSequence<T> implements Deque<T>, IDequeSequence<T>, Serializable {

    /**
     *  Auto-computed serialVersionUID
     */
    private static final long serialVersionUID = 4041418285223704058L;

    public static <U> IDequeSequence<U> fromDeque (Deque<U> deque) {
        if (Sequence.USE_NULL_SEQUENCE) {
            if (deque == null) {
                return NullDequeSequence.instance();
            }
        }
        if (deque instanceof IDequeSequence) {
            return (IDequeSequence<U>) deque;
        }
        return new DequeSequence<U> (deque);
    }
    
    public static <U> IDequeSequence<U> fromIterable (Iterable<U> it) {
        if (Sequence.USE_NULL_SEQUENCE) {
            if (it == null) {
                return NullDequeSequence.instance();
            }
        }
        if (it instanceof IDequeSequence) {
            return (IDequeSequence<U>) it;
        }
        Deque<U> deque = new LinkedList<U> ();
        if (Sequence.IGNORE_NULL_VALUES) {
            for (U u : it) {
                if (u != null) {
                    deque.add(u);
                }
            }
        }
        else if (it instanceof Collection){
            deque.addAll((Collection<? extends U>) it);
        }
        else {
            for (U u: it) {
                deque.add(u);
            }
        }
        return new DequeSequence<U> (deque);
    }
    
    public static <U> IDequeSequence<U> fromDequeAndArray(Deque<U> deque, U... array) {
        if (Sequence.USE_NULL_SEQUENCE) {
            if (deque == null && array == null) {
                return NullDequeSequence.instance();
            }
            else if (deque == null) {
                deque = new LinkedList<U>();
            }
            else if (array == null) {
                if (deque instanceof IDequeSequence) { return (IDequeSequence<U>) deque; }
                return new DequeSequence<U>(deque);
            }
        }
        List<U> input = Arrays.asList(array);
        if (Sequence.IGNORE_NULL_VALUES) {
            for (U u : input) {
                if (u != null) {
                    deque.add(u);
                }
            }
        }
        else {
            deque.addAll(input);
        }
        if (deque instanceof IDequeSequence) { return (IDequeSequence<U>) deque; }
        return new DequeSequence<U>(deque);
    }
    
    public static <U> IDequeSequence<U> fromDequeWithValues(Deque<U> deque, Iterable<? extends U> it) {
        Deque<U> tmp = deque;
        if (Sequence.USE_NULL_SEQUENCE) {
            if (deque == null && it == null) {
                return NullDequeSequence.instance();
            }
            else if (deque == null) {
                tmp = new LinkedList<U>();
            }
            else if (it == null) { return fromDeque(deque); }
        }
        if (Sequence.IGNORE_NULL_VALUES) {
            for (U u : it) {
                if (u != null) {
                    tmp.add(u);
                }
            }
        }
        else if (it instanceof Collection) {
            tmp.addAll((Collection<? extends U>) it);
        }
        else {
            for (U u : it) {
                tmp.add(u);
            }
        }
        if (tmp instanceof IDequeSequence) { return (IDequeSequence<U>) tmp; }
        return new DequeSequence<U>(tmp);
    }
    
    // Delegate methods 

    public void addFirst(T t) {
        getDeque().addFirst(t);
    }

    public void addLast(T t) {
        getDeque().addLast(t);
    }

    public Iterator<T> descendingIterator() {
        return getDeque().descendingIterator();
    }

    public T getFirst() {
        return getDeque().getFirst();
    }

    public T getLast() {
        return getDeque().getLast();
    }

    public boolean offerFirst(T t) {
        return getDeque().offerFirst(t);
    }

    public boolean offerLast(T t) {
        return getDeque().offerLast(t);
    }

    public T peekFirst() {
        return getDeque().peekFirst();
    }

    public T peekLast() {
        return getDeque().peekLast();
    }

    public T pollFirst() {
        return getDeque().pollFirst();
    }

    public T pollLast() {
        return getDeque().pollLast();
    }

    public T pop() {
        return getDeque().pop();
    }

    public void push(T t) {
        getDeque().push(t);
    }

    public T removeFirst() {
        return getDeque().removeFirst();
    }

    public boolean removeFirstOccurrence(Object o) {
        return getDeque().removeFirstOccurrence(o);
    }

    public T removeLast() {
        return getDeque().removeLast();
    }

    public boolean removeLastOccurrence(Object o) {
        return getDeque().removeLastOccurrence(o);
    }

    // IDequeSequence
    
    public T addFirstElement(T t) {
        getDeque().addFirst(t);
        return t;
    }

    public T removeLastElement() {
        if (Sequence.NULL_WHEN_EMPTY) {
            if (getDeque().isEmpty()) {
                return null;
            }
        }
        return getDeque().removeLast();
    }
    
    public T peekElement() {
        if (Sequence.NULL_WHEN_EMPTY) {
            if (getDeque().isEmpty()) {
                return null;
            }
        }
        return getDeque().peek();
    }

    public T popElement() {
        if (Sequence.NULL_WHEN_EMPTY) {
            if (getDeque().isEmpty()) {
                return null;
            }
        }
        return getDeque().pop();
    }

    public T pushElement(T t) {
        getDeque().push(t);
        return t;
    }

    @Override
    public IDequeSequence<T> addSequence(ISequence<? extends T> seq) {
        return (IDequeSequence<T>) super.addSequence(seq);
    }
    
    @Override
    public IDequeSequence<T> removeSequence(ISequence<? extends T> seq) {
        return (IDequeSequence<T>) super.removeSequence(seq);
    }
    
    @Override
    public IDequeSequence<T> removeWhere(IWhereFilter<T> filter) {
        return (IDequeSequence<T>) super.removeWhere(filter);
    }
    
    @Override
    public IDequeSequence<T> asUnmodifiable() {
        // TODO Auto-generated method stub
        return (IDequeSequence<T>) super.asUnmodifiable();
    }
    
    @Override
    public IDequeSequence<T> asSynchronized() {
        // TODO Auto-generated method stub
        return (IDequeSequence<T>) super.asSynchronized();
    }

    public Deque<T> toDeque() {
        return this;
    }

    protected DequeSequence (Deque<T> deque) {
        super (deque);
    }

    protected Deque<T> getDeque() {
        return (Deque<T>) getQueue();
    }

}
