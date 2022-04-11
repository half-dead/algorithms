package p2000_;

/**
 * https://leetcode.com/problems/number-of-wonderful-substrings/
 *
 * @author half-dead
 */
public class Puzzle1915 {

    public static void main(String[] args) {
        Solution s = new Puzzle1915().new Solution();
        System.out.println(s.wonderfulSubstrings("aba"));
    }

    // prefix sum, bit masking
    class Solution {
        public long wonderfulSubstrings(String word) {
            int[] freq = new int[1024];
            freq[0] = 1;

            int state = 0;
            long res = 0L;
            for (char c : word.toCharArray()) {
                state ^= 1 << (c - 'a');
                res += freq[state];
                for (int i = 0; i < 10; i++) {
                    res += freq[state ^ (1 << i)];
                }
                freq[state]++;
            }
            return res;
        }
    }
}
