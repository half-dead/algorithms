package p0500_;

import util.Print;

import java.util.*;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 *
 * @author half-dead
 */
public class Puzzle218_TheSkylineProblem {
    public static void main(String[] args) {
        Solution s1 = new Puzzle218_TheSkylineProblem().new Solution();
//        Print.pt(s1.getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}));
//        Print.pt(s1.getSkyline(new int[][]{{0, 2, 3}, {2, 5, 3}}));
        Print.pt(s1.getSkyline(new int[][]{{2, 14, 4}, {4, 8, 8}, {6, 16, 4}}));
    }

    // Divide and conquer, 5ms
    public class DacSolution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            return dac(buildings, 0, buildings.length - 1);
        }

        private LinkedList<List<Integer>> dac(int[][] buildings, int lo, int hi) {
            LinkedList<List<Integer>> res = new LinkedList<>();
            if (lo > hi) return res;
            else if (lo == hi) {
                res.add(Arrays.asList(buildings[lo][0], buildings[lo][2]));
                res.add(Arrays.asList(buildings[lo][1], 0));
                return res;
            }

            int mid = (hi + lo) / 2, leftH = 0, rightH = 0;
            LinkedList<List<Integer>> left = dac(buildings, lo, mid), right = dac(buildings, mid + 1, hi);
            while (!left.isEmpty() || !right.isEmpty()) {
                long x1 = left.isEmpty() ? Long.MAX_VALUE : left.peekFirst().get(0);
                long x2 = right.isEmpty() ? Long.MAX_VALUE : right.peekFirst().get(0);
                int x = 0;
                if (x1 < x2) {
                    List<Integer> temp = left.pollFirst();
                    x = temp.get(0);
                    leftH = temp.get(1);
                } else if (x1 > x2) {
                    List<Integer> temp = right.pollFirst();
                    x = temp.get(0);
                    rightH = temp.get(1);
                } else {
                    x = left.peekFirst().get(0);
                    leftH = left.pollFirst().get(1);
                    rightH = right.pollFirst().get(1);
                }
                int h = Math.max(leftH, rightH);
                if (res.isEmpty() || h != res.peekLast().get(1)) {
                    res.add(Arrays.asList(x, h));
                }
            }
            return res;
        }
    }

    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> res = new ArrayList<>();

            // 按照高度降序，同高度根据起点升序
            PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : b[2] - a[2]);

            // 默认起点，PRE保存前面能看见的最高建筑和他的终点起点
            int[] temp = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};

            for (int[] building : buildings) {
                // 当出现断点情况，需要清空之前建筑群
                while (!heap.isEmpty() && building[0] > temp[1]) {
                    // 获取之前最高建筑
                    int[] top = heap.poll();
                    // 如果最高的终点在PRE之前，说明已经处理
                    if (top[1] <= temp[1]) continue;
                    // 如果遇到PRE之后的点，加入结果并更新PRE
                    res.add(Arrays.asList(temp[1], top[2]));
                    temp = top;
                }

                if (building[2] > temp[2]) { // 当前建筑比之前建筑高
                    if (building[0] == temp[0]) {
                        // 同起点情况下，矮建筑必然被挡住，直接删除
                        res.remove(res.size() - 1);
                    }
                    // 未被之后遮挡前先加入结果
                    res.add(Arrays.asList(building[0], building[2]));
                    if (building[1] < temp[1]) {// 如果终点小于前终点，将前值入堆
                        heap.offer(temp);
                    }
                    temp = building;// 更新前值因为发现了更高的
                } else if (building[2] == temp[2]) { // 同高度继续延伸END
                    temp[1] = building[1];
                } else if (building[1] > temp[1]) { // 矮建筑直接入堆
                    heap.offer(building);
                }
            }

            // 如果堆不为空，重复之前操作
            while (!heap.isEmpty()) {
                int[] top = heap.poll();
                if (top[1] <= temp[1]) continue;
                if (top[2] != temp[2]) {
                    res.add(Arrays.asList(temp[1], top[2]));
                }
                temp = top;
            }
            // 最后有剩余
            if (temp[2] > 0) {
                res.add(Arrays.asList(temp[1], 0));
            }
            return res;
        }
    }

    class SegmentTreeSolution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> result = new ArrayList<>();
            if (buildings == null || buildings.length == 0) return result;

            int minL = buildings[0][0], maxR = minL;
            for (int[] b : buildings) maxR = Math.max(maxR, b[1]);

            Segment root = new Segment(minL, maxR, 0);
            for (int[] b : buildings) root.add(b[0], b[1], b[2]);

            dfs(root, result);
            result.add(Arrays.asList(maxR, 0));
            return result;
        }

        void dfs(Segment node, List<List<Integer>> result) {
            if (node.left == null && node.right == null) {
                int size = result.size();
                if (size == 0 || result.get(size - 1).get(1) != node.height)
                    if (node.start > 0 || node.height > 0) result.add(Arrays.asList(node.start, node.height));
            } else {
                dfs(node.left, result);
                dfs(node.right, result);
            }
        }

        class Segment {
            int start, end, height, mid = -1;
            Segment left, right;

            public Segment(int x1, int x2, int h) {
                this.start = x1;
                this.end = x2;
                this.height = h;
            }

            void add(int x1, int x2, int h) {
                if (mid != -1) {
                    if (x1 >= mid) right.add(x1, x2, h);
                    else if (x2 <= mid) left.add(x1, x2, h);
                    else {
                        left.add(x1, mid, h);
                        right.add(mid, x2, h);
                    }
                    return;
                }

                if (x1 == start && x2 == end) height = Math.max(height, h);
                else if (x1 == start) {
                    left = new Segment(x1, x2, Math.max(height, h));
                    right = new Segment(mid = x2, end, height);
                } else if (x2 == end) {
                    left = new Segment(start, x1, height);
                    right = new Segment(mid = x1, x2, Math.max(height, h));
                } else {
                    left = new Segment(start, x1, height);
                    right = new Segment(mid = x1, end, height);
                    right.add(x1, x2, h);
                }
            }
        }
    }
}
