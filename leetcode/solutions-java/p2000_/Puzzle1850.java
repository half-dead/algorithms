package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/
 *
 * @author half-dead
 */
public class Puzzle1850 {

    class Solution {
        public int getMinSwaps(String str, int k) {
            int len = str.length(), res = 0;

            char[] cs = str.toCharArray();
            while (k-- > 0) {
                int i = len - 1;
                while (i > 0 && cs[i - 1] >= cs[i]) i--;

                char tmp = cs[i - 1];
                int pos = i;
                for (int j = i; j < len; j++) {
                    if (tmp < cs[j] && cs[j] < cs[pos]) {
                        pos = j;
                    }
                }
                // swap the two digit
                cs[i - 1] = cs[pos];
                cs[pos] = tmp;
                // sort(i,len) to get the next permutation
                Arrays.sort(cs, i, len);
            }

            char[] ori = str.toCharArray();
            for (int i = 0; i < len; i++) {
                if (ori[i] != cs[i]) {
                    int j = i + 1;
                    while (ori[i] != cs[j]) j++;

                    res += j - i;

                    System.arraycopy(cs, i, cs, i + 1, j - i);
                    cs[i] = ori[i];
                }
            }
            return res;
        }
    }
}
