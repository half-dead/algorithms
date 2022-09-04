package util;

import java.util.Arrays;

/**
 * @author half-dead
 */ // Tested by Leetcode 698
class DivideSticks {
    static boolean[] vst;
    static int[] nums;
    static int targetNumOfBlocks;
    static int targetBlockSum;

    // divide int[] sticks into K blocks, and each block has sum == blockSum
    static boolean canPartitionKBlocks(final int[] sticks, int numOfBlocks, int blockSum) {
        vst = new boolean[sticks.length];
        nums = Arrays.copyOf(sticks, sticks.length);
        Arrays.sort(nums);
        targetNumOfBlocks = numOfBlocks;
        targetBlockSum = blockSum;
        return dfs(0, nums.length - 1, 0, 0);
    }

    private static boolean dfs(int depth, int startIndex, int currentSum, int currentNumOfBlocks) {
        if (depth == nums.length) return currentNumOfBlocks == targetNumOfBlocks;
        if (currentNumOfBlocks >= targetNumOfBlocks) return false;
        if (nums[0] + currentSum > targetBlockSum) return false; // TODO

        int lastIndex = -1;
        for (int i = startIndex; i >= 0; i--) {
            if (vst[i]) continue;
            if (lastIndex >= 0 && nums[lastIndex] == nums[i]) continue; // skip duplicate
            if (nums[i] + currentSum > targetBlockSum) continue; // TODO

            vst[i] = true;
            if (nums[i] + currentSum == targetBlockSum) { // TODO
                if (dfs(depth + 1, nums.length - 1, 0, currentNumOfBlocks + 1)) {
                    return true;
                }
            } else {
                if (dfs(depth + 1, i - 1, nums[i] + currentSum, currentNumOfBlocks)) {
                    return true;
                }
            }
            vst[i] = false;

            lastIndex = i;
            if (currentSum == 0) return false;
        }
        return false;
    }
}
