package p2500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 *
 * @author half-dead
 */
public class Puzzle2096 {

    // lowest common ancestor, DFS
    class Solution {
        public String getDirections(TreeNode root, int startValue, int destValue) {
            StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
            find(root, startValue, s1);
            find(root, destValue, s2);

            // remove common prefix
            int n = Math.min(s1.length(), s2.length()), i = 0;
            while (i < n && s1.charAt(i) == s2.charAt(i)) i++;

            StringBuilder res = new StringBuilder();
            for (int j = i; j < s1.length(); j++) {
                res.append("U");
            }
            res.append(s2, i, s2.length());
            return res.toString();
        }

        boolean find(TreeNode root, int value, StringBuilder sb) {
            if (root.val == value) return true;

            if (root.left != null) {
                sb.append("L");
                if (find(root.left, value, sb)) return true;
                sb.deleteCharAt(sb.length() - 1);
            }
            if (root.right != null) {
                sb.append("R");
                if (find(root.right, value, sb)) return true;
                sb.deleteCharAt(sb.length() - 1);
            }
            return false;
        }
    }
}
