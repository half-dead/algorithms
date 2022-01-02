package p0500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/expression-add-operators/
 *
 * @author half-dead
 */
public class Puzzle282_ExpressionAddOperators {

    public static void main(String[] args) {
        Puzzle282_ExpressionAddOperators p = new Puzzle282_ExpressionAddOperators();
        Solution s = p.new Solution();
        System.out.println(s.addOperators("123456789", 45));
    }

    class Solution {
        public List<String> addOperators(String num, int target) {
            int len = num.length();
            char[] curr = new char[len * 2];
            List<String> result = new ArrayList<>();
            long head = 0L;
            for (int i = 0; i < len; i++) {
                head = head * 10 + num.charAt(i) - '0';
//                dfs(result, num, curr, i + 1, head, target);
                if (head == 0) {
                    break;
                }
            }
            return result;
        }

        public void dfs(List<String> result, String num, char[] curr, int currIndex, int leftIndex, long head, int target) {
            if (leftIndex >= num.length()) {

            } else {
                long val = 0;
                for (int i = leftIndex; i < num.length(); i++) {
                    val += val * 10 + num.charAt(i) - '0';
                    curr[currIndex++] = num.charAt(i);
                    curr[currIndex] = '+';
                    dfs(result, num, curr, currIndex + 1, i + 1, val, target);
                    curr[currIndex] = '-';
                    curr[currIndex] = '*';

                }
            }
        }
    }


    class Solution2 {
        public List<String> addOperators(String num, int target) {
            int len = num.length();
            char[] chars = num.toCharArray(), exp = new char[len * 2];
            List<String> result = new ArrayList<>();
            long value = 0;

            for (int j = 0, i = 0; i < len; ) {
                value = value * 10 + chars[i] - '0';
                exp[j++] = chars[i++];
                helper(result, chars, len, i, target, exp, j, 0, value);
                if (value == 0) {
                    break;
                }
            }
            return result;
        }

        void helper(List<String> results, char[] chars, int n, int i, long target,
                    char[] exp, int j, long result, long tail) {
            if (i == n) {
                if (result + tail == target) {
                    results.add(String.valueOf(exp, 0, j));
                }
            } else {
                long value = 0;
                for (int op = j++, k = i; k < n; ++k) {
                    value = value * 10 + chars[k] - '0';
                    exp[j++] = chars[k];
                    exp[op] = '+';
                    helper(results, chars, n, k + 1, target, exp, j, result + tail, value);
                    exp[op] = '-';
                    helper(results, chars, n, k + 1, target, exp, j, result + tail, -value);
                    exp[op] = '*';
                    helper(results, chars, n, k + 1, target, exp, j, result, tail * value);
                    if (value == 0) {
                        break;
                    }
                }
            }
        }
    }

    public class Solution3 {
        public List<String> addOperators(String num, int target) {
            List<String> rst = new ArrayList<String>();
            if (num == null || num.length() == 0) return rst;
            helper(rst, "", num, target, 0, 0, 0);
            return rst;
        }

        public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
            if (pos == num.length()) {
                if (target == eval)
                    rst.add(path);
                return;
            }
            for (int i = pos; i < num.length(); i++) {
                if (i != pos && num.charAt(pos) == '0') break;
                long cur = Long.parseLong(num.substring(pos, i + 1));
                if (pos == 0) {
                    helper(rst, path + cur, num, target, i + 1, cur, cur);
                } else {
                    helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

                    helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

                    helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
                }
            }
        }
    }

}
