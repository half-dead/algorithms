package p1500_;

/**
 * https://leetcode.com/problems/maximum-69-number/
 *
 * @author half-dead
 */
public class Puzzle1323_Maximum69Number {
    class Solution {
        public int maximum69Number(int num) {
            if (num > 6000 && num < 7000) return num + 3000;
            int h = num % 1000;
            if (h > 600 && h < 700) return num + 300;
            h = num % 100;
            if (h > 60 && h < 70) return num + 30;
            h = num % 10;
            if (h == 6) return num + 3;
            return num;
        }
    }
}
