package p1000_;

/**
 * https://leetcode.com/problems/my-calendar-ii/
 * Solutions:
 * 1. TreeMap
 * 2. SegmentTree
 * 3. Binary Search Tree
 *
 * @author half-dead
 */
public class Puzzle731 {

    public static void main(String[] args) {
        MyCalendarTwo mct = new Puzzle731().new MyCalendarTwo();
        System.out.println(mct.book(24, 40));
        System.out.println(mct.book(43, 50));
        System.out.println(mct.book(27, 43));
        System.out.println(mct.book(5, 21));
        System.out.println(mct.book(30, 40));
        System.out.println(mct.book(14, 29));
        System.out.println(mct.book(3, 19));
        System.out.println(mct.book(3, 14));
        System.out.println(mct.book(25, 39));
        System.out.println(mct.book(6, 19));
    }

    class MyCalendarTwo {
        ST root;

        public MyCalendarTwo() {
            root = new ST(0, 1_000_000_000, 0);
        }

        public boolean book(int start, int end) {
            int k = query(root, start, end - 1);
            if (k >= 2) return false;

            book(root, start, end - 1, 1);
            return true;
        }

        class ST {
            int from, to;
            int k, lazy;
            ST left, right;

            ST(int from, int to, int k) {
                this.from = from;
                this.to = to;
                this.k = k;
            }
        }

        private int query(ST node, int start, int end) {
            if (start > end || node == null || start > node.to || end < node.from) return 0;

            if (start <= node.from && node.to <= end) return node.k;
            normalize(node);
            return Math.max(query(node.left, start, end), query(node.right, start, end));
        }

        private void book(ST node, int start, int end, int delta) {
            if (start > end || node == null || start > node.to || end < node.from) return;

            if (start <= node.from && node.to <= end) {
                node.lazy = delta;
                node.k += delta;
                normalize(node);
                return;
            }
            normalize(node);
            book(node.left, start, end, delta);
            book(node.right, start, end, delta);

            node.k = Math.max(node.left.k, node.right.k);
        }

        private void normalize(ST node) {
            if (node.from < node.to) {
                if (node.left == null || node.right == null) {
                    int m = node.from + (node.to - node.from) / 2;
                    node.left = new ST(node.from, m, node.k);
                    node.right = new ST(m + 1, node.to, node.k);
                } else if (node.lazy > 0) {
                    node.left.lazy += node.lazy;
                    node.left.k += node.lazy;
                    node.right.lazy += node.lazy;
                    node.right.k += node.lazy;
                }
            }

            node.lazy = 0;
        }

    }


}
