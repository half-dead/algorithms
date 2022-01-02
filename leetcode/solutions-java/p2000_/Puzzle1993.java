package p2000_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/operations-on-tree/
 *
 * @author half-dead
 */
public class Puzzle1993 {

    class LockingTree {

        Node[] nodes;

        public LockingTree(int[] parent) {
            int n = parent.length;
            Map<Integer, List<Integer>> g = new HashMap<>();
            for (int i = 1; i < n; i++) {
                g.computeIfAbsent(parent[i], x -> new ArrayList<>()).add(i);
            }
            nodes = new Node[n];
            dfs(null, 0, g);
        }

        Node dfs(Node parent, int id, Map<Integer, List<Integer>> g) {
            Node node = new Node(parent);
            List<Integer> children = g.get(id);
            if (children != null) {
                node.children = new ArrayList<>(children.size());
                for (int cid : children) {
                    node.children.add(dfs(node, cid, g));
                }
            }
            return nodes[id] = node;
        }

        public boolean lock(int num, int user) {
            Node node = nodes[num];
            if (node.locked) return false;

            node.locked = true;
            node.user = user;
            return true;
        }

        public boolean unlock(int num, int user) {
            Node node = nodes[num];
            if (!node.locked || node.user != user) return false;

            node.locked = false;
            node.user = 0;
            return true;
        }

        public boolean upgrade(int num, int user) {
            Node temp = nodes[num];
            while (temp != null) {
                if (temp.locked) return false;
                temp = temp.parent;
            }

            temp = nodes[num];
            int total = unlockAll(temp);
            if (total == 0) return false;

            temp.locked = true;
            temp.user = user;
            return true;
        }

        private int unlockAll(Node node) {
            int res = 0;
            if (node.locked) {
                node.locked = false;
                res++;
            }
            if (node.children != null) {
                for (Node child : node.children) {
                    res += unlockAll(child);
                }
            }
            return res;
        }
    }

    class Node {
        Node parent;
        List<Node> children;
        boolean locked;
        int user;

        Node(Node parent) {
            this.parent = parent;
        }
    }
}
