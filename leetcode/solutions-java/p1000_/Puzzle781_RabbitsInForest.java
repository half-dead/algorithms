/*
https://leetcode.com/problems/rabbits-in-forest/description/

In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them)
tell you how many other rabbits have the same color as them. Those answers are placed in an array.

Return the minimum number of rabbits that could be in the forest.

Examples:
    Input: answers = [1, 1, 2]
    Output: 5
    Explanation:
    The two rabbits that answered "1" could both be the same color, say red.
    The rabbit than answered "2" can't be red or the answers would be inconsistent.
    Say the rabbit that answered "2" was blue.
    Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
    The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.

    Input: answers = [10, 10, 10]
    Output: 11

    Input: answers = []
    Output: 0
Note:
    answers will have length at most 1000.
    Each answers[i] will be an integer in the range [0, 999].
 */

package p1000_;

/**
 * @author half-dead
 */
public class Puzzle781_RabbitsInForest {
    class Solution {
        public int numRabbits(int[] answers) {
            int[] map = new int[1000];
            for (int ans : answers) {
                map[ans]++;
            }
            int res = 0;
            for (int i = 0; i < 1000; i++) {
                int ans = i, count = map[i];
                if (ans > 0) {
                    int sameCount = ans + 1;
                    res += (count / sameCount) * sameCount;
                    if (count % sameCount != 0) {
                        res += sameCount;
                    }
                } else if (count > 0) {
                    res += count;
                }
            }
            return res;
        }
    }
}
