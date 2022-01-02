package p1000_;

/**
 * https://leetcode.com/problems/binary-gap/
 *
 * @author half-dead
 */
public class Puzzle868_BinaryGap {
    public static void main(String[] args) {
        Puzzle868_BinaryGap p = new Puzzle868_BinaryGap();
        Solution s = p.new Solution();
        System.out.println(s.binaryGap(22));
        System.out.println(s.binaryGap(5));
        System.out.println(s.binaryGap(6));
        System.out.println(s.binaryGap(4));
    }

    class Solution {
        public int binaryGap(int n) {
            int prevIndex = -1, currIndex = 0, max = 0;
            while (n > 0) {
                if ((n & 1) == 1) {
                    if (prevIndex >= 0) max = Math.max(currIndex - prevIndex, max);
                    prevIndex = currIndex;
                }
                currIndex++;
                n >>= 1;
            }
            return max;
        }
    }
}
