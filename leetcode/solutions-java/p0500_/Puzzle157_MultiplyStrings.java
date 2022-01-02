package p0500_;

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * @author half-dead
 */
public class Puzzle157_MultiplyStrings {

    public static void main(String[] args) {
        Puzzle157_MultiplyStrings p = new Puzzle157_MultiplyStrings();
        Solution solution = p.new Solution();
        String result = solution.multiply("9237469238749782949", "2837459872934");
        System.out.println(result);
    }

    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }

            int len1 = num1.length();
            int len2 = num2.length();

            int maxLen = 0;
            List<StringBuilder> list = new ArrayList<>();
            for (int i = len1 - 1; i >= 0; i--) {
                int n = num1.charAt(i) - '0';

                StringBuilder builder = new StringBuilder();
                int zeros = len1 - i - 1;
                while (zeros-- > 0) {
                    builder.append("0");
                }
                int extra = 0;
                for (int j = len2 - 1; j >= 0; j--) {
                    int m = num2.charAt(j) - '0';
                    int mul = n * m + extra;
                    builder.insert(0, (mul % 10));
                    extra = mul / 10;
                }
                if (extra > 0) {
                    builder.insert(0, extra);
                }
                if (builder.length() > maxLen) {
                    maxLen = builder.length();
                }
                list.add(builder);
            }

            for (StringBuilder sb : list) {
                while (sb.length() < maxLen) {
                    sb.insert(0, "0");
                }
            }

            StringBuilder result = new StringBuilder(maxLen + 1);
            int extra = 0;
            for (int i = maxLen; i > 0; i--) {
                int sum = 0;
                for (StringBuilder sb : list) {
                    if (sb.length() >= maxLen) {
                        sum += sb.charAt(i - 1) - '0';
                    }
                }
                sum += extra;
                extra = sum / 10;
                sum = sum % 10;
                result.insert(0, sum);
            }
            if (extra > 0) {
                result.insert(0, extra);
            }

            return result.toString();
        }
    }

    class CopyFastSolution {
        public String multiply(String num1, String num2) {
            char[] n1 = num1.toCharArray();
            char[] n2 = num2.toCharArray();

            int len1 = num1.length();
            int len2 = num2.length();

            int[] arr = new int[len1 + len2];
            for (int i = len1 - 1; i >= 0; i--) {
                int n = n1[i] - '0';
                for (int j = len2 - 1; j >= 0; j--) {
                    int m = n2[j] - '0';
                    arr[i + j + 1] += n * m;
                }
            }

            for (int index = arr.length - 1; index > 0; index--) {
                arr[index - 1] = arr[index - 1] + arr[index] / 10;
                arr[index] = arr[index] % 10;
            }

            StringBuilder builder = new StringBuilder(arr.length);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0 || builder.length() > 0) {
                    builder.append(arr[i]);
                }
            }
            return builder.length() > 0 ? builder.toString() : "0";
        }
    }


    class FastSolution {
        public String multiply(String num1, String num2) {
            char[] n1 = num1.toCharArray();
            char[] n2 = num2.toCharArray();
            int m = n1.length, n = n2.length;
            int[] dp = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                int x1 = n1[i] - '0';
                for (int j = n - 1; j >= 0; j--) {
                    int x2 = n2[j] - '0';
                    int cur = x1 * x2;
                    dp[i + j + 1] += cur;
                    dp[i + j] += dp[i + j + 1] / 10;
                    dp[i + j + 1] %= 10;
                }
            }
            StringBuilder str = new StringBuilder();

            for (int i = 0; i < dp.length; i++) {
                if (dp[i] != 0 || str.length() != 0) str.append(dp[i]);
            }

            return (str.length() == 0) ? "0" : str.toString();
        }
    }
}
