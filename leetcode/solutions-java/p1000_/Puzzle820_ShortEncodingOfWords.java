package p1000_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/short-encoding-of-words/
 *
 * @author half-dead
 */
public class Puzzle820_ShortEncodingOfWords {

    public static void main(String[] args) {
        Puzzle820_ShortEncodingOfWords p = new Puzzle820_ShortEncodingOfWords();
        Solution s = p.new Solution();
        System.out.println(s.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(s.minimumLengthEncoding(new String[]{"me", "time"}));
    }

    class Solution0 {
        public int minimumLengthEncoding(String[] words) {
            Set<String> s = new HashSet<>(Arrays.asList(words));
            for (String word : words) {
                for (int i = 1; i < word.length(); ++i) {
                    s.remove(word.substring(i));
                }
            }
            int res = 0;
            for (String w : s) {
                res += w.length() + 1;
            }
            return res;
        }
    }


    class Solution {

        public int minimumLengthEncoding(String[] words) {
            int count = 0, totalLen = 0;

            Trie[] root = new Trie[26];
            for (String word : words) {

                Trie[] level = root;
                boolean skip = false;
                for (int i = word.length() - 1; i >= 0; i--) {
                    int idx = word.charAt(i) - 'a';
                    Trie t = level[idx];
                    if (t == null) {
                        t = new Trie();
                    } else if (t.start) {
                        count--;
                        totalLen -= word.length() - i;
                        t.start = false;
                    } else if (i == 0) {
                        skip = true;
                    }

                    if (i == 0 && !skip) {
                        count++;
                        t.start = true;
                        totalLen += word.length();
                    }
                    level[idx] = t;
                    level = t.prev;
                }
            }

            return count + totalLen;
        }

    }

    class Trie {
        boolean start;
        Trie[] prev;

        public Trie() {
            prev = new Trie[26];
        }
    }
}
