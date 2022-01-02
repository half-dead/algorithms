/*
https://leetcode.com/problems/most-frequent-subtree-sum/description/

Given the root of a tree, you are asked to find the most frequent subtree sum.
The subtree sum of a node is defined as the sum of all the node values
formed by the subtree rooted at that node (including the node itself).

So what is the most frequent subtree sum value?
If there is a tie, return all the values with the highest frequency in any order.

Examples 1
    Input:
      5
     /  \
    2   -3
    return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
    Input:
      5
     /  \
    2   -5
    return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */

package p1000_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author half-dead
 */
public class Puzzle508_MostFrequentSubtreeSum {
    class Solution {
        private Map<Integer, Integer> map = new HashMap<>();
        private List<Integer> list = new ArrayList<>();
        private int max = 0;

        public int[] findFrequentTreeSum(TreeNode root) {
            if (root == null) {
                return new int[]{};
            }
            recur2(root, map, list);
            int[] res = new int[list.size()];
            int i = 0;
            for (int j : list) {
                res[i++] = j;
            }
            return res;
        }

        public void recur2(TreeNode root, Map<Integer, Integer> map, List<Integer> list) {
            if (root == null) {
                return;
            }
            recur2(root.left, map, list);
            recur2(root.right, map, list);
            int sum = root.val;
            if (root.left != null) {
                sum += root.left.val;
            }
            if (root.right != null) {
                sum += root.right.val;
            }
            root.val = sum;
            int freq = map.getOrDefault(root.val, 0) + 1;
            map.put(root.val, freq);
            if (freq == max) {
                list.add(sum);
            } else if (freq > max) {
                max = freq;
                list.clear();
                list.add(sum);
            }
        }
    }
}
