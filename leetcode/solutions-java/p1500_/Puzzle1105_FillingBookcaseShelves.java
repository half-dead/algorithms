package p1500_;

/**
 * https://leetcode.com/problems/filling-bookcase-shelves/
 *
 * @author half-dead
 */
public class Puzzle1105_FillingBookcaseShelves {


    public static void main(String[] args) {
        Solution s1 = new Puzzle1105_FillingBookcaseShelves().new Solution();
        MySolution s2 = new Puzzle1105_FillingBookcaseShelves().new MySolution();
        int[][] books = {{11, 83}, {170, 4}, {93, 80}, {155, 163}, {134, 118}, {75, 14}, {122, 192}, {123, 154}, {187, 29}, {160, 64}, {170, 152}, {113, 179}, {60, 102}, {28, 187}, {59, 95}, {187, 97}, {49, 193}, {67, 126}, {75, 45}, {130, 160}, {4, 102}, {116, 171}, {43, 170}, {96, 188}, {54, 15}, {167, 183}, {58, 158}, {59, 55}, {148, 183}, {89, 95}, {90, 113}, {51, 49}, {91, 28}, {172, 103}, {173, 3}, {131, 78}, {11, 199}, {77, 200}, {58, 65}, {77, 30}, {157, 58}, {18, 194}, {101, 148}, {22, 197}, {76, 181}, {21, 176}, {50, 45}, {80, 174}, {116, 198}, {138, 9}, {58, 125}, {163, 102}, {133, 175}, {21, 39}, {141, 156}, {34, 185}, {14, 113}, {11, 34}, {35, 184}, {16, 132}, {78, 147}, {85, 170}, {32, 149}, {46, 94}, {196, 3}, {155, 90}, {9, 114}, {117, 119}, {17, 157}, {94, 178}, {53, 55}, {103, 142}, {70, 121}, {9, 141}, {16, 170}, {92, 137}, {157, 30}, {94, 82}, {144, 149}, {128, 160}, {8, 147}, {153, 198}, {12, 22}, {140, 68}, {64, 172}, {86, 63}, {66, 158}, {23, 15}, {120, 99}, {27, 165}, {79, 174}, {46, 19}, {60, 98}, {160, 172}, {128, 184}, {63, 172}, {135, 54}, {40, 4}, {102, 171}, {29, 125}, {81, 9}, {111, 197}, {16, 90}, {22, 150}, {168, 126}, {187, 61}, {47, 190}, {54, 110}, {106, 102}, {55, 47}, {117, 134}, {33, 107}, {2, 10}, {18, 62}, {109, 188}, {113, 37}, {59, 159}, {120, 175}, {17, 147}, {112, 195}, {177, 53}, {148, 173}, {29, 105}, {196, 32}, {123, 51}, {29, 19}, {161, 178}, {148, 2}, {70, 124}, {126, 9}, {105, 87}, {41, 121}, {147, 10}, {78, 167}, {91, 197}, {22, 98}, {73, 33}, {148, 194}, {166, 64}, {33, 138}, {139, 158}, {160, 19}, {140, 27}, {103, 109}, {88, 16}, {99, 181}, {2, 140}, {50, 188}, {200, 77}, {73, 84}, {159, 130}, {115, 199}, {152, 79}, {1, 172}, {124, 136}, {117, 138}, {158, 86}, {193, 150}, {56, 57}, {150, 133}, {52, 186}, {21, 145}, {127, 97}, {108, 110}, {174, 44}, {199, 169}, {139, 200}, {66, 48}, {52, 190}, {27, 86}, {142, 191}, {191, 79}, {126, 114}, {125, 100}, {176, 95}, {104, 79}, {146, 189}, {144, 78}, {52, 106}, {74, 74}, {163, 128}, {34, 181}, {20, 178}, {15, 107}, {105, 8}, {66, 142}, {39, 126}, {95, 59}, {164, 69}, {138, 18}, {110, 145}, {128, 200}, {149, 150}, {149, 93}, {145, 140}, {90, 170}, {81, 127}, {57, 151}, {167, 127}, {95, 89}};
        long t1 = System.nanoTime();
        s1.minHeightShelves(books, 500);
        long t2 = System.nanoTime();
        s2.minHeightShelves(books, 500);
        long t3 = System.nanoTime();
        float f = 1000f * 1000f;
        System.out.printf("cost: %.3f, %.3f\n", (t3 - t2) / f, (t2 - t1) / f);
    }

    // worst case O(n^2) time, O(n) space, 0ms
    class Solution {
        public int minHeightShelves(int[][] books, int shelf) {
            int len = books.length;
            int[] dp = new int[len];
            dp[0] = books[0][1];
            for (int to = 1; to < len; to++) {
                int sumWidth = books[to][0], maxHeight = books[to][1], from = to - 1;
                dp[to] = dp[to - 1] + maxHeight;
                for (; from >= 0 && (sumWidth += books[from][0]) <= shelf; from--)
                    dp[to] = Math.min(dp[to], (maxHeight = Math.max(maxHeight, books[from][1])) + (from > 0 ? dp[from - 1] : 0));
            }
            return dp[len - 1];
        }
    }

    // always O(n^2) time, O(n^2) space, 74ms
    class MySolution {
        public int minHeightShelves(int[][] books, int shelf) {
            int len = books.length;
            int[][][] dp = new int[len][len][3];
            dp[0][0][0] = dp[0][0][1] = books[0][1];
            dp[0][0][2] = books[0][0];
            for (int i = 1; i < len; i++) {
                int width = books[i][0], height = books[i][1], totalH = Integer.MAX_VALUE;
                for (int j = 0; j <= i - 1; j++) {
                    int[] p = dp[i - 1][j];
                    int pth = p[0], ph = p[1], pw = p[2];
                    totalH = Math.min(pth, totalH);
                    pw += width;
                    if (pw > shelf) {
                        pth += height;
                        ph = height;
                        pw = width;
                    } else if (height > ph) {
                        pth += height - ph;
                        ph = height;
                    }
                    dp[i][j] = new int[]{pth, ph, pw};
                }
                dp[i][i] = new int[]{totalH + height, height, width};
            }
            int r = Integer.MAX_VALUE;
            for (int[] n : dp[len - 1]) r = Math.min(r, n[0]);
            return r;
        }
    }
}
