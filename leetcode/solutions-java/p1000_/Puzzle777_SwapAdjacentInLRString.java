package p1000_;

/**
 * https://leetcode.com/problems/swap-adjacent-in-lr-string/
 *
 * @author half-dead
 */
public class Puzzle777_SwapAdjacentInLRString {
    public static void main(String[] args) {
        Puzzle777_SwapAdjacentInLRString p = new Puzzle777_SwapAdjacentInLRString();
        Solution s = p.new Solution();
        System.out.println(s.canTransform("XXRXXLXXXX", "XXXXRXXLXX")); // false
        System.out.println(s.canTransform("XXXXXLXXXX", "LXXXXXXXXX")); // true
        System.out.println(s.canTransform("XXRXLXRXXX", "XXRLXXXXXR")); // true
        System.out.println(s.canTransform("XLXRRXXRXX", "LXXXXXXRRR")); // true

    }

    class Solution {
        public boolean canTransform(String start, String end) {
            char[] charsA = start.toCharArray(), charsB = end.toCharArray();
            int i = 0;
            for (; i < charsA.length; ) {
                char ca = charsA[i], cb = charsB[i];
                int count1 = 0, count2 = 0;
                if (ca == cb) i++;
                else if (ca == 'R' && cb == 'X') {
                    while (i < charsA.length && charsA[i] != 'L' && charsB[i] != 'L') {
                        if (charsA[i] == 'R') count1++;
                        if (charsB[i] == 'R') count2++;
                        i++;
                    }
                    if (count1 != count2) return false;
                } else if (ca == 'X' && cb == 'L') {
                    while (i < charsA.length && charsA[i] != 'R' && charsB[i] != 'R') {
                        if (charsA[i] == 'L') count1++;
                        if (charsB[i] == 'L') count2++;
                        i++;
                    }
                    if (count1 != count2) return false;
                } else return false;
            }
            return true;
        }
    }
}
