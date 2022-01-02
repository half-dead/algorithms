package p1500_;

import struct.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 *
 * @author half-dead
 */
public class Puzzle1302_DeepestLeavesSum {


    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            LinkedList<TreeNode> q = new LinkedList<>();
            if (root != null) q.push(root);
            while (q.size() > 0) {
                int sum = 0;
                LinkedList<TreeNode> nq = new LinkedList<>();
                while (q.size() > 0) {
                    TreeNode n = q.pop();
                    sum += n.val;
                    if (n.left != null) nq.push(n.left);
                    if (n.right != null) nq.push(n.right);
                }
                if (nq.size() == 0) {
                    return sum;
                }
                q = nq;
            }
            return 0;
        }

    }

    class DfsSolution {
        private int sum = 0;
        private int maxDepth = 0;

        public int deepestLeavesSum(TreeNode root) {
            dfs(root, 1);
            return sum;
        }

        public void dfs(TreeNode node, int depth) {
            if (node == null) return;
            if (depth > maxDepth) {
                maxDepth = depth;
                sum = node.val;
            } else if (depth == maxDepth) {
                sum += node.val;
            }
            dfs(node.left, depth + 1);
            dfs(node.right, depth + 1);
        }
    }
}
