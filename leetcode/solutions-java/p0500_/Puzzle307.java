package p0500_;

/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 *
 * @author half-dead
 */
public class Puzzle307 {
    public static void main(String[] args) {
        NumArray nm = new Puzzle307().new NumArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        System.out.println(nm.sumRange(0, 7));
        System.out.println(nm.sumRange(1, 6));
    }

    // segment tree, O(N) for initialize, O(logN) for update & sumRange
    class NumArray {
        int[] st;
        int shift;

        public NumArray(int[] nums) {
            int len = nums.length;
            if (len == 0) return;

            shift = len - 1;
            st = new int[(len << 1) - 1];
            System.arraycopy(nums, 0, st, shift, len);
            for (int i = st.length - 1; i >= 1; i--) st[(i + 1) / 2 - 1] += st[i];
        }

        public void update(int i, int val) {
            int diff = val - st[i += shift];
            st[i] = val;
            while (i > 0) st[i = ((i + 1) / 2 - 1)] += diff;
        }

        public int sumRange(int i, int j) {
            int res = 0;
            for (i += shift, j += shift; i < j; i = (i + 1) / 2 - 1, j = (j + 1) / 2 - 1) {
                if (i % 2 == 0) res += st[i++];
                if (j % 2 == 1) res += st[j--];
            }
            if (i == j) res += st[i];
            return res;
        }
    }
}
