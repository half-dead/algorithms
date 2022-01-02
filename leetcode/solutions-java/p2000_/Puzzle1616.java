package p2000_;

/**
 * https://leetcode.com/problems/split-two-strings-to-make-palindrome/
 *
 * @author half-dead
 */
public class Puzzle1616 {

    // greedy
    class Solution {
        public boolean checkPalindromeFormation(String a, String b) {
            boolean x = false, y = false, p = false, q = false, r = false, s = false;
            int i = 0, j = a.length() - 1;
            while (i < j) {
                char a1 = a.charAt(i), a2 = a.charAt(j);
                char b1 = b.charAt(i), b2 = b.charAt(j);
                if (!x && a1 != b2) {
                    x = true;
                }
                if (x && a1 != a2) p = true;
                if (x && b1 != b2) q = true;

                if (!y && b1 != a2) {
                    y = true;
                }
                if (y && a1 != a2) r = true;
                if (y && b1 != b2) s = true;

                if (p && q && r && s) return false;
                i++;
                j--;
            }
            return i >= j;
        }
    }
}
