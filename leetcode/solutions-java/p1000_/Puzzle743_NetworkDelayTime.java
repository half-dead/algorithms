package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/network-delay-time/
 *
 * @author half-dead
 */
public class Puzzle743_NetworkDelayTime {

    public static void main(String[] args) {
        Puzzle743_NetworkDelayTime p = new Puzzle743_NetworkDelayTime();
        Solution s = p.new Solution();
        int[][] times = new int[][]{{10, 3, 41}, {13, 4, 66}, {15, 13, 41}, {2, 9, 84}, {15, 2, 57}, {10, 7, 76}, {4, 3, 90}, {1, 14, 35}, {7, 3, 54}, {14, 4, 36}, {7, 13, 63}, {14, 6, 91}, {11, 2, 37}, {4, 1, 3}, {12, 10, 63}, {11, 1, 28}, {6, 4, 62}, {14, 11, 45}, {1, 9, 14}, {5, 8, 18}, {9, 15, 22}, {12, 9, 37}, {7, 1, 65}, {12, 5, 78}, {15, 14, 15}, {4, 13, 97}, {1, 15, 35}, {10, 9, 82}, {15, 8, 1}, {15, 7, 75}, {3, 7, 64}, {10, 14, 81}, {13, 3, 59}, {5, 7, 49}, {2, 4, 90}, {10, 13, 43}, {11, 13, 26}, {10, 5, 27}, {1, 3, 54}, {4, 9, 18}, {5, 9, 70}, {5, 12, 58}, {13, 5, 78}, {7, 8, 68}, {1, 13, 12}, {3, 10, 38}, {13, 7, 17}, {5, 1, 71}, {15, 10, 89}, {11, 8, 40}, {7, 15, 48}, {8, 2, 55}, {1, 11, 25}, {3, 15, 72}, {1, 7, 11}, {14, 2, 25}, {9, 10, 17}, {13, 10, 69}, {12, 3, 6}, {6, 15, 4}, {14, 13, 52}, {12, 15, 48}, {14, 7, 61}, {13, 14, 45}, {3, 4, 91}, {11, 10, 94}, {10, 4, 71}, {3, 14, 0}, {3, 6, 37}, {6, 11, 35}, {4, 6, 25}, {6, 1, 16}, {9, 2, 97}, {13, 9, 78}, {8, 7, 62}, {11, 3, 21}, {2, 10, 30}, {2, 13, 54}, {14, 8, 6}, {4, 14, 7}, {2, 6, 62}, {2, 15, 11}, {14, 15, 41}, {7, 2, 8}, {5, 14, 31}, {6, 8, 13}, {2, 3, 76}, {9, 14, 34}, {8, 15, 6}, {7, 11, 38}, {5, 4, 46}, {1, 4, 10}, {14, 12, 22}, {9, 13, 66}, {6, 12, 74}, {6, 3, 68}, {5, 6, 74}, {10, 11, 18}, {3, 8, 84}, {5, 13, 20}, {8, 11, 41}, {2, 8, 41}, {15, 4, 2}, {8, 1, 82}, {9, 1, 60}, {7, 14, 60}, {3, 12, 32}, {11, 7, 26}, {10, 2, 56}, {9, 3, 69}, {15, 11, 77}, {5, 2, 35}, {11, 15, 34}, {8, 6, 35}, {8, 12, 12}, {4, 11, 94}, {4, 5, 38}, {1, 10, 25}, {7, 12, 34}, {12, 2, 48}, {2, 7, 75}, {12, 11, 93}, {15, 6, 13}, {1, 8, 11}, {12, 13, 51}, {13, 6, 72}, {3, 11, 46}, {9, 4, 15}, {10, 12, 47}, {12, 7, 17}, {8, 13, 62}, {11, 12, 67}, {14, 3, 17}, {5, 3, 11}, {14, 5, 30}, {13, 8, 90}, {3, 5, 42}, {3, 1, 90}, {4, 12, 62}, {9, 6, 78}, {9, 5, 63}, {2, 5, 19}, {14, 1, 42}, {1, 5, 27}, {13, 12, 71}, {9, 12, 86}, {4, 2, 98}, {7, 5, 24}, {6, 10, 47}, {10, 8, 42}, {9, 11, 60}, {2, 14, 72}, {7, 4, 29}, {12, 4, 15}, {1, 12, 57}, {15, 1, 65}, {1, 6, 78}, {12, 1, 7}, {2, 1, 48}, {8, 5, 35}, {7, 6, 73}, {8, 14, 15}, {9, 8, 2}, {13, 15, 56}, {15, 12, 24}, {10, 6, 75}, {4, 15, 40}, {7, 10, 87}, {2, 12, 79}, {15, 3, 65}, {3, 9, 78}, {13, 2, 31}, {14, 10, 72}, {11, 14, 83}, {6, 5, 99}, {8, 9, 55}, {8, 4, 3}, {4, 8, 41}, {6, 9, 97}, {10, 15, 19}, {15, 5, 97}, {10, 1, 36}, {5, 15, 69}, {11, 4, 68}, {9, 7, 0}, {12, 8, 28}, {6, 13, 89}, {14, 9, 37}, {11, 9, 64}, {12, 6, 32}, {3, 13, 8}, {7, 9, 8}, {6, 7, 59}, {13, 1, 13}, {12, 14, 97}, {8, 10, 85}, {2, 11, 82}, {3, 2, 87}, {13, 11, 5}, {15, 9, 27}, {4, 10, 27}, {5, 11, 64}, {8, 3, 59}, {6, 14, 51}, {4, 7, 95}, {11, 6, 54}, {6, 2, 35}, {1, 2, 39}, {5, 10, 89}, {11, 5, 91}};
        int n = s.networkDelayTime(times, 15, 2);
        System.out.println(n);
    }

    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            int[] result = new int[n + 1];
            boolean[] marker = new boolean[n + 1];
            for (int i = 0; i <= n; i++) {
                result[i] = -1;
            }
            result[k] = 0;
            int[][] map = new int[n + 1][n + 1];
            for (int i = 0; i < n + 1; i++) {
                Arrays.fill(map[i], -1);
            }
            for (int[] e : times) {
                map[e[0]][e[1]] = e[2];
            }

            int count = 0;
            while (count < n) {
                int min = Integer.MAX_VALUE;
                int minIndex = -1;
                for (int i = 1; i < n + 1; i++) {
                    if (result[i] != -1 && result[i] < min && !marker[i]) {
                        min = result[i];
                        minIndex = i;
                    }
                }
                if (minIndex == -1) {
                    return -1;
                }
                marker[minIndex] = true;
                count++;
                for (int i = 1; i < n + 1; i++) {
                    if (map[minIndex][i] != -1) {
                        int cost = map[minIndex][i] + result[minIndex];
                        if (result[i] == -1 || result[i] > cost) {
                            result[i] = cost;
                        }
                    }
                }
            }

            int total = -1;
            for (int i = 1; i < n + 1; i++) {
                if (result[i] > total) {
                    total = result[i];
                }
            }
            return total;
        }
    }

}