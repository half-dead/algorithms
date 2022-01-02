/*
https://leetcode.com/problems/2-keys-keyboard/description/

Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
    Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
    Paste: You can paste the characters which are copied last time.

Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted.
Output the minimum number of steps to get n 'A'.

Example 1:
    Input: 3
    Output: 3
Explanation:
    Intitally, we have one character 'A'.
    In step 1, we use Copy All operation.
    In step 2, we use Paste operation to get 'AA'.
    In step 3, we use Paste operation to get 'AAA'.
Note:
    The n will be in the range [1, 1000].

 */

package p1000_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle650_2KeysKeyboard {

    public static void main(String[] args) {
        Solution s = new Puzzle650_2KeysKeyboard().new Solution();
        Solution1 s1 = new Puzzle650_2KeysKeyboard().new Solution1();
        System.out.println(s1.minSteps(22));
        System.out.println(s.minSteps(22));
    }

    class Solution {
        public int minSteps(int n) {
            if (n == 1) {
                return 0;
            }
            List<Integer> factors = new ArrayList<>();
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    factors.add(i);
                }
            }
            if (factors.size() == 0) {
                return n;
            }

            int count = n;
            for (int factor : factors) {
                int nn = minSteps(factor) + (n / factor);
                if (count > nn) {
                    count = nn;
                }
            }
            return count;
        }
    }

    class Solution1 {
        public int minSteps(int n) {
            int res = 0;
            for (int i = 2; i <= n; i++) {
                if (i < 0) {
                    break;
                }
                while (n % i == 0) {
                    res += i;
                    n /= i;
                }
            }
            return res;
        }
    }
}
