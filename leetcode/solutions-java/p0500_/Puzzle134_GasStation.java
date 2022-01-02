package p0500_;

// There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
//
// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
//
// You begin the journey with an empty tank at one of the gas stations.
//
// Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
//
// Note:
// The solution is guaranteed to be unique.

/**
 * https://leetcode.com/problems/gas-station/
 */
public class Puzzle134_GasStation {

    public static void main(String[] args) {
        Puzzle134_GasStation p = new Puzzle134_GasStation();
        NeatSolution solution = p.new NeatSolution();
        int[] gas = new int[]{1, 1, 1, 4};
        int[] cost = new int[]{2, 2, 2, 1};
        int i = solution.canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    // based on idea from https://leetcode.com/discuss/4159/share-some-of-my-ideas
    public class NeatSolution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int start = 0, total = 0, tank = 0;
            for (int i = 0; i < gas.length; i++)
                if ((tank = tank + gas[i] - cost[i]) < 0) {
                    start = i + 1;
                    total += tank;
                    tank = 0;
                }
            return (total + tank < 0) ? -1 : start;
        }
    }

    public class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            if (gas.length == 1) {
                return gas[0] >= cost[0] ? 0 : -1;
            }

            int[] gap = new int[gas.length];
            for (int i = 0; i < gas.length; i++) {
                gap[i] = gas[i] - cost[i];
            }

            int s = 0;
            while (s < gap.length && gap[s] <= 0) s++;
            if (s == gas.length) return -1;

            int i = 0, sum = 0, idx = -1;
            for (; i < gap.length && s < gap.length; i++) {
                int temp = sum + gap[(i + s) % gap.length];
                if (temp < 0) {
                    s += ++i;
                    i = -1;
                    sum = 0;
                    continue;
                } else {
                    sum = temp;
                    // circle completed
                    if ((s != gap.length - 1 && i == gap.length - 1) || (i + s) % gap.length == s - 1) {
                        idx = s;
                    }
                }
            }
            return idx;
        }
    }

    // TLE
    public class TleSolution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int[] gap = new int[gas.length];
            for (int i = 0; i < gas.length; i++) {
                gap[i] = gas[i] - cost[i];
            }
            int start = 0;
            while (start < gap.length) {
                if (gap[start] > 0) {
                    int sum = 0;
                    int i = 0;
                    for (; i < gap.length; i++) {
                        sum += gap[(i + start) % gap.length];
                        if (sum < 0) {
                            i = gap.length + 1;
                        }
                    }
                    if (i == gap.length) {
                        return start;
                    }
                }
                start++;
            }
            return start < gap.length ? start : -1;
        }
    }
}
