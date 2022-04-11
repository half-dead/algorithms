package p2000_;

import java.util.*;

/**
 * https://leetcode.com/problems/delete-duplicate-folders-in-system/
 *
 * @author half-dead
 */
public class Puzzle1948 {

    public static void main(String[] args) {
        Solution s = new Puzzle1948().new Solution();
        System.out.println(s.deleteDuplicateFolder(Arrays.asList(
                Arrays.asList("b"),
                Arrays.asList("f"),
                Arrays.asList("f", "r"),
                Arrays.asList("f", "r", "g"),
                Arrays.asList("f", "r", "g", "c"),
                Arrays.asList("f", "r", "g", "c", "r"),
                Arrays.asList("f", "o"),
                Arrays.asList("f", "o", "x"),
                Arrays.asList("f", "o", "x", "t"),
                Arrays.asList("f", "o", "x", "d"),
                Arrays.asList("f", "o", "l"),
                Arrays.asList("l"),
                Arrays.asList("l", "q"),
                Arrays.asList("c"),
                Arrays.asList("h"),
                Arrays.asList("h", "t"),
                Arrays.asList("h", "o"),
                Arrays.asList("h", "o", "d"),
                Arrays.asList("h", "o", "t")

        )));
    }

    // trie, post-order dfs
    class Solution {
        Map<String, TrieNode> map = new HashMap<>();
        List<List<String>> res = new LinkedList<>();

        public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
            TrieNode root = new TrieNode("");
            for (List<String> path : paths) {
                TrieNode level = root;
                for (String f : path) {
                    level = level.sub.computeIfAbsent(f, TrieNode::new);
                }
            }

            mark(root);
            delete(root, new LinkedList<>());
            return res;
        }

        String mark(TrieNode node) {
            if (node.sub.size() == 0) return node.name;

            StringBuilder sb = new StringBuilder("[");
            for (TrieNode next : node.sub.values()) {
                sb.append(mark(next)).append(",");
            }
            sb.append("]");

            String key = sb.toString();
            if (map.containsKey(key)) {
                node.dup = true;
                map.get(key).dup = true;
            } else {
                map.put(key, node);
            }

            return node.name + "/" + key;
        }

        void delete(TrieNode node, LinkedList<String> path) {
            if (node.dup) return;

            if (node.name.length() > 0) path.addLast(node.name);

            for (TrieNode next : node.sub.values()) delete(next, path);

            if (path.size() > 0) res.add(new ArrayList<>(path));
            path.pollLast();
        }

        class TrieNode {
            String name;
            Map<String, TrieNode> sub;
            boolean dup = false;

            TrieNode(String s) {
                name = s;
                sub = new TreeMap<>();
            }
        }
    }


}
