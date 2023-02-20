package gb.homeworks.linkedlist;

public class MyNode<E> {

    public E value;
    public MyNode<E> next;
    public MyNode<E> previous;

    public MyNode(E value, MyNode<E> next, MyNode<E> previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "{ " + value + " }";
    }
}
