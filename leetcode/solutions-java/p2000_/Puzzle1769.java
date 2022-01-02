package p2000_;

/**
 * @author half-dead
 */
public class Puzzle1769 {

    class Solution {
        public int[] minOperations(String boxes) {
            int len = boxes.length(), move0 = 0, totalCountOf1 = 0;
            for (int i = 0; i < len; i++) {
                if (boxes.charAt(i) == '1') {
                    move0 += i;
                    totalCountOf1++;
                }
            }

            int[] res = new int[len];
            res[0] = move0;
            int c = boxes.charAt(0) == '1' ? 1 : 0;
            for (int i = 1; i < len; i++) {
                res[i] = res[i - 1] - (totalCountOf1 - c) + c;
                if (boxes.charAt(i) == '1') c++;
            }
            return res;
        }
    }
}
