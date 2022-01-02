package p1500_;

import struct.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle1161 {
    class Solution {
        public int maxLevelSum(TreeNode root) {
            int result = 0, max = Integer.MIN_VALUE, level = 1;
            LinkedList<TreeNode> q = new LinkedList<>();
            q.addLast(root);
            for (; q.size() > 0; level++) {
                int sum = 0;
                for (int j = q.size(); j > 0; j--) {
                    TreeNode node = q.pollFirst();
                    sum += node.val;
                    if (node.left != null) q.addLast(node.left);
                    if (node.right != null) q.addLast(node.right);
                }
                if (sum > max) {
                    result = level;
                    max = sum;
                }
            }
            return result;
        }
    }
}
