package p1000_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle987 {

    class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            TreeMap<Integer, PriorityQueue<int[]>> map = new TreeMap<>();
            preorder(root, 0, 0, map);
            List<List<Integer>> list = new ArrayList<>(map.size());
            for (PriorityQueue<int[]> pq : map.values()) {
                List<Integer> column = new ArrayList<>(pq.size());
                while (!pq.isEmpty()) {
                    column.add(pq.poll()[1]);
                }
                list.add(column);
            }
            return list;
        }

        void preorder(TreeNode root, int x, int y, TreeMap<Integer, PriorityQueue<int[]>> map) {
            if (root == null) return;
            map.computeIfAbsent(x, (k) -> new PriorityQueue<>((e, f) -> e[0] == f[0] ? e[1] - f[1] : e[0] - f[0]))
                    .add(new int[]{y, root.val});
            preorder(root.left, x - 1, y + 1, map);
            preorder(root.right, x + 1, y + 1, map);
        }
    }
}
