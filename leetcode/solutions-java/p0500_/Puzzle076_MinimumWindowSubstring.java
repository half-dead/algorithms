package p0500_;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * @author half-dead
 */
public class Puzzle076_MinimumWindowSubstring {
    public static void main(String[] args) {
        Puzzle076_MinimumWindowSubstring p = new Puzzle076_MinimumWindowSubstring();
        Solution s = p.new Solution();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
    }

    class Solution {
        public String minWindow(String s, String t) {
            int[] arr = new int[128];
            for (int i = 0; i < t.length(); i++) {
                arr[t.charAt(i)]++;
            }

            int counter = t.length(), left = 0, right = 0, window = Integer.MAX_VALUE, head = -1;
            while (right < s.length()) {
                char rc = s.charAt(right++);
                if (arr[rc] > 0) {
                    counter--;
                }
                arr[rc]--;

                while (counter == 0) {
                    if (right - left < window) {
                        window = right - (head = left);
                    }

                    char lc = s.charAt(left++);
                    if (arr[lc] == 0) {
                        counter++;
                    }
                    arr[lc]++;
                }
            }
            return head == -1 ? "" : s.substring(head, head + window);
        }
    }

    class Solution2 {
        public String minWindow(String s, String t) {
            if (t == null || s == null || s.length() < t.length()) return "";

            int lenS = s.length(), lenT = t.length();
            int[] arr = new int[128];
            for (int i = 0; i < lenT; i++) {
                arr[t.charAt(i)]++;
                arr[s.charAt(i)]--;
            }

            int left = 0, right = lenT;
            int window = Integer.MAX_VALUE, windowStart = -1;
            for (; right <= lenS; ) {
                int cnt = countPositive(arr);
                if (cnt == 0) {
                    int newWindow = right - left;
                    if (newWindow < window) {
                        window = newWindow;
                        windowStart = left;
                    }
                    if (window == lenT) {
                        break;
                    }
                }

                if (cnt == 0 && left + lenT <= right) {
                    arr[s.charAt(left++)]++;
                    while (left < right && t.indexOf(s.charAt(left)) == -1) {
                        arr[s.charAt(left++)]++;
                    }
                } else if (cnt > 0 && right < lenS) {
                    for (int m = 0; m < cnt && right < lenS; m++) {
                        while (right < lenS && t.indexOf(s.charAt(right)) == -1) {
                            arr[s.charAt(right++)]--;
                        }
                        if (right < lenS)
                            arr[s.charAt(right++)]--;
                    }
                } else {
                    break;
                }
            }
            return windowStart >= 0 ? s.substring(windowStart, windowStart + window) : "";
        }

        int countPositive(int[] a) {
            int cnt = 0;
            for (int n : a) {
                if (n > 0) cnt += n;
            }
            return cnt;
        }
    }
}
