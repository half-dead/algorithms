package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-area-rectangle/
 *
 * @author half-dead
 */
public class Puzzle939_MinimumAreaRectangle {

    class Solution {
        public int minAreaRect(int[][] points) {
            Map<Integer, Set<Integer>> yLines = new HashMap<>();
            for (int[] point : points) {
                yLines.putIfAbsent(point[0], new HashSet<>());
                yLines.get(point[0]).add(point[1]);
            }
            int min = 0;
            for (int[] p1 : points) {
                for (int[] p2 : points) {
                    int x1 = p1[0], x2 = p2[0], y1 = p1[1], y2 = p2[1];
                    if (x1 != x2 && y1 != y2) {
                        if (yLines.get(x1).contains(y2) && yLines.get(x2).contains(y1)) {
                            int area = Math.abs((x1 - x2) * (y1 - y2));
                            min = min == 0 ? area : Math.min(area, min);
                        }
                    }
                }
            }
            return min;
        }
    }

    // Complicated
    class Solution2 {
        public int minAreaRect(int[][] points) {
            Map<Integer, Set<Integer>> lines = new HashMap<>();
            for (int[] point : points) {
                lines.putIfAbsent(point[0], new HashSet<>());
                lines.get(point[0]).add(point[1]);
            }

            int min = 0;
            // all lines paralleled to y-axis
            List<Integer> xlist = new ArrayList<>(lines.keySet());
            // 递归每一条纵线
            for (int i = 0; i < xlist.size() - 1; i++) {
                int x1 = xlist.get(i);
                List<Integer> y1list = new ArrayList<>(lines.get(x1));

                // 如果这条纵线上有至少2个点
                if (y1list.size() > 1) {
                    for (int m = 0; m < y1list.size() - 1; m++) {
                        // 确定坐标(x1, y1)
                        int y1 = y1list.get(m);

                        for (int j = i + 1; j < xlist.size(); j++) {
                            int x2 = xlist.get(j);
                            Set<Integer> y2set = lines.get(x2);
                            // 这两条纵线有两个点的纵坐标相同，即存在一条与x轴平行的边
                            if (y2set.contains(y1)) {
                                for (int n = m + 1; n < y1list.size(); n++) {
                                    int y2 = y1list.get(n);
                                    if (y2set.contains(y2)) {
                                        int area = Math.abs((x2 - x1) * (y2 - y1));
                                        if (min == 0) {
                                            min = area;
                                        } else {
                                            min = Math.min(min, area);
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
            return min;
        }
    }
}
