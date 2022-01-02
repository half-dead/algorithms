package p1000_;

/**
 * https://leetcode.com/problems/global-and-local-inversions/
 *
 * @author half-dead
 */
public class Puzzle775 {

    class Solution {
        public boolean isIdealPermutation(int[] a) {
            for (int i = 0, len = a.length; i < len; i++)
                if (Math.abs(i - a[i]) > 1) return false;
            return true;
        }
    }
}
