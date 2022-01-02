package p1000_;

import struct.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 *
 * @author half-dead
 */
public class Puzzle872_LeafSimilarTrees {
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            LinkedList<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
            dfs(q1, root1);
            dfs(q2, root2);
            return q1.size() == q2.size() && q1.equals(q2);
        }

        void dfs(LinkedList<Integer> q, TreeNode node) {
            if (node == null) return;

            if (node.left == null && node.right == null) {
                q.addLast(node.val);
                return;
            }
            dfs(q, node.left);
            dfs(q, node.right);
        }
    }
}
