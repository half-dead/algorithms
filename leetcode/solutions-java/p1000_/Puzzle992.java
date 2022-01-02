package p1000_;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/subarrays-with-k-different-integers/
 *
 * @author half-dead
 */
public class Puzzle992 {

    public static void main(String[] args) {
        Solution s = new Puzzle992().new Solution();
        System.out.println(s.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(s.subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
    }

    class Solution {
        public int subarraysWithKDistinct(int[] nums, int k) {
            int n = nums.length, res = 0, prefix = 0;

            int[] freq = new int[n + 1];
            for (int left = 0, right = 0, cnt = 0; right < n; right++) {
                if (freq[nums[right]]++ == 0) cnt++;

                if (cnt > k) {
                    freq[nums[left++]]--;
                    cnt--;
                    prefix = 0;
                }
                while (freq[nums[left]] > 1) {
                    prefix++;
                    freq[nums[left++]]--;
                }
                if (cnt == k) res += prefix + 1;
            }
            return res;
        }
    }

    // sliding window, freq map, doubly-linked list, O(N) time & space
    class Solution1 {
        public int subarraysWithKDistinct(int[] nums, int k) {
            int n = nums.length, max = 0, res = 0;
            for (int x : nums) max = Math.max(max, x);

            List<Deque<Integer>> freq = new ArrayList<>(max + 1);
            for (int i = 0; i <= max; i++) freq.add(new LinkedList<>());

            int left = 0, right = 0, cnt = 0;
            while (left < n && right < n) {
                while (right < n && cnt < k) {
                    Deque<Integer> slot = freq.get(nums[right]);
                    slot.addLast(right++);
                    if (slot.size() == 1) cnt++;
                }

                int mid = right - 1;
                while (right < n && freq.get(nums[right]).size() > 0) {
                    freq.get(nums[right]).addLast(right++);
                }

                while (cnt == k) {
                    res += right - mid;
                    Deque<Integer> slot = freq.get(nums[left++]);
                    slot.pollFirst();
                    if (slot.isEmpty()) cnt--;
                    else mid = Math.max(mid, slot.peekFirst());
                }
            }
            return res;
        }
    }
}
