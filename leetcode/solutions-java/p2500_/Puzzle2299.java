package p2500_;

/**
 * https://leetcode.com/problems/strong-password-checker-ii/
 *
 * @author half-dead
 */
public class Puzzle2299 {
    class Solution {
        public boolean strongPasswordCheckerII(String password) {
            if (password.length() < 8) return false;

            boolean lower = false, upper = false, digit = false, special = false;
            boolean same = false;
            char prev = ' ';
            for (char c : password.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    lower = true;
                } else if (c >= 'A' && c <= 'Z') {
                    upper = true;
                } else if (c >= '0' && c <= '9') {
                    digit = true;
                } else {
                    special = true;
                }

                if (c == prev) {
                    same = true;
                    break;
                }
                prev = c;
            }
            return !same && lower && upper && digit && special;
        }
    }
}
