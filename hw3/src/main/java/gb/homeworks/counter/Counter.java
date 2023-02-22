package gb.homeworks.counter;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final int NUMBER_OF_THREADS = 5;

    public void countToX(int x){
        AtomicInteger counter = new AtomicInteger();

        Thread[] threads = new Thread[NUMBER_OF_THREADS];
        final Lock lock = new ReentrantLock();
        for (int i = 0; i <NUMBER_OF_THREADS ; i++) {
            threads[i] = new Thread(() -> {
                while (counter.get() < x) {
                    if (lock.tryLock()) {
                        try {
                            counter.getAndIncrement();
                            System.out.println("Thread " + Thread.currentThread().getName() + " increased counter to: " + counter.get());
                        } finally {
                            lock.unlock();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
        }
        for (Thread t:
             threads) {
            t.start();
        }
        while (counter.get() < x) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
