package p1500_;

/**
 * @author half-dead
 */
public class Puzzle1415 {
    class Solution {
        public String getHappyString(int n, int k) {
            int max = 3, m = 1;
            while (++m <= n) {
                max *= 2;
            }
            if (k > max) {
                return "";
            }

            int oneThird = max / 3, left, right;
            char prev = ' ';
            if (k <= oneThird) {
                prev = 'a';
                left = 1;
                right = oneThird;
            } else if (k <= 2 * oneThird) {
                prev = 'b';
                left = oneThird + 1;
                right = 2 * oneThird;
            } else {
                prev = 'c';
                left = 2 * oneThird + 1;
                right = max;
            }

            char[] res = new char[n];
            for (int i = 0; i < n; i++) {
                res[i] = prev;
                int mid = (left + right) / 2;
                boolean b = k <= mid;
                if (b) {
                    if (prev == 'a') prev = 'b';
                    else prev = 'a';
                    right = mid;
                } else {
                    if (prev == 'c') prev = 'b';
                    else prev = 'c';
                    left = mid + 1;
                }
            }
            return new String(res);
        }
    }
}
