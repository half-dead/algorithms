package p2000_;

import struct.TreeNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
 *
 * @author half-dead
 */
public class Puzzle1530 {

    // bottom-up dp using hashmap as memory
    class Solution {
        int res;
        int distance;

        public int countPairs(TreeNode root, int d) {
            this.distance = d;
            dfs(root);
            return res;
        }

        Map<Integer, Integer> dfs(TreeNode node) {
            Map<Integer, Integer> map = new HashMap<>();
            if (node.left == null && node.right == null) {
                map.put(0, 1);
                return map;
            }

            Map<Integer, Integer> lm = node.left != null ? dfs(node.left) : Collections.emptyMap(),
                    rm = node.right != null ? dfs(node.right) : Collections.emptyMap();

            for (int kl : lm.keySet()) {
                for (int kr : rm.keySet()) {
                    if (kl + kr + 2 <= distance) {
                        res += lm.get(kl) * rm.get(kr);
                    }
                }
            }

            for (int depth : lm.keySet()) {
                map.put(1 + depth, map.getOrDefault(1 + depth, 0) + lm.get(depth));
            }
            for (int depth : rm.keySet()) {
                map.put(1 + depth, map.getOrDefault(1 + depth, 0) + rm.get(depth));
            }
            return map;
        }
    }
}
