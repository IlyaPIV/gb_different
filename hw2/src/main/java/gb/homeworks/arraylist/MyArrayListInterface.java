package gb.homeworks.arraylist;

public interface MyArrayListInterface<E> {

    public int size();

    public boolean isEmpty();

    public int indexOf(E o);

    public Object[] toArray();

    public void add(E value);
    public void add(int index, E value);
    public E get(int index);
    public E set(int index, E value);
    public E remove(int index);
    public void clear();


}
