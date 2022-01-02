package p0500_;

// Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
//
// For example:
//
// Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
//
// Follow up:
// Could you do it without any loop/recursion in O(1) runtime?
//
// Hint:
//
// A naive implementation of the above process is trivial. Could you come up with other methods?
// What are all the possible results?
// How do they occur, periodically or randomly?
// You may find this Wikipedia article useful.


/**
 * https://leetcode.com/problems/add-digits/
 */
public class Puzzle258_AddDigits {
    public class Solution {
        public int addDigits(int num) {
            if (num == 0) return 0;
            int a;
            return ((a = num % 9) == 0) ? 9 : a;
        }
    }
}
