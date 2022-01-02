package p0500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 *
 * @author half-dead
 */
public class Puzzle216_CombinationSumIII {

    public static void main(String[] args) {
        Puzzle216_CombinationSumIII p = new Puzzle216_CombinationSumIII();
        Solution s = p.new Solution();
        List<List<Integer>> lists = s.combinationSum3(3, 9);
        System.out.println(lists);
    }

    class Solution {
        int[] left = new int[]{0, 45, 44, 42, 39, 35, 30, 24, 17, 9};

        public List<List<Integer>> combinationSum3(int k, int n) {
            return dfs(k, n, 1);
        }

        private List<List<Integer>> dfs(int k, int n, int start) {
            if (start > 9 || left[start] < n) {
                return new ArrayList<>();
            } else if (k == 1) {
                if (n >= start && n < 10) {
                    List<Integer> list = new ArrayList<>();
                    list.add(n);
                    List<List<Integer>> result = new ArrayList<>();
                    result.add(list);
                    return result;
                } else {
                    return new ArrayList<>();
                }
            } else {
                List<List<Integer>> result = new ArrayList<>();
                for (int i = start; i < 10; i++) {
                    List<List<Integer>> rest = dfs(k - 1, n - i, i + 1);
                    if (rest.size() > 0) {
                        for (List<Integer> comb : rest) {
                            comb.add(i);
                        }
                        result.addAll(rest);
                    }
                }
                return result;
            }
        }
    }

}
