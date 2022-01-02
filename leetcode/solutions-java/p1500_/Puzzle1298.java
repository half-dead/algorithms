package p1500_;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/
 *
 * @author half-dead
 */
public class Puzzle1298 {

    // BFS
    class Solution {
        public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

            Deque<Integer> q = new LinkedList<>();
            Set<Integer> keysAcquired = new HashSet<>(), lockedBoxes = new HashSet<>();
            for (int box : initialBoxes) {
                if (status[box] == 1) q.addLast(box);
                else lockedBoxes.add(box);
            }

            int res = 0;
            while (q.size() > 0) {
                int box = q.pollFirst();

                // take candies
                res += candies[box];

                // take keys
                for (int k : keys[box]) keysAcquired.add(k);

                // take containedBoxes
                for (int cb : containedBoxes[box]) {
                    if (status[cb] == 1) q.addLast(cb);
                    else lockedBoxes.add(cb);
                }

                // open locked boxes
                Set<Integer> keysUsed = new HashSet<>();
                for (int key : keysAcquired) {
                    if (lockedBoxes.contains(key)) {
                        lockedBoxes.remove(key);
                        q.addLast(key);
                        keysUsed.add(key);
                    }
                }
                keysAcquired.removeAll(keysUsed);
            }
            return res;
        }
    }
}
