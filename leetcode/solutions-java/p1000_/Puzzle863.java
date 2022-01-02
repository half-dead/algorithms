package p1000_;

import struct.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle863 {

    class GSolution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            Map<TreeNode, TreeNode> parentMap = new HashMap<>();
            dfs(parentMap, root, null);

            boolean[] visited = new boolean[501];
            LinkedList<TreeNode> q = new LinkedList<>();
            q.offer(target);
            while (k-- > 0) {
                int size = q.size();
                while (size-- > 0) {
                    TreeNode node = q.poll();

                    visited[node.val] = true;
                    TreeNode parent = parentMap.get(node), left = node.left, right = node.right;
                    if (parent != null && !visited[parent.val]) q.offer(parent);
                    if (left != null && !visited[left.val]) q.offer(left);
                    if (right != null && !visited[right.val]) q.offer(right);
                }
            }
            List<Integer> res = new ArrayList<>();
            for (TreeNode node : q) res.add(node.val);
            return res;
        }

        void dfs(Map<TreeNode, TreeNode> parentMap, TreeNode node, TreeNode parent) {
            if (node == null) return;
            if (parent != null) parentMap.put(node, parent);
            dfs(parentMap, node.left, node);
            dfs(parentMap, node.right, node);
        }
    }
}
