package p2000_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-good-meals/
 *
 * @author half-dead
 */
public class Puzzle1711 {

    public static void main(String[] args) {
        Solution s = new Puzzle1711().new Solution();
        System.out.println(s.countPairs(new int[]{1, 3, 5, 7, 9}));
        System.out.println(s.countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));
    }

    class Solution {
        public int countPairs(int[] deliciousness) {
            Map<Integer, Long> tm = new HashMap<>();
            for (int d : deliciousness) tm.put(d, tm.getOrDefault(d, 0L) + 1);

            int mod = 1000000007, max = 1 << 20;
            long res = 0L;
            for (int m : tm.keySet()) {
                int n = 0;
                if (m == 0) n = 1;
                else if ((m & (m - 1)) == 0) n = m;
                else {
                    n = Integer.highestOneBit(m * 2) * 2 - m;
                }

                long cm = tm.get(m);
                while (n <= max) {
                    if (m == n) {
                        res += cm * (cm - 1) / 2;
                    } else {
                        res += cm * tm.getOrDefault(n, 0L);
                    }
                    res %= mod;
                    n = m + (n << 1);
                }
            }
            return (int) res;
        }
    }
}
