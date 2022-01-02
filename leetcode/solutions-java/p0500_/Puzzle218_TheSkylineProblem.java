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
        Solution2 s2 = new Puzzle218_TheSkylineProblem().new Solution2();
//        Print.pt(s2.getSkyline(new int[][]{{0, 2, 3}, {2, 5, 3}}));
//        Print.pt(s1.getSkyline(new int[][]{{0, 2, 3}, {2, 5, 3}}));
//        Print.pt(s2.getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}));
//        Print.pt(s1.getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}));
//        Print.pt(s2.getSkyline(new int[][]{{0, 2147483647, 2147483647}}));
//        Print.pt(s1.getSkyline(new int[][]{{0, 2147483647, 2147483647}}));
//        Print.pt(s2.getSkyline(new int[][]{{2, 9, 10}, {9, 12, 15}}));
//        Print.pt(s1.getSkyline(new int[][]{{2, 9, 10}, {9, 12, 15}}));
//        Print.pt(s2.getSkyline(new int[][]{{1, 2, 1}, {1, 2, 2}, {1, 2, 3}}));
//        Print.pt(s1.getSkyline(new int[][]{{1, 2, 1}, {1, 2, 2}, {1, 2, 3}}));
//        Print.pt(s2.getSkyline(new int[][]{{0, 3, 3}, {1, 5, 3}, {2, 4, 3}, {3, 7, 3}}));
//        Print.pt(s1.getSkyline(new int[][]{{0, 3, 3}, {1, 5, 3}, {2, 4, 3}, {3, 7, 3}}));
        Print.pt(s2.getSkyline(new int[][]{{0, 5, 7}, {5, 10, 7}, {5, 10, 12}, {10, 15, 7}, {15, 20, 7}, {15, 20, 12}, {20, 25, 7}}));
        Print.pt(s1.getSkyline(new int[][]{{0, 5, 7}, {5, 10, 7}, {5, 10, 12}, {10, 15, 7}, {15, 20, 7}, {15, 20, 12}, {20, 25, 7}}));
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

    class MySolution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            LinkedList<Pair> startQ = new LinkedList<>();

            PriorityQueue<Pair> endQ = new PriorityQueue<>((p1, p2) -> p1.x == p2.x ? p1.h - p2.h : p1.x - p2.x);
            for (int i = 0; i < buildings.length; i++) {
                Pair curStart = new Pair(buildings[i][0], buildings[i][2], true), curEnd = new Pair(buildings[i][1], buildings[i][2], false);

                if (!endQ.isEmpty()) {
                    popQ(startQ, endQ, curStart);
                }
                while (!startQ.isEmpty() && (startQ.peekLast().x == curStart.x || startQ.peekLast().h == curStart.h))
                    startQ.removeLast();
                startQ.addLast(curStart);
                endQ.add(curEnd);
            }
            popQ(startQ, endQ, null);
            List<List<Integer>> result = new ArrayList<>();
            for (Pair pair : startQ) {
                result.add(Arrays.asList(pair.x, pair.h));
            }
            return result;
        }

        void popQ(LinkedList<Pair> startQ, PriorityQueue<Pair> endQ, Pair edge) {
            while (!endQ.isEmpty() && (edge == null || endQ.peek().x <= edge.x)) {
                Pair end = endQ.poll(), last = startQ.peekLast();
                while (!startQ.isEmpty() && (last = startQ.peekLast()).isLeft && last.h < end.h) {
                    startQ.removeLast();
                }
                if (startQ.isEmpty()) {
                    System.out.println("kljs");
                }
                startQ.peekLast().h = end.h;
                startQ.addLast(new Pair(end.x, 0, true));
            }
        }

        class Pair {
            int x, h;
            boolean isLeft;

            public Pair(int x, int h, boolean isLeft) {
                this.x = x;
                this.h = h;
                this.isLeft = isLeft;
            }

            @Override
            public String toString() {
                return "(" + x + ", " + h + ')';
            }
        }
    }

    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> res = new ArrayList<>();
            // 按照高度降序，同高度根据起点升序
            PriorityQueue<int[]> heightHeap = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : b[2] - a[2]);

            // 默认起点，PRE保存前面能看见的最高建筑和他的终点起点
            int[] pre = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
            for (int[] b : buildings) {
                // 当出现断点情况，需要清空之前建筑群
                while (!heightHeap.isEmpty() && b[0] > pre[1]) {
                    // 获取之前最高建筑
                    int[] curHighest = heightHeap.poll();
                    // 如果最高的终点在PRE之前，说明已经处理
                    if (curHighest[1] <= pre[1]) continue;
                    // 如果遇到PRE之后的点，加入结果并更新PRE
                    res.add(Arrays.asList(pre[1], curHighest[2]));
                    pre = curHighest;
                }

                // 当前建筑比之前建筑高
                if (b[2] > pre[2]) {
                    if (b[0] == pre[0]) {
                        // 同起点情况下，矮建筑必然被挡住，直接删除
                        res.remove(res.size() - 1);
                    }
                    // 未被之后遮挡前先加入结果
                    res.add(Arrays.asList(b[0], b[2]));
                    if (b[1] < pre[1]) {// 如果终点小于前终点，将前值入堆
                        heightHeap.offer(pre);
                    }
                    pre = b;// 更新前值因为发现了更高的
                } else if (b[2] == pre[2]) {
                    // 同高度继续延伸END
                    pre[1] = b[1];
                } else if (b[1] > pre[1]) {
                    // 矮建筑直接入堆
                    heightHeap.offer(b);
                }
            }

            while (!heightHeap.isEmpty()) {
                // 如果堆不为空，重复之前操作
                int[] cur = heightHeap.poll();
                if (cur[1] <= pre[1]) continue;
                res.add(Arrays.asList(pre[1], cur[2]));
                pre = cur;
            }
            // 最后有剩余
            if (pre[2] > 0) {
                res.add(Arrays.asList(pre[1], 0));
            }
            return res;
        }
    }

    // Segment tree solution, 474ms
    class Solution2 {
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
