package p2500_;

import struct.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/create-binary-tree-from-descriptions/
 *
 * @author half-dead
 */
public class Puzzle2196 {


    class Solution {
        public TreeNode createBinaryTree(int[][] d) {
            Set<Integer> set = new HashSet<>();
            for (int[] e : d) {
                set.add(e[0]);
                set.add(e[1]);
            }

            Map<Integer, TreeNode> map = new HashMap<>();
            for (int[] e : d) {
                TreeNode parent = map.computeIfAbsent(e[0], TreeNode::new),
                        child = map.computeIfAbsent(e[1], TreeNode::new);
                if (e[2] == 1) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                set.remove(e[1]);
            }
            return map.get(set.iterator().next());
        }
    }
}
