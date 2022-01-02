/*
https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

You need to find the largest value in each row of a binary tree.

Example:
  Input:
            1
           / \
          3   2
         / \   \
        5   3   9
  Output: [1, 3, 9]
 */

package p1000_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle515_FindLargestValueInEachTreeRow {

    public static void main(String[] args) {
        Puzzle515_FindLargestValueInEachTreeRow p = new Puzzle515_FindLargestValueInEachTreeRow();
        Solution s = p.new Solution();
        System.out.println(s.largestValues(new TreeNode("[1,3,2,5,3,#,9]")));
    }

    class StackSolution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();

            if (root != null) {
                queue.push(root);
            }
            while (queue.size() > 0) {
                LinkedList<TreeNode> nextRow = new LinkedList<>();
                Integer max = Integer.MIN_VALUE;
                while (queue.size() > 0) {
                    TreeNode head = queue.pop();
                    if (max < head.val) {
                        max = head.val;
                    }
                    if (head.left != null) {
                        nextRow.push(head.left);
                    }
                    if (head.right != null) {
                        nextRow.push(head.right);
                    }
                }
                queue = nextRow;
                result.add(max);
            }
            return result;
        }
    }

    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            dfs(root, 0, result);
            return result;
        }

        public void dfs(TreeNode root, int level, List<Integer> result) {
            if (root != null) {
                if (result.size() > level) {
                    result.set(level, Math.max(root.val, result.get(level)));
                } else {
                    result.add(level, root.val);
                }

                dfs(root.left, level + 1, result);
                dfs(root.right, level + 1, result);
            }
        }
    }
}
