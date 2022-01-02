package p1500_;

/**
 * @author half-dead
 */
public class Puzzle1381 {

    class CustomStack {
        int[] data;
        int capacity;
        int pos = 0;

        public CustomStack(int maxSize) {
            capacity = maxSize;
            data = new int[capacity];
        }

        public void push(int x) {
            if (pos < capacity) data[pos++] = x;
        }

        public int pop() {
            return pos > 0 ? data[--pos] : -1;
        }

        public void increment(int k, int val) {
            for (int i = 0; i < Math.min(pos, k); i++)
                data[i] += val;
        }
    }

}
