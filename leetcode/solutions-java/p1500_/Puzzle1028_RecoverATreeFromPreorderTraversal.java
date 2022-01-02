package p1500_;

import struct.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
 *
 * @author half-dead
 */
public class Puzzle1028_RecoverATreeFromPreorderTraversal {

    public static void main(String[] args) {
        Solution s = new Puzzle1028_RecoverATreeFromPreorderTraversal().new Solution();
        TreeNode treeNode = s.recoverFromPreorder("1-401--349---90--88");
        System.out.println(treeNode);
    }

    class Solution {
        public TreeNode recoverFromPreorder(String s) {
            if (s == null || s.length() == 0) return null;

            LinkedList<TreeNode> q = new LinkedList<>();
            int i = 0, len = s.length();
            while (i < len) {
                int depth = 0, n = 0;
                while (i < len && s.charAt(i) == '-') {
                    i++;
                    depth++;
                }
                while (i < len && s.charAt(i) != '-') {
                    n = 10 * n + (s.charAt(i++) - '0');
                }

                while (q.size() > depth) q.pop();

                TreeNode node = new TreeNode(n);
                if (q.size() > 0) {
                    TreeNode parent = q.peek();
                    if (parent.left == null) parent.left = node;
                    else parent.right = node;
                }
                q.push(node);
            }
            return q.peekLast();
        }
    }
}
