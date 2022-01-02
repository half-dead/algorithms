package p1500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
 *
 * @author half-dead
 */
public class Puzzle1233 {
    public static void main(String[] args) {
        Solution s = new Puzzle1233().new Solution();
        System.out.println(s.removeSubfolders(new String[]{"/a/b", "/a/b/c"}));
    }

    // sort by length + Trie
    class Solution {
        public List<String> removeSubfolders(String[] folders) {
            Arrays.sort(folders, (a, b) -> a.length() - b.length());
            List<String> result = new ArrayList<>();
            Trie root = new Trie();
            for (String folder : folders) {
                Trie node = root;
                boolean skip = false;
                for (int i = 0; i < folder.length(); i++) {
                    int idx = folder.charAt(i) - 'a';
                    if (idx < 0) idx = 26;
                    if (node.next[idx] == null) node.next[idx] = new Trie();
                    node = node.next[idx];

                    if (node.end && folder.charAt(i + 1) == '/') {
                        skip = true;
                        break;
                    }
                }
                if (skip) continue;
                node.end = true;
                result.add(folder);
            }
            return result;
        }

        class Trie {
            Trie[] next;
            boolean end;

            public Trie() {
                next = new Trie[27];
            }
        }
    }


    // Trie + dfs, 84ms
    class TrieDfsSolution {
        public List<String> removeSubfolders(String[] folders) {
            Trie root = new Trie();
            for (String folder : folders) {
                Trie node = root;
                char[] cs = folder.toCharArray();
                for (char c : cs) {
                    int idx = c == '/' ? 26 : (c - 'a');
                    if (node.next[idx] == null) {
                        node.next[idx] = new Trie();
                    }
                    node = node.next[idx];
                }
                node.end = true;
                node.val = folder;
            }
            List<String> result = new LinkedList<>();
            dfs(root, result);
            return result;
        }

        void dfs(Trie root, List<String> result) {
            if (root.end) {
                result.add(root.val);
                for (int i = 0; i < 26; i++) if (root.next[i] != null) dfs(root.next[i], result);
            } else {
                for (Trie node : root.next) if (node != null) dfs(node, result);
            }
        }

        class Trie {
            Trie[] next;
            boolean end;
            String val;

            public Trie() {
                next = new Trie[27];
            }
        }
    }

    class SortSolution {
        public List<String> removeSubfolders(String[] folders) {
            Arrays.sort(folders);
            List<String> result = new LinkedList<>();
            String prev = " ";
            for (String folder : folders)
                if (!folder.startsWith(prev) || folder.charAt(prev.length()) != '/')
                    result.add((prev = folder));
            return result;
        }
    }
}
