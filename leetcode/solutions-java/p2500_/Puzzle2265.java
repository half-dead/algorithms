package p2500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 *
 * @author half-dead
 */
public class Puzzle2265 {


    // post-order dfs
    class Solution {

        int res = 0;

        public int averageOfSubtree(TreeNode root) {
            dfs(root);
            return res;
        }

        public int[] dfs(TreeNode node) {
            if (node == null) {
                return new int[]{0, 0};
            }
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);
            int sum = left[0] + right[0] + node.val;
            int cnt = left[1] + right[1] + 1;
            if (node.val == sum / cnt) {
                res++;
            }
            return new int[]{sum, cnt};
        }
    }
}
