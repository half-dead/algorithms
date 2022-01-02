package p0500_;

// Implement int sqrt(int x).
//
// Compute and return the square root of x.
//
// x is guaranteed to be a non-negative integer.

/**
 * @author half-dead
 */
public class Puzzle069_Sqrt {

    public static void main(String[] args) {
        Puzzle069_Sqrt p = new Puzzle069_Sqrt();
        Solution s = p.new Solution();
        int sqrt = s.mySqrt(10000);
        System.out.println(sqrt);
    }

    class Solution {
        public int mySqrt(int x) {
            if (x < 2) {
                return x;
            }
            int left = 1, right = x / 2;
            int answer = 0;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (x / mid < mid) {
                    right = mid - 1;
                } else {
                    answer = mid;
                    left = mid + 1;
                }
            }
            return answer;
        }
    }
}
