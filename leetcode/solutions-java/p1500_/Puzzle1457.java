package p1500_;

import struct.TreeNode;

/**
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle1457 {

    class Solution {
        public int pseudoPalindromicPaths(TreeNode root) {
            // map[0] stores the result
            // map[1-9] stores the number of nodes with value 1-9
            int[] map = new int[10];
            dfs(root, map);
            return map[0];
        }

        void dfs(TreeNode node, int[] map) {
            if (node == null) return;

            map[node.val]++;
            if (node.left == null && node.right == null) {
                int odd = 0;
                for (int i = 1; i <= 9; i++) if ((map[i] & 1) == 1) odd++;
                if (odd < 2) map[0]++;
            } else {
                dfs(node.left, map);
                dfs(node.right, map);
            }
            map[node.val]--;
        }
    }
}
