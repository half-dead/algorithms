package p2500_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/sum-of-k-mirror-numbers/
 *
 * @author half-dead
 */
public class Puzzle2081 {
    public static void main(String[] args) {
        Solution s = new Puzzle2081().new Solution();
        System.out.println(s.kMirror(7, 30));
    }

    class Solution {
        public long kMirror(int k, int n) {
            Set<Integer> set = new HashSet<>(Arrays.asList(9, 99, 999, 9999,
                    99999, 999999, 9999999, 99999999, 999999999));

            long res = 0L;
            int base = 1;
            boolean odd = true;
            int cnt = 0;
            while (n > 0) {
                long cand = gen(base, odd);
                if (check(cand, k)) {
                    n--;
                    res += cand;
                }
                base++;
                if (set.contains(base - 1)) {
                    odd = !odd;
                    if (!odd) base /= 10;
                }
                cnt++;
            }
            System.out.println(cnt);
            return res;
        }

        long gen(int base, boolean odd) {
            long res = base;
            if (odd) base /= 10;
            while (base > 0) {
                res = res * 10 + (base % 10);
                base /= 10;
            }
            return res;
        }

        // much faster than string
        boolean check(long num, int k) {
            long div = 1L;
            while (div * k <= num) div *= k;

            for (; num > 0; div /= (long) k * k) {
                if ((num / div) != num % k) return false;
                num = (num - (num / div) * div - (num % k)) / k;
            }
            return true;
        }
    }
}
