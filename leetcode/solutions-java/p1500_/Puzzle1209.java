package p1500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 *
 * @author half-dead
 */
public class Puzzle1209 {

    class Solution {
        public String removeDuplicates(String s, int k) {
            char[] arr = s.toCharArray();
            int i = 0, n = arr.length;
            int[] count = new int[n];
            for (int j = 0; j < n; j++, i++) {
                arr[i] = arr[j];
                count[i] = (i > 0 && arr[i] == arr[i - 1]) ? count[i - 1] + 1 : 1;
                if (count[i] == k) i -= k;
            }
            return new String(arr, 0, i);
        }
    }

    class StackSolution {
        public String removeDuplicates(String s, int k) {
            StringBuilder curr = new StringBuilder();
            LinkedList<StringBuilder> q = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (curr.length() == 0 || curr.charAt(0) == c) {
                    curr.append(c);
                    if (curr.length() == k) curr = q.size() >  0 ? q.pop() : new StringBuilder();
                } else {
                    q.push(curr);
                    curr = new StringBuilder().append(c);
                }
            }
            if (curr.length() > 0) q.push(curr);

            StringBuilder result = new StringBuilder();
            while (q.size() > 0) result.append(q.pollLast());
            return result.toString();
        }
    }
}
