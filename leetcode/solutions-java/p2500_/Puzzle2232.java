package p2500_;

/**
 * https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression/
 */
public class Puzzle2232 {

    public static void main(String[] args) {
        Solution s = new Puzzle2232().new Solution();
        System.out.println(s.minimizeResult("247+38"));
        System.out.println(s.minimizeResult("12+34"));
        System.out.println(s.minimizeResult("999+999"));
    }

    // brute force
    class Solution {
        public String minimizeResult(String exp) {
            String[] arr = exp.split("\\+");
            char[] left = arr[0].toCharArray(), right = arr[1].toCharArray();

            long min = Long.MAX_VALUE;
            String res = "";
            for (int i = 0; i < left.length; i++) {
                String as = new String(left, 0, i), bs = new String(left, i, left.length - i);
                long a = as.length() == 0 ? 1 : Long.parseLong(as), b = Long.parseLong(bs);

                for (int j = 1; j <= right.length; j++) {
                    String cs = new String(right, 0, j), ds = new String(right, j, right.length - j);
                    long c = Long.parseLong(cs), d = ds.length() == 0 ? 1 : Long.parseLong(ds);

                    long temp = a * (b + c) * d;
                    if (temp < min) {
                        res = as + "(" + bs + "+" + cs + ")" + ds;
                        min = temp;
                    }
                }
            }
            return res;
        }
    }
}
