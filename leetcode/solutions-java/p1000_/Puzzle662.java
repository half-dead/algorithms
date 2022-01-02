package p1000_;

import struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle662 {

    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            Map<Integer, long[]> map = new HashMap<>();
            dfs(root, 0, 0, map);

            int res = 1;
            for (long[] r : map.values()) res = Math.max(res, (int) (r[1] - r[0] + 1));
            return res;
        }

        void dfs(TreeNode node, int level, int shift, Map<Integer, long[]> map) {
            if (node == null) return;

            map.computeIfAbsent(level, x -> new long[]{shift, shift})[1] = shift;

            dfs(node.left, level + 1, shift * 2, map);
            dfs(node.right, level + 1, shift * 2 + 1, map);
        }
    }
}
