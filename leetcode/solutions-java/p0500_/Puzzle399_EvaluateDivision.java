package p0500_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/evaluate-division/
 *
 * @author half-dead
 */
public class Puzzle399_EvaluateDivision {

    public static void main(String[] args) {
        Puzzle399_EvaluateDivision p = new Puzzle399_EvaluateDivision();
        Solution s = p.new Solution();
        double[] res = s.calcEquation(
                new String[][]{{"a", "b"}, {"b", "c"}},
                new double[]{2.0d, 3.0d},
                new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}}
        );
        System.out.println(Arrays.toString(res));
    }

    class Solution {
        Map<String, Factor> map;

        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            map = new HashMap<>();
            for (String[] equation : equations) {
                for (String var : equation) {
                    map.put(var, new Factor(1.0d, var));
                }
            }

            for (int i = 0; i < equations.length; i++) {
                union(equations[i][0], equations[i][1], values[i]);
            }

            double[] res = new double[queries.length];
            for (int i = 0; i < res.length; i++) {
                Factor fa = find(queries[i][0]);
                Factor fb = find(queries[i][1]);
                if (fa == null || fb == null) {
                    res[i] = -1.0d;
                } else if (fa.b.equals(fb.b)) {
                    res[i] = fa.co / fb.co;
                } else {
                    res[i] = -1.0d;
                }
            }
            return res;
        }

        private void union(String a, String b, double d) {
            Factor fa = find(a), fb = find(b);
            if (!fa.b.equals(fb.b)) {
                map.put(fa.b, new Factor(d * fb.co / fa.co, fb.b));
            }
        }

        private Factor find(String a) {
            Factor f1 = map.get(a);
            if (f1 != null && !f1.b.equals(a)) {
                double d = f1.co;
                Factor f2 = find(f1.b);
                Factor factor = new Factor(d * f2.co, f2.b);
                map.put(a, factor);
                return factor;
            } else {
                return f1;
            }
        }
    }

    class Factor {
        double co;
        String b;

        public Factor(double co, String b) {
            this.co = co;
            this.b = b;
        }
    }
}
