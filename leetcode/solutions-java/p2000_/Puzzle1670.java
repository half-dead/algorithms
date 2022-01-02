package p2000_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/design-front-middle-back-queue/
 *
 * @author half-dead
 */
public class Puzzle1670 {

    class FrontMiddleBackQueue {
        LinkedList<Integer> left, right;

        public FrontMiddleBackQueue() {
            left = new LinkedList<>();
            right = new LinkedList<>();
        }

        public void pushFront(int val) {
            left.addFirst(val);
            if (left.size() - right.size() > 1) {
                right.addFirst(left.pollLast());
            }
        }

        public void pushMiddle(int val) {
            if (left.size() > right.size()) right.addFirst(left.pollLast());
            left.addLast(val);
        }

        public void pushBack(int val) {
            right.addLast(val);
            if (right.size() - left.size() > 1) {
                left.addLast(right.pollFirst());
            }
        }

        public int popFront() {
            if (left.size() == 0) return right.size() == 0 ? -1 : right.pollFirst();
            int x = left.pollFirst();
            reblance();
            return x;
        }

        public int popMiddle() {
            if (right.size() > left.size()) return right.pollFirst();
            return left.size() == 0 ? -1 : left.pollLast();
        }

        public int popBack() {
            if (right.size() == 0) return left.size() == 0 ? -1 : left.pollLast();
            int x = right.pollLast();
            reblance();
            return x;
        }

        void reblance() {
            if (left.size() - right.size() > 1) {
                right.addFirst(left.pollLast());
            } else if (right.size() - left.size() > 1) {
                left.addLast(right.pollFirst());
            }
        }
    }

}
