package p0500_;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * @author half-dead
 */
public class Puzzle315 {

    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            List[] list = new List[20001];
            for (int i = 0; i <= 20000; i++) list[i] = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                list[nums[i] + 10000].add(i);
            }

            int[] res = new int[nums.length];
            TreeSet<Integer> ts = new TreeSet<>();
            for (int i = 0; i <= 20000; i++) {
                for (Object o : list[i]) {
                    int oo = (Integer) o;
                    ts.add(oo);
                    res[oo] = ts.tailSet(oo, false).size();
                }
            }
            List<Integer> ans = new ArrayList<>(res.length);
            for (int x : res) ans.add(x);
            return ans;
        }
    }
}
