package p2000_;

import struct.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-bsts-to-create-single-bst/
 *
 * @author half-dead
 */
public class Puzzle1932 {

    public static void main(String[] args) {
        Solution s = new Puzzle1932().new Solution();
        System.out.println(s.canMerge(Arrays.asList(
                new TreeNode("[7]")
        )));
    }

    // dfs
    class Solution {
        public TreeNode canMerge(List<TreeNode> trees) {
            Set<Integer> roots = new HashSet<>(trees.size());
            for (TreeNode tn : trees) roots.add(tn.val);

            Map<Integer, Set<Integer>> g = new HashMap<>(trees.size());
            for (TreeNode tn : trees) {
                int v = tn.val;
                g.put(v, new HashSet<>());

                if (tn.left != null) {
                    if (!g.get(v).add(tn.left.val)) return null;
                    roots.remove(tn.left.val);
                }
                if (tn.right != null) {
                    if (!g.get(v).add(tn.right.val)) return null;
                    roots.remove(tn.right.val);
                }
            }
            if (roots.size() != 1) return null;

            TreeNode root = new TreeNode(roots.iterator().next());
            if (dfs(root, g) && g.size() == 0 && check(root, 0, Integer.MAX_VALUE))
                return root;
            return null;
        }

        boolean dfs(TreeNode root, Map<Integer, Set<Integer>> g) {
            Set<Integer> children = g.get(root.val);
            if (children == null) return true;

            g.remove(root.val);
            boolean res = true;
            for (int cv : children) {
                if (cv < root.val && root.left == null) {
                    root.left = new TreeNode(cv);
                    res = res && dfs(root.left, g);
                } else if (cv > root.val && root.right == null) {
                    root.right = new TreeNode(cv);
                    res = res && dfs(root.right, g);
                } else {
                    return false;
                }
            }
            return res;
        }

        boolean check(TreeNode root, int lo, int hi) {
            if (root == null) return true;
            boolean res = root.val > lo && root.val < hi;
            return res && check(root.left, lo, root.val) && check(root.right, root.val, hi);
        }
    }
}
