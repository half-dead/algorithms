package p0500_;

// You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
//
// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
//
// You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

/**
 * https://leetcode.com/problems/first-bad-version/
 */
public class Puzzle278_FirstBadVersion {

    public static void main(String[] args) {
        Puzzle278_FirstBadVersion p = new Puzzle278_FirstBadVersion();
        Solution2 s = p.new Solution2();
        System.out.println(s.firstBadVersion(348956792));
    }

    public class VersionControl {
        boolean isBadVersion(int version) {
            return version >= 234672;
        }
    }

    /* The isBadVersion API is defined in the parent class VersionControl.
          boolean isBadVersion(int version); */
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            if (n == 1) {
                return n;
            }

            if (isBadVersion(n) ^ isBadVersion(n - 1)) {
                return n;
            }

            long max = n, min = 1;
            n = (int) ((max + min) / 2);
            boolean temp;
            while (!((temp = isBadVersion(n)) ^ isBadVersion(n - 1)) && n > 0) {
                if (temp) {
                    max = n - 1;
                } else {
                    min = n + 1;
                }
                n = (int) ((max + min) / 2);
            }
            return n;
        }
    }

    public class Solution2 extends VersionControl {
        public int firstBadVersion(int n) {
            int start = 1, end = n;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (isBadVersion(mid)) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return start;
        }
    }

}
