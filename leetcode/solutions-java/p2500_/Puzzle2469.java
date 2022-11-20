package p2500_;

/**
 * https://leetcode.com/problems/convert-the-temperature/
 */
public class Puzzle2469 {
    class Solution {
        public double[] convertTemperature(double celsius) {
            return new double[]{celsius + 273.15d, celsius * 1.8 + 32};
        }
    }
}
