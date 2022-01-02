package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/previous-permutation-with-one-swap/
 *
 * @author half-dead
 */
public class Puzzle1053 {

    public static void main(String[] args) {
        Solution s = new Puzzle1053().new Solution();
        System.out.println(Arrays.toString(s.prevPermOpt1(new int[]{3, 1, 1, 3})));
    }

    class Solution {
        public int[] prevPermOpt1(int[] arr) {
            int len = arr.length;
            for (int i = len - 1; i > 0; i--) {
                if (arr[i] < arr[i - 1]) {
                    int x = arr[i - 1], y = arr[i], idx = i;
                    for (int j = i + 1; j < len; j++) {
                        if (arr[j] < x) {
                            if (arr[j] > y) {
                                y = arr[j];
                                idx = j;
                            }
                        } else {
                            break;
                        }
                    }
                    arr[i - 1] = y;
                    arr[idx] = x;
                    break;
                }
            }
            return arr;
        }
    }
}
