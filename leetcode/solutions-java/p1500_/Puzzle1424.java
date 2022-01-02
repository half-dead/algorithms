package p1500_;

import util.Print;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 *
 * @author half-dead
 */
public class Puzzle1424 {

    public static void main(String[] args) {
        Solution s = new Puzzle1424().new Solution();
        Print.pt(s.findDiagonalOrder(Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7),
                Collections.singletonList(8),
                Arrays.asList(9, 10, 11),
                Arrays.asList(12, 13, 14, 15, 16)
        )));
    }

    // Sort by coordinates
    class SortSolution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            int total = 0;
            for (List<Integer> row : nums) total += row.size();

            int[][] m = new int[total][2];
            for (int i = 0, r = 0, rows = nums.size(); r < rows; r++) {
                for (int c = 0, cols = nums.get(r).size(); c < cols; c++) {
                    m[i++] = new int[]{r, c};
                }
            }
            Arrays.sort(m, (p, q) -> {
                int d1 = p[0] + p[1], d2 = q[0] + q[1];
                return d1 == d2 ? p[1] - q[1] : d1 - d2;
            });

            int[] ans = new int[total];
            for (int i = 0; i < total; i++) ans[i] = nums.get(m[i][0]).get(m[i][1]);
            return ans;
        }
    }

    class BucketSolution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            int rows = nums.size(), total = 0, max = 0;
            for (int i = 0, size; i < rows; i++) {
                total += (size = nums.get(i).size());
                max = Math.max(i + size - 1, max);
            }

            LinkedList<Integer>[] buckets = new LinkedList[max + 1];
            for (int i = 0; i <= max; i++) buckets[i] = new LinkedList<>();

            for (int r = 0; r < rows; r++) {
                List<Integer> row = nums.get(r);
                for (int c = 0, cols = row.size(); c < cols; c++) {
                    buckets[r + c].addFirst(row.get(c));
                }
            }

            int i = 0;
            int[] ans = new int[total];
            for (LinkedList<Integer> bucket : buckets)
                for (int n : bucket)
                    ans[i++] = n;
            return ans;
        }
    }

    class Solution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            int total = 0, rows = nums.size(), bucketNum = 0;
            for (int r = 0, cols; r < rows; r++) {
                total += (cols = nums.get(r).size());
                bucketNum = Math.max(bucketNum, r + cols);
            }

            int[] numCountPerBucket = new int[bucketNum], startIdx = new int[bucketNum];
            // 计算每个桶的元素个数
            for (int r = 0; r < rows; r++)
                for (int c = 0, cols = nums.get(r).size(); c < cols; c++)
                    numCountPerBucket[r + c]++;
            // 计算每个桶的起始索引（即前面所有桶的元素个数的累加和）
            for (int i = 1; i < bucketNum; i++) startIdx[i] = startIdx[i - 1] + numCountPerBucket[i - 1];

            int[] ans = new int[total];
            for (int i = rows - 1; i >= 0; i--) {
                List<Integer> row = nums.get(i);
                for (int j = 0, cols = row.size(); j < cols; ++j)
                    ans[startIdx[i + j]++] = row.get(j);
            }
            return ans;
        }
    }

}
