package p1000_;

/**
 * https://leetcode.com/problems/design-circular-queue/
 *
 * @author half-dead
 */
public class Puzzle622 {

    class MyCircularQueue {
        private int[] q;
        private int size, first, last;

        public MyCircularQueue(int k) {
            q = new int[k];
            size = k;
            first = last = -1;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            last = (last + 1) % size;
            q[last] = value;
            if (first == -1) first = last;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            if (first == last) first = last = -1;
            else first = (first + 1) % size;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : q[first];
        }

        public int Rear() {
            return isEmpty() ? -1 : q[last];
        }

        public boolean isEmpty() {
            return first == -1;
        }

        public boolean isFull() {
            return (last + 1) % size == first;
        }
    }

}
