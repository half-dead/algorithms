package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/query-kth-smallest-trimmed-number/
 *
 * @author half-dead
 */
public class Puzzle2343 {

    public static void main(String[] args) {
        Solution s = new Puzzle2343().new Solution();
        int[] ans = s.smallestTrimmedNumbers(
                new String[]{"102", "473", "251", "814"},
                new int[][]{{1, 1}, {2, 3}, {4, 2}, {1, 2}}
        );
        System.out.println(Arrays.toString(ans));
    }

    class Solution {
        public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
            int n = queries.length, m = nums.length;

            int[][] cq = new int[n][3];
            for (int i = 0; i < n; i++) {
                cq[i] = new int[]{queries[i][0], queries[i][1], i};
            }
            Arrays.sort(cq, (a, b) -> {
                return b[1] - a[1];
            });

            String[][] cnums = new String[m][2];
            for (int i = 0; i < m; i++) {
                cnums[i] = new String[]{nums[i], (1000 + i) + ""};
            }
            Arrays.sort(cnums, (a, b) -> {
                int d = a[0].compareTo(b[0]);
                return d != 0 ? d : a[1].compareTo(b[1]);
            });

            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                int k = cq[i][0] - 1, limit = cq[i][1], idx = cq[i][2];

                int before = cnums[0][0].length();
                if (limit < before) {
                    for (String[] s : cnums) {
                        s[0] = s[0].substring(before - limit, before);
                    }

                    Arrays.sort(cnums, (a, b) -> {
                        int d = a[0].compareTo(b[0]);
                        return d != 0 ? d : a[1].compareTo(b[1]);
                    });
                }
                res[idx] = Integer.parseInt(cnums[k][1]) - 1000;
            }

            return res;
        }
    }
}
