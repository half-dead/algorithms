package p2500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/evaluate-boolean-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle2331 {

    // recursion
    class Solution {
        public boolean evaluateTree(TreeNode root) {
            if (root.val < 2) return root.val == 1;

            boolean a = evaluateTree(root.left);
            boolean b = evaluateTree(root.right);
            return root.val == 2 ? (a | b) : (a & b);
        }
    }
}
