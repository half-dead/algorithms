package p1500_;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/print-in-order/
 *
 * @author half-dead
 */
public class Puzzle1114_PrintInOrder {


    class Foo {

        Semaphore s2, s3;

        public Foo() {
            s2 = new Semaphore(0);
            s3 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            s2.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            s2.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            s3.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            s3.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    class AtomicIntegerFoo {

        private AtomicInteger state = new AtomicInteger(0);

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            state.set(1);
        }

        public void second(Runnable printSecond) throws InterruptedException {

            while (state.get() != 1) {
                TimeUnit.MILLISECONDS.sleep(1);
            }

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();

            state.set(2);
        }

        public void third(Runnable printThird) throws InterruptedException {

            while (state.get() != 2) {
                TimeUnit.MILLISECONDS.sleep(1);
            }

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
