package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/sequentially-ordinal-rank-tracker/
 *
 * @author half-dead
 */
public class Puzzle2102 {

    class SORTracker {

        PriorityQueue<SL> left, right;
        int cnt = 0;

        public SORTracker() {
            left = new PriorityQueue<>(Comparator.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(String name, int score) {
            left.offer(new SL(name, score));
            if (left.size() > cnt)
                right.offer(left.poll());
        }

        public String get() {
            left.offer(right.poll());
            cnt++;
            return left.peek().name;
        }
    }

    class SL implements Comparable<SL> {
        String name;
        int score;

        SL(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int compareTo(SL o) {
            int d = o.score - score;
            if (d != 0) return d;
            return name.compareTo(o.name);
        }
    }

}
