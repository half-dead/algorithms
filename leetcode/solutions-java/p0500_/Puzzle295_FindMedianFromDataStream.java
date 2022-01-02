package p0500_;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * @author half-dead
 */
public class Puzzle295_FindMedianFromDataStream {
    class MedianFinder {
        PriorityQueue<Integer> lo, hi;

        public MedianFinder() {
            lo = new PriorityQueue<>(Collections.reverseOrder());
            hi = new PriorityQueue<>();
        }

        public void addNum(int num) {
            hi.add(num);
            if (lo.size() > 0 && lo.peek() > hi.peek()) {
                hi.add(lo.poll());
                lo.add(hi.poll());
            }
            if (hi.size() > lo.size() + 1) {
                lo.add(hi.poll());
            }
        }

        public double findMedian() {
            return hi.size() > lo.size() ? hi.peek() : (hi.peek() / 2.0d + lo.peek() / 2.0d);
        }
    }
}
