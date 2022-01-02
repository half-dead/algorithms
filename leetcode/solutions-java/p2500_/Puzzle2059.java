package p2500_;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-operations-to-convert-number/
 *
 * @author half-dead
 */
public class Puzzle2059 {

    // BFS
    class Solution {
        final int LO = 0, HI = 1000;

        public int minimumOperations(int[] nums, int start, int goal) {
            Set<Integer> seen = new HashSet<>(HI - LO + 1);
            seen.add(start);

            Deque<Integer> q = new LinkedList<>();
            q.addLast(start);

            int step = 0;
            while (q.size() > 0) {
                for (int i = q.size(); i > 0; i--) {
                    int x = q.pollFirst();
                    if (x < LO || x > HI) continue;

                    for (int v : nums) {
                        int plus = x + v, minus = x - v, xor = x ^ v;
                        if (plus == goal || minus == goal || xor == goal) return step + 1;

                        if (plus >= LO && plus <= HI && seen.add(plus)) q.addLast(plus);
                        if (minus >= LO && minus <= HI && seen.add(minus)) q.addLast(minus);
                        if (xor >= LO && xor <= HI && seen.add(xor)) q.addLast(xor);
                    }
                }
                step++;
            }
            return -1;
        }
    }
}
