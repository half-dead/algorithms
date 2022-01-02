package p0500_;

// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.

/**
 * https://leetcode.com/problems/min-stack/
 */
public class Puzzle155_MinStack {

    public static void main(String[] args) {
        Puzzle155_MinStack p = new Puzzle155_MinStack();
        MinStack stack = p.new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        stack.getMin();
        stack.pop();
        stack.getMin();
        stack.pop();
        stack.getMin();
        stack.pop();
        stack.getMin();
    }

    class MinStack {
        private int capacity = 16;
        private int[] values = new int[capacity];
        private int head = 0;
        private int min = Integer.MAX_VALUE;

        public void push(int x) {
            values[head++] = x;
            if (head == 1 || x < min) {
                min = x;
            }
            if (head == capacity) {
                capacity <<= 1;
                int[] newValues = new int[capacity];
                System.arraycopy(values, 0, newValues, 0, head);
                values = newValues;
            }
        }

        public void pop() {
            int val = values[--head];
            if (val == min) {
                int m = values[0];
                for (int i = 1; i < head; i++) {
                    if (values[i] < m) {
                        m = values[i];
                    }
                }
                min = m;
            }
        }

        public int top() {
            return values[head - 1];
        }

        public int getMin() {
            return min;
        }
    }

}
