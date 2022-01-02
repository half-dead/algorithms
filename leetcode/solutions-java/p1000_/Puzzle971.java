package p1000_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
 *
 * @author half-dead
 */
public class Puzzle971 {

    class Solution {
        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            List<Integer> res = new ArrayList<>();
            dfs(root, voyage, new int[]{0}, res);
            return res;
        }

        boolean dfs(TreeNode node, int[] voyage, int[] pos, List<Integer> res) {
            if (node == null) return true;
            if (node.val != voyage[pos[0]]) {
                res.clear();
                res.add(-1);
                return false;
            }
            pos[0]++;
            if (pos[0] == voyage.length) return true;
            if (node.left != null && node.right != null && node.right.val == voyage[pos[0]]) {
                res.add(node.val);
                return dfs(node.right, voyage, pos, res) && dfs(node.left, voyage, pos, res);
            } else {
                return dfs(node.left, voyage, pos, res) && dfs(node.right, voyage, pos, res);
            }
        }
    }
}
