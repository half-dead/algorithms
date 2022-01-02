package p0500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lexicographical-numbers/
 *
 * @author half-dead
 */
public class Puzzle386 {

    class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> list = new ArrayList<>(n);
            for (int i = 1; i <= 9; i++) dfs(list, n, i);
            return list;
        }

        void dfs(List<Integer> list, int max, int prev) {
            if (prev > max) return;
            list.add(prev);
            for (int num = prev * 10, i = 0; i <= 9; i++, num++) {
                if (num <= max) dfs(list, max, num);
                else break;
            }
        }
    }
}
