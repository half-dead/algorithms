package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-frequency-stack/
 *
 * @author half-dead
 */
public class Puzzle895 {

    class FreqStack {

        Map<Integer, Integer> freq = new HashMap<>();
        List<LinkedList<Integer>> list = new ArrayList<>();

        public FreqStack() {

        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            if (list.size() < f) {
                list.add(new LinkedList<>());
            }
            list.get(f - 1).addLast(x);
        }

        public int pop() {
            LinkedList<Integer> slot = list.get(list.size() - 1);
            int res = slot.pollLast();
            if (slot.size() == 0) {
                list.remove(list.size() - 1);
            }
            freq.put(res, freq.get(res) - 1);
            return res;
        }
    }

}
