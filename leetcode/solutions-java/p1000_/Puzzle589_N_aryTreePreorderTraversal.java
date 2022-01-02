/*
https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/

Given an n-ary tree, return the preorder traversal of its nodes' values.


For example, given a 3-ary tree:

Return its preorder traversal as: [1,3,5,6,2,4].


Note: Recursive solution is trivial, could you do it iteratively?
 */

package p1000_;

import struct.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle589_N_aryTreePreorderTraversal {

    class RecursiveSolution {
        public List<Integer> preorder(Node root) {
            List<Integer> result = new LinkedList<>();
            if (root != null) {
                result.add(root.val);
                for (Node n : root.children) {
                    result.addAll(preorder(n));
                }
            }
            return result;
        }
    }

    class IterativeSolution {
        public List<Integer> preorder(Node root) {
            LinkedList<Integer> result = new LinkedList<>();
            LinkedList<Node> stack = new LinkedList<>();
            stack.push(root);
            while (stack.size() > 0) {
                Node node = stack.pop();
                if (node != null) {
                    result.add(node.val);
                    List<Node> children = node.children;
                    if (children != null && children.size() > 0) {
                        LinkedList<Node> copy = new LinkedList<>(children);
                        copy.addAll(stack);
                        stack = copy;
                    }
                }
            }
            return result;
        }
    }
}
