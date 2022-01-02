package p1500_;

import util.Print;

/**
 * https://leetcode.com/problems/distribute-candies-to-people
 *
 * @author half-dead
 */
public class Puzzle1103 {
    public static void main(String[] args) {
        Solution s = new Puzzle1103().new Solution();
        Print.pt(s.distributeCandies(Integer.MAX_VALUE, 123));
    }

    class Solution {
        public int[] distributeCandies(int candies, int num) {
            if (num == 1) return new int[]{candies};

            int sum = num * (num + 1) / 2, loop = 0;
            while (candies > sum) {
                loop++;
                candies -= sum;
                sum += num * num;
            }
            System.out.println(loop);

            int[] res = new int[num];
            if (loop > 0) {
                res[0] = loop + num * loop * (loop - 1) / 2;
                for (int i = 1; i < num; i++) res[i] = res[i - 1] + loop;
            }

            for (int i = 0, gift = loop * num + 1; candies > 0; candies -= gift++, i++)
                res[i] += Math.min(candies, gift);
            return res;
        }
    }
}
