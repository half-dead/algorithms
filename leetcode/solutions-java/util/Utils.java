package util;

import java.util.*;

public class Utils {
    // nums = "aaabaaaba" odd d[1] return [1, 2, 1, 4, 1, 2, 2]
    // d[0] for even, d[1] for odd
    public static int[][] manacher(String s) {
        int n = s.length();
        int[] d1 = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; ++i) {
            int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);
            while (0 <= i - k && i + k < n && s.charAt(i - k) == s.charAt(i + k)) k++;
            d1[i] = k;
            if (i + k - 1 > r) {
                l = i - k + 1;
                r = i + k - 1;
            }
        }

        int[] d0 = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = (i > r) ? 0 : Math.min(d0[l + r - i + 1], r - i + 1);
            while (0 <= i - k - 1 && i + k < n && s.charAt(i - k - 1) == s.charAt(i + k)) {
                k++;
            }
            d0[i] = k;
            if (i + k - 1 > r) {
                l = i - k;
                r = i + k - 1;
            }
        }
        return new int[][]{d0, d1};
    }

    // generate primes that is <= n
    public static int[] genPrimes(int n) {
        if (n <= 1) return new int[0];
        boolean[] isComp = new boolean[n + 1];
        int len = 0;
        for (int i = 2; i <= n; i++) {
            if (!isComp[i]) {
                len++;
                for (int j = i + i; j <= n; j += i) {
                    isComp[j] = true;
                }
            }
        }
        int[] ans = new int[len];
        for (int i = 2, j = 0; i <= n; i++) {
            if (!isComp[i]) {
                ans[j++] = i;
            }
        }
        return ans;
    }

    public static int lowerBound(int[] a, int target, int n) {
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int upperBound(int[] a, int target, int n) {
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static <T extends Comparable<T>> int lowerBound(T[] a, T target, int n) {
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static <T extends Comparable<T>> int upperBound(T[] a, T target, int n) {
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid].compareTo(target) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static <T extends Comparable<T>> int lowerBound(List<T> a, T target) {
        int low = 0;
        int high = a.size();
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (a.get(mid).compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static <T extends Comparable<T>> int upperBound(List<T> a, T target) {
        int low = 0;
        int high = a.size();
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (a.get(mid).compareTo(target) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static long or(int x, int y) {
        return ((long) x << 32) | ((long) y << 32 >>> 32);
    }

    // k = 0...nums.length - 1
    // After calling this function, nums[k] is the k-th number.
    public static int kthNumber(int[] nums, int k) {
        return kthNumberHelper(nums, k, 0, nums.length - 1);
    }

    // end is inclusive (0 to nums.length - 1)
    private static int kthNumberHelper(int[] nums, int K, int start, int end) {
        if (start == end) return nums[start];
        int i = partition(nums, start, end);
        return K <= i ? kthNumberHelper(nums, K, start, i) : kthNumberHelper(nums, K, i + 1, end);
    }

    // end is inclusive (0 to nums.length - 1)
    public static int partition(int[] nums, int start, int end) {
        int pos = start + ((end - start) >> 1);
        int pivot = nums[pos];

        int i = start, j = end;
        nums[pos] = nums[end];
        while (i < j) {
            while (i < j && nums[i] < pivot) i++;
            if (i < j) nums[j--] = nums[i];

            while (i < j && pivot < nums[j]) j--;
            if (i < j) nums[i++] = nums[j];
        }

        // pos is the final position for pivot.
        nums[i] = pivot;
        return i;
    }

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // partition nums into 3 parts [smaller than pivot, equal to pivot, larger than pivot]
    public static void partition3(int[] nums, int pivot) {
        int n = nums.length;
        int l = 0, r = n - 1;
        for (int i = 0; i <= r; i++) {
            if (nums[i] < pivot) {
                swap(nums, l++, i);
            } else if (nums[i] > pivot) {
                swap(nums, r--, i--);
            }
        }
    }

    // end is inclusive
    public static void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    // Return false if next permutation is not available. (nums is not changed for this case)
    public static boolean nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) return false;
        int i = n - 1;
        while (i - 1 >= 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        if (i <= 0) return false;
        for (int j = n - 1; j >= i; j--) {
            if (nums[j] > nums[i - 1]) {
                int t = nums[j];
                nums[j] = nums[i - 1];
                nums[i - 1] = t;

                reverse(nums, i, n - 1);
                break;
            }
        }
        return true;
    }

    // Return false if previous permutation is not available. (nums is not changed for this case)
    public static boolean prevPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) return false;
        int i = n - 1;
        while (i - 1 >= 0 && nums[i - 1] <= nums[i]) {
            i--;
        }
        if (i <= 0) return false;
        for (int j = n - 1; j >= i; j--) {
            if (nums[j] < nums[i - 1]) {
                int t = nums[j];
                nums[j] = nums[i - 1];
                nums[i - 1] = t;

                reverse(nums, i, n - 1);
                break;
            }
        }
        return true;
    }

    // This function is deprecated, please hash(int l, int r) in class StableStringHash or StringHash
    // rolling hash of substrings of 's' with length == k
    // long[pos] = hash(s.substring(pos, pos + k))
    public static long[] rollingHash(String s, int k) {
        long[] ans = new long[s.length() - k + 1];
        int seed1 = 31;
        int seed2 = 131;
        int h1 = 0, h2 = 0, power1 = 1, power2 = 1;
        for (int i = 0; i < k; i++) {
            h1 = h1 * seed1 + s.charAt(i);
            h2 = h2 * seed2 + s.charAt(i);

            power1 *= seed1;
            power2 *= seed2;
        }

        ans[0] = ((long) h1 << 32) | ((long) h2 << 32 >>> 32);
        for (int i = k; i < s.length(); i++) {
            h1 = h1 * seed1 + s.charAt(i) - power1 * s.charAt(i - k);
            h2 = h2 * seed2 + s.charAt(i) - power2 * s.charAt(i - k);
            ans[i - k + 1] = ((long) h1 << 32) | ((long) h2 << 32 >>> 32);
        }

        return ans;
    }

    public static long stringHash(String s) {
        int h1 = 0;
        int h2 = 0;
        int seed1 = 31;
        int seed2 = 131;

        for (int i = 0; i < s.length(); i++) {
            h1 = h1 * seed1 + s.charAt(i);
            h2 = h2 * seed2 + s.charAt(i);
        }
        return ((long) h1 << 32) | ((long) h2 << 32 >>> 32);
    }

    public static int[] kmpNext(String s) {
        int n = s.length();
        int[] next = new int[n];
        next[0] = 0;
        for (int i = 1; i < n; i++) {
            int k = next[i - 1];
            while (k > 0 && s.charAt(i) != s.charAt(k)) k = next[k - 1];
            if (s.charAt(i) == s.charAt(k)) {
                next[i] = k + 1;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }

    // s is the original String
    // p is the pattern String
    public static boolean kmpMatch(String s, String p) {
        int[] next = kmpNext(p);
        int n = s.length();
        int m = p.length();
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && p.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (p.charAt(j) == s.charAt(i)) j++;
            if (j == m) return true;
        }
        return false;
    }

    // a, b could be negative
    // remainder >= 0
    // return [a / b, a % b]
    public static int[] divMod(int a, int b) {
        int r = a % b;
        int c = a / b;
        if (r < 0) {
            r += Math.abs(b);
            c++;
        }
        return new int[]{c, r};
    }

    public static List<Integer> negativeBase(int n, int base) {
        List<Integer> digits = new ArrayList<>();
        if (n == 0) {
            digits.add(0);
            return digits;
        }
        while (n != 0) {
            // t[0] = n / base
            // t[1] = n % base;
            int[] t = divMod(n, base);
            digits.add(t[1]);
            n = t[0];
        }
        Collections.reverse(digits);
        return digits;
    }

    // (a ^ b) % MOD
    public static long powMod(long a, long b, long MOD) {
        long res = 1L;
        a %= MOD; // In case a * a is overflow
        while (b > 0) {
            if ((b & 1) != 0) res = (res * a) % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    // Tested by leetcode 1163
    public static int[] suffixSort(int[] s) {
        int n = s.length;
        int[] count = new int[n], t;
        int[] SA = new int[n], nSA = new int[n];
        int[] rank = new int[n], nRank = new int[n];

        Integer[] tempArray = new Integer[n];
        for (int x = 0; x < n; x++) tempArray[x] = x;
        Arrays.sort(tempArray, (a, b) -> Integer.compare(s[a], s[b]));
        for (int x = 0; x < n; x++) SA[x] = tempArray[x];

        int i, k;
        for (rank[SA[0]] = 0, i = 1; i < n; i++) {
            rank[SA[i]] = (s[SA[i]] != s[SA[i - 1]]) ? rank[SA[i - 1]] + 1 : rank[SA[i - 1]];
        }
        for (k = 1; k < n && rank[SA[n - 1]] < n - 1; k <<= 1) {
            for (i = 0; i < n; i++) count[rank[SA[i]]] = i + 1;
            for (i = n - 1; i >= 0; i--) if (SA[i] >= k) nSA[--count[rank[SA[i] - k]]] = SA[i] - k;
            for (i = n - k; i < n; i++) nSA[--count[rank[i]]] = i;
            t = SA;
            SA = nSA;
            nSA = t;
            for (nRank[SA[0]] = 0, i = 1; i < n; i++) {
                nRank[SA[i]] = (SA[i] + k >= n || SA[i - 1] + k >= n || rank[SA[i]] != rank[SA[i - 1]] || rank[SA[i] + k] != rank[SA[i - 1] + k]) ? nRank[SA[i - 1]] + 1 : nRank[SA[i - 1]];
            }
            t = rank;
            rank = nRank;
            nRank = t;
        }
        return SA;
    }

    public static int min(int... values) {
        int ret = values[0];
        for (int v : values) ret = Math.min(ret, v);
        return ret;
    }

    public static int max(int... values) {
        int ret = values[0];
        for (int v : values) ret = Math.max(ret, v);
        return ret;
    }

    public static void preprocessCombination(long[][] C, long MOD) {
        int m = C.length;
        int n = C[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i && j < n; j++) {
                if (j == 0 || i == j) C[i][j] = 1;
                else C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }
    }

    public static void preprocessCombination(long[][] C) {
        int m = C.length;
        int n = C[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i && j < n; j++) {
                if (j == 0 || i == j) C[i][j] = 1;
                else C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]);
            }
        }
    }

    public static void preprocessPermutation(long[][] P, long MOD) {
        int m = P.length;
        int n = P[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i && j < n; j++) {
                if (i == 0 || j == 0) P[i][j] = 1;
                else P[i][j] = P[i][j - 1] * (i - j + 1) % MOD;
            }
        }
    }

    public static long gcd(long x, long y) {
        return x != 0 ? gcd(y % x, x) : y;
    }
}

// Tested by Leetcode 732
// DynamicSegmentTree
// Lazy execution example is in https://leetcode.com/submissions/detail/435779875/


