package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/three-equal-parts/
 *
 * @author half-dead
 */
public class Puzzle927 {

    public static void main(String[] args) {
        Solution s = new Puzzle927().new Solution();
        System.out.println(Arrays.toString(s.threeEqualParts(new int[]{0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1})));
    }

    class Solution {
        public int[] threeEqualParts(int[] arr) {
            int n = arr.length, cnt1 = 0, a = -1, b = -1;
            for (int x : arr) cnt1 += x;
            if (cnt1 % 3 != 0) return new int[]{a, b};

            cnt1 /= 3;
            for (int i = n - 1; i >= 0; i--) {
                cnt1 -= arr[i];
                if (cnt1 == 0) {
                    b = i;
                    break;
                }
            }

            StringBuilder sb = new StringBuilder(n);
            for (int x : arr) sb.append(x);

            String s = sb.toString(), third = s.substring(b, n);

            a = s.indexOf(third);
            if (a >= 0 && a + 2 * third.length() <= b) {
                int second = s.indexOf(third, a + third.length());
                if (second >= 0 && second + third.length() <= b) {
                    return new int[]{a + third.length() - 1, second + third.length()};
                }
            }
            return new int[]{-1, -1};
        }
    }
}
