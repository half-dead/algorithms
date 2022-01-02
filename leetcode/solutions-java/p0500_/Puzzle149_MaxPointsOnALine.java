package p0500_;

import java.math.BigInteger;
import java.util.*;

/**
 * https://leetcode.com/problems/max-points-on-a-line/
 *
 * @author half-dead
 */
public class Puzzle149_MaxPointsOnALine {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE-Integer.MIN_VALUE);
        Solution s = new Puzzle149_MaxPointsOnALine().new Solution();
        System.out.println(s.maxPoints(new int[][]{{1, 1}, {2, 2}, {1, 2}, {2, 1}}));
    }

    class Solution1 {
        public int maxPoints(int[][] points) {
            if (points.length == 1) return 1;
            Map<BigInteger, Set<BigInteger>> map = new HashMap<>();
            for (int i = 0, len = points.length; i < len; i++) {
                int[] px = points[i];
                for (int j = i + 1; j < len; j++) {
                    int[] py = points[j];
                    BigInteger k = getK(px, py);
                    Set<BigInteger> set = map.computeIfAbsent(k, key -> new HashSet<>());
                    set.add(new BigInteger(i + "").shiftLeft(64).or(new BigInteger(String.valueOf(((long) px[0] << 32) | px[1]))));
                    set.add(new BigInteger(j + "").shiftLeft(64).or(new BigInteger(String.valueOf(((long) py[0] << 32) | py[1]))));
                }
            }
            int max = 0;
            for (Set<BigInteger> set : map.values()) max = Math.max(max, set.size());
            return max;
        }

        private BigInteger getK(int[] x, int[] y) {
            long dx = (long) x[0] - y[0], dy = (long) x[1] - y[1];
            boolean positive = (dx >= 0 && dy >= 0) || (dx <= 0 && dy <= 0);
            dx = Math.abs(dx);
            dy = Math.abs(dy);
            if (dx != 0 && dy != 0) {
                long gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
            }
            if (!positive) dx = -dx;
            return new BigInteger(String.valueOf(dx)).shiftLeft(64).or(new BigInteger(String.valueOf(dy)));
        }

        private long gcd(long a, long b) {
            long mod = a % b;
            return mod == 0 ? b : gcd(b, mod);
        }
    }

    class Solution {
        public int maxPoints(int[][] points) {
            int n = points.length;
            if (n < 3) return n;

            Arrays.sort(points, (a, b) -> (Math.abs(a[0] - a[1]) - Math.abs(b[0] - b[1])));
            int max = 0;
            for (int i = 1; i < n; i++) {
                long x = points[i][0], y = points[i][1];
                long dx = x - points[i - 1][0], dy = y - points[i - 1][1];

                int count = 0;
                if (dx == 0 && dy == 0) {
                    for (int[] p : points) {
                        if (p[0] != x || p[1] != y)
                            break;
                        count++;
                    }
                } else {
                    for (int[] p : points) {
                        if ((p[0] - x) * dy != (p[1] - y) * dx)
                            continue;
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
            return max;
        }
    }
}
