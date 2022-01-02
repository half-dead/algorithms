package p0500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * @author half-dead
 */
public class Puzzle124_BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        Puzzle124_BinaryTreeMaximumPathSum p = new Puzzle124_BinaryTreeMaximumPathSum();
        Solution s = p.new Solution();
        System.out.println(s.maxPathSum(new TreeNode("[-2,6,#,0,-6]")));
    }

    class Solution {
        public int maxPathSum(TreeNode root) {
            if (root == null) return 0;
            int[] max = dfs(root);
            return Math.max(max[0], max[1]);
        }

        int[] dfs(TreeNode root) {
            if (root == null) return null;

            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            return new int[]{
                    max(
                            root.val,
                            left != null ? (root.val + left[0]) : root.val,
                            right != null ? (root.val + right[0]) : root.val
                    ),
                    max(
                            left != null ? left[0] : Integer.MIN_VALUE,
                            left != null ? left[1] : Integer.MIN_VALUE,
                            right != null ? right[0] : Integer.MIN_VALUE,
                            right != null ? right[1] : Integer.MIN_VALUE,
                            root.val + (left != null ? left[0] : 0) + (right != null ? right[0] : 0)
                    )
            };
        }

        int max(int... arr) {
            int max = Integer.MIN_VALUE;
            for (int n : arr) {
                max = Math.max(max, n);
            }
            return max;
        }
    }
}
