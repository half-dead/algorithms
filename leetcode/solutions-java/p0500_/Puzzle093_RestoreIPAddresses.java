package p0500_;

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle093_RestoreIPAddresses {

    public static void main(String[] args) {
        Puzzle093_RestoreIPAddresses p = new Puzzle093_RestoreIPAddresses();
        Solution solution = p.new Solution();
        List<String> strings = solution.restoreIpAddresses("010010");
        System.out.println(strings);
    }

    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> allFormulas = generateFormula(s.length(), 4);
            if (allFormulas == null || allFormulas.isEmpty()) {
                return new ArrayList<>();
            }
            List<String> allIps = new ArrayList<>();
            allFormulas.forEach(f -> {
                char[] chars = f.toCharArray();
                int firstSegmentDigits = Integer.valueOf(chars[0] + "");
                StringBuilder ipBuilder = new StringBuilder();
                ipBuilder.append(s.substring(0, firstSegmentDigits));
                int cursor = firstSegmentDigits;
                for (int i = 1; i < chars.length; i++) {
                    int digits = Integer.valueOf(chars[i] + "");
                    ipBuilder.append(".").append(s.substring(cursor, cursor + digits));
                    cursor += digits;
                }
                String ip = ipBuilder.toString();
                if (isValidIp(ip)) {
                    allIps.add(ip);
                }
            });
            return allIps;
        }

        public boolean isValidIp(String ip) {
            int start = 0, end = 0, i = 0;
            String[] segments = new String[4];
            while ((end = ip.indexOf(".", start)) != -1) {
                segments[i++] = ip.substring(start, end);
                start = end + 1;
            }
            segments[i++] = ip.substring(start);
            for (String segment : segments) {
                if (segment.charAt(0) == '0' && segment.length() > 1) {
                    return false;
                }
                if (Integer.valueOf(segment) > 255) {
                    return false;
                }
            }
            return true;
        }

        public List<String> generateFormula(int remainingDigits, int remainingNums) {
            List<String> list = new ArrayList<>();
            if (remainingNums > 1) {
                remainingNums--;
                for (int i = 1; i <= 3; i++) {
                    final int fi = i;
                    generateFormula(remainingDigits - fi, remainingNums).forEach(s -> list.add("" + fi + s));
                }
            } else {
                if (remainingDigits >= 1 && remainingDigits <= 3) {
                    list.add("" + remainingDigits);
                }
            }
            return list;
        }
    }
}
