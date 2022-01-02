package p1000_;

import struct.TreeNode;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle958_CheckCompletenessOfABinaryTree {

    public static void main(String[] args) {
        Puzzle958_CheckCompletenessOfABinaryTree p = new Puzzle958_CheckCompletenessOfABinaryTree();
        Solution s = p.new Solution();
        boolean b = s.isCompleteTree(new TreeNode("[1,2,3,4,5,6]"));
        System.out.println(b);
    }

    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            if (root == null) {
                return false;
            }
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            q.push(root);
            int max = -1;
            while (q.size() > 0) {
                ArrayDeque<TreeNode> next = new ArrayDeque<>();
                while (q.size() > 0) {
                    TreeNode node = q.pop();
                    if (node.left == null && node.right != null) {
                        return false;
                    }
                    int childrens = 0;
                    if (node.left != null) {
                        childrens++;
                        next.addLast(node.left);
                    }
                    if (node.right != null) {
                        childrens++;
                        next.addLast(node.right);
                    }

                    if (max == -1) {
                        max = childrens;
                    } else if (childrens > max) {
                        return false;
                    } else if (max != 2 && childrens > 0) {
                        return false;
                    } else {
                        max = childrens;
                    }
                }
                q = next;
            }
            return true;
        }
    }
}
