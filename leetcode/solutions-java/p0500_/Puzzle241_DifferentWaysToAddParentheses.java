package p0500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 *
 * @author half-dead
 */
public class Puzzle241_DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        Puzzle241_DifferentWaysToAddParentheses p = new Puzzle241_DifferentWaysToAddParentheses();
        Solution s = p.new Solution();
        List<Integer> integers = s.diffWaysToCompute("2*3-4*5");
        System.out.println(integers);
    }

    class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> list = new ArrayList<>();
            int num = 0;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c >= '0' && c <= '9') {
                    num *= 10;
                    num += c - '0';
                    continue;
                }
                list.add(num);
                num = 0;
                if (c == '+') {
                    list.add(-1);
                } else if (c == '-') {
                    list.add(-2);
                } else if (c == '*') {
                    list.add(-3);
                } else {
                    throw new IllegalArgumentException();
                }
            }
            list.add(num);
            return recur(list, 0, list.size() - 1);
        }

        public List<Integer> recur(List<Integer> input, int from, int to) {
            if (from == to) {
                List<Integer> res = new ArrayList<>();
                res.add(input.get(from));
                return res;
            } else {
                List<Integer> res = new ArrayList<>();
                int operators = (to - from) >> 1;
                int o = 0;
                while (o < operators) {
                    List<Integer> left = recur(input, from, from + o * 2);
                    int operator = input.get(from + o * 2 + 1);
                    List<Integer> right = recur(input, from + o * 2 + 2, to);
                    for (int n1 : left) {
                        for (int n2 : right) {
                            if (operator == -1) res.add(n1 + n2);
                            else if (operator == -2) res.add(n1 - n2);
                            else res.add(n1 * n2);
                        }
                    }
                    o++;
                }
                return res;
            }
        }
    }
}
