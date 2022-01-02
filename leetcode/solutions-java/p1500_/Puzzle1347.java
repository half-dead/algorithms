package p1500_;

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 *
 * @author half-dead
 */
public class Puzzle1347 {

    class Solution {
        public int minSteps(String s, String t) {
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - 'a']++;
                cnt[t.charAt(i) - 'a']--;
            }
            int sum = 0;
            for (int c : cnt) if (c > 0) sum += c;
            return sum;
        }
    }
}
