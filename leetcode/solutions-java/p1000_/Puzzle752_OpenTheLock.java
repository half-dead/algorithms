package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/open-the-lock/
 *
 * @author half-dead
 */
public class Puzzle752_OpenTheLock {
    public static void main(String[] args) {
        Solution s = new Puzzle752_OpenTheLock().new Solution();
        int step = s.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888");
        System.out.println(step);
    }

    class Solution {
        public int openLock(String[] deadends, String target) {
            int n = 10000;
            boolean[] pits = new boolean[n];
            Arrays.fill(pits, true);
            for (String deadend : deadends) pits[Integer.parseInt(deadend)] = false;

            if (!pits[0]) return -1;

            int t = Integer.parseInt(target);
            boolean[] from = new boolean[n], to = new boolean[n];
            from[0] = true;
            to[t] = true;

            for (int loop = 0; loop < 10; loop++) {
                if (cross(from, to)) return loop * 2;
                if (turn(from, pits, n) == 0) return -1;
                if (cross(from, to)) return loop * 2 + 1;
                if (turn(to, pits, n) == 0) return -1;
            }
            return -1;
        }

        private int turn(boolean[] arr, boolean[] deadends, int n) {
            boolean[] next = new boolean[n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i]) {
                    int[] neighbours = new int[]{
                            (i + 1000) % n, (i + 9000) % n,
                            1000 * (i / 1000) + ((i + 100) % 1000), 1000 * (i / 1000) + ((i + 900) % 1000),
                            100 * (i / 100) + ((i + 10) % 100), 100 * (i / 100) + ((i + 90) % 100),
                            10 * (i / 10) + ((i + 1) % 10), 10 * (i / 10) + ((i + 9) % 10)
                    };
                    for (int j = 0; j < neighbours.length; j++) {
                        if (deadends[neighbours[j]]) {
                            next[neighbours[j]] = deadends[neighbours[j]];
                            count++;
                        }
                    }
                }
            }

            System.arraycopy(next, 0, arr, 0, n);
            return count;
        }

        private boolean cross(boolean[] arr1, boolean[] arr2) {
            for (int i = 0; i < arr1.length; i++)
                if (arr1[i] && arr2[i]) return true;
            return false;
        }
    }
}
