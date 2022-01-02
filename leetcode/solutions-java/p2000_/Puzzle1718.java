package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
 *
 * @author half-dead
 */
public class Puzzle1718 {

    public static void main(String[] args) {
        Solution s = new Puzzle1718().new Solution();
        for (int i = 1; i <= 20; i++)
            System.out.println(Arrays.toString(s.constructDistancedSequence(i)));
    }

    class Solution {
        public int[] constructDistancedSequence(int n) {
            int len = n * 2 - 1;
            int[] res = new int[len];
            bt(res, new boolean[n + 1], n, 0, len);
            return res;
        }

        boolean bt(int[] res, boolean[] used, int n, int i, int len) {
            while (i < len && res[i] != 0) i++;
            if (i == len) return true;

            for (int m = n; m > 0; m--) {
                if (used[m]) continue;
                if (m > 1 && i + m >= len) return false;
                if (m > 1 && res[i + m] != 0) continue;

                used[m] = true;
                int j = m > 1 ? i + m : i;
                res[i] = res[j] = m;

                if (bt(res, used, n, i + 1, len)) return true;

                used[m] = false;
                res[i] = res[j] = 0;
            }
            return false;
        }
    }
}
