package p1500_;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/building-h2o/
 *
 * @author half-dead
 */
public class Puzzle1117_BuildingH2O {


    class H2O {

        Semaphore h = new Semaphore(2);
        Semaphore o = new Semaphore(0);

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

            h.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            o.release();

        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire(2);
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            h.release(2);
        }
    }

    class AtomicIntegerH2O {

        AtomicInteger h = new AtomicInteger(0);

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

            while (h.get() == 2) {
                TimeUnit.MILLISECONDS.sleep(1);
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            h.incrementAndGet();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            while (h.get() != 2) {
                TimeUnit.MILLISECONDS.sleep(1);
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            h.set(0);
        }
    }
}
