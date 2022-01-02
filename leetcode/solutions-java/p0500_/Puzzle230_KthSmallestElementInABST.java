package p0500_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * @author half-dead
 */
public class Puzzle230_KthSmallestElementInABST {

    class Solution {
        int count;
        int number;
        public int kthSmallest(TreeNode root, int k) {
            inorder(root, k);
            return number;
        }

        public void inorder(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            inorder(root.left, k);
            count++;
            if (count == k) {
                number = root.val;
                return;
            }
            inorder(root.right, k);
        }
    }

    class Solution1 {
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            inorder(root, k, list);
            return list.get(k - 1);
        }

        public void inorder(TreeNode root, int k, List<Integer> list) {
            if (root == null || list.size() == k) {
                return;
            }
            inorder(root.left, k, list);
            list.add(root.val);
            inorder(root.right, k, list);
        }
    }
}
