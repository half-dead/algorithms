package p1500_;

/**
 * https://leetcode.com/problems/construct-k-palindrome-strings/
 *
 * @author half-dead
 */
public class Puzzle1400 {

    class Solution {
public boolean canConstruct(String s, int k) {
    int cnt = 0;
    for (char c : s.toCharArray()) cnt ^= 1 << (c - 'a');
    return s.length() >= k && Integer.bitCount(cnt) <= k;
}
    }
}
