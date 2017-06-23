package com.gadgets.listImpl;

import com.gadgets.entity.SellableProduct;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;

/**
 * @author Kostiantyn_Diachenk1
 */

public class MyListImpl<E> implements List<E> {

    /**
     * The array buffer into which the elements of the MyListImpl are stored.
     * The capacity of the ArrayList is the length of this array buffer. Any
     * empty MyListImpl with array == {} will be expanded to DEFAULT_CAPACITY
     * when the first element is added.
     */
    private E[] array;

    /**
     * The capacity of the MyListImpl (the number of elements it contains).
     *
     * @serial
     */
    private int capacity;

    /**
     * The size of the MyListImpl (the number of elements it contains).
     *
     * @serial
     */
    private int size;

    /**
     * The special condition for iterator() for obtaining elements satisfied
     * this condition.
     */
    private Predicate<E> condition;

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 6;

    /**
     * Constructs an empty list with an initial capacity of six.
     */
    public MyListImpl() {
        init();
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param  capacity  the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public MyListImpl(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.size = 0;
        this.array = (E[]) new Object[capacity];
        this.condition = t -> true;
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param array the array whose elements are to be placed into this list
     *              the type of array should be casted to E
     * @throws NullPointerException if the specified collection is null
     */
    public MyListImpl(E[] array) {
        if (array == null){
            throw new NullPointerException();
        }
        this.size = 0;
        this.capacity = array.length * 5 / 3;
        this.array = (E[]) new Object[capacity];
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }
        this.condition = t -> true;
    }

    /**
     * Initial method, which constructs a list with initial capacity.
     */
    private void init() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.array = (E[]) new Object[capacity];
        this.condition = t -> true;
    }

