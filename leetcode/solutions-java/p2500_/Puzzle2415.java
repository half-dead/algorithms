package p2500_;

import struct.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle2415 {

    class Solution {
        public TreeNode reverseOddLevels(TreeNode root) {
            dfs(root.left, root.right, 1);
            return root;
        }

        void dfs(TreeNode node, TreeNode partener, int level) {
            if (node == null || partener == null) return;

            if (level % 2 == 1) {
                int temp = node.val;
                node.val = partener.val;
                partener.val = temp;
            }

            dfs(node.left, partener.right, level + 1);
            dfs(node.right, partener.left, level + 1);
        }
    }

    class Solution1 {
        public TreeNode reverseOddLevels(TreeNode root) {
            Map<Integer, Deque<TreeNode>> nodes = new HashMap<>();
            Map<Integer, Deque<Integer>> vals = new HashMap<>();
            dfs(root, 0, nodes, vals);
            for (int level : nodes.keySet()) {
                Deque<TreeNode> nodeq = nodes.get(level);
                Deque<Integer> valq = vals.get(level);
                while (nodeq.size() > 0) {
                    nodeq.pollFirst().val = valq.pollLast();
                }
            }
            return root;
        }

        void dfs(TreeNode node, int level, Map<Integer, Deque<TreeNode>> nodes, Map<Integer, Deque<Integer>> vals) {
            if (node == null) return;

            if (level % 2 != 0) {
                Deque<TreeNode> nodeq = nodes.computeIfAbsent(level, x -> new LinkedList<>());
                Deque<Integer> valq = vals.computeIfAbsent(level, x -> new LinkedList<>());
                nodeq.addLast(node);
                valq.addLast(node.val);
            }
            dfs(node.left, level + 1, nodes, vals);
            dfs(node.right, level + 1, nodes, vals);
        }
    }
}
