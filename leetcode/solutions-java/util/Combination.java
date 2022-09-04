package util;

/**
 * @author half-dead
 */
class Combination {
    long[] factorial;
    long[] inverseFactorial;
    long MOD;

    // O(maxSize) for preprocessing
    // MOD must be prime
    public Combination(int maxSize, long MOD) {
        factorial = new long[maxSize + 1];
        inverseFactorial = new long[maxSize + 1];
        factorial[0] = 1;
        inverseFactorial[0] = 1;
        this.MOD = MOD;
        for (int i = 1; i <= maxSize; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
            inverseFactorial[i] = inverse(factorial[i]);
        }
    }

    // x, y are long[1]
    // ax + by = gcd(a, b)
    private long extGcd(long a, long b, long[] x, long[] y) {
        if (b == 0) {
            x[0] = 1;
            y[0] = 0;
            return a;
        } else {
            long r = extGcd(b, a % b, y, x);
            y[0] -= x[0] * (a / b);
            return r;
        }
    }

    // (a * x) % MOD = 1
    // x is the inverse element
    public long inverse(long a) {
        long[] x = new long[1], y = new long[1];
        extGcd(a, MOD, x, y);
        return (x[0] % MOD + MOD) % MOD;
    }

    // m >= n
    // O(1)
    public long P(int m, int n) {
        if (m == 0 || n == 0) return 1;
        else if (m == n) return factorial[m];
            //return factorial[m] * inverse(factorial[m - n]) % MOD;
        else return factorial[m] * inverseFactorial[m - n] % MOD;
    }

    // m >= n
    // O(1)
    public long C(int m, int n) {
        if (m == 0 || n == 0 || m == n) return 1;
            //return factorial[m] * inverse(factorial[m - n]) % MOD * inverse(factorial[n]) % MOD;
        else return factorial[m] * inverseFactorial[m - n] % MOD * inverseFactorial[n] % MOD;
    }
}
