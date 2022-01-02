/*
https://leetcode.com/problems/happy-number/

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits,
and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1

*/

package p0500_;

import java.util.HashSet;

public class Puzzle202_HappyNumber {

    public static void main(String[] args) {
        Puzzle202_HappyNumber p = new Puzzle202_HappyNumber();
        Solution solution = p.new Solution();
        boolean happy = solution.isHappy(7);
        System.out.println(happy);
    }

    public class Solution {
        public boolean isHappy(int n) {
            HashSet<Integer> set = new HashSet<>();
            int sum = 0;
            while (true) {
                while (n > 0) {
                    int mod = n % 10;
                    sum += mod * mod;
                    n /= 10;
                }
                if (sum == 1) {
                    return true;
                } else if (set.contains(sum)) {
                    return false;
                } else {
                    set.add(sum);
                    n = sum;
                    sum = 0;
                }
            }
        }
    }
}
