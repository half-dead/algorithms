/*
https://leetcode.com/problems/unique-binary-search-trees-ii/description/

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:
    Input: 3
    Output:
        [
          [1,null,3,2],
          [3,2,null,1],
          [3,1,null,null,2],
          [2,1,3],
          [1,null,2,null,3]
        ]
    Explanation:
        The above output corresponds to the 5 unique BST's shown below:

           1         3     3      2      1
            \       /     /      / \      \
             3     2     1      1   3      2
            /     /       \                 \
           2     1         2                 3
 */

package p0500_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle095_UniqueBinarySearchTreesII {

    public static void main(String[] args) {
        Solution s = new Puzzle095_UniqueBinarySearchTreesII().new Solution();
        s.generateTrees(3);
    }

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            return recur(1, n);
        }

        public List<TreeNode> recur(int start, int end) {
            List<TreeNode> finalResult = new ArrayList<>();
            if (start > end) {
                return finalResult;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> result = new ArrayList<>();
                List<TreeNode> left = recur(start, i - 1);
                List<TreeNode> right = recur(i + 1, end);
                if (left.size() == 0) {
                    TreeNode root = new TreeNode(i);
                    result.add(root);
                } else {
                    for (TreeNode sub : left) {
                        TreeNode root = new TreeNode(i);
                        root.left = sub;
                        result.add(root);
                    }
                }

                if (right.size() > 0) {
                    List<TreeNode> dup = new ArrayList<>(result);
                    result = new ArrayList<>(dup.size() * right.size());
                    for (TreeNode root : dup) {
                        for (TreeNode sub : right) {
                            TreeNode newRoot = new TreeNode(root.val);
                            newRoot.left = root.left;
                            newRoot.right = sub;
                            result.add(newRoot);
                        }
                    }
                }
                finalResult.addAll(result);
            }
            return finalResult;
        }
    }

    static class DpSolution {
        public static List<TreeNode> generateTrees(int n) {
            List<TreeNode>[] result = new List[n + 1];
            result[0] = new ArrayList<>();
            if (n == 0) {
                return result[0];
            }

            result[0].add(null);
            for (int len = 1; len <= n; len++) {
                result[len] = new ArrayList<>();
                for (int j = 0; j < len; j++) {
                    for (TreeNode nodeL : result[j]) {
                        for (TreeNode nodeR : result[len - j - 1]) {
                            TreeNode node = new TreeNode(j + 1);
                            node.left = nodeL;
                            node.right = clone(nodeR, j + 1);
                            result[len].add(node);
                        }
                    }
                }
            }
            return result[n];
        }

        private static TreeNode clone(TreeNode n, int offset) {
            if (n == null) {
                return null;
            }
            TreeNode node = new TreeNode(n.val + offset);
            node.left = clone(n.left, offset);
            node.right = clone(n.right, offset);
            return node;
        }
    }
}
