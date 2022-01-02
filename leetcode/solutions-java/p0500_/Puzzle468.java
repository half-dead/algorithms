package p0500_;

/**
 * https://leetcode.com/problems/validate-ip-address/
 *
 * @author half-dead
 */
public class Puzzle468 {


    public static void main(String[] args) {
        Solution s = new Puzzle468().new Solution();
        System.out.println(s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }

    class Solution {
        final String NTH = "Neither";

        public String validIPAddress(String IP) {
            if (IP == null || IP.length() < 7) return NTH;
            if (IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') return NTH;
            String[] arr = IP.split("\\.");
            if (arr.length == 4) {
                for (String x : arr) {
                    if (x.length() == 0 || x.length() > 3) return NTH;
                    for (char c : x.toCharArray()) {
                        if (c < '0' || c > '9') return NTH;
                    }
                    if (Integer.parseInt(x) > 255) return NTH;
                    if (x.charAt(0) == '0' && x.length() > 1) return NTH;
                }
                return "IPv4";
            }

            if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') return NTH;
            arr = IP.split(":");
            if (arr.length == 8) {
                for (String x : arr) {
                    if (x.length() == 0 || x.length() > 4)
                        return NTH;
                    for (char c : x.toCharArray()) {
                        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')) {
                        } else {
                            return NTH;
                        }
                    }
                }
                return "IPv6";
            }
            return NTH;
        }
    }
}
