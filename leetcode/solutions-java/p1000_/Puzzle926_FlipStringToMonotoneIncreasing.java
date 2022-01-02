package p1000_;

/**
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/
 *
 * @author half-dead
 */
public class Puzzle926_FlipStringToMonotoneIncreasing {
    public static void main(String[] args) {
        Solution s = new Puzzle926_FlipStringToMonotoneIncreasing().new Solution();
//        System.out.println(s.minFlipsMonoIncr("10011111110010111011"));
//        System.out.println(s.minFlipsMonoIncr("00110"));
//        System.out.println(s.minFlipsMonoIncr("011010001101001"));
        System.out.println(s.minFlipsMonoIncr("000001101001100001100010100011"));// 9
    }

    class Solution {
        public int minFlipsMonoIncr(String s) {
            int flip1to0count = 0, flip0to1Count = 0;
            int count0 = 0, count1 = 0;
            int i = 0;
            while (i < s.length()) {
                while (i < s.length() && s.charAt(i) == '0') {
                    count0++;
                    i++;
                }
                if (count0 > 0 && count1 != 0) {
                    if (count1 - flip0to1Count <= count0 + flip0to1Count) {
                        flip1to0count += count1 - flip0to1Count;
                        flip0to1Count = 0;
                        count1 = 0;
                    } else {
                        count1 += count0;
                        flip0to1Count += count0;
                    }
                }
                while (i < s.length() && s.charAt(i) == '1') {
                    count1++;
                    i++;
                }
                count0 = 0;
            }
            return flip1to0count + flip0to1Count;
        }
    }
}
