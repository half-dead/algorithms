package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 *
 * @author half-dead
 */
public class Puzzle538_ConvertBSTToGreaterTree {

    public static void main(String[] args) {
        Puzzle538_ConvertBSTToGreaterTree p = new Puzzle538_ConvertBSTToGreaterTree();
        Solution s = p.new Solution();
        s.convertBST(new TreeNode("[1,0,4,-2,#,3]"));
    }

    class Solution {
        public TreeNode convertBST(TreeNode root) {
            sum(root, 0);
            return root;
        }

        private void sum(TreeNode root, int parentValue) {
            if (root == null) {
                return;
            }
            if (root.right != null) {
                sum(root.right, parentValue);
                TreeNode temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                root.val += temp.val;
            } else {
                root.val += parentValue;
            }
            if (root.left != null) {
                sum(root.left, root.val);
            }
        }
    }

    class SimpleSolution {
        public TreeNode convertBST(TreeNode root) {
            sum(root, 0);
            return root;
        }

        public int sum(TreeNode root, int val) {
            if (root == null) {
                return val;
            }
            root.val += sum(root.right, val);
            return sum(root.left, root.val);
        }

    }
}
