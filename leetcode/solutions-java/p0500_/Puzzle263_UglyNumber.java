package p0500_;

// Write a program to check whether a given number is an ugly number.
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
// For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
// Note that 1 is typically treated as an ugly number.

/**
 * @author half-dead
 */
public class Puzzle263_UglyNumber {

    class Solution {
        public boolean isUgly(int num) {

            if (num < 1) {
                return false;
            }
            if (num < 7) {
                return true;
            }
            while (num >= 7) {
                if (num % 2 == 0) {
                    num /= 2;
                } else if (num % 3 == 0) {
                    num /= 3;
                } else if (num % 5 == 0) {
                    num /= 5;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
