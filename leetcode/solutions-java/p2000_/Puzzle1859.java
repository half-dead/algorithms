package p2000_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/sorting-the-sentence/
 *
 * @author half-dead
 */
public class Puzzle1859 {

    class Solution {
        public String sortSentence(String s) {
            String[] arr = s.split(" ");
            Arrays.sort(arr, Comparator.comparingInt(a -> a.charAt(a.length() - 1)));
            String res = String.join("", arr).replaceAll("[0-9]", " ");
            return res.substring(0, res.length() - 1);
        }
    }
}
