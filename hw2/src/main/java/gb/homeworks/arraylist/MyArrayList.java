package gb.homeworks.arraylist;

import java.util.Arrays;

public class MyArrayList<E> implements MyArrayListInterface<E>{
    private final int DEFAULT_MINIMAL_SIZE = 10;
    private int size = 0;
    private E[] arr = (E[]) new Object[DEFAULT_MINIMAL_SIZE];

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, size);
    }

    @Override
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) return i;
        }
        return -1;
    }

    @Override
    public void add(E value) {
        arr[size] = value;
        size++;
        if (size == arr.length) grow();
    }

    private void grow() {
        int newLength = (int) ((arr.length * 1.5) + 1);
        arr = Arrays.copyOf(arr, newLength);
    }

    private void trim() {
        int newLength = (int) (arr.length / 4.0 + 1);
        newLength = Math.max(newLength, DEFAULT_MINIMAL_SIZE);
        arr = Arrays.copyOf(arr, newLength);
    }

    @Override
    public void add(int index, E value) {
        if (index >= size) throw new IndexOutOfBoundsException("Wrong index");

        E replacedValue = arr[index];
        arr[index] = value;
        size++;
        if (size == arr.length) grow();
        for (int i = index + 1; i <= size; i++) {
            E temp = arr[i];
            arr[i] = replacedValue;
            replacedValue = temp;
        }

    }

    @Override
    public E get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("Wrong index");

        return arr[index];
    }

    @Override
    public E set(int index, E value) {
        if (index >= size) throw new IndexOutOfBoundsException("Wrong index");

        E oldValue = arr[index];
        arr[index] = value;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("Wrong index");

        E removedValue = arr[index];
        for (int i = index; i < size; i++) {
            arr[i] = arr[i+1];
        }
        size--;
        if (arr.length / 4 > size) trim();

        return removedValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ArrayList (size= ")
                .append(size)
                .append(", length=")
                .append(arr.length)
                .append(") - [ ");

        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
            if (i < size-1) sb.append(", ");
        }
        return sb.append(" ]").toString();
    }
}
