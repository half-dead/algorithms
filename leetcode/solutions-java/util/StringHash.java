package util;

/**
 * @author half-dead
 */ // NOTE: Faster than StableStringHash, but has only one SEED, not stable
// This class cannot pass Leetcode 1923
class StringHash {
    long[] h;
    long[] pow;
    static final long SEED = 31L;

    public StringHash(String s) {
        int n = s.length();
        h = new long[n + 1];
        pow = new long[n + 1];
        pow[0] = 1;
        for (int i = 1; i <= n; i++) pow[i] = (pow[i - 1] * SEED);
        //h[i] = hash[s[0...i - 1]]
        h[0] = 0;
        for (int i = 1; i <= n; i++) {
            h[i] = (h[i - 1] * SEED + s.charAt(i - 1));
        }
    }

    // hash[s[l....r]]
    public long hash(int l, int r) {
        return (h[r + 1] - h[l] * pow[r - l + 1]);
    }

    public static long hashCode(String s) {
        long h = 0;
        for (int i = 0; i < s.length(); i++) {
            h = h * SEED + s.charAt(i);
        }
        return h;
    }

    public static long hashCode(char[] s) {
        long h = 0;
        for (int i = 0; i < s.length; i++) {
            h = h * SEED + s[i];
        }
        return h;
    }
}
