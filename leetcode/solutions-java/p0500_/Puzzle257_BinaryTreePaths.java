package p0500_;

// Given a binary tree, return all root-to-leaf paths.
//
// For example, given the following binary tree:
//
//    1
//  /   \
// 2    3
//  \
//   5
//
// All root-to-leaf paths are:
// ["1->2->5", "1->3"]

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle257_BinaryTreePaths {

    public static void main(String[] args) {
        Puzzle257_BinaryTreePaths p = new Puzzle257_BinaryTreePaths();
        Solution s = p.new Solution();

        TreeNode root = new TreeNode("{1,2,3,4,5,6,7,8,9,10,11,12,13,#,#,14,15,16,17,18,#,19,#,#,#,#,#,#,#,#,#,20}");
        List<String> list = s.binaryTreePaths(root);
        System.out.println(list);
    }

    class Solution {

        public List<String> binaryTreePaths(TreeNode root) {

            List<String> result = new ArrayList<>();

            if (root != null) {
                LinkedList<TreeNode> nodeQueue = new LinkedList<>();
                LinkedList<String> pathQueue = new LinkedList<>();

                nodeQueue.addLast(root);
                pathQueue.addLast("" + root.val);

                while (nodeQueue.peekFirst() != null) {
                    TreeNode parent = nodeQueue.pollFirst();
                    String parentPath = pathQueue.pollFirst();

                    if (parent.left != null) {
                        nodeQueue.addLast(parent.left);
                        pathQueue.addLast(parentPath + "->" + parent.left.val);
                    }
                    if (parent.right != null) {
                        nodeQueue.addLast(parent.right);
                        pathQueue.addLast(parentPath + "->" + parent.right.val);
                    }
                    if (parent.left == null && parent.right == null) {
                        result.add(parentPath);
                    }
                }
            }

            return result;
        }
    }
}
