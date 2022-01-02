package p2000_;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/stone-game-vi/
 *
 * @author half-dead
 */
public class Puzzle1686 {
    public static void main(String[] args) {
        Solution s = new Puzzle1686().new Solution();
        System.out.println(s.stoneGameVI(new int[]{9, 8, 3, 8}, new int[]{10, 6, 9, 5}));
    }

    // array + sort
    class Solution {
        public int stoneGameVI(int[] av, int[] bv) {
            int len = av.length, res = 0;
            for (int i = 0; i < len; i++) {
                res += av[i] - bv[i];
                av[i] += bv[i];
            }
            Arrays.sort(av);

            int i = len - 1;
            while (i > 0) {
                res += av[i] - av[i - 1];
                i -= 2;
            }
            if (i == 0) res += av[i];
            return Integer.compare(res, 0);
        }
    }

    // PriorityQueue
    class SolutionPQ {
        public int stoneGameVI(int[] aliceValues, int[] bobValues) {
            int len = aliceValues.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>(len, (a, b) -> b[0] - a[0]);
            for (int i = 0; i < len; i++) {
                pq.offer(new int[]{aliceValues[i] + bobValues[i], i});
            }
            boolean aliceTurn = true;
            int sa = 0, sb = 0;
            while (pq.size() > 0) {
                int[] top = pq.poll();
                if (aliceTurn) sa += aliceValues[top[1]];
                else sb += bobValues[top[1]];
                aliceTurn = !aliceTurn;
            }
            int res = sa - sb;
            if (res > 0) return 1;
            if (res < 0) return -1;
            return 0;
        }
    }
}
