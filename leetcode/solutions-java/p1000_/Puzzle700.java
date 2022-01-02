package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * @author half-dead
 */
public class Puzzle700 {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) return null;
            else if (root.val == val) return root;
            else if (root.val > val) return searchBST(root.left, val);
            else return searchBST(root.right, val);
        }
    }
}
