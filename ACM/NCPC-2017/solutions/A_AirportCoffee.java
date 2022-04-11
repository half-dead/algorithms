import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("ALL")
public class A_AirportCoffee {

    private static long totalDistance, slowSpeed, fastSpeed, waitTime, drinkTime;
    private static long m, slowUnitDistance, fullUnitDistance, fullUnitTime;
    private static long[] carts;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = reader.readLine().split(" ");
        slowSpeed = Long.parseLong(arr[1]);
        fastSpeed = Long.parseLong(arr[2]);
        waitTime = Long.parseLong(arr[3]);
        drinkTime = Long.parseLong(arr[4]);

        m = slowSpeed * fastSpeed;
        totalDistance = m * Long.parseLong(arr[0]);

        slowUnitDistance = m * slowSpeed * waitTime;
        fullUnitDistance = slowUnitDistance + m * fastSpeed * drinkTime;
        fullUnitTime = m * (waitTime + drinkTime);

        // parse carts
        int n = Integer.parseInt(reader.readLine().trim());
        carts = new long[n + 1];
        arr = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            carts[i] = m * Long.parseLong(arr[i]);
        }
        carts[n] = totalDistance;

        // dp[i] is the minimun time cost from i to n
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 0;

        // next[i] is the next cart we should go to from cart i
        int[] next = new int[n + 1];
        Arrays.fill(next, -1);

        // build dp array backwards
        for (int i = n - 1, j = n; i >= 0; i--) {

            // if we buy coffee at i and drink it all, where would we reach?
            long limit = carts[i] + m * (slowSpeed * waitTime + fastSpeed * drinkTime);
            if (limit > totalDistance) {
                dp[i] = calTimeCost(i, n);
                continue;
            }

            // find the furthest cart j we could reach from i only buy coffee at i
            while (j > i && carts[j] > limit) j--;
            if (i == j) j++;

            // plan A: from i to j
            dp[i] = calTimeCost(i, j) + dp[j];
            next[i] = j;

            // plan B: from i to j+1
            if (j < n) {
                long planB = calTimeCost(i, j + 1) + dp[j + 1];
                if (planB < dp[i]) {
                    dp[i] = planB;
                    next[i] = j + 1;
                }
            }
        }

        // build the path we need
        ArrayList<Integer> path = new ArrayList<>();
        if (n > 0) {
            path.add(0);
            for (int i = 0; next[i] != -1 && next[i] != n; i = next[i]) {
                path.add(next[i]);
            }
        }

        // print result
        System.out.println(path.size());
        StringBuilder sb = new StringBuilder();
        if (n > 0) sb.append(path.get(0));
        for (int i = 1; i < path.size(); i++) {
            sb.append(" ").append(path.get(i));
        }
        System.out.println(sb);
    }

    // time cost to get from i to j just buy coffee at i
    static long calTimeCost(int i, int j) {
        long dis = carts[j] - carts[i];

        // we can drink all coffee
        if (dis >= fullUnitDistance) return fullUnitTime + (dis - fullUnitDistance) / slowSpeed;

        // we can drink some coffee
        if (dis >= slowUnitDistance) return waitTime * m + (dis - slowUnitDistance) / fastSpeed;

        // we can not drink any coffee
        return dis / slowSpeed;
    }
}