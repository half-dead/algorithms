package p2000_;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/car-fleet-ii/
 *
 * @author half-dead
 */
public class Puzzle1776 {

    // monotone stack, O(N) time & space
    class Solution {
        public double[] getCollisionTimes(int[][] cars) {
            int n = cars.length;

            double[] res = new double[n];
            res[n - 1] = -1.0d;

            Deque<Integer> stack = new LinkedList<>();
            stack.push(n - 1);

            for (int i = n - 2; i >= 0; i--) {
                int[] p = cars[i];
                double time = -1.0d;

                while (stack.size() > 0) {
                    int top = stack.peek();
                    double distance = cars[top][0] - p[0], relativeSpeed = p[1] - cars[top][1];

                    // prev car will never collide with next car
                    if (relativeSpeed <= 0) stack.pop();
                        // by the time prev car collide with next car
                        // next car is already collide with another car, so we need to pop from stack
                    else if ((time = distance / relativeSpeed) >= res[top] && res[top] > 0) stack.pop();
                    else break;
                }
                res[i] = time;
                stack.push(i);
            }
            return res;
        }
    }
}
