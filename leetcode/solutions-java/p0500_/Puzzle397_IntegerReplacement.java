package p0500_;

/**
 * @author half-dead
 */
public class Puzzle397_IntegerReplacement {
    public static void main(String[] args) {
        Puzzle397_IntegerReplacement p = new Puzzle397_IntegerReplacement();
        Solution s = p.new Solution();
        System.out.println(Integer.toBinaryString(100000000));
        System.out.println(s.integerReplacement(100000000));
    }

    class Solution {
        public int integerReplacement(int n) {
            int count = 0;
            while (n != 1) {
                if ((n & 1) == 0) {
                    n >>>= 1;
                } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                    n--;
                } else {
                    n++;
                }
                count++;
            }
            return count;
        }
    }

    class Solution2 {
        public int integerReplacement(int n) {
            char[] chars = Integer.toBinaryString(n).toCharArray();
            int count = 0, count1 = 0;
            for (int i = chars.length - 1; i > 0; ) {
                char c = chars[i];
                if (c == '1') {
                    count1++;
                    i--;
                } else {
                    if (count1 > 0) {
                        count += count1 + 1;
                    }
                    if (count1 > 1) {
                        chars[i] = '1';
                    } else {
                        i--;
                        count++;
                    }
                    count1 = 0;
                }
            }
            // special case for 3
            if (count1 == 1) {
                count += 2;
            } else if (count1 > 1) {
                count += count1 + 2;
            }
            return count;
        }
    }
}
