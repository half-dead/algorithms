package p2000_;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/
 *
 * @author half-dead
 */
public class Puzzle1878 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {33307, 7665, 66064, 94820, 26967, 57606, 57166, 96690, 29974, 94461, 83063, 81320, 40482, 85314, 6366, 748, 28813, 9395, 7028, 64658, 9181, 73377, 58204, 7667, 82480, 11820, 2454, 83701, 33349, 46306, 19462, 99326},
                {65112, 73007, 10258, 18665, 64554, 44991, 2698, 89229, 20930, 91742, 44072, 3891, 47675, 94755, 70182, 84744, 40661, 94818, 72026, 90178, 64280, 43029, 37182, 68248, 84462, 13822, 82535, 75828, 90482, 22931, 55327, 94756},
                {51072, 63023, 72236, 13017, 48025, 86634, 27013, 68682, 40119, 90310, 4544, 79194, 31038, 80742, 92954, 81258, 14073, 36822, 63307, 80015, 89180, 53694, 10052, 35649, 98696, 47119, 6558, 94739, 6518, 57986, 19257, 30967},
                {15892, 77155, 70685, 20006, 99508, 97779, 67581, 49015, 60576, 61066, 39718, 72330, 56951, 16599, 71814, 20623, 8681, 72485, 21196, 79552, 87726, 67191, 8529, 4220, 48289, 14455, 77903, 96952, 21979, 15087, 90411, 62452},
                {22224, 26420, 47847, 29885, 96683, 19622, 31054, 15234, 62949, 62501, 76463, 53473, 36300, 47756, 54711, 21688, 94763, 17533, 54, 58541, 67062, 2374, 98023, 29161, 35657, 75635, 31044, 59019, 91635, 47109, 18050, 41431},
                {67363, 29635, 19989, 17061, 21742, 94982, 93185, 54142, 10265, 90305, 52223, 76056, 89006, 5823, 98748, 91617, 78847, 62721, 75663, 73761, 50764, 25785, 14997, 93274, 66090, 59397, 37101, 92301, 99754, 46755, 47825, 90897},
                {8446, 21801, 26403, 97711, 12220, 3145, 45636, 21686, 80529, 25190, 6124, 72829, 71942, 26036, 63869, 7349, 24522, 72900, 73434, 48633, 36975, 73077, 14490, 15330, 46979, 31910, 70909, 79894, 53346, 56354, 65298, 99146},
                {80604, 62672, 20568, 44345, 73027, 4924, 17365, 5831, 72798, 27156, 89074, 66761, 73270, 54212, 14348, 67547, 78092, 42171, 3273, 88418, 1770, 88273, 57329, 526, 99309, 49746, 85572, 22247, 64455, 3669, 39092, 68259},
                {74712, 33611, 84194, 1623, 85624, 88285, 84120, 86013, 80780, 42007, 25897, 27318, 52011, 53983, 6357, 44536, 78535, 78171, 279, 10270, 38561, 86513, 95674, 91687, 11393, 29570, 86073, 39834, 62166, 78126, 74824, 85470},
                {34465, 75715, 40310, 27147, 1984, 69419, 17857, 95761, 55048, 91085, 70031, 58906, 51660, 30944, 16081, 63589, 76507, 68057, 44588, 11855, 7580, 7971, 76203, 45346, 9786, 63077, 71188, 5360, 63557, 44339, 155, 10847},
                {13458, 8068, 33398, 45750, 44012, 10346, 67172, 32596, 49580, 26955, 50722, 47948, 23614, 84573, 37986, 70593, 81872, 63909, 80250, 26484, 94307, 87701, 59860, 49354, 58005, 62210, 61994, 19893, 2271, 35327, 81205, 73513},
                {18044, 30740, 37198, 78451, 7630, 58300, 36336, 44109, 89169, 84, 82058, 40709, 63827, 71472, 34629, 17193, 42314, 7597, 93380, 15799, 56681, 30003, 98395, 40360, 36409, 57556, 41605, 53875, 39496, 47459, 23506, 2948},
                {77088, 3682, 31703, 747, 29599, 81689, 98707, 23059, 6146, 3972, 57637, 66726, 33268, 45629, 99389, 9595, 78036, 17474, 92336, 13387, 38431, 92904, 66887, 10465, 7111, 36402, 57951, 27283, 47641, 3899, 33929, 12564}
        };
        Solution s = new Puzzle1878().new Solution();
        System.out.println(Arrays.toString(s.getBiggestThree(grid)));
    }

    class Solution {
        public int[] getBiggestThree(int[][] grid) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int[] row : grid) for (int x : row) add(set, x);

            int[][] dirs = new int[][]{{1, -1}, {1, 1}, {-1, 1}, {-1, -1}};

            int m = grid.length, n = grid[0].length, maxEdge = (Math.min(m, n) - 1) / 2;
            for (int edge = 1; edge <= maxEdge; edge++) {

                for (int r = 0; r < m; r++) {
                    if (r < edge || r + edge >= m) continue;

                    for (int c = 0; c < n; c++) {
                        if (c < edge || c + edge >= n) continue;

                        int sum = 0, i = r - edge, j = c, d = 0;
                        for (int cnt = 1; cnt <= edge * 4; cnt++) {
                            sum += grid[i][j];
                            i += dirs[d][0];
                            j += dirs[d][1];
                            if (cnt % edge == 0) d = (d + 1) % 4;
                        }
                        add(set, sum);
                    }
                }
            }

            int[] res = new int[set.size()];
            int i = set.size() - 1;
            for (int x : set) res[i--] = x;
            return res;
        }

        void add(TreeSet<Integer> set, int n) {
            set.add(n);
            if (set.size() > 3) set.remove(set.first());
        }
    }
}
