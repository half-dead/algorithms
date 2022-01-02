package p1500_;

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings
 *
 * @author half-dead
 */
public class Puzzle1071 {
    public static void main(String[] args) {
        Solution s = new Puzzle1071().new Solution();

//        System.out.println(s.gcdOfStrings(
//                "ADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBB",
//                "ADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBBADADCCBBCBDCDDBABCBB"
//        ));
        System.out.println(s.gcdOfStrings("ABCABC", "ABC"));
    }

    class Solution {
        public String gcdOfStrings(String a, String b) {
            if (a.equals(b)) return a;

            String divisorA = divisor(a), divisorB = divisor(b);
            if (!divisorA.equals(divisorB)) return "";

            int lenA = a.length() / divisorA.length(), lenB = b.length() / divisorA.length();
            if (lenA % lenB == 0 || lenB % lenA == 0)
                return lenA > lenB ? b : a;

            int gcd = gcd(lenA, lenB);
            StringBuilder res = new StringBuilder();
            while (gcd-- > 0) res.append(divisorA);
            return res.toString();
        }

        int gcd(int a, int b) {
            return a > 0 ? gcd(b % a, a) : b;
        }

        // return the shortest repeating part if there is one, otherwise return the string itself
        String divisor(String s) {
            char c = s.charAt(0);
            int next = 0;
            while ((next = s.indexOf(c, next + 1)) != -1) {
                for (int i = next; i < s.length(); i++) {
                    if (s.charAt(i % next) != s.charAt(i)) break;
                    if (i + 1 == s.length()) return s.substring(0, next);
                }
            }
            return s;
        }
    }
}
