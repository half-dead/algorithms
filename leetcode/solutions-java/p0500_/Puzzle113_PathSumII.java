/*
https://leetcode.com/problems/path-sum-ii/description/

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
Note: A leaf is a node with no children.

Example:
    Given the below binary tree and sum = 22,
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \    / \
    7    2  5   1
Return:
    [
       [5,4,11,2],
       [5,8,4,5]
    ]
 */

package p0500_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle113_PathSumII {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            dfs(result, new ArrayList<>(), root, sum);
            return result;
        }

        public void dfs(List<List<Integer>> result, List<Integer> current, TreeNode root, int sum) {
            if (root == null) {
                return;
            }

            current.add(root.val);
            sum -= root.val;
            if (root.left == null && root.right == null) {
                if (sum == 0) {
                    result.add(current);
                    return;
                }
            }
            dfs(result, new ArrayList<>(current), root.left, sum);
            dfs(result, new ArrayList<>(current), root.right, sum);
            return;
        }
    }
}
