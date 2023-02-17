package gb.homeworks.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    public void testLinkedList(){
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.display();

        initValues(myLinkedList);

        searching(myLinkedList);

        removing(myLinkedList);

//        вывод на консоль:
//
//        LinkedList is empty...
//        LinkedList (1): - { a } -
//        LinkedList (2): - { b } - { a } -
//        LinkedList (3): - { b } - { a } - { c } -
//        LinkedList (4): - { d } - { b } - { a } - { c } -
//        LinkedList (5): - { d } - { b } - { a } - { c } - { e } -
//        LinkedList (6): - { f } - { d } - { b } - { a } - { c } - { e } -
//        LinkedList contains 'a'? true
//        LinkedList contains 'z'? false
//        LinkedList (5): - { d } - { b } - { a } - { c } - { e } -
//        LinkedList (4): - { b } - { a } - { c } - { e } -
//        current first: b
//        LinkedList (3): - { b } - { a } - { c } -
//        current last: c
//        trying to remove 'a': true
//        LinkedList (2): - { b } - { c } -
//        trying to remove 'a': false
//        LinkedList (2): - { b } - { c } -
//        LinkedList (1): - { c } -
//        LinkedList is empty...

    }

    private static void searching(MyLinkedList<String> myLinkedList) {
        System.out.println("LinkedList contains 'a'? " + myLinkedList.contains("a"));
        System.out.println("LinkedList contains 'z'? " + myLinkedList.contains("z"));
    }

    private static void removing(MyLinkedList<String> myLinkedList) {
        myLinkedList.removeFirst();
        myLinkedList.display();
        myLinkedList.removeFirst();
        myLinkedList.display();
        System.out.println("current first: " + myLinkedList.getFirst());
        myLinkedList.removeLast();
        myLinkedList.display();
        System.out.println("current last: " + myLinkedList.getLast());
        System.out.println("trying to remove 'a': " + myLinkedList.remove("a"));
        myLinkedList.display();
        System.out.println("trying to remove 'a': " + myLinkedList.remove("a"));
        myLinkedList.display();
        myLinkedList.removeFirst();
        myLinkedList.display();
        myLinkedList.removeFirst();
        myLinkedList.display();

    }

    private static void initValues(MyLinkedList<String> myLinkedList) {
        myLinkedList.insertLast("a");
        myLinkedList.display();
        myLinkedList.insertFirst("b");
        myLinkedList.display();
        myLinkedList.insertLast("c");
        myLinkedList.display();
        myLinkedList.insertFirst("d");
        myLinkedList.display();
        myLinkedList.insertLast("e");
        myLinkedList.display();
        myLinkedList.insertFirst("f");
        myLinkedList.display();
    }

}