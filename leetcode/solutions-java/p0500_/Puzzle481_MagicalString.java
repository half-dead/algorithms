/*
https://leetcode.com/problems/magical-string/description/

A magical string S consists of only '1' and '2' and obeys the following rules:
    The string S is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string S itself.

The first few elements of string S is the following: S = "1221121221221121122……"
    If we group the consecutive '1's and '2's in S, it will be:
        1 22 11 2 1 22 1 22 11 2 11 22 ......
    and the occurrences of '1's or '2's in each group are:
        1 2	2 1 1 2 1 2 2 1 2 2 ......

You can see that the occurrence sequence above is the S itself.
Given an integer N as input, return the number of '1's in the first N number in the magical string S.

Note: N will not exceed 100,000.

Example 1:
    Input: 6
    Output: 3
    Explanation: The first 6 elements of magical string S is "12211" and it contains three 1's, so return 3.
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle481_MagicalString {

    public static void main(String[] args) {
        Solution s = new Puzzle481_MagicalString().new Solution();
        System.out.println(s.magicalString(100));
    }

    class Solution {
        public int magicalString(int n) {
            boolean[] q = new boolean[n];
            int groupIndex = 0, nIndex = 0, res = 0;
            boolean prevIsOne = false;
            while (nIndex < n) {
                boolean currentIsOne = !prevIsOne;
                if (groupIndex == nIndex) {
                    int count = currentIsOne ? 1 : 2;
                    while (count > 0 && nIndex < n) {
                        q[nIndex++] = currentIsOne;
                        if (currentIsOne) {
                            res++;
                        }
                        count--;
                    }
                    groupIndex++;
                } else {
                    int count = q[groupIndex++] ? 1 : 2;
                    while (count > 0 && nIndex < n) {
                        q[nIndex++] = currentIsOne;
                        if (currentIsOne) {
                            res++;
                        }
                        count--;
                    }
                }
                prevIsOne = currentIsOne;
            }
//            StringBuilder b = new StringBuilder(n);
//            int j = 0;
//            while (j < n) {
//                b.append(q[j++] ? '1' : '2');
//            }
//            System.out.println(b.toString());
            return res;
        }
    }

}
