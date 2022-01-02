package p2000_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/remove-stones-to-minimize-the-total/
 *
 * @author half-dead
 */
public class Puzzle1962 {

    class Solution {
        public int minStoneSum(int[] piles, int k) {
            int[] freq = new int[5001];
            int sum = 0;
            for (int p : piles) {
                sum += p;
                while (p > 1) {
                    int np = p >> 1;
                    freq[np]++;
                    p -= np;
                }
            }
            for (int i = 5000; i > 0 && k > 0; i--) {
                int cnt = Math.min(freq[i], k);
                sum -= cnt * i;
                k -= cnt;
            }
            return sum;
        }
    }

    // PriorityQueue NlogN + KlogN
    class PQSolution {
        public int minStoneSum(int[] piles, int k) {
            int n = piles.length, sum = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(n, (a, b) -> b - a);
            for (int m : piles) {
                pq.offer(m);
                sum += m;
            }

            while (k-- > 0) {
                int top = pq.poll();
                int remove = top >> 1;
                sum -= remove;
                pq.offer(top - remove);
            }
            return sum;
        }
    }
}
