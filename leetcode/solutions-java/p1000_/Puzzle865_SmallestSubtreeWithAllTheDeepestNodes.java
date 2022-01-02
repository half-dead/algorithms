package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 *
 * @author half-dead
 */
public class Puzzle865_SmallestSubtreeWithAllTheDeepestNodes {

    public static void main(String[] args) {
        Puzzle865_SmallestSubtreeWithAllTheDeepestNodes p = new Puzzle865_SmallestSubtreeWithAllTheDeepestNodes();
        Solution s = p.new Solution();
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(2);
        root.right.right.right = new TreeNode(3);
        TreeNode node = s.subtreeWithAllDeepest(root);
    }

    class Solution {
        private int maxDepth = 0;
        private int count = 0;

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            dfs1(root, 1);
            int depth = 1;
            while (root != null) {
                int c1 = dfs2(root.left, depth + 1, 0);
                int c2 = dfs2(root.right, depth + 1, 0);
                if (c1 < count && c2 < count) {
                    return root;
                } else if (c1 == count) {
                    root = root.left;
                } else if (c2 == count) {
                    root = root.right;
                }
                depth++;
            }
            return null;
        }

        private void dfs1(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (maxDepth < depth) {
                maxDepth = depth;
                count = 1;
            } else if (maxDepth == depth) {
                count++;
            }
            depth++;
            dfs1(root.left, depth);
            dfs1(root.right, depth);
        }

        private int dfs2(TreeNode root, int depth, int count) {
            if (root == null) {
                return count;
            }
            if (depth == maxDepth) {
                return count + 1;
            } else {
                depth++;
                return dfs2(root.left, depth, count) + dfs2(root.right, depth, count);
            }
        }
    }


    // Neat !!!!
    class Solution2 {
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return dfs(root).node;
        }

        private Pair dfs(TreeNode root) {
            if (root == null) {
                return new Pair(0, null);
            }
            Pair left = dfs(root.left);
            Pair right = dfs(root.right);

            int d1 = left.maxDepth, d2 = right.maxDepth;
            int depth = Math.max(d1, d2) + 1;
            if (d1 == d2) {
                return new Pair(depth, root);
            } else if (d1 > d2) {
                return new Pair(depth, left.node);
            } else {
                return new Pair(depth, right.node);
            }
        }
    }

    class Pair {
        int maxDepth;
        TreeNode node;

        Pair(int maxDepth, TreeNode node) {
            this.maxDepth = maxDepth;
            this.node = node;
        }
    }

}
