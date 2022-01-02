package p1500_;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/stream-of-characters/
 *
 * @author half-dead
 */
public class Puzzle1032 {

    // Forward-order Trie + Deque
    class StreamChecker0 {

        TN root;
        Deque<TN> q = new LinkedList<>();

        public StreamChecker0(String[] words) {
            root = new TN();

            for (String word : words) {
                TN level = root;
                for (char c : word.toCharArray()) {
                    int idx = c - 'a';
                    if (level.next[idx] == null) level.next[idx] = new TN();
                    level = level.next[idx];
                }
                level.word = true;
            }
        }

        public boolean query(char letter) {
            boolean match = false;
            int idx = letter - 'a';

            q.addLast(root);
            for (int i = q.size(); i > 0; i--) {
                TN node = q.pollFirst();
                TN next = node.next[idx];

                if (next == null) continue;
                if (next.word) match = true;
                q.addLast(next);
            }
            return match;
        }
    }

    // Reverse-order Trie
    class StreamChecker {

        TN root;
        StringBuilder sb = new StringBuilder();

        public StreamChecker(String[] words) {
            root = new TN();

            for (String word : words) {
                TN level = root;
                for (int i = word.length() - 1; i >= 0; i--) {
                    int idx = word.charAt(i) - 'a';
                    if (level.next[idx] == null) level.next[idx] = new TN();
                    level = level.next[idx];
                }
                level.word = true;
            }
        }

        public boolean query(char letter) {
            sb.append(letter);

            TN node = root;
            for (int i = sb.length() - 1; i >= 0; i--) {
                int idx = sb.charAt(i) - 'a';
                node = node.next[idx];
                if (node == null) break;
                if (node.word) return true;
            }
            return false;
        }
    }

    class TN {
        TN[] next;
        boolean word;

        TN() {
            next = new TN[26];
        }
    }
}
