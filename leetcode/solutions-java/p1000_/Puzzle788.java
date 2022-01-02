package p1000_;

/**
 * https://leetcode.com/problems/rotated-digits/
 *
 * @author half-dead
 */
public class Puzzle788 {
    public static void main(String[] args) {
        Solution s = new Puzzle788().new Solution();
        for (int i = 1; i <= 99; i++) {
            System.out.println("i=" + i + ", res=" + s.rotatedDigits(i));
        }
    }

    class Solution {
        public int rotatedDigits(int n) {
            String s = n + "";
            int res = 0, digits = s.length();
            boolean has2569 = false;
            for (char c : s.toCharArray()) {

                int p = c - '0' + (digits == 1 ? 1 : 0);
                if (c > '7' || (digits == 1 && c == '7')) p--;
                if (c > '4' || (digits == 1 && c == '4')) p--;
                if (c > '3' || (digits == 1 && c == '3')) p--;
                res += p * Math.pow(7, digits - 1);

                int exclude = 0;
                if (c > '0' || (digits == 1 && c == '0')) exclude++;
                if (c > '1' || (digits == 1 && c == '1')) exclude++;
                if (c > '8' || (digits == 1 && c == '8')) exclude++;
                if (!has2569) res -= exclude * Math.pow(3, digits - 1);

                if (c == '7' || c == '4' || c == '3') break;
                if (c == '2' || c == '5' || c == '6' || c == '9') has2569 = true;

                digits--;
            }
            return res;
        }
    }
}
