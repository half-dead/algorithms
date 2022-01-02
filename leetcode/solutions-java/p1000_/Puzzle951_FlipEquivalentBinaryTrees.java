package p1000_;

import struct.TreeNode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/flip-equivalent-binary-trees/
 *
 * @author half-dead
 */
public class Puzzle951_FlipEquivalentBinaryTrees {
    public static void main(String[] args) {
    }
    class Solution {
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null || root1.val != root2.val) {
                return false;
            }
            boolean b1 = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
            boolean b2 = flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right);
            return b1 || b2;
        }
    }
}
