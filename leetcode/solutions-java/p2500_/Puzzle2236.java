package p2500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/root-equals-sum-of-children/
 */
public class Puzzle2236 {


    class Solution {
        public boolean checkTree(TreeNode root) {
            return root.val == root.left.val + root.right.val;
        }
    }
}
