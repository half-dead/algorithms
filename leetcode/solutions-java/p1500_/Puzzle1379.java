package p1500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 *
 * @author half-dead
 */
public class Puzzle1379 {

    class Solution {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            if (original == null) return null;
            if (original == target) return cloned;
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            return left != null ? left : getTargetCopy(original.right, cloned.right, target);
        }
    }
}
