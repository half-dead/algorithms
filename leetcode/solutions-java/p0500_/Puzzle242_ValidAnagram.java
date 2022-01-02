package p0500_;

// Given two strings s and t, write a function to determine if t is an anagram of s.
//
// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.
//
// Note:
// You may assume the string contains only lowercase alphabets.
//
// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class Puzzle242_ValidAnagram {

    public static void main(String[] args) {
        Puzzle242_ValidAnagram.Solution s = new Puzzle242_ValidAnagram().new Solution();
        System.out.println(s.isAnagram("anagram", "aanagrm"));
    }

    public class Solution {
        public boolean isAnagram(String s, String t) {
            byte[] arr1 = new byte[26];
            byte[] arr2 = new byte[26];
            for (char c : s.toCharArray()) {
                arr1[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                arr2[c - 'a']++;
            }
            return new String(arr1).equals(new String(arr2));
        }
    }
}
