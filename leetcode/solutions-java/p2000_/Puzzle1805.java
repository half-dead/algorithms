package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-different-integers-in-a-string/
 *
 * @author half-dead
 */
public class Puzzle1805 {

    public static void main(String[] args) {
        Solution s = new Puzzle1805().new Solution();
        System.out.println(s.numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(s.numDifferentIntegers("leet1234code234"));
        System.out.println(s.numDifferentIntegers("a1b01c001"));
    }

    class Solution {
        public int numDifferentIntegers(String word) {
            return (int) Arrays.stream(word.split("[a-z]+")).filter(w -> w.length() > 0).map(w -> w.replaceFirst("^0+", "")).distinct().count();
        }
    }
}
