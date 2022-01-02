package p1500_;

import java.util.*;

/**
 * https://leetcode.com/problems/dinner-plate-stacks/
 *
 * @author half-dead
 */
public class Puzzle1172 {

    class DinnerPlates {

        int capacity;
        List<LinkedList<Integer>> stacks;
        TreeMap<Integer, Integer> tm;
        PriorityQueue<Integer> pq;

        public DinnerPlates(int capacity) {
            this.capacity = capacity;
            stacks = new ArrayList<>();
            tm = new TreeMap<>();
            pq = new PriorityQueue<>();
        }

        public void push(int val) {
            if (pq.size() > 0) {
                int index = pq.poll();
                Deque<Integer> dq = stacks.get(index);
                dq.push(val);
                tm.put(index, dq.size());
                return;
            }

            if (stacks.size() == 0 || stacks.get(stacks.size() - 1).size() == capacity) {
                stacks.add(new LinkedList<>());
            }
            int index = stacks.size() - 1;
            Deque<Integer> dq = stacks.get(index);
            dq.push(val);
            tm.put(index, dq.size());
        }

        public int pop() {
            if (tm.size() == 0) return -1;

            int index = tm.lastKey();
            Deque<Integer> dq = stacks.get(index);
            int res = dq.pop();
            if (dq.size() == 0) {
                tm.remove(index);
            } else {
                tm.replace(index, dq.size());
            }
            return res;
        }

        public int popAtStack(int index) {
            if (tm.size() == 0 || tm.getOrDefault(index, 0) == 0) return -1;

            Deque<Integer> dq = stacks.get(index);
            int res = dq.pop();
            if (dq.size() == 0) {
                tm.remove(index);
            } else {
                tm.replace(index, dq.size());
            }
            pq.offer(index);
            return res;
        }
    }
}
