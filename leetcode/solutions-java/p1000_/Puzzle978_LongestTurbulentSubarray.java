package p1000_;

/**
 * https://leetcode.com/problems/longest-turbulent-subarray/
 *
 * @author half-dead
 */
public class Puzzle978_LongestTurbulentSubarray {

    public static void main(String[] args) {
        Solution s = new Puzzle978_LongestTurbulentSubarray().new Solution();
        int r = s.maxTurbulenceSize(new int[]{
                8, 8, 9, 10, 6, 8, 2, 4, 2, 2, 10, 6, 6, 10, 10, 2, 3, 5, 1,
                2, 10, 4, 2, 0, 9, 4, 9, 3, 0, 6, 3, 2, 3, 10, 10, 6, 4, 6,
                4, 4, 2, 5, 1, 4, 1, 1, 9, 8, 9, 5, 3, 5, 5, 4, 5, 5, 6, 5,
                3, 3, 7, 2, 0, 10, 9, 7, 7, 3, 5, 1, 0, 9, 6, 3, 1, 3, 4, 4,
                3, 6, 3, 2, 1, 4, 10, 2, 3, 4, 4, 3, 6, 7, 6, 2, 1, 7, 0, 6, 8, 10
        });
        System.out.println(r);
    }

    class Solution {
        public int maxTurbulenceSize(int[] a) {
            int max = 0;
            for (int i = 0; i < a.length - 1; ) {
                while (i < a.length - 1 && a[i] == a[i + 1]) {
                    i++;
                }

                if (i < a.length - 1) {
                    int size = 2;
                    boolean more = a[i] - a[i + 1] > 0;
                    i++;
                    while (i < a.length - 1 && a[i] != a[i + 1] && a[i] - a[i + 1] > 0 == !more) {
                        more = !more;
                        i++;
                        size++;
                    }
                    max = Math.max(max, size);
                }
            }
            return Math.max(1, max);
        }
    }

    class Solution1 {
        public int maxTurbulenceSize(int[] A) {
            int inc = 1, dec = 1, result = 1;
            for (int i = 1; i < A.length; i++) {
                if (A[i] < A[i - 1]) {
                    dec = inc + 1;
                    inc = 1;
                } else if (A[i] > A[i - 1]) {
                    inc = dec + 1;
                    dec = 1;
                } else {
                    inc = 1;
                    dec = 1;
                }
                result = Math.max(result, Math.max(dec, inc));
            }
            return result;
        }
    }
}
