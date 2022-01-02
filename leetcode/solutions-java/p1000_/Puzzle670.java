package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-swap/
 *
 * @author half-dead
 */
public class Puzzle670 {
    public static void main(String[] args) {
        Solution s = new Puzzle670().new Solution();
        System.out.println(s.maximumSwap(2736));
        System.out.println(s.maximumSwap(9973));
    }

    class Solution {
        public int maximumSwap(int num) {
            char[] cs = Integer.toString(num).toCharArray();
            int[] last = new int[10];
            for (int i = 0; i < cs.length; i++) last[cs[i] - '0'] = i;

            for (int i = 0; i < cs.length; i++) {
                for (int d = 9; d > cs[i] - '0'; d--) {
                    if (last[d] > i) {
                        char tmp = cs[i];
                        cs[i] = cs[last[d]];
                        cs[last[d]] = tmp;
                        return Integer.parseInt(new String(cs));
                    }
                }
            }
            return num;
        }
    }

    class Solution1 {
        public int maximumSwap(int num) {
            String s = String.valueOf(num);
            int len = s.length();
            int[] a1 = new int[len], a2 = new int[len];
            for (int i = 0; i < len; i++) {
                a1[i] = a2[i] = s.charAt(i) - '0';
            }
            Arrays.sort(a2);

            int i = 0, j = len - 1;
            while (i < len) {
                if (a1[i] == a2[j]) {
                    i++;
                    j--;
                } else {
                    int temp = a1[i];
                    a1[i] = a2[j];
                    for (int k = len - 1; k > i; k--) {
                        if (a1[k] == a2[j]) {
                            a1[k] = temp;
                            break;
                        }
                    }
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int d : a1) sb.append(d);
            return Integer.parseInt(sb.toString());
        }
    }
}
