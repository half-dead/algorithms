package p1500_;

/**
 * https://leetcode.com/problems/find-in-mountain-array/
 *
 * @author half-dead
 */
public class Puzzle1095 {

    public static void main(String[] args) {
        Puzzle1095 p = new Puzzle1095();
        DefaultMA ma = p.new DefaultMA(new int[]{1, 2, 3, 4, 5, 3, 1});

        Solution s = p.new Solution();
        System.out.println(s.findInMountainArray(3, ma));
    }

    class Solution {
        public int findInMountainArray(int target, MountainArray ma) {
            int n = ma.length();

            int lo = 1, hi = n - 1, top = lo;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                int a = ma.get(mid - 1), b = ma.get(mid), c = ma.get(mid + 1);
                if (a < b && b < c) {
                    lo = mid + 1;
                } else if (a > b && b > c) {
                    hi = mid - 1;
                } else {
                    top = mid;
                    break;
                }
            }
            if (lo >= hi) top = lo;
            if (ma.get(top) == target) return top;

            int left = bs(0, top - 1, true, target, ma);
            return left < 0 ? bs(top + 1, n - 1, false, target, ma) : left;
        }

        int bs(int lo, int hi, boolean asc, int target, MountainArray ma) {
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                int val = ma.get(mid);
                if (val == target) return mid;
                else if (val < target == asc) lo = mid + 1;
                else hi = mid - 1;
            }
            return ma.get(lo) == target ? lo : -1;
        }
    }

    interface MountainArray {
        int get(int index);

        int length();
    }

    class DefaultMA implements MountainArray {
        int[] arr;

        public DefaultMA(int[] arr) {
            this.arr = arr;
        }

        @Override
        public int get(int index) {
            return arr[index];
        }

        @Override
        public int length() {
            return arr.length;
        }
    }
}
