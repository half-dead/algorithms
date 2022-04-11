package p2500_;

/**
 * https://leetcode.com/problems/find-substring-with-given-hash-value/
 *
 * @author half-dead
 */
public class Puzzle2156 {

    public static void main(String[] args) {
        Solution s = new Puzzle2156().new Solution();
        System.out.println(s.subStrHash("xmmhdakfursinye", 96, 45, 15, 21));
    }

    // reverse order traverse, rolling-hash
    class Solution {
        public String subStrHash(String s, int power, int mod, int k, int hashValue) {
            long curr = 0L, mul = 1L;
            for (int i = 0; i < k; i++) mul = (mul * power) % mod;

            int n = s.length(), index = 0;
            for (int i = n - 1; i >= 0; i--) {
                curr = (curr * power + (s.charAt(i) - 'a' + 1)) % mod;
                if (n - i > k) {
                    curr = (curr - (s.charAt(i + k) - 'a' + 1) * mul) % mod;
                    curr = (curr + mod) % mod;
                }
                if (n - i >= k && curr == hashValue) {
                    index = i;
                }
            }
            return s.substring(index, index + k);
        }
    }
}
