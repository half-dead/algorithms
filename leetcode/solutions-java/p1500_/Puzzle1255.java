package p1500_;

/**
 * https://leetcode.com/problems/maximum-score-words-formed-by-letters/
 *
 * @author half-dead
 */
public class Puzzle1255 {
    class Solution {
        public int maxScoreWords(String[] words, char[] letters, int[] score) {
            int[] count = new int[26], res = new int[1];
            for (char c : letters) count[c - 'a']++;
            backtracking(words, count, score, 0, 0, res);
            return res[0];
        }

        public void backtracking(String[] words, int[] count, int[] score, int idx, int cur, int[] res) {
            if (idx == words.length) {
                res[0] = Math.max(res[0], cur);
                return;
            }

            backtracking(words, count, score, idx + 1, cur, res);

            char[] chars = words[idx].toCharArray();
            boolean b = true;
            for (char c : chars) if (count[c - 'a']-- == 0) b = false;
            if (b) {
                for (char c : chars) cur += score[c - 'a'];
                backtracking(words, count, score, idx + 1, cur, res);
            }
            for (char c : chars) count[c - 'a']++;
        }

    }
}
