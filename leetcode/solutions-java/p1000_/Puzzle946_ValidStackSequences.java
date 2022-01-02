package p1000_;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/validate-stack-sequences/
 *
 * @author half-dead
 */
public class Puzzle946_ValidStackSequences {

    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> q = new ArrayDeque<>();
            int pushIndex = 0, popIndex = 0;
            while (pushIndex < pushed.length) {
                if (q.size() == 0) {
                    q.push(pushed[pushIndex++]);
                } else if (q.peek() == popped[popIndex]) {
                    q.pop();
                    popIndex++;
                } else {
                    q.push(pushed[pushIndex++]);
                }
            }
            while (q.size() > 0) {
                if (q.peek() != popped[popIndex]) {
                    return false;
                }
                q.pop();
                popIndex++;
            }
            return true;
        }
    }
}
