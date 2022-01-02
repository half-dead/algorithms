package p1000_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 *
 * @author half-dead
 */
public class Puzzle904 {

    // O(1) space
    class Solution {
        public int totalFruit(int[] tree) {
            // track last two fruits seen
            int lastFruit = -1;
            int secondLastFruit = -1;
            int lastFruitCount = 0;
            int currMax = 0;
            int max = 0;

            for (int fruit : tree) {
                if (fruit == lastFruit || fruit == secondLastFruit)
                    currMax++;
                else
                    currMax = lastFruitCount + 1; // last fruit + new fruit

                if (fruit == lastFruit)
                    lastFruitCount++;
                else
                    lastFruitCount = 1;

                if (fruit != lastFruit) {
                    secondLastFruit = lastFruit;
                    lastFruit = fruit;
                }

                max = Math.max(max, currMax);
            }

            return max;
        }
    }

    // O(n) space, 7ms
    class ArraySolution {
        public int totalFruit(int[] tree) {
            int n = tree.length, start = 0, end = 0, types = 0;
            int[] cnt = new int[n];
            for (; end < n; end++) {
                if (cnt[tree[end]]++ == 0) types++;
                if (types > 2 && --cnt[tree[start++]] == 0) types--;
            }
            return end - start;
        }
    }

    // O(2) space, 37ms
    class MapSolution {
        public int totalFruit(int[] tree) {
            int n = tree.length, start = 0, end = 0;
            Map<Integer, Integer> sw = new HashMap<>(4);
            for (; end < n; end++) {
                int fruit = tree[end];
                sw.put(fruit, sw.getOrDefault(fruit, 0) + 1);
                if (sw.size() > 2) {
                    int remove = tree[start++];
                    int cnt = sw.get(remove);
                    if (cnt == 1) sw.remove(remove);
                    else sw.put(remove, cnt - 1);
                }
            }
            return end - start;
        }
    }
}
