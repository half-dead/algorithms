package p2000_;

/**
 * https://leetcode.com/problems/rotating-the-box/
 *
 * @author half-dead
 */
public class Puzzle1861 {

    class Solution {
        public char[][] rotateTheBox(char[][] box) {

            int m = box.length, n = box[0].length;
            for (char[] row : box) {
                int stones = 0, spaces = 0;
                for (int i = 0; i <= n; i++) {
                    char c = i < n ? row[i] : ' ';
                    if (c == '#') {
                        stones++;
                    } else if (c == '.') {
                        spaces++;
                    } else {
                        for (int j = i - 1; ; j--) {
                            if (stones > 0) {
                                row[j] = '#';
                                stones--;
                            } else if (spaces > 0) {
                                row[j] = '.';
                                spaces--;
                            } else {
                                break;
                            }
                        }
                        stones = 0;
                        spaces = 0;
                    }
                }
            }

            char[][] res = new char[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[j][m - i - 1] = box[i][j];
                }
            }
            return res;
        }
    }
}
