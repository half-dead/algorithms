package util;

/**
 * @author half-dead
 */
class ArraySum {
    long[] sum;
    int n;

    // nums index starts from 0 to nums.length - 1;
    public ArraySum(int[] nums) {
        n = nums.length;
        sum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public ArraySum(long[] nums) {
        n = nums.length;
        sum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    // [l, r], index starts from 0
    public long getSum(int l, int r) {
        // error handling
        if (!(l >= 0 && l < n && r >= 0 && r < n) || l > r) return 0L;
        return sum[r + 1] - sum[l];
    }
}
