package p2500_;

/**
 * https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
 *
 * @author half-dead
 */
public class Puzzle2138 {

    class Solution {
        public String[] divideString(String s, int k, char fill) {
            int n = s.length(), m = (n + k - 1) / k;
            String[] res = new String[m];
            for (int i = 0; i < m; i++) {
                res[i] = s.substring(i * k, Math.min(n, (i + 1) * k));
                while (res[i].length() < k) res[i] = res[i] + fill;
            }
            return res;

        }
    }
}
