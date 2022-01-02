package p1000_;

import struct.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 *
 * @author half-dead
 */
public class Puzzle590_N_aryTreePostorderTraversal {

    class Solution {
        public List<Integer> postorder(Node root) {
            LinkedList<Integer> result = new LinkedList<>();
            if (root == null) return result;

            Deque<Node> q = new LinkedList<>();
            q.addLast(root);
            while (q.size() > 0) {
                Node node = q.pollLast();
                result.addFirst(node.val);
                for (Node child : node.children) q.addLast(child);
            }
            return result;
        }
    }

    class RecursiveSolution {
        public List<Integer> postorder(Node root) {
            List<Integer> list = new LinkedList<>();
            if (root == null) return list;
            dfs(root, list);
            return list;
        }

        public void dfs(Node node, List<Integer> list) {
            for (Node child : node.children) dfs(child, list);
            list.add(node.val);
        }
    }
}
