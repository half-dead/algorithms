package p1000_;

import struct.Node;

/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 *
 * @author half-dead
 */
public class Puzzle559 {


    class Solution {
        public int maxDepth(Node root) {
            return dfs(root);
        }

        int dfs(Node node) {
            if (node == null) return 0;
            int max = 0;
            for (Node child : node.children) {
                max = Math.max(max, dfs(child));
            }
            return 1 + max;
        }
    }
}
