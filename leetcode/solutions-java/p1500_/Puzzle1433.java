package p1500_;

/**
 * https://leetcode.com/problems/check-if-a-string-can-break-another-string/submissions/
 *
 * @author half-dead
 */
public class Puzzle1433 {
    public static void main(String[] args) {
        Solution s = new Puzzle1433().new Solution();
        System.out.println(s.checkIfCanBreak("abc", "xya"));
        System.out.println(s.checkIfCanBreak("abe", "acd"));
        System.out.println(s.checkIfCanBreak("leetcodee", "interview"));
    }

    class Solution {
        public boolean checkIfCanBreak(String s1, String s2) {
            int[] count = new int[26];
            for (char c : s1.toCharArray()) count[c - 'a']++;
            for (char c : s2.toCharArray()) count[c - 'a']--;
            int sum = 0;
            boolean positive = false, negative = false;
            for (int c : count) {
                sum += c;
                if (sum > 0) positive = true;
                else if (sum < 0) negative = true;
            }
            return !positive || !negative;
        }
    }
}
