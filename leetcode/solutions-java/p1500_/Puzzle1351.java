package p1500_;

/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 *
 * @author half-dead
 */
public class Puzzle1351 {

    public static void main(String[] args) {
        Solution s = new Puzzle1351().new Solution();
        System.out.println(s.countNegatives(new int[][]{
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        }));
    }

    class Solution {
        public int countNegatives(int[][] grid) {
            int rows = grid.length, cols = grid[0].length;
            int cnt = 0, to = cols;
            for (int i = 0; i < rows; i++) {
                int[] row = grid[i];

                int pos = binarySearch0(row, 0, to, -1);
                if (pos < 0) {
                    // find the correct insertion point, all elements at [pos, cols-1] is negative
                    pos = -pos - 1;
                } else {
                    // we need to find the left most -1 on this row
                    while (pos > 0 && row[pos - 1] == -1) pos--;
                }

                if (pos == 0) {
                    // the first element is negative, we can just calculate and return the result
                    return cnt + (rows - i) * cols;
                } else {
                    // update 'to', update cnt
                    cnt += cols - (to = pos);
                }
            }
            return cnt;
        }

        // because the array is in non-increasing order, we could not use Arrays.sort()
        // just copied here with a little modification
        private int binarySearch0(int[] a, int from, int to, int key) {
            int low = from, high = to - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1, midVal = a[mid];

                if (midVal > key) low = mid + 1;
                else if (midVal < key) high = mid - 1;
                else return mid;
            }
            return -(low + 1);
        }
    }
}
