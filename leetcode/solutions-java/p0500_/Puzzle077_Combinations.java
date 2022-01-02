package p0500_;

/*

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle077_Combinations {

    public static void main(String[] args) {
        Puzzle077_Combinations p = new Puzzle077_Combinations();
        NeatSolution solution = p.new NeatSolution();
        List<List<Integer>> combine = solution.combine(6, 3);
        System.out.println(combine);
    }

    class NeatSolution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            dfs(1, n, k, new ArrayList<>(k), result);
            return result;
        }

        public void dfs(int start, int end, int k, List<Integer> current, List<List<Integer>> result) {
            if (k == 0) {
                result.add(new ArrayList<>(current));
                return;
            }
            if (end - start + 1 < k) {
                return;
            }
            current.add(start);
            System.out.println("firstDfs\t" + start + " " + end + " " + k);
            dfs(start + 1, end, k - 1, current, result);
            current.remove(current.size() - 1);
            System.out.println("secondDfs\t" + start + " " + end + " " + k);
            dfs(start + 1, end, k, current, result);
        }
    }

    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            return recursive(k, 1, n);
        }

        public List<List<Integer>> recursive(int k, int startIndex, int endIndex) {
            if (k == endIndex - startIndex + 1) {
                return newListList(startIndex, endIndex);
            }

            if (k > 1) {
                List<List<Integer>> subList = recursive(k - 1, startIndex + 1, endIndex);
                subList.forEach(list -> list.add(startIndex));
                subList.addAll(recursive(k, startIndex + 1, endIndex));
                return subList;
            } else {
                List<List<Integer>> result = new ArrayList<>();
                for (int i = startIndex; i <= endIndex; i++) {
                    result.add(newList(i));
                }
                return result;
            }
        }

        public List<Integer> newList(int i) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            return list;
        }

        public List<List<Integer>> newListList(int i, int j) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> subList = new ArrayList<>();
            for (int n = i; n <= j; n++) {
                subList.add(n);
            }
            list.add(subList);
            return list;
        }

    }


}

