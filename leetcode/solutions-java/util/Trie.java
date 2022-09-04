package util;

/**
 * @author half-dead
 */
class Trie {
    private static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isWord = false;
        long count = 0L;
    }

    private TrieNode root = new TrieNode();

    public void add(String word) {
        add(word, 1L);
    }

    public void remove(String word) {
        add(word, -1L);
    }

    private void add(String word, long count) {
        TrieNode cur = root;
        cur.count += count;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.next[c] == null) cur.next[c] = new TrieNode();
            cur = cur.next[c];
            cur.count += count;
        }
        cur.isWord = true;
    }

    public boolean contains(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.next[c] == null || cur.next[c].count <= 0L) return false;
            cur = cur.next[c];
            //if (cur.isWord) return true;
        }
        return cur.isWord;
    }
}
