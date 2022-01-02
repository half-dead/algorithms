package p1000_;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 *
 * @author half-dead
 */
public class Puzzle894_AllPossibleFullBinaryTrees {
    public static void main(String[] args) {
        Puzzle894_AllPossibleFullBinaryTrees p = new Puzzle894_AllPossibleFullBinaryTrees();
        Solution s = p.new Solution();
        List<TreeNode> treeNodes = s.allPossibleFBT(7);
        System.out.println(1);
    }

    class Solution {
        private Map<Integer, List<TreeNode>> map = new HashMap<>();

        public List<TreeNode> allPossibleFBT(int n) {
            List<TreeNode> result = new ArrayList<>();
            if (n == 1) {
                result.add(new TreeNode(0));
                map.put(1, result);
            } else if (n % 2 != 0) {
                int left = 1, right = n - 2;
                while (right > 0) {
                    List<TreeNode> leftList = compute(left);
                    List<TreeNode> rightList = compute(right);
                    for (TreeNode ln : leftList) {
                        for (TreeNode rn : rightList) {
                            TreeNode root = new TreeNode(0);
                            root.left = ln;
                            root.right = rn;
                            result.add(root);
                        }
                    }
                    left += 2;
                    right -= 2;
                }
            }
            return result;
        }

        private List<TreeNode> compute(int n) {
            List<TreeNode> list = map.get(n);
            if (list == null) {
                list = allPossibleFBT(n);
                map.put(n, list);
            }
            return list;
        }
    }

}
