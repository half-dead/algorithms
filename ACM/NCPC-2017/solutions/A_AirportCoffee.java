import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_AirportCoffee {

    public static long len;
    public static long v1;
    public static long v2;
    public static long c;
    public static long wait;
    public static long drink;
    public static int n;
    public static long[] carts;

    public static void main(String[] args) throws Exception {

        // Read in all the basic parameters.
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(stdin.readLine());
        len = Long.parseLong(tok.nextToken());
        v1 = Long.parseLong(tok.nextToken());
        v2 = Long.parseLong(tok.nextToken());
        wait = Long.parseLong(tok.nextToken());
        drink = Long.parseLong(tok.nextToken());

        // Adjusting length so we can avoid doubles for time. time in units 1/(v1*v2) sec.
        c = v1 * v2;
        len *= c;

        // Get cart locations - adjust by factor v1*v2.
        n = Integer.parseInt(stdin.readLine().trim());
        tok = new StringTokenizer(stdin.readLine());
        carts = new long[n + 1];
        for (int i = 0; i < n; i++)
            carts[i] = v1 * v2 * Long.parseLong(tok.nextToken());
        carts[n] = len;

        // Set up DP.
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 0;
        int[] next = new int[n + 1];
        Arrays.fill(next, -1);

        int j = n; // j is index we are building off of.

        // Fill in DP array backwards.
        for (int i = n - 1; i >= 0; i--) {

            // Where we would run out of coffee if we took coffee from this cart.
            long marker = carts[i] + c * (v1 * wait + v2 * drink);

            // Means this is our last coffee since it lasts till the end - just calculate straight.
            if (marker > len) {
                dp[i] = cost(i, n);
                continue;
            }

            // Iterate j back to our breaking point.
            while (j > i && carts[j] > marker) j--;
            if (i == j) j++;

            // Cost (i,j) is the time to get from i to j just taking coffee at i.
            dp[i] = cost(i, j) + dp[j];
            next[i] = j;

            // Try the first shop after our marker.
            if (j + 1 <= n && cost(i, j + 1) + dp[j + 1] < dp[i]) {
                dp[i] = cost(i, j + 1) + dp[j + 1];
                next[i] = j + 1;
            }
        }

        // Just build our list forward.
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (n > 0) {
            res.add(0);
            j = 0;
            while (next[j] != -1 && next[j] != n) {
                res.add(next[j]);
                j = next[j];
            }
        }

        // Output the result.
        System.out.println(res.size());
        StringBuffer sb = new StringBuffer();
        if (n > 0) sb.append(res.get(0));
        for (int i = 1; i < res.size(); i++)
            sb.append(" " + res.get(i));
        System.out.println(sb);

    }

    // Returns the time for going from stop i to j only taking coffee at i.
    public static long cost(int from, int to) {

        long d = carts[to] - carts[from];
        long full = c * (v1 * wait + v2 * drink);

        // Easy case, coffee is done.
        if (d >= full)
            return wait * c + drink * c + (d - full) / v1;

        // We get to start drinking it...
        if (d >= c * v1 * wait)
            return wait * c + (d - c * v1 * wait) / v2;

        // Never drink it (pretty dumb) but I think I need this.
        return d / v1;
    }
}