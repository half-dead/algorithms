package p1500_;

/**
 * https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 *
 * @author half-dead
 */
public class Puzzle1491 {

    class Solution {
        public double average(int[] salary) {
            int n = salary.length;
            int min = salary[0], max = salary[0], sum = 0;
            for (int s : salary) {
                min = Math.min(min, s);
                max = Math.max(max, s);
                sum += s;
            }
            return (sum - min - max) / (double) (n - 2);

        }
    }
}