    /**
     * Returns the number of elements in this list.  If this list contains
     * more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns <tt>true</tt> if this list contains no elements or is empty.
     *
     * @return <tt>true</tt> if this list contains no elements or is empty.
     */
    @Override
    public boolean isEmpty() {
        return array == null || size == 0;
    }

    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this list contains
     * at least one element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    @Override
    public boolean contains(Object o) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if ((o == null && array[i] == null) || (array[i] != null && array[i].equals(o))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<E> iterator() {
        this.condition = t -> true;
        return new IteratorImpl();
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence
     *  with certain condition.
     *
     * @param condition the condition to obtain elements from list
     * @return an iterator over the elements in this list in proper sequence
     */
    public Iterator<E> iterator(Predicate<E> condition) {
        this.condition = condition;
        return new IteratorImpl();
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must
     * allocate a new array even if this list is backed by an array).
     * The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this list in proper
     *         sequence
     * @see Arrays#copyOf(Object[], int)
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    /**
     * Returns an array containing all of the elements in this list in
     * proper sequence (from first to last element); the runtime type of
     * the returned array is that of the specified array.  If the list fits
     * in the specified array, it is returned therein.  Otherwise, a new
     * array is allocated with the runtime type of the specified array and
     * the size of this list.
     *
     * <p>If type of array couldn't cast to T[], then will catch ArrayStoreException
     * and will return null.
     *
     * <p>If the list fits in the specified array with room to spare (i.e.,
     * the array has more elements than the list), the element in the array
     * immediately following the end of the list is set to <tt>null</tt>.
     * (This is useful in determining the length of the list <i>only</i> if
     * the caller knows that the list does not contain any null elements.)
     *
     * <p>Like the {@link #toArray()} method, this method acts as bridge between
     * array-based and collection-based APIs.  Further, this method allows
     * precise control over the runtime type of the output array, and may,
     * under certain circumstances, be used to save allocation costs.
     *
     * <p>Suppose <tt>x</tt> is a list known to contain only strings.
     * The following code can be used to dump the list into a newly
     * allocated array of <tt>String</tt>:
     *
     * <pre>{@code
     *     String[] y = x.toArray(new String[0]);
     * }</pre>
     *
     * Note that <tt>toArray(new Object[0])</tt> is identical in function to
     * <tt>toArray()</tt>.
     *
     * @param a the array into which the elements of this list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return an array containing the elements of this list. If throws
     *          ArrayStoreException - return null.
     *
     * @throws ArrayStoreException if the runtime type of the specified array
     *         is not a supertype of the runtime type of every element in
     *         this list
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public <T> T[] toArray(T[] a) {
        try {
            if (a.length < size)
                return (T[]) Arrays.copyOf(array, size, a.getClass());
            System.arraycopy(array, 0, a, 0, size);
            if (a.length > size)
                a[size] = null;
        } catch (ArrayStoreException ex) {
            return null;
        }
        return a;
    }

    // Modification Operations

    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @param e element to be appended to this list
     * @return <tt>true</tt> (as specified by {@link Collection#add})
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this list
     */
    @Override
    public boolean add(E e) {
        if (array == null) {
            init();
        }
        if (size == capacity) {
            capacity *= 5 / 3;
            array = Arrays.copyOf(array, capacity, (Class<? extends E[]>) array.getClass());
        }
        array[size++] = e;
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present (optional operation).  If this list does not contain
     * the element, it is unchanged.  More formally, removes the element with
     * the lowest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
     * (if such an element exists).  Returns <tt>true</tt> if this list
     * contained the specified element (or equivalently, if this list changed
     * as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return <tt>true</tt> if this list contained the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    @Override
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if ((o == null && array[i] == null) || (array[i] != null && array[i].equals(o))) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    // Bulk Modification Operations

    /**
     * Returns <tt>true</tt> if this list contains all of the elements of the
     * specified collection.
     *
     * @param  c collection to be checked for containment in this list
     * @return <tt>true</tt> if this list contains all of the elements of the
     *         specified collection
     * @throws ClassCastException if the types of one or more elements
     *         in the specified collection are incompatible with this
     *         list
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @see #contains(Object)
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        if (isEmpty()) {
            return false;
        }
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator (optional operation).  The behavior of this
     * operation is undefined if the specified collection is modified while
     * the operation is in progress.  (Note that this will occur if the
     * specified collection is this list, and it's nonempty.)
     *
     * @param c collection containing elements to be added to this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws ClassCastException if the class of an element of the specified
     *         collection prevents it from being added to this list
     * @see #add(Object)
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    /**
     * Inserts all of the elements in the specified collection into this
     * list at the specified position (optional operation).  Shifts the
     * element currently at that position (if any) and any subsequent
     * elements to the right (increases their indices).  The new elements
     * will appear in this list in the order that they are returned by the
     * specified collection's iterator.  The behavior of this operation is
     * undefined if the specified collection is modified while the
     * operation is in progress.  (Note that this will occur if the specified
     * collection is this list, and it's nonempty.)
     *
     * @param index index at which to insert the first element from the
     *              specified collection
     * @param c collection containing elements to be added to this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws ClassCastException if the class of an element of the specified
     *         collection prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt; size()</tt>)
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for (E e : c) {
            add(++index, e);
        }
        return true;
    }

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection (optional operation).
     *
     * @param c collection containing elements to be removed from this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws ClassCastException if the class of an element of this list
     *         is incompatible with the specified collection
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @see #remove(Object)
     * @see #contains(Object)
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean res = false;
        for (int i = 0; i < c.size(); i++) {
            while (remove(c.toArray()[i])) {
                res = true;
            }
        }
        return res;
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection (optional operation).  In other words, removes
     * from this list all of its elements that are not contained in the
     * specified collection.
     *
     * @param c collection containing elements to be retained in this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws ClassCastException if the class of an element of this list
     *         is incompatible with the specified collection
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @see #remove(Object)
     * @see #contains(Object)
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = false;
        boolean res = false;
        for (E e : array) {
            for (Object o : c) {
                if ((o == null && e == null) || (e != null && e.equals(o))) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                remove(e);
                flag = false;
                res = true;
            }
        }
        return res;
    }

    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        init();
    }

    private boolean isAvailableIndex(int index) {
        if (array == null || index < 0 || index > size) {
            return false;
        }
        return true;
    }

    // Positional Access Operations

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    @Override
    public E get(int index) {
        if (!isAvailableIndex(index)){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    @Override
    public E set(int index, E element) {
        if (!isAvailableIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        E tmp = array[index];
        array[index] = element;
        return tmp;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt; size()</tt>)
     */
    @Override
    public void add(int index, E element) {
        if (!isAvailableIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        array = Arrays.copyOf(array, ++size);
        System.arraycopy(array, index, array, index + 1, size - index - 1);
        array[index] = element;
    }

    /**
     * Removes the element at the specified position in this list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    @Override
    public E remove(int index) {
        if (!isAvailableIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        E tmp = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return tmp;
    }

    // Search Operations

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if ((o == null && array[i] == null) || (array[i] != null && array[i].equals(o))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the highest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if ((o == null && array[i] == null) || (array[i] != null && array[i].equals(o))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Sets the special condition for obtain element by iterator.
     * @param condition special condition for obtain element by iterator
     */
    public void setCondition(Predicate<E> condition) {
        this.condition = condition;
    }

    // List Iterators

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence).
     *
     * @return a list iterator over the elements in this list (in proper
     *         sequence)
     */
    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list.
     * The specified index indicates the first element that would be
     * returned by an initial call to {@link ListIterator#next next}.
     * An initial call to {@link ListIterator#previous previous} would
     * return the element with the specified index minus one.
     *
     * @param index index of the first element to be returned from the
     *        list iterator (by a call to {@link ListIterator#next next})
     * @return a list iterator over the elements in this list (in proper
     *         sequence), starting at the specified position in the list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index > size()})
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    // View

    /**
     * Returns a view of the portion of this list between the specified
     * <tt>fromIndex</tt>, inclusive, and <tt>toIndex</tt>, exclusive.  (If
     * <tt>fromIndex</tt> and <tt>toIndex</tt> are equal, the returned list is
     * empty.)  The returned list is backed by this list, so non-structural
     * changes in the returned list are reflected in this list, and vice-versa.
     * The returned list supports all of the optional list operations supported
     * by this list.<p>
     *
     * This method eliminates the need for explicit range operations (of
     * the sort that commonly exist for arrays).  Any operation that expects
     * a list can be used as a range operation by passing a subList view
     * instead of a whole list.  For example, the following idiom
     * removes a range of elements from a list:
     * <pre>{@code
     *      list.subList(from, to).clear();
     * }</pre>
     * Similar idioms may be constructed for <tt>indexOf</tt> and
     * <tt>lastIndexOf</tt>, and all of the algorithms in the
     * <tt>Collections</tt> class can be applied to a subList.<p>
     *
     * The semantics of the list returned by this method become undefined if
     * the backing list (i.e., this list) is <i>structurally modified</i> in
     * any way other than via the returned list.  (Structural modifications are
     * those that change the size of this list, or otherwise perturb it in such
     * a fashion that iterations in progress may yield incorrect results.)
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     *         (<tt>fromIndex &lt; 0 || toIndex &gt; size ||
     *         fromIndex &gt; toIndex</tt>)
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }


    /*
        Iterator implementation
     */
    private class IteratorImpl implements Iterator<E> {
        /**
         * The current position on array
         */
        int pos;

        /**
         * The flag for check the sequence of operation:
         *      1) next()
         *      2) remove()
         */
        boolean nextFlag;

        /**
         * The special condition for obtain element by iterator
         */
        Predicate<E> condition;

        public IteratorImpl() {
            this.pos = -1;
            this.nextFlag = false;
            this.condition = MyListImpl.this.condition;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element which satisfied {@link #condition} rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            int tmpPos = pos;
            while (array != null && tmpPos + 1 < size) {
                if (condition.test(array[tmpPos + 1])) {
                    return true;
                } else {
                    tmpPos++;
                }
            }
            return false;
        }

        /**
         * Returns the next element in the iteration which satisfied {@link #condition}
         *
         * @return the next element in the iteration which satisfied {@link #condition}
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (hasNext()) {
                while (array != null && pos + 1 < size) {
                    if (condition.test(array[pos + 1])) {
                        pos++;
                        break;
                    } else {
                        pos++;
                    }
                }
                nextFlag = true;
                return array[pos];
            }
            throw new NoSuchElementException();
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.  The behavior of an iterator
         * is unspecified if the underlying collection is modified while the
         * iteration is in progress in any way other than by calling this
         * method.
         *
         * @throws IllegalStateException if the {@code next} method has not
         *         yet been called, or the {@code remove} method has already
         *         been called after the last call to the {@code next}
         *         method
         */
        @Override
        public void remove() {
            if (!nextFlag) {
                throw new IllegalStateException();
            }
            pos--;
            System.arraycopy(array, pos + 1, array, pos, size - pos - 1);
            size--;
            nextFlag = false;
        }
    }
}
