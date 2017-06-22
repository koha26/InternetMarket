package com.gadgets.listImpl;

import java.lang.reflect.Array;
import java.util.*;

public class MyListImpl<E> implements List<E> {

    private E[] array;
    private int capacity;
    private int size;

    private static final int DEFAULT_CAPACITY = 6;

    public MyListImpl() {
        init();
    }

    public MyListImpl(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.array = (E[]) new Object[capacity];
    }

    public MyListImpl(E[] array) {
        this.array = array;
        this.size = array.length;
        this.capacity = size * 5 / 3;
        this.array = (E[]) new Object[capacity];
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }
    }

    private void init() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return array == null || size == 0;
    }

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

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] copy = ((Object) a.getClass() == (Object) Object[].class)
                ? (T[]) new Object[size]
                : (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        System.arraycopy(array, 0, copy, 0, size);
        return copy;
    }

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

    @Override
    public boolean remove(Object o) {
        if (isEmpty()){
            return false;
        }
        for (int i = 0; i < size; i++) {
            if ((o == null && array[i] == null)
                    || (array[i] != null && array[i].equals(o))) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (isEmpty()){
            return false;
        }
        for (Object o :c) {
            if (!contains(o)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e :c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for (E e :c) {
            add(++index, e);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean res = false;
        for (int i = 0; i < c.size(); i++) {
            while (remove(c.toArray()[i])){
                res = true;
            }
        }
        return res;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = false;
        boolean res = false;
        for (E e: array) {
            for (Object o :c) {
                if ((o == null && e == null) || (e != null && e.equals(o))){
                    flag = true;
                    break;
                }
            }
            if (flag){
                remove(e);
                flag = false;
                res = true;
            }
        }
        return res;
    }

    @Override
    public void clear() {
        init();
    }

    private boolean isAvailableIndex(int index){
        if (index < 0 || index > size){
            return false;
        }
        return true;
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        if (!isAvailableIndex(index)){
            throw new IndexOutOfBoundsException();
        }
        E tmp = array[index];
        array[index] = element;
        return tmp;
    }

    @Override
    public void add(int index, E element) {
        if (!isAvailableIndex(index)){
            throw new IndexOutOfBoundsException();
        }
        array = Arrays.copyOf(array, ++size);
        System.arraycopy(array, index, array, index+1, size - index - 1);
        array[index] = element;
    }

    @Override
    public E remove(int index) {
        if (!isAvailableIndex(index)){
            throw new IndexOutOfBoundsException();
        }
        E tmp = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return tmp;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if ((o == null && array[i] == null) || (array[i] != null && array[i].equals(o))){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if ((o == null && array[i] == null) || (array[i] != null && array[i].equals(o))){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }


    /*
        Iterator implementation
     */
    private class IteratorImpl implements Iterator<E>{
        int pos;
        boolean nextFlag;

        public IteratorImpl() {
            this.pos = -1;
            this.nextFlag = false;
        }

        @Override
        public boolean hasNext() {
            if (array != null && pos+1 < size){
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            if (hasNext()){
                nextFlag = true;
                return array[++pos];
            }
            throw new IllegalStateException();
        }

        @Override
        public void remove() {
            if (!nextFlag){
                throw new IllegalStateException();
            }
            MyListImpl.this.remove(pos--);
            nextFlag = false;
        }
    }
}
