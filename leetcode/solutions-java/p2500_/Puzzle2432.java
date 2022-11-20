package p2500_;

/**
 * https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/
 */
public class Puzzle2432 {
    class Solution {
        public int hardestWorker(int n, int[][] logs) {
            int max = 0, res = n - 1, prev = 0;
            for (int[] log : logs) {
                int id = log[0], time = log[1] - prev;
                if (time > max) {
                    max = time;
                    res = id;
                } else if (time == max && id < res) {
                    res = id;
                }
                prev = log[1];
            }
            return res;
        }
    }
}
