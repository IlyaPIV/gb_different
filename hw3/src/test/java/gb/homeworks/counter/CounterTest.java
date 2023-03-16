package gb.homeworks.counter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @Test
    void countToX() {
        Counter counter = new Counter();
        counter.countToX(20);

//        Thread Thread-0 increased counter to: 1
//        Thread Thread-0 increased counter to: 2
//        Thread Thread-1 increased counter to: 3
//        Thread Thread-2 increased counter to: 4
//        Thread Thread-0 increased counter to: 5
//        Thread Thread-4 increased counter to: 6
//        Thread Thread-0 increased counter to: 7
//        Thread Thread-0 increased counter to: 8
//        Thread Thread-1 increased counter to: 9
//        Thread Thread-4 increased counter to: 10
//        Thread Thread-0 increased counter to: 11
//        Thread Thread-4 increased counter to: 12
//        Thread Thread-1 increased counter to: 13
//        Thread Thread-0 increased counter to: 14
//        Thread Thread-2 increased counter to: 15
//        Thread Thread-3 increased counter to: 16
//        Thread Thread-1 increased counter to: 17
//        Thread Thread-3 increased counter to: 18
//        Thread Thread-0 increased counter to: 19
//        Thread Thread-4 increased counter to: 20
//
//        Process finished with exit code 0

    }
}