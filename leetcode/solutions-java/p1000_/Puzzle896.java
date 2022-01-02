package p1000_;

/**
 * https://leetcode.com/problems/monotonic-array/
 *
 * @author half-dead
 */
public class Puzzle896 {

    public static void main(String[] args) {
    }


    class Solution {
        public boolean isMonotonic(int[] A) {
            int monotone = 0, prev = A[0];
            for (int n : A) {
                if (n != prev) {
                    if (monotone != 0 && monotone * (prev - n) < 0) return false;
                    else if (monotone == 0) monotone = prev > n ? 1 : -1;
                    prev = n;
                }
            }
            return true;
        }
    }
}
