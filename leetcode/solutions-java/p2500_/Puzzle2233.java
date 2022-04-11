package p2500_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximum-product-after-k-increments/
 */
public class Puzzle2233 {

    // greedy, priority queue
    class Solution {
        public int maximumProduct(int[] nums, int k) {
            int mod = (int) 1e9 + 7;

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int x : nums) pq.offer(x);

            while (k > 0) {
                pq.offer(pq.poll() + 1);
                k--;
            }

            long p = 1L;
            while (pq.size() > 0) {
                p = (p * pq.poll()) % mod;
            }

            return (int) p;
        }
    }

    // greedy, bucket sort
    class Solution1 {
        public int maximumProduct(int[] nums, int k) {
            int mod = (int) 1e9 + 7;
            int[] freq = new int[1100001];
            for (int x : nums) freq[x]++;

            for (int i = 0; i <= 1100000; i++) {
                int cnt = Math.min(freq[i], k);
                freq[i] -= cnt;
                freq[i + 1] += cnt;
                k -= cnt;
                if (k == 0) break;
            }

            long p = 1L;
            for (int i = 0; i <= 1100000; i++) {
                int times = freq[i];
                while (times > 0) {
                    p = (p * i) % mod;
                    times--;
                }
                if (p == 0) break;
            }
            return (int) p;
        }
    }
}
