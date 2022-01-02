package p0500_;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/super-ugly-number/
 *
 * @author half-dead
 */
public class Puzzle313 {

    public static void main(String[] args) {
        Solution s = new Puzzle313().new Solution();
        System.out.println(s.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }

    // PriorityQueue
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            if (n == 1) return 1;

            PriorityQueue<int[]> pq = new PriorityQueue<>(primes.length, Comparator.comparingInt(a -> a[0]));
            for (int prime : primes) pq.offer(new int[]{prime, prime, 1});

            int[] cache = new int[n + 1];
            cache[1] = 1;

            for (int i = 2; i <= n; i++) {
                cache[i] = pq.peek()[0];

                while (cache[i] == pq.peek()[0]) {
                    int[] temp = pq.poll();
                    temp[0] = temp[1] * cache[++temp[2]];
                    pq.offer(temp);
                }
            }
            return cache[n];
        }
    }

}
