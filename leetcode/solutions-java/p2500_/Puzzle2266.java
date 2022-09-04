package p2500_;

/**
 * https://leetcode.com/problems/count-number-of-texts/
 *
 * @author half-dead
 */
public class Puzzle2266 {

    // dp
    class Solution {
        public int countTexts(String pk) {
            int mod = (int) 1e9 + 7, n = pk.length();

            long[] dp3 = new long[n + 1], dp4 = new long[n + 1];
            dp3[0] = dp4[0] = 1L;

            for (int i = 1; i <= n; i++) {
                long temp = 0L;
                if (i >= 1) temp += dp3[i - 1];
                if (i >= 2) temp += dp3[i - 2];
                if (i >= 3) temp += dp3[i - 3];
                dp3[i] = temp % mod;
            }
            for (int i = 1; i <= n; i++) {
                long temp = 0L;
                if (i >= 1) temp += dp4[i - 1];
                if (i >= 2) temp += dp4[i - 2];
                if (i >= 3) temp += dp4[i - 3];
                if (i >= 4) temp += dp4[i - 4];
                dp4[i] = temp % mod;
            }

            long res = 1L;
            int i = 0;
            while (i < n) {
                char c = pk.charAt(i);
                int j = i + 1;
                while (j < n && pk.charAt(j) == c) j++;
                int cnt = j - i;
                long curr = (c == '7' || c == '9') ? dp4[cnt] : dp3[cnt];
                res = (res * curr) % mod;
                i = j;
            }
            return (int) (res % mod);
        }
    }
}
