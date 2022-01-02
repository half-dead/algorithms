package p0500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 *
 * @author half-dead
 */
public class Puzzle273_IntegerToEnglishWords {
    public static void main(String[] args) {
        Puzzle273_IntegerToEnglishWords p = new Puzzle273_IntegerToEnglishWords();
        Solution s = p.new Solution();
        System.out.println(s.numberToWords(123));
        System.out.println(s.numberToWords(12345));
        System.out.println(s.numberToWords(1234567));
        System.out.println(s.numberToWords(1234567891));
    }

    class Solution {
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        {
            map.put(0, "");
            map.put(1, "One");
            map.put(2, "Two");
            map.put(3, "Three");
            map.put(4, "Four");
            map.put(5, "Five");
            map.put(6, "Six");
            map.put(7, "Seven");
            map.put(8, "Eight");
            map.put(9, "Nine");
            map.put(10, "Ten");
            map.put(11, "Eleven");
            map.put(12, "Twelve");
            map.put(13, "Thirteen");
            map.put(14, "Fourteen");
            map.put(15, "Fifteen");
            map.put(16, "Sixteen");
            map.put(17, "Seventeen");
            map.put(18, "Eighteen");
            map.put(19, "Nineteen");
            map.put(20, "Twenty");
            map.put(30, "Thirty");
            map.put(40, "Forty");
            map.put(50, "Fifty");
            map.put(60, "Sixty");
            map.put(70, "Seventy");
            map.put(80, "Eighty");
            map.put(90, "Ninety");
            map2.put(1, "");
            map2.put(2, "Thousand");
            map2.put(3, "Million");
            map2.put(4, "Billion");
        }

        public String numberToWords(int num) {
            if (num == 0) return "Zero";
            StringBuilder builder = new StringBuilder();
            int count = 0;
            while (num > 0) {
                count++;
                int mod = num % 1000;
                if (mod == 0) {
                    num /= 1000;
                    continue;
                }
                StringBuilder sub = new StringBuilder();
                int hundred = mod / 100;
                if (hundred > 0) sub.append(map.get(hundred)).append(' ').append("Hundred").append(' ');
                int d2 = mod % 100;
                if (map.containsKey(d2)) {
                    sub.append(map.get(d2)).append(' ');
                } else {
                    sub.append(map.get(d2 / 10 * 10)).append(' ').append(map.get(d2 % 10)).append(' ');
                }
                sub.append(map2.get(count)).append(' ');
                builder.insert(0, sub.toString());
                num /= 1000;
            }
            return builder.toString().trim().replaceAll("[ ]+", " ");
        }
    }
}
