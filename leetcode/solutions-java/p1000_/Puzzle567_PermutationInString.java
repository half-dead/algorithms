package p1000_;

/**
 * https://leetcode.com/problems/permutation-in-string/
 *
 * @author half-dead
 */
public class Puzzle567_PermutationInString {
    public static void main(String[] args) {
        Puzzle567_PermutationInString p = new Puzzle567_PermutationInString();
        Solution s = p.new Solution();
        boolean b = s.checkInclusion("adc", "dcda");
        System.out.println(b);
    }


    public class Solution0 {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            if (len1 > len2) {
                return false;
            }
            int[] count = new int[26];
            for (int i = 0; i < len1; i++) {
                count[s1.charAt(i) - 'a']++;
                count[s2.charAt(i) - 'a']--;
            }
            if (allZero(count)) {
                return true;
            }

            for (int i = len1; i < len2; i++) {
                count[s2.charAt(i) - 'a']--;
                count[s2.charAt(i - len1) - 'a']++;
                if (allZero(count)) {
                    return true;
                }
            }
            return false;
        }

        private boolean allZero(int[] count) {
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            if (len1 > len2) {
                return false;
            }
            int[] arr1 = new int[26], arr2 = new int[26];
            for (int i = 0; i < len1; i++) {
                arr1[s1.charAt(i) - 'a']++;
                arr2[s2.charAt(i) - 'a']++;
            }
            int i = 0;
            do {
                int diff = diff(arr1, arr2);
                if (diff == 0) {
                    return true;
                }
                if (i + diff <= len2 - len1) {
                    for (int j = 0; j < diff; j++) {
                        arr2[s2.charAt(i + j) - 'a']--;
                        arr2[s2.charAt(i + j + len1) - 'a']++;
                    }
                }
                i += diff;
            } while (i < len2);
            return false;
        }

        private int diff(int[] a, int[] b) {
            int diff = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    diff += Math.abs(a[i] - b[i]);
                }
            }
            return diff >>> 1;
        }
    }

}
