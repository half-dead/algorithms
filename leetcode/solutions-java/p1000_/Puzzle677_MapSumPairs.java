package p1000_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/map-sum-pairs/
 *
 * @author half-dead
 */
public class Puzzle677_MapSumPairs {

    class MapSum {
        Map<Character, Trie> map;

        public MapSum() {
            this.map = new HashMap<>();
        }

        public void insert(String key, int val) {
            Trie trie = null;
            Map<Character, Trie> level = this.map;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (level.containsKey(c)) {
                    trie = level.get(c);
                    trie.sum += val;
                    level = trie.children;
                } else {
                    trie = new Trie(c, val);
                    level.put(c, trie);
                    level = trie.children;
                }
            }

            int sum = 0;
            for (Trie t : level.values()) {
                sum += t.sum;
            }
            int oldVal = trie.sum - sum;
            int diff = val - oldVal;

            level = this.map;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                trie = level.get(c);
                level = trie.children;
                trie.sum += diff;
            }
        }

        public int sum(String prefix) {
            Trie trie = null;
            Map<Character, Trie> level = this.map;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                trie = level.get(c);
                if (trie == null) {
                    break;
                }
                level = trie.children;
            }
            if (trie == null) {
                return 0;
            }
            return trie.sum;
        }
    }

    class Trie {
        char c;
        int sum;
        Map<Character, Trie> children;

        public Trie(char c, int sum) {
            this.c = c;
            this.sum = sum;
            this.children = new HashMap<>();
        }
    }

}
