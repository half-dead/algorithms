package p2500_;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/smallest-number-in-infinite-set/
 *
 * @author half-dead
 */
public class Puzzle2336 {
    class SmallestInfiniteSet {

        int min = 1;
        TreeSet<Integer> ts = new TreeSet<>();

        public SmallestInfiniteSet() {

        }

        public int popSmallest() {
            if (ts.size() > 0) {
                int x = ts.first();
                ts.remove(x);
                return x;
            } else {
                return min++;
            }
        }

        public void addBack(int num) {
            if (num >= min) return;
            ts.add(num);
        }
    }

}
