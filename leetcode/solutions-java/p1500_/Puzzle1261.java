package p1500_;

import struct.TreeNode;

import java.util.BitSet;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle1261 {

    class FindElements {
        private BitSet set = new BitSet();

        public FindElements(TreeNode root) {
            dfs(root, 0);
        }

        public boolean find(int target) {
            return set.get(target);
        }

        private void dfs(TreeNode node, int idx) {
            if (node == null) return;
            set.set(idx);
            dfs(node.left, 2 * idx + 1);
            dfs(node.right, 2 * idx + 2);
        }
    }

    class ArrayFindElements {
        boolean[] values;

        public ArrayFindElements(TreeNode root) {
            values = new boolean[1 << 20];

            LinkedList<Pair> q = new LinkedList<>();
            q.addLast(new Pair(0, root));
            while (q.size() > 0) {
                for (int j = q.size(); j > 0; j--) {
                    Pair top = q.pollFirst();
                    int idx = top.idx;
                    TreeNode node = top.node;

                    values[idx] = true;
                    if (node.left != null) q.addLast(new Pair(2 * idx + 1, node.left));
                    if (node.right != null) q.addLast(new Pair(2 * idx + 2, node.right));
                }
            }
        }

        public boolean find(int target) {
            return values[target];
        }

        class Pair {
            int idx;
            TreeNode node;

            public Pair(int idx, TreeNode node) {
                this.idx = idx;
                this.node = node;
            }
        }
    }

}
