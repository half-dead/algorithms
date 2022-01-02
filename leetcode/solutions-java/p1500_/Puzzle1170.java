package p1500_;

import util.Print;

/**
 * https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
 *
 * @author half-dead
 */
public class Puzzle1170 {
    public static void main(String[] args) {
        Solution s = new Puzzle1170().new Solution();
        Print.pt(s.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"}));
    }

    class Solution {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int[] fwords = new int[words.length], mem = new int[11], res = new int[queries.length];
            int i = 0;
            for (String word : words) fwords[i++] = f(word);
            for (int f : fwords) mem[f]++;

            i = 0;
            for (String query : queries) {
                for (int f = f(query) + 1; f < 11; f++) res[i] += mem[f];
                i++;
            }
            return res;
        }

        int f(String word) {
            int min = 'z', cnt = 0;
            for (char c : word.toCharArray()) {
                if (c < min) {
                    min = c;
                    cnt = 1;
                } else if (c == min) cnt++;
            }
            return cnt;
        }
    }
}
