package p0500_;

// Implement atoi to convert a string to an integer.
//
// Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
//
// Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
//
// Update (2015-02-10):
// The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
//
// spoilers alert... click to show requirements for atoi.
//
// Requirements for atoi:
// The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
//
// The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
//
// If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
//
// If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

/**
 * https://oj.leetcode.com/problems/string-to-integer-atoi/
 */
public class Puzzle008_AtoI {

    public class Solution {
        public int atoi(String str) {
            long result = 0;
            int flag = 1;
            boolean pm = false;
            boolean started = false;
            outer:
            for (char c : str.toCharArray()) {
                switch (c) {
                    case ' ':
                    case '\n':
                    case '\r':
                    case '\t':
                    case '\b':
                        if (!started) {
                            continue;
                        } else {
                            break outer;
                        }
                    case '+':
                    case '-':
                        if (!pm) {
                            flag = c == '+' ? 1 : -1;
                        } else {
                            break outer;
                        }
                        pm = true;
                        started = true;
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        started = true;
                        if (!pm) {
                            pm = true;
                        }
                        result = 10 * result + (c - '0');
                        if ((result * flag) > Integer.MAX_VALUE) {
                            result = Integer.MAX_VALUE;
                            break outer;
                        } else if ((result * flag) < Integer.MIN_VALUE) {
                            result = Integer.MAX_VALUE + 1;
                            break outer;
                        }
                        break;
                    default:
                        break outer;
                }
            }
            return (int) (result * flag);
        }
    }
}
