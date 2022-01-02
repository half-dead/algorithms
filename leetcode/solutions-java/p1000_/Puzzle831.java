package p1000_;

/**
 * https://leetcode.com/problems/masking-personal-information/
 *
 * @author half-dead
 */
public class Puzzle831 {

    class Solution {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\D+");

        public String maskPII(String s) {
            int atIndex = s.indexOf('@');
            if (atIndex >= 0) {
                return (s.charAt(0) + "*****" + s.substring(atIndex - 1)).toLowerCase();
            } else {
                String digits = p.matcher(s).replaceAll("");
                String local = "***-***-" + digits.substring(digits.length() - 4);
                if (digits.length() == 10) return local;

                StringBuilder ans = new StringBuilder("+");
                for (int i = 0; i < digits.length() - 10; ++i) ans.append("*");
                return ans + "-" + local;
            }
        }
    }
}
