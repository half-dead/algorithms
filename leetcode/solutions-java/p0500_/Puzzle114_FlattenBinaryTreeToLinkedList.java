package p0500_;

// Given a binary tree, flatten it to a linked list in-place.
//
//  For example,
//  Given
//       1
//      / \
//     2   5
//    / \   \
//   3   4   6
// The flattened tree should look like:
//   1
//    \
//     2
//      \
//       3
//        \
//         4
//          \
//           5
//            \
//             6

import struct.TreeNode;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Puzzle114_FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Puzzle114_FlattenBinaryTreeToLinkedList p = new Puzzle114_FlattenBinaryTreeToLinkedList();
        NonQueueSolution nq = p.new NonQueueSolution();
        TreeNode tn = new TreeNode("[3,4,5,1,2]");
        System.out.println(tn);
        nq.flatten(tn);
        System.out.println(tn);
    }

    // O(n) space complexity
    public class QueueSolution {
        public void flatten(TreeNode root) {
            if (root == null) return;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>(2048);
            queue.add(root);
            TreeNode p = new TreeNode(0), newRoot = p;
            while (!queue.isEmpty()) {
                TreeNode node = queue.pop();
                if (node.right != null) queue.addFirst(node.right);
                if (node.left != null) queue.addFirst(node.left);
                p.right = node;
                p = node;
                node.left = null;
            }
            root.left = null;
            root.right = newRoot.right.right;
        }
    }

    // non-recursive, O(1) space complexity, neat!
    public class NonQueueSolution {
        public void flatten(TreeNode root) {
            while (root != null) {
                if (root.left != null) {
                    TreeNode node = root.left;
                    while (node.right != null) {
                        node = node.right;
                    }
                    node.right = root.right;
                    root.right = root.left;
                    root.left = null;
                }
                root = root.right;
            }
        }
    }

    public class RecursiveSolution {
        public void flatten(TreeNode root) {
            if (root == null) return;
            flatten(root.left);
            flatten(root.right);

            TreeNode r = root.right;
            if (root.left != null) {
                root.right = root.left;
                root.left = null;

                while (root.right != null) {
                    root = root.right;
                }

                root.right = r;
            }
        }
    }
}
