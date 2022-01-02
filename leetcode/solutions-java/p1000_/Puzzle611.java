package p1000_;

import java.util.Arrays;

/**
 * @author half-dead
 */
public class Puzzle611 {

    public static void main(String[] args) {
        Solution s = new Puzzle611().new Solution();
        System.out.println(s.triangleNumber(new int[]{2, 2, 3, 4}));
    }


    class Solution {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int count = 0, n = nums.length;
            for (int i = n - 1; i >= 2; i--) {
                int left = 0, right = i - 1;
                while (left < right) {
                    if (nums[left] + nums[right] > nums[i]) {
                        count += right - left;
                        right--;
                    } else left++;
                }
            }
            return count;
        }
    }

    // cnt sort, O(1000^3)
    class Solution1 {
        public int triangleNumber(int[] nums) {
            int[] cnt = new int[1001];
            for (int n : nums) cnt[n]++;

            int res = 0;
            for (int a = 1; a <= 1000; a++) {
                if (cnt[a] == 0) continue;

                for (int b = a; b <= 1000; b++) {
                    if (cnt[b] == 0) continue;

                    for (int c = b; c <= 1000; c++) {
                        if (a + b <= c) {
                            break;
                        }
                        if (cnt[c] == 0) continue;

                        if (a == b && b == c) {
                            res += comb3(cnt[a]);
                        } else if (a == b && a + b > c) {
                            res += comb2(cnt[a]) * cnt[c];
                        } else if (b == c) {
                            res += cnt[a] * comb2(cnt[b]);
                        } else if (check(a, b, c)) {
                            res += cnt[a] * cnt[b] * cnt[c];
                        }
                    }
                }
            }
            return res;
        }

        int comb2(int x) {
            return x * (x - 1) / 2;
        }

        int comb3(int x) {
            return x * (x - 1) * (x - 2) / 6;
        }

        boolean check(int a, int b, int c) {
            return a + b > c;
        }
    }
}
