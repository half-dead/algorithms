package p1500_;

/**
 * https://leetcode.com/problems/count-largest-group/
 *
 * @author half-dead
 */
public class Puzzle1399_CountLargestGroup {

    class Solution {
        public int countLargestGroup(int n) {
            int[] mem = new int[37];
            int prev = 0, sum = 0, max = 0, result = 0;

            for (int i = 1; i <= n; i++) {
                if (prev % 10 == 9) {
                    int j = i;
                    sum = 0;
                    while (j > 0) {
                        sum += (j % 10);
                        j /= 10;
                    }
                } else sum++;
                prev = i;
                mem[sum]++;
            }

            for (int apperance : mem)
                if (apperance > max) {
                    max = apperance;
                    result = 1;
                } else if (apperance == max) result++;
            return result;
        }
    }

    class CountingSolution {
        public int countLargestGroup(int n) {
            int[] mem = new int[37];
            for (int i = 1; i <= n; i++) {
                int j = i, sum = 0;
                while (j > 0) {
                    sum += (j % 10);
                    j /= 10;
                }
                mem[sum]++;
            }

            int max = 0, result = 0;
            for (int apperance : mem)
                if (apperance > max) {
                    max = apperance;
                    result = 1;
                } else if (apperance == max) result++;
            return result;
        }
    }
}
