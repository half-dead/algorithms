package p0500_;

/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 *
 * @author half-dead
 */
public class Puzzle318_MaximumProductOfWordLengths {
    class Solution {
        public int maxProduct(String[] words) {
            int[] arr = new int[words.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = toInt(words[i]);
            }
            int max = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                int len1 = words[i].length();
                for (int j = i + 1; j < arr.length; j++) {
                    if ((arr[i] & arr[j]) == 0) {
                        max = Math.max(max, len1 * words[j].length());
                    }
                }
            }
            return max;
        }

        private int toInt(String word) {
            int res = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                res |= 1 << ('z' - c);
            }
            return res;
        }
    }
}
