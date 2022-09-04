package p2500_;

/**
 * https://leetcode.com/problems/sum-of-numbers-with-units-digit-k/
 *
 * @author half-dead
 */
public class Puzzle2310 {

    class Solution {
        public int minimumNumbers(int num, int k) {
            if (num == 0) return 0;
            for (int i = 1; i * k <= num && i <= 10; ++i)
                if (k * i % 10 == num % 10)
                    return i;
            return -1;
        }
    }
}
