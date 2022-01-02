package p0500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle331 {
    public static void main(String[] args) {
        Solution s = new Puzzle331().new Solution();
        System.out.println(s.isValidSerialization("#"));
        System.out.println(s.isValidSerialization("#,#,#"));
        System.out.println(s.isValidSerialization("9,3,4,#,#,1,#,#,#,2,#,6,#,#"));
    }

    // Neat!
    class xSolution {
        public boolean isValidSerialization(String s) {
            int slots = 1, n = s.length();
            char[] chars = s.toCharArray();
            for (int i = 0; i < n; i++) {
                if (chars[i] == ',') {
                    if (--slots < 0) return false;
                    if (chars[i - 1] != '#') slots += 2;
                }
            }
            slots = (chars[n - 1] == '#') ? slots - 1 : slots + 1;
            return slots == 0;
        }
    }

    class Solution {
        public boolean isValidSerialization(String s) {
            if (s == null || s.length() == 0) return false;
            LinkedList<Integer> stack = new LinkedList<>();
            for (String node : s.split(",")) {
                if (stack.size() > 0) {
                    while (stack.size() > 0 && stack.peek() == 2) stack.pop();
                    if (stack.size() == 0 || stack.peek() > 2)
                        return false;
                }

                if (node.equals("#")) {
                    if (stack.size() == 0) {
                        stack.push(2);
                    } else if (stack.peek() < 2) {
                        stack.push(stack.pop() + 1);
                    } else {
                        return false;
                    }
                } else {
                    if (stack.size() > 0) stack.push(stack.pop() + 1);
                    stack.push(0);
                }
            }
            while (stack.size() > 0 && stack.peek() == 2) stack.pop();
            return stack.size() == 0;
        }
    }
}
