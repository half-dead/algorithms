package p0500_;

/**
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 *
 * @author half-dead
 */
public class Puzzle421_MaximumXOROfTwoNumbersInAnArray {

    public static void main(String[] args) {
        Puzzle421_MaximumXOROfTwoNumbersInAnArray p = new Puzzle421_MaximumXOROfTwoNumbersInAnArray();
        int[] arr = new int[]{20, 12, 29, 76, 94, 65, 95, 33, 79, 80, 57, 78};
        for (int i : arr) {
            System.out.printf("%32s\n", Integer.toBinaryString(i));
        }
        Solution s = p.new Solution();
        System.out.println(s.findMaximumXOR(arr));
    }

    class Solution {
        public int findMaximumXOR(int[] nums) {
            int r = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int xor = nums[i] ^ nums[j];
                    r = Math.max(r, xor);
                }
            }
            return r;
        }
    }

    class TrieSolution {
        public int findMaximumXOR(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Trie root = new Trie();
            for (int num : nums) {
                Trie curNode = root;
                for (int i = 31; i >= 0; i--) {
                    int curBit = (num >>> i) & 1;
                    if (curNode.children[curBit] == null) {
                        curNode.children[curBit] = new Trie();
                    }
                    curNode = curNode.children[curBit];
                }
            }

            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                Trie curNode = root;
                int curSum = 0;
                for (int i = 31; i >= 0; i--) {
                    int curBit = (num >>> i) & 1;
                    if (curNode.children[curBit ^ 1] != null) {
                        curSum += (1 << i);
                        curNode = curNode.children[curBit ^ 1];
                    } else {
                        curNode = curNode.children[curBit];
                    }
                }
                max = Math.max(curSum, max);
            }
            return max;
        }
    }

    class Trie {
        Trie[] children;

        public Trie() {
            children = new Trie[2];
        }
    }

}
