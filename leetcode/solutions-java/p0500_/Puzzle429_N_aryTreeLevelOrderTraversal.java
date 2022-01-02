package p0500_;

import struct.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 *
 * @author half-dead
 */
public class Puzzle429_N_aryTreeLevelOrderTraversal {

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root != null) {
                recur(result, 0, root);
            }
            return result;
        }

        public void recur(List<List<Integer>> result, int level, Node node) {
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(node.val);
            int nextlevel = level + 1;
            for (Node n : node.children) {
                recur(result, nextlevel, n);
            }
        }
    }


    class StackSolution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            LinkedList<Node> stack = new LinkedList<>();
            Node marker = new Node();
            stack.push(root);
            stack.push(marker);
            List<Integer> temp = new ArrayList<>();
            while (stack.size() > 0) {
                Node n = stack.pop();
                if (n == marker) {
                    if (stack.size() > 0) {
                        stack.push(marker);
                    }
                    result.add(temp);
                    temp = new ArrayList<>();
                } else {
                    temp.add(n.val);
                    for (Node child : n.children) {
                        stack.push(child);
                    }
                }
            }
            return result;
        }
    }
}
