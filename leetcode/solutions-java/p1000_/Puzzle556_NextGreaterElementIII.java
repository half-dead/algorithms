package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-greater-element-iii/
 *
 * @author half-dead
 */
public class Puzzle556_NextGreaterElementIII {
    public static void main(String[] args) {
        Solution s = new Puzzle556_NextGreaterElementIII().new Solution();
        System.out.println(s.nextGreaterElement(1987654));
    }

    class Solution {
        public int nextGreaterElement(int n) {
            char[] chars = String.valueOf(n).toCharArray();

            int i = chars.length - 1;
            while (i > 0 && chars[i - 1] >= chars[i]) {
                i--;
            }

            if (i == 0) return -1;

            char min = chars[i - 1];
            char next = Character.MAX_VALUE;
            int idx = i;
            for (int j = i; j < chars.length; j++) {
                if (chars[j] > min && chars[j] < next) {
                    next = chars[j];
                    idx = j;
                }
            }
            chars[i - 1] = chars[idx];
            chars[idx] = min;

            Arrays.sort(chars, i, chars.length);
            long ans = Long.valueOf(new String(chars));
            return ans > Integer.MAX_VALUE ? -1 : (int) ans;
        }
    }
}
