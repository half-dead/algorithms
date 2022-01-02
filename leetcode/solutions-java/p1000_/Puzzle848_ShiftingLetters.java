package p1000_;

/**
 * https://leetcode.com/problems/shifting-letters/
 *
 * @author half-dead
 */
public class Puzzle848_ShiftingLetters {
    public static void main(String[] args) {
        Puzzle848_ShiftingLetters p = new Puzzle848_ShiftingLetters();
        Solution s = p.new Solution();
        System.out.println(s.shiftingLetters("abcde", new int[]{3, 5, 9, 10, 11}));
    }

    class Solution {
        public String shiftingLetters(String s, int[] shifts) {
            int sum = 0;
            char[] chars = s.toCharArray();
            for (int i = shifts.length - 1; i >= 0; i--) {
                sum += shifts[i];
                sum %= 26;
                chars[i] = (chars[i] + sum > 'z') ? (char) (chars[i] - 26 + sum) : (char) (chars[i] + sum);
            }
            return new String(chars);
        }
    }
}
