package p2500_;

/**
 * https://leetcode.com/problems/count-integers-with-even-digit-sum/
 *
 * @author half-dead
 */
public class Puzzle2180 {
    class Solution {
        int countEven(int num) {
            int temp = num, sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            return sum % 2 == 0 ? num / 2 : (num - 1) / 2;
        }
    }

    // brute force
    class Solution1 {
        public int countEven(int num) {
            int res = 0;
            for (int i = 1; i <= num; i++) {
                int dsum = 0;
                int j = i;
                while (j > 0) {
                    dsum += j % 10;
                    j /= 10;
                }
                if (dsum % 2 == 0) res++;
            }
            return res;
        }
    }

}
