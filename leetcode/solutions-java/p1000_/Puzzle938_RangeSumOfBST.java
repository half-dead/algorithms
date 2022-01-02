package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 *
 * @author half-dead
 */
public class Puzzle938_RangeSumOfBST {
    class Solution {
        public int rangeSumBST(TreeNode root, int min, int max) {
            if (root == null) {
                return 0;
            }
            int result = 0;
            if (root.val >= min && root.val <= max) {
                result += root.val;
            }
            result += rangeSumBST(root.left, min, max);
            result += rangeSumBST(root.right, min, max);
            return result;
        }
    }
}
