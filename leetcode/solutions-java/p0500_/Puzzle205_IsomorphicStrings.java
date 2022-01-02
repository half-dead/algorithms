package p0500_;

// Given two strings s and t, determine if they are isomorphic.
// Two strings are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving the order of characters.
// No two characters may map to the same character but a character may map to itself.
//
// For example,
// Given "egg", "add", return true.
// Given "foo", "bar", return false.
// Given "paper", "title", return true.
//
// Note:
// You may assume both s and t have the same length.

import java.util.HashMap;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class Puzzle205_IsomorphicStrings {

    public class IndexSolution {
        public boolean isIsomorphic(String s, String t) {
            int[] a = new int[256];
            int[] b = new int[256];
            for (int i = 0; i < s.length(); i++) {
                if (a[s.charAt(i)] != b[t.charAt(i)]) {
                    return false;
                }
                a[s.charAt(i)] = b[t.charAt(i)] = i + 1;
            }
            return true;
        }
    }

    // stupid, idiotic
    public class MapSolution {
        public boolean isIsomorphic(String s, String t) {
            HashMap<Character, Character> map = new HashMap<>(s.length());
            char[] chars = new char[s.length()];
            for (int i = 0; i < s.length(); i++) {
                Character c = map.get(t.charAt(i));
                if (c == null) {
                    if (map.containsValue(s.charAt(i))) {
                        return false;
                    }
                    map.put(t.charAt(i), s.charAt(i));
                    chars[i] = t.charAt(i);
                } else if (c != s.charAt(i)) {
                    return false;
                } else {
                    chars[i] = t.charAt(i);
                }
            }
            return t.equals(new String(chars));
        }
    }
}
