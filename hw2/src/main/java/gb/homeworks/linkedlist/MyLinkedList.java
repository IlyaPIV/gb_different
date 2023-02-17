package gb.homeworks.linkedlist;

public class MyLinkedList<E> implements MyLinkedListInterface<E>{
    private int size;

    private MyNode<E> first;
    private MyNode<E> last;

    @Override
    public void insertFirst(E value) {
        MyNode<E> newNode = new MyNode<>(value, first, null);
        if (size == 0) {
            last = newNode;
        } else {
            first.previous = newNode;
        }
        first = newNode;
        size++;
    }

    @Override
    public void insertLast(E value) {
        MyNode<E> newNode = new MyNode<>(value, null, last);
        if (size == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    @Override
    public E getFirst() {
        return first.value;
    }

    @Override
    public E getLast() {
        return last.value;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;

        MyNode<E> removed = first;
        size--;
        first = first.next;
        if (size != 0) first.previous = null;
        removed.next = null;


        return removed.value;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        size--;
        MyNode<E> removed = last;
        last = last.previous;
         if (size != 0) last.next = null;
        removed.previous = null;

        return null;
    }

    @Override
    public boolean remove(E value) {
        MyNode<E> current = first;
        MyNode<E> previous = null;

        while (current != null) {
            if (current.value.equals(value)) break;

            previous = current;
            current = current.next;
        }

        if (current == null) return false;

        if (current == first) {
            removeFirst();
            return true;
        }

        if (current == last) {
            removeLast();
            return true;
        }

        previous.next = current.next;
        current.next.previous = previous;
        current.previous = null;
        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        MyNode<E> current = first;

        while (current.next != null) {
            if (current.value.equals(value)) return true;
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        if (size() == 0) {
            System.out.println("LinkedList is empty...");
        } else {
            MyNode<E> current = first;
            System.out.print("LinkedList (" + size + "): - ");
            while (current != null) {
                System.out.print(current);
                current = current.next;
                System.out.print(" - ");
            }
            System.out.println();
        }
    }
}
