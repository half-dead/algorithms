package util;

/**
 * @author half-dead
 */
class PrimeNumbers {
    int[] primes;
    int[][][] primeFactors;

    // generate primes <= n
    public PrimeNumbers(int n) {
        boolean[] isComp = new boolean[n + 1];
        int[] primeFactorCount = new int[n + 1];
        int primeCount = 0;
        for (int p = 2; p <= n; p++) {
            if (isComp[p]) continue;
            primeCount++;
            primeFactorCount[p] = 1;
            for (int j = p + p; j <= n; j += p) {
                isComp[j] = true;
                primeFactorCount[j]++;
            }

        }
        this.primeFactors = new int[n + 1][][];
        this.primes = new int[primeCount];
        primeCount = 0;
        for (int i = 0; i <= n; i++) {
            primeFactors[i] = new int[primeFactorCount[i]][2];
            primeFactorCount[i] = 0;
        }
        for (int p = 2; p <= n; p++) {
            if (isComp[p]) continue;
            primes[primeCount++] = p;
            primeFactors[p][0][0] = p;
            primeFactors[p][0][1] = 1;
            for (int j = p + p; j <= n; j += p) {
                int t = j;
                int c = 0;
                while (t % p == 0) {
                    t /= p;
                    c++;
                }
                primeFactors[j][primeFactorCount[j]][0] = p;
                primeFactors[j][primeFactorCount[j]++][1] = c;
            }
        }
    }

    public int[] getPrimes() {
        return primes;
    }

    // return array with [prime, count] pairs
    // n <= 1 returns int[0][2]
    public int[][] getPrimeFactors(int n) {
        return primeFactors[n];
    }
}
