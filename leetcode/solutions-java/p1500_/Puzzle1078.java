package p1500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/occurrences-after-bigram/
 *
 * @author half-dead
 */
public class Puzzle1078 {
    public static void main(String[] args) {
        Solution s = new Puzzle1078().new Solution();
        System.out.println(Arrays.toString(s.findOcurrences("alice is a good girl she is a good student", "a", "good")));
        System.out.println(Arrays.toString(s.findOcurrences("alice is aa good girl she is a good student", "a", "good")));
        System.out.println(Arrays.toString(s.findOcurrences("we will we will rock you", "we", "will")));
    }

    class Solution {
        public String[] findOcurrences(String text, String first, String second) {
            List<String> result = new ArrayList<>();
            text = " " + text;
            String s = " " + first + " " + second + " ";
            int p = s.length(), idx = -1;
            while ((idx = text.indexOf(s, idx + 1)) != -1) {
                int firstSpace = text.indexOf(' ', idx + p);
                result.add(text.substring(idx + p, firstSpace >= 0 ? firstSpace : text.length()));
            }
            return result.toArray(new String[0]);
        }
    }
}
