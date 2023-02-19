package gb.homeworks.arraylist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MyArrayListTest {

    @Test
    public void testArray(){
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        System.out.println(myArrayList);
//        ArrayList (size= 0, length=10) - [  ]
        testAdding(myArrayList);
//        ArrayList (size= 5, length=10) - [ 5, 1, 4, 2, 3 ]

        testAddingAndGrow(myArrayList);
//        ArrayList (size= 10, length=16) - [ 9, 5, 1, 4, 2, 3, 6, 10, 7, 8 ]

        System.out.println("Replaced value was " + myArrayList.set(4, 0));
//        Replaced value was 2
        System.out.println(myArrayList);
//        ArrayList (size= 10, length=16) - [ 9, 5, 1, 4, 0, 3, 6, 10, 7, 8 ]

        System.out.println("Removed 1th value was " + myArrayList.remove(0));
//        Removed 1th value was 9
        System.out.println("Removed 9th value was " + myArrayList.remove(8));
//        Removed 9th value was 8
        System.out.println("Removed 6th value was " + myArrayList.remove(5));
//        Removed 6th value was 6
        System.out.println(myArrayList);
//        ArrayList (size= 7, length=16) - [ 5, 1, 4, 0, 3, 10, 7 ]

        Object[] toArray = myArrayList.toArray();
        System.out.printf("copied array's length is %d - %s\n", toArray.length, Arrays.toString(toArray));
//        copied array's length is 7 - [5, 1, 4, 0, 3, 10, 7]

        testRemoveAndTrim(myArrayList);
//        ArrayList (size= 2, length=10) - [ 10, 7 ]

    }

    private static void testRemoveAndTrim(MyArrayList<Integer> myArrayList) {
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);
        System.out.println(myArrayList);
    }

    private static void testAddingAndGrow(MyArrayList<Integer> myArrayList) {
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(0, 9);
        myArrayList.add(7, 10);
        System.out.println(myArrayList);
//        ArrayList (size= 10, length=16) - [ 9, 5, 1, 4, 2, 3, 6, 10, 7, 8 ]
    }

    private static void testAdding(MyArrayList<Integer> myArrayList) {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(1, 4);
        myArrayList.add(0, 5);
        System.out.println(myArrayList);
//        ArrayList (size= 5, length=10) - [ 5, 1, 4, 2, 3 ]
    }

}