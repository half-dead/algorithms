package p1500_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
 *
 * @author half-dead
 */
public class Puzzle1005 {
    class Solution {
        public int largestSumAfterKNegations(int[] a, int k) {
            PriorityQueue<Integer> q = new PriorityQueue<>();
            int min = Integer.MAX_VALUE, sum = 0;
            for (int n : a) {
                if (n < 0) q.add(n);
                min = Math.min(min, Math.abs(n));
                sum += n;
            }
            while (q.size() > 0 && k-- > 0) {
                sum += q.poll() * -2;
            }
            if (q.size() > 0 || k % 2 == 0) return sum;
            else return sum - min * 2;
        }
    }
}
