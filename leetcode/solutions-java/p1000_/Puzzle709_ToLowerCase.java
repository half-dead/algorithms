/*
https://leetcode.com/problems/to-lower-case/description/

Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"
 */

package p1000_;

/**
 * @author half-dead
 */
public class Puzzle709_ToLowerCase {

    class Solution {
        public String toLowerCase(String str) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 'A' && chars[i] <= 'Z') {
                    chars[i] = (char) ('a' + chars[i] - 'A');
                }
            }
            return new String(chars);
        }
    }
}
