package p1000_;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/asteroid-collision/
 *
 * @author half-dead
 */
public class Puzzle735 {

    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < asteroids.length; i++) {
                if (asteroids[i] > 0) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && asteroids[stack.peek()] < -asteroids[i]) {
                        asteroids[stack.pop()] = 0;
                    }
                    if (stack.isEmpty()) continue;

                    if (asteroids[stack.peek()] == -asteroids[i]) {
                        asteroids[stack.pop()] = asteroids[i] = 0;
                    } else if (asteroids[stack.peek()] > -asteroids[i]) {
                        asteroids[i] = 0;
                    }
                }
            }
            int size = 0;
            for (int j = 0; j < asteroids.length; j++) {
                if (asteroids[j] != 0) {
                    asteroids[size++] = asteroids[j];
                }
            }
            return Arrays.copyOfRange(asteroids, 0, size);
        }
    }
}
