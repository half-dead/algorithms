package p1500_;

/**
 * @author half-dead
 */
public class Puzzle1482 {

    public static void main(String[] args) {
        Solution s = new Puzzle1482().new Solution();
        System.out.println(s.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
    }

    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            if (m * k > bloomDay.length) {
                return -1;
            }

            int min = bloomDay[0], max = bloomDay[0];
            for (int d : bloomDay) {
                min = Math.min(min, d);
                max = Math.max(max, d);
            }
            if (min == max) {
                return max;
            }

            while (min < max) {
                int mid = (min + max) / 2;
                boolean succ = false;
                int cnt = 0, cbq = 0;
                for (int d : bloomDay) {
                    if (d <= mid) {
                        if (++cnt == k) {
                            if (++cbq == m) {
                                succ = true;
                                break;
                            }
                            cnt = 0;
                        }
                    } else {
                        cnt = 0;
                    }
                }
                if (succ) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            return min;
        }
    }
}
