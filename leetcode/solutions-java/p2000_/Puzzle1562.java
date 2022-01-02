package p2000_;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/find-latest-group-of-size-m/
 *
 * @author half-dead
 */
public class Puzzle1562 {

    public static void main(String[] args) {
        Solution1 s = new Puzzle1562().new Solution1();
        s.findLatestStep(new int[]{3, 5, 1, 2, 4}, 1);
    }

    class Solution {
        public int findLatestStep(int[] arr, int m) {
            if (m == arr.length) return m;
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            tm.put(1, arr.length);
            for (int i = arr.length - 1; i >= 0; i--) {
                int cut = arr[i], right;
                Integer left = tm.floorKey(cut);
                if (left == null || cut > (right = tm.get(left))) {
                    continue;
                }
                tm.remove(left);

                if (cut - 1 - left == m - 1 || right - cut - 1 == m - 1) {
                    return i;
                }
                if (cut - left > m) tm.put(left, cut - 1);
                if (right - cut > m) tm.put(cut + 1, right);

            }
            return -1;
        }
    }

    class Solution1 {
        public int findLatestStep(int[] arr, int m) {
            int res = -1, len = arr.length;
            if (len == m) return len;

            int[] groups = new int[len + 2];
            for (int i = 0; i < len; ++i) {
                int a = arr[i], left = groups[a - 1], right = groups[a + 1];
                groups[a - left] = groups[a + right] = left + right + 1;
                if (left == m || right == m)
                    res = i;
            }
            return res;
        }
    }
}
