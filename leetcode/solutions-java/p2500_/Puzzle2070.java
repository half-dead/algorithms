package p2500_;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/most-beautiful-item-for-each-query/
 *
 * @author half-dead
 */
public class Puzzle2070 {

    public static void main(String[] args) {
        Solution s = new Puzzle2070().new Solution();
        System.out.println(Arrays.toString(s.maximumBeauty(
                new int[][]{{1, 2}},
                new int[]{1, 2}
        )));

    }

    // sort + binary search
    class Solution {
        public int[] maximumBeauty(int[][] items, int[] queries) {
            Arrays.sort(items, (a, b) -> a[0] - b[0]);

            int m = items.length, i = 0, max = 0;
            int[] ps = new int[m + 1], bs = new int[m + 1];
            for (int[] item : items) {
                int price = item[0], beauty = item[1];
                max = Math.max(max, beauty);

                if (price > ps[i]) {
                    ps[++i] = price;
                }
                bs[i] = max;
            }

            int n = queries.length;
            int[] ans = new int[n];
            for (int j = 0; j < n; j++) {
                int q = queries[j];
                int pos = Arrays.binarySearch(ps, 0, i + 1, q);

                if (pos < 0) pos = -pos - 1;

                if (pos > m || ps[pos] > q || pos > i) pos--;

                ans[j] = bs[pos];
            }
            return ans;
        }
    }

    // sort + treemap
    class Solution1 {
        public int[] maximumBeauty(int[][] items, int[] queries) {
            Arrays.sort(items, (a, b) -> a[0] - b[0]);

            TreeMap<Integer, Integer> tm = new TreeMap<>();
            tm.put(0, 0);

            for (int[] item : items) {
                int price = item[0], beauty = item[1];
                int max = Math.max(tm.lastEntry().getValue(), tm.getOrDefault(price, 0));
                tm.put(price, Math.max(max, beauty));
            }

            int n = queries.length;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                int key = tm.floorKey(queries[i]);
                ans[i] = tm.get(key);
            }
            return ans;
        }
    }
}
