package p0500_;

/**
 * @author half-dead
 */
public class Puzzle424 {

    public static void main(String[] args) {
        Solution s = new Puzzle424().new Solution();
        System.out.println(s.characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
    }

    class Solution {
        public int characterReplacement(String s, int k) {
            int[] count = new int[128];
            char[] chars = s.toCharArray();
            int max = 0, start = 0;
            for (int end = 0; end < chars.length; end++) {
                max = Math.max(max, ++count[chars[end]]);
                if (max + k <= end - start) count[chars[start++]]--;
            }
            return chars.length - start;
        }
    }

    // A-Z solution
    class AZSolution {
        public int characterReplacement(String s, int k) {
            if (k >= s.length()) return s.length();

            char[] chars = s.toCharArray();
            int max = 0;
            for (char target = 'A'; target <= 'Z'; target++) {

                int start = 0, end = 0, w = k;
                while (end < chars.length) {
                    while (end < chars.length && (chars[end] == target || w > 0)) {
                        if (chars[end] != target) w--;
                        end++;
                    }
                    max = Math.max(max, end - start);
                    while (start < end && chars[start] == target) start++;
                    if (start < end && w < k) {
                        start++;
                        w++;
                    }
                    if (w == 0) {
                        start = ++end;
                    }

                }
            }
            return max;
        }
    }
}
