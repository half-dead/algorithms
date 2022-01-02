package p1000_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/
 *
 * @author half-dead
 */
public class Puzzle988_SmallestStringStartingFromLeaf {

    class Solution {
        String result;
        public String smallestFromLeaf(TreeNode root) {
            if (root == null) {
                return "";
            }
            recur(root, new StringBuilder());
            return result;
        }

        private void recur(TreeNode root, StringBuilder sb) {
            sb.append((char) ('a' + root.val));
            if (root.left == null && root.right == null) {
                String s = sb.reverse().toString();
                if (result == null || s.compareTo(result) < 0) {
                    result = s;
                }
                return;
            }
            if (root.left != null) {
                recur(root.left, new StringBuilder(sb));
            }
            if (root.right != null) {
                recur(root.right, new StringBuilder(sb));
            }
        }
    }
}
