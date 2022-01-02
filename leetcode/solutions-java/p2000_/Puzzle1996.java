package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
 *
 * @author half-dead
 */
public class Puzzle1996 {

    // BucketSort + greedy
    class Solution {
        public int numberOfWeakCharacters(int[][] props) {
            int res = 0, maxA = 0;
            for (int[] p : props) maxA = Math.max(maxA, p[0]);

            int[] maxD = new int[maxA + 1];
            for (int[] p : props) maxD[p[0]] = Math.max(maxD[p[0]], p[1]);

            for (int i = maxA - 1; i > 0; i--) maxD[i] = Math.max(maxD[i], maxD[i + 1]);

            for (int[] p : props)
                if (p[0] < maxA && p[1] < maxD[p[0] + 1]) res++;

            return res;
        }
    }

    // sort + greedy
    class SortSolution {
        public int numberOfWeakCharacters(int[][] p) {
            Arrays.sort(p, (a, b) -> b[0] - a[0]);
            int res = 0, n = p.length, maxA = p[0][0], maxD = 0, currD = p[0][1];
            for (int i = 1; i < n; i++) {
                int a = p[i][0], d = p[i][1];
                if (a == maxA) {
                    currD = Math.max(currD, d);
                } else {
                    maxD = Math.max(maxD, currD);
                    currD = d;
                    maxA = a;
                }
                if (d < maxD) res++;
            }
            return res;
        }
    }
}
