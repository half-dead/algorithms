package p1000_;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author half-dead
 */
public class Puzzle715 {

    // treemap
    class RangeModule {
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        public void addRange(int left, int right) {
            Map.Entry<Integer, Integer> lo = tm.floorEntry(left), hi = tm.floorEntry(right);

            if (lo != null && lo.getValue() >= left) left = lo.getKey();
            if (hi != null && hi.getValue() > right) right = hi.getValue();

            tm.put(left, right);
            tm.subMap(left, false, right, true).clear();
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> lo = tm.floorEntry(left);
            return lo != null && lo.getValue() >= right;
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> lo = tm.floorEntry(left), hi = tm.floorEntry(right);

            if (hi != null && hi.getValue() > right) tm.put(right, hi.getValue());
            if (lo != null && lo.getValue() > left) tm.put(lo.getKey(), left);

            tm.subMap(left, true, right, false).clear();
        }
    }

    // binary search tree
    class BSTRangeModule {
        class TreeNode {
            int lo, hi;
            TreeNode left, right;

            public TreeNode(int lo, int end) {
                this.lo = lo;
                this.hi = end;
            }
        }

        TreeNode root;

        public void addRange(int left, int right) {
            root = addRange(root, left, right);
        }

        public boolean queryRange(int left, int right) {
            return queryRange(root, left, right);
        }

        public void removeRange(int left, int right) {
            root = removeRange(root, left, right);
        }

        private TreeNode addRange(TreeNode root, int start, int end) {
            if (start >= end) return root;
            if (root == null) return new TreeNode(start, end);

            if (root.lo >= end) root.left = addRange(root.left, start, end);
            else if (root.hi <= start) root.right = addRange(root.right, start, end);
            else {
                root.left = addRange(root.left, start, root.lo); // if start >= root.start, no change on root.left
                root.right = addRange(root.right, root.hi, end); // if root.end >= end, no change on root.right
            }
            return root;
        }

        private TreeNode removeRange(TreeNode root, int start, int end) {
            if (start >= end) return root;
            if (root == null) return root;

            if (root.lo >= end) root.left = removeRange(root.left, start, end);
            else if (root.hi <= start) root.right = removeRange(root.right, start, end);
            else {
                root.left = removeRange(root.left, start, root.lo);  // if start >= root.start, no change on root.left
                root.right = removeRange(root.right, root.hi, end);
                root.left = addRange(root.left, root.lo, start);
                root.right = addRange(root.right, end, root.hi);
                root = remove(root);
            }
            return root;
        }

        private TreeNode remove(TreeNode node) {
            if (node == null) return null;
            if (node.left == null) return node.right;

            TreeNode leftLargest = getLargest(node.left, node);
            leftLargest.left = node.left;
            leftLargest.right = node.right;
            return leftLargest;
        }

        private TreeNode getLargest(TreeNode node, TreeNode parent) {
            while (node.right != null) {
                parent = node;
                node = node.right;
            }

            if (parent.left == node) parent.left = node.left;
            if (parent.right == node) parent.right = node.left;
            node.left = null;
            return node;
        }

        private boolean queryRange(TreeNode root, int start, int end) {
            if (start >= end) return true;  // See the last line of the function
            if (root == null) return false;

            if (root.lo >= end) return queryRange(root.left, start, end);
            if (root.hi <= start) return queryRange(root.right, start, end);
            if (start >= root.lo && end <= root.hi) return true;

            // This implies it is true for range [root.start, root.end);
            return queryRange(root.left, start, root.lo) && queryRange(root.right, root.hi, end);
        }
    }

    // segment tree
    class SegmentTreeRangeModule {
        ST root = new ST(1, Integer.MAX_VALUE, false);

        public void addRange(int left, int right) {
            root.update(left, right, true);
        }

        public boolean queryRange(int left, int right) {
            return root.query(left, right);
        }

        public void removeRange(int left, int right) {
            root.update(left, right, false);
        }

        class ST {
            int begin, end, mid;
            boolean v;
            boolean leaf = true;
            ST a, b;

            ST(int begin, int end, boolean value) {
                this.begin = begin;
                this.end = end;
                this.v = value;
            }

            boolean query(int left, int right) {
                if (leaf) return v;

                if (mid <= left) return b.query(left, right);
                else if (mid >= right) return a.query(left, right);
                else return v = a.query(left, mid) && b.query(mid, right);
            }

            void update(int left, int right, boolean value) {
                if (!leaf) {
                    if (right <= mid) a.update(left, right, value);
                    else if (mid <= left) b.update(left, right, value);
                    else {
                        a.update(left, mid, value);
                        b.update(mid, right, value);
                    }
                    return;
                }

                if (begin == left && end == right) {
                    v = value;
                    return;
                }

                if (end == right) {
                    mid = left;
                    a = new ST(begin, mid, v);
                    b = new ST(mid, end, value);
                } else if (begin == left) {
                    mid = right;
                    a = new ST(begin, mid, value);
                    b = new ST(mid, end, v);
                } else {
                    mid = left;
                    a = new ST(begin, mid, v);
                    b = new ST(mid, end, v);
                    b.update(left, right, value);
                }
                leaf = false;
            }
        }
    }
}
