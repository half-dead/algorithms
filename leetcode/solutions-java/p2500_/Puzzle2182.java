package p2500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/construct-string-with-repeat-limit/
 *
 * @author half-dead
 */
public class Puzzle2182 {

    public static void main(String[] args) {
        Solution s = new Puzzle2182().new Solution();
        System.out.println(s.repeatLimitedString("aaaaaaa", 6));
    }

    class Solution {
        public String repeatLimitedString(String s, int repeatLimit) {
            int[] freq = new int[128];
            for (char c : s.toCharArray()) {
                freq[c]++;
            }
            LinkedList<int[]> q = new LinkedList<>();
            for (int i = 'z'; i >= 'a'; i--) {
                if (freq[i] > 0) q.addLast(new int[]{i, freq[i]});
            }

            int[] top = q.pollFirst();
            StringBuilder sb = new StringBuilder();
            while (q.size() > 0) {
                int cnt = Math.min(top[1], repeatLimit);
                top[1] -= cnt;

                char c = (char) top[0];
                for (int i = 0; i < cnt; i++) sb.append(c);

                if (top[1] == 0) {
                    top = q.pollFirst();
                } else {
                    sb.append((char) q.peekFirst()[0]);
                    if (--q.peekFirst()[1] == 0) {
                        q.pollFirst();
                    }
                }
            }

            for (int i = sb.length() > 0 && sb.charAt(sb.length() - 1) == top[0] ? 1 : 0; i < Math.min(repeatLimit, top[1]); i++)
                sb.append((char) top[0]);
            return sb.toString();
        }
    }
}
