package p1000_;

import java.util.Arrays;
import java.util.Random;

/**
 * @author half-dead
 */
public class Puzzle528 {
    public static void main(String[] args) {
        Solution s = new Puzzle528().new Solution(new int[]{1, 9});
        for (int i = 0; i < 9; i++)
            System.out.println(s.pickIndex());
    }

    class Solution {

        int[] sum;
        Random random;
        int max;

        public Solution(int[] w) {
            random = new Random(System.currentTimeMillis());
            sum = new int[w.length];
            for (int i = 0; i < w.length; i++) {
                sum[i] = i == 0 ? w[i] : (sum[i - 1] + w[i]);
            }
            max = sum[w.length - 1];
        }

        public int pickIndex() {
            int pos = Arrays.binarySearch(sum, random.nextInt(max) + 1);
            if (pos >= 0) return pos;
            else return -pos - 1;
        }
    }

}
