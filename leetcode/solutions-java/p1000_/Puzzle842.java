package p1000_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/
 *
 * @author half-dead
 */
public class Puzzle842 {
    public static void main(String[] args) {
        Solution s = new Puzzle842().new Solution();
        System.out.println(s.splitIntoFibonacci("121474836462147483647"));
    }

    class Solution {
        public List<Integer> splitIntoFibonacci(String s) {
            List<Integer> result = new ArrayList<>();
            long a, b;
            for (int da = 1, ds = s.length(), aMax = Math.min(10, ds); da <= aMax; da++) {
                if (da > 1 && s.charAt(0) == '0') break;
                if ((a = Long.parseLong(s.substring(0, da))) > Integer.MAX_VALUE) break;

                for (int db = 1, bMax = Math.min(ds - da, 10); db <= bMax; db++) {
                    if (db > 1 && s.charAt(da) == '0') break;
                    if ((b = Long.parseLong(s.substring(da, da + db))) > Integer.MAX_VALUE) break;

                    result.add((int) a);
                    result.add((int) b);
                    if (check(s, a, b, result)) return result;
                    else result.clear();
                }
            }
            return result;
        }

        boolean check(String s, long a, long b, List<Integer> list) {
            int ds = s.length(), da = String.valueOf(a).length(), db = String.valueOf(b).length(), dc, idx = da + db;
            long c;
            while (idx < ds) {
                if ((c = a + b) > Integer.MAX_VALUE) break;

                if (idx + (dc = String.valueOf(c).length()) <= ds) {
                    if (Long.parseLong(s.substring(idx, idx + dc)) != c) break;

                    list.add((int) c);
                    a = b;
                    b = c;
                    if ((idx += dc) == ds) return true;
                } else break;
            }
            return false;
        }
    }
}
