package p0500_;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * @author half-dead
 */
public class Puzzle208_ImplementTriePrefixTree {
    public static void main(String[] args) {
        Puzzle208_ImplementTriePrefixTree p = new Puzzle208_ImplementTriePrefixTree();
        Trie trie = p.new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    class Trie {
        Trie[] next;
        boolean end = false;

        public Trie() {
            next = new Trie[26];
        }

        public void insert(String word) {
            Trie[] level = next;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                Trie t = level[idx];
                if (t == null) {
                    t = new Trie();
                    level[idx] = t;
                }
                level = t.next;
                if (i == word.length() - 1) {
                    t.end = true;
                }
            }
        }

        public boolean search(String word) {
            Trie[] level = next;
            Trie t = null;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if ((t = level[idx]) == null) break;
                level = t.next;
            }
            return t != null && t.end;
        }

        public boolean startsWith(String prefix) {
            Trie[] level = next;
            Trie t = null;
            for (int i = 0; i < prefix.length(); i++) {
                int idx = prefix.charAt(i) - 'a';
                if ((t = level[idx]) == null) break;
                level = t.next;
            }
            return t != null;
        }
    }
}
