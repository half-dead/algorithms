package p1000_;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * @author half-dead
 */
public class Puzzle703_KthLargestElementInAStream {

    public static void main(String[] args) {
        Puzzle703_KthLargestElementInAStream p = new Puzzle703_KthLargestElementInAStream();
        KthLargest kl = p.new KthLargest(15, new int[]{0});
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(kl.add(j));
            }
        }
    }

    class KthLargest {
        private PriorityQueue<Integer> q;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.q = new PriorityQueue<>(k);
            for (int n : nums) {
                add(n);
            }
        }

        public int add(int val) {
            if (q.size() < k) {
                q.offer(val);
            } else if (q.peek() < val) {
                q.poll();
                q.offer(val);
            }
            return q.peek();
        }
    }
}