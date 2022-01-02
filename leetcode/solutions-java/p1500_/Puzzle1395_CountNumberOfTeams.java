package p1500_;

/**
 * https://leetcode.com/problems/count-number-of-teams/
 *
 * @author half-dead
 */
public class Puzzle1395_CountNumberOfTeams {

    class On2Solution {
        public int numTeams(int[] rating) {
            int count = 0;
            int len = rating.length;
            for (int i = 1; i < len - 1; i++) {
                int[] lt = new int[2], gt = new int[2];
                for (int j = 0; j < len; j++) {
                    if (rating[j] < rating[i]) lt[j < i ? 0 : 1]++;
                    if (rating[j] > rating[i]) gt[j < i ? 0 : 1]++;
                }
                count += lt[0] * gt[1] + lt[1] * gt[0];
            }
            return count;
        }
    }

    class BruteForceSolution {
        public int numTeams(int[] rating) {
            int count = 0;
            int len = rating.length;

            for (int i = 0; i < len - 2; i++)
                for (int j = i + 1; j < len - 1; j++)
                    if (rating[j] > rating[i])
                        for (int k = j + 1; k < len; k++)
                            if (rating[k] > rating[j]) count++;

            for (int i = 0; i < len - 2; i++)
                for (int j = i + 1; j < len - 1; j++)
                    if (rating[j] < rating[i])
                        for (int k = j + 1; k < len; k++)
                            if (rating[k] < rating[j]) count++;
            return count;
        }
    }
}
