package p1000_;

/**
 * https://leetcode.com/problems/rle-iterator/
 *
 * @author half-dead
 */
public class Puzzle900_RLEIterator {
    class RLEIterator {
        int[] arr;
        int index;

        public RLEIterator(int[] arr) {
            this.arr = arr;
            index = 0;
        }

        public int next(int n) {
            while (index < arr.length) {
                if (arr[index] >= n) {
                    arr[index] -= n;
                    return arr[index + 1];
                } else {
                    n -= arr[index];
                    index += 2;
                }
            }
            return -1;
        }
    }

}
