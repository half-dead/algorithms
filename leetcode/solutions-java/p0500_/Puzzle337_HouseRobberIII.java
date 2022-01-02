package p0500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/house-robber-iii/
 *
 * @author half-dead
 */
public class Puzzle337_HouseRobberIII {
    public static void main(String[] args) {
        Puzzle337_HouseRobberIII p = new Puzzle337_HouseRobberIII();
        Solution s = p.new Solution();
        System.out.println(s.rob(new TreeNode("[3,2,3,#,3,#,1]")));
        System.out.println(s.rob(new TreeNode("[3,4,5,1,3,#,1]")));
        System.out.println(s.rob(new TreeNode("[0,2,5,1,3]")));
    }

    class Solution {
        public int rob(TreeNode root) {
            int[] res = dfs(root);
            return Math.max(res[0], res[1]);
        }

        int[] dfs(TreeNode root) {
            if (root == null) return new int[2];
            int[] left = dfs(root.left), right = dfs(root.right);
            return new int[]{
                    root.val + left[1] + right[1],
                    Math.max(left[0], left[1]) + Math.max(right[0], right[1])
            };
        }
    }

    class Solution2 {
        public int rob(TreeNode root) {
            return dfs(root, false);
        }

        int dfs(TreeNode root, boolean b) {
            if (root == null) return 0;
            int n1 = b ? 0 : (root.val + dfs(root.left, true) + dfs(root.right, true));
            int n2 = dfs(root.left, false) + dfs(root.right, false);
            return Math.max(n1, n2);
        }
    }
}
