package util;

/**
 * @author half-dead
 */
class StableIntegerArrayHash {
    static class SingleIntegerArrayHash {
        long[] h;
        long[] pow;
        final long SEED;
        final long MOD;

        public SingleIntegerArrayHash(int[] s, long SEED, long MOD) { // example: SEED = 131L;
            this.SEED = SEED;
            this.MOD = MOD;
            int n = s.length;
            h = new long[n + 1];
            pow = new long[n + 1];
            pow[0] = 1;
            for (int i = 1; i <= n; i++) pow[i] = (pow[i - 1] * SEED) % MOD;
            //h[i] = hash[s[0...i - 1]]
            h[0] = 0;
            for (int i = 1; i <= n; i++) {
                h[i] = (h[i - 1] * SEED + s[i - 1]) % MOD;
            }
        }

        // hash[s[l....r]]
        public long hash(int l, int r) {
            return ((h[r + 1] - h[l] * pow[r - l + 1]) % MOD + MOD) % MOD;
        }
    }

    private SingleIntegerArrayHash hash1, hash2;
    static final long SEED1 = 31L, SEED2 = 131L;
    static final long MOD = 1_000_000_007L; // or 1_000_000_123L

    public StableIntegerArrayHash(int[] s) {
        hash1 = new SingleIntegerArrayHash(s, SEED1, MOD);
        hash2 = new SingleIntegerArrayHash(s, SEED2, MOD);
    }

    public long hash(int l, int r) {
        return (hash1.hash(l, r) << 32) | (hash2.hash(l, r) << 32 >>> 32);
    }

    public static long hashCode(int[] s) {
        long h1 = 0, h2 = 0;
        for (int i = 0; i < s.length; i++) {
            h1 = (h1 * SEED1 + s[i]) % MOD;
            h2 = (h2 * SEED2 + s[i]) % MOD;
        }
        return (h1 << 32) | (h2 << 32 >>> 32);
    }
}
