package p0500_;

// Given a binary tree, return the postorder traversal of its nodes' values.
//
// For example:
// Given binary tree {1,#,2,3},
// 1
//  \
//   2
//  /
// 3
// return [3,2,1].
//
// Note: Recursive solution is trivial, could you do it iteratively?

import struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class Puzzle145_BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode("{1,2,3,4,5,6,7}");
        Puzzle145_BinaryTreePostorderTraversal p = new Puzzle145_BinaryTreePostorderTraversal();

        Solution s = p.new Solution();
        s.postorderTraversal(root);

        Solution2 s2 = p.new Solution2();
        s2.postorderTraversal(root);

        Solution3 s3 = p.new Solution3();
        s3.postorderTraversal(root);
    }

    public class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;

            int i = 0;
            LinkedList<TreeNode> queue = new LinkedList<>();
            LinkedList<Boolean> flags = new LinkedList<>();
            queue.addLast(root);
            flags.addLast(false);
            while (!queue.isEmpty()) {
                i++;
                TreeNode node = queue.peekFirst();
                Boolean flag = flags.peekFirst();
                if (flag) {
                    result.add(queue.removeFirst().val);
                    flags.removeFirst();
                } else {
                    flags.removeFirst();
                    flags.addFirst(true);
                    if (node.right != null) {
                        queue.addFirst(node.right);
                        flags.addFirst(false);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                        flags.addFirst(false);
                    }
                }
            }
            System.out.println("i = " + i);
            return result;
        }
    }

    public class Solution2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            if (root == null) return list;

            int i = 0;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                i++;
                TreeNode node = queue.removeFirst();
                list.addFirst(node.val);
                if (node.left != null) queue.addFirst(node.left);
                if (node.right != null) queue.addFirst(node.right);
            }
            System.out.println("i2 = " + i);
            return list;
        }
    }

    public class Solution3 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;

            int i = 0;
            TreeNode lastNode = null;
            ArrayDeque<TreeNode> toVisit = new ArrayDeque<>();
            while (root != null || !toVisit.isEmpty()) {
                i++;
                if (root != null) {
                    toVisit.addLast(root);
                    root = root.left;
                } else {
                    TreeNode node = toVisit.peekLast();
                    if (node.right != null && lastNode != node.right) {
                        root = node.right;
                    } else {
                        lastNode = toVisit.removeLast();
                        list.add(lastNode.val);
                    }
                }
            }
            System.out.println("i3 = " + i);
            return list;
        }
    }

    public class RecursiveSolution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            recurse(list, root);
            return list;
        }

        public void recurse(List<Integer> list, TreeNode node) {
            if (node == null) return;
            recurse(list, node.left);
            recurse(list, node.right);
            list.add(node.val);
        }
    }
}
