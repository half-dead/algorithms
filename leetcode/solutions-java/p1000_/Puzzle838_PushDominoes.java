package p1000_;

/**
 * https://leetcode.com/problems/push-dominoes/
 *
 * @author half-dead
 */
public class Puzzle838_PushDominoes {
    class Solution {
        public String pushDominoes(String dominoes) {
            int len = dominoes.length(), idxR = -1, idxL = -1;
            int[] distanceR = new int[len], distanceL = new int[len];
            char[] chars = dominoes.toCharArray();

            for (int i = 0; i < len; i++)
                if (chars[i] == '.') distanceR[i] = idxR == -1 ? 0 : (i - idxR);
                else idxR = chars[i] == 'R' ? i : -1;

            for (int i = len - 1; i >= 0; i--)
                if (chars[i] == '.') distanceL[i] = idxL == -1 ? 0 : (idxL - i);
                else idxL = chars[i] == 'L' ? i : -1;

            for (int i = 0; i < len; i++) {
                int dr = distanceR[i], dl = distanceL[i];
                if (dr != dl) {
                    if (dr == 0) chars[i] = 'L';
                    else if (dl == 0) chars[i] = 'R';
                    else chars[i] = dr < dl ? 'R' : 'L';
                }
            }
            return new String(chars);
        }
    }
}
