package p2500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-unequal-triplets-in-array/
 */
public class Puzzle2475 {
    class Solution {
        public int unequalTriplets(int[] nums) {
            int[] freq = new int[1001];
            for (int x : nums) {
                freq[x]++;
            }

            List<Integer> list = new ArrayList<>();
            for (int f : freq) {
                if (f > 0) {
                    list.add(f);
                }
            }

            if (list.size() < 3) return 0;

            int total = nums.length, res = 0;
            for (int i = 0; i < list.size() - 2; i++) {
                int a = list.get(i);
                int b = 0, temp = total - a;
                for (int j = i + 1; j < list.size() - 1; j++) {
                    int x = list.get(j);
                    b += x * (temp - x);
                    temp -= x;
                }
                res += a * b;
                total -= a;
            }
            return res;
        }
    }

    class Solution2 {
        public int unequalTriplets(int[] nums) {
            int[] cnt = new int[1001];
            int trips = 0, pairs = 0;
            for (int i = 0; i < nums.length; ++i) {
                int x = nums[i];
                trips += pairs - cnt[x] * (i - cnt[x]);
                pairs += i - cnt[x];
                cnt[x] += 1;
            }
            return trips;
        }
    }

}
