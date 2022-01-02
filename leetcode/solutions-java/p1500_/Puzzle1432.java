package p1500_;

/**
 * https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/
 *
 * @author half-dead
 */
public class Puzzle1432 {

    public static void main(String[] args) {
        Solution s = new Puzzle1432().new Solution();
        System.out.println(s.maxDiff(123456));
        System.out.println(s.maxDiff(555));
    }

    class Solution {
        public int maxDiff(int num) {
            String s = "" + num;
            char[] cs = s.toCharArray();
            int len = cs.length, max = num;

            for (char c : cs) {
                if (c != '9') {
                    max = Integer.parseInt(s.replace(c, '9'));
                    break;
                }
            }

            if (cs[0] != '1')
                return max - Integer.parseInt(s.replace(cs[0], '1'));
            for (int i = 1; i < len; i++)
                if (cs[i] != '0' && cs[i] != cs[0])
                    return max - Integer.parseInt(s.replace(cs[i], '0'));
            return max - num;
        }
    }
}
