package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 *
 * @author half-dead
 */
public class Puzzle373 {

    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] num2, int k) {
            int len1 = nums1.length, len2 = num2.length;
            k = Math.min(k, len1 * len2);
            List<List<Integer>> res = new ArrayList<>();
            if (k == 0) return res;

            boolean[][] seen = new boolean[len1][len2];
            PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(p -> nums1[p[0]] + num2[p[1]]));
            q.offer(new int[]{0, 0});
            seen[0][0] = true;
            while (k-- > 0) {
                int[] p = q.poll();
                res.add(Arrays.asList(nums1[p[0]], num2[p[1]]));

                int np0 = p[0] + 1, np1 = p[1] + 1;
                if (np0 < len1 && !seen[np0][p[1]]) {
                    seen[np0][p[1]] = true;
                    q.offer(new int[]{np0, p[1]});
                }
                if (np1 < len2 && !seen[p[0]][np1]) {
                    seen[p[0]][np1] = true;
                    q.offer(new int[]{p[0], np1});
                }
            }
            return res;
        }
    }
}
