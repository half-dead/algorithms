package p1500_;

import struct.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 *
 * @author half-dead
 */
public class Puzzle1008 {

    public static void main(String[] args) {
        Solution s = new Puzzle1008().new Solution();
//        System.out.println(s.bstFromPreorder(new int[]{5, 3, 4}));
//        System.out.println(s.bstFromPreorder(new int[]{3, 2, 4}));
        System.out.println(s.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
    }

    // iterative
    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            TreeNode root = new TreeNode(preorder[0]);
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            for (int i = 1; i < preorder.length; i++) {
                int val = preorder[i];
                TreeNode node = new TreeNode(val);
                if (val < stack.peek().val) {
                    stack.peek().left = node;
                } else {
                    TreeNode parent = stack.peek();
                    while (!stack.isEmpty() && stack.peek().val < val) parent = stack.pop();
                    parent.right = node;
                }
                stack.push(node);
            }
            return root;
        }
    }

    // recursive
    class DfsSolution {
        int i = 0;

        public TreeNode bstFromPreorder(int[] preorder) {
            return recur(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        TreeNode recur(int[] preorder, int min, int max) {
            if (i == preorder.length || preorder[i] < min || preorder[i] > max) return null;
            TreeNode node = new TreeNode(preorder[i++]);
            node.left = recur(preorder, min, node.val);
            node.right = recur(preorder, node.val, max);
            return node;
        }
    }
}
