package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/letter-tile-possibilities/
 *
 * @author half-dead
 */
public class Puzzle1079 {
    public static void main(String[] args) {
        Solution s = new Puzzle1079().new Solution();
        System.out.println(s.numTilePossibilities("ABCDEFGHIJKL"));
    }

    // Neat
    class Solution {
        public int numTilePossibilities(String tiles) {
            int[] count = new int[26];
            for (char c : tiles.toCharArray()) count[c - 'A']++;
            return dfs(count);
        }

        int dfs(int[] arr) {
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                if (arr[i] == 0) continue;
                sum++;
                arr[i]--;
                sum += dfs(arr);
                arr[i]++;
            }
            return sum;
        }
    }

    class DfsSolution {
        public int numTilePossibilities(String tiles) {
            int n = tiles.length();
            int[] res = new int[1];
            while (n > 0) dfs(tiles, 0, n--, res);
            return res[0];
        }

        private void dfs(String tiles, int count, int size, int[] res) {
            if (count == size) {
                res[0]++;
                return;
            }

            char[] chars = tiles.toCharArray();
            Arrays.sort(chars);

            char prev = ' ';
            for (int i = 0, len = chars.length; i < len; i++) {
                if (prev != chars[i]) {
                    prev = chars[i];
                    if (i != 0) {
                        char temp = chars[0];
                        chars[0] = chars[i];
                        chars[i] = temp;
                    }
                    dfs(new String(chars, 1, len - 1), count + 1, size, res);
                }
            }
        }
    }
}
