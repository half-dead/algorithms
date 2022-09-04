package p2500_;

/**
 * https://leetcode.com/problems/largest-palindromic-number/
 *
 * @author half-dead
 */
public class Puzzle2384 {

    public static void main(String[] args) {
        Solution s = new Puzzle2384().new Solution();
        System.out.println(s.largestPalindromic("444947137"));
    }

    class Solution {
        public String largestPalindromic(String num) {
            int[] cnt = new int[10];
            for (int i = 0; i < num.length(); i++) {
                cnt[num.charAt(i) - '0']++;
            }

            StringBuilder head = new StringBuilder();
            for (int i = 9; i >= 0; i--) {
                int x = cnt[i] / 2;
                while (x > 0) {
                    if (i > 0 || head.length() > 0) head.append((char) ('0' + i));
                    x--;
                }
                cnt[i] %= 2;
            }
            StringBuilder tail = new StringBuilder(head).reverse();

            StringBuilder mid = new StringBuilder();
            for (int i = 9; i >= 0; i--) {
                if (cnt[i] > 0) {
                    mid.append((char) ('0' + i));
                    break;
                }
            }

            head.append(mid).append(tail);

            if (head.length() == 0) return "0";
            return head.toString();
        }
    }
}
