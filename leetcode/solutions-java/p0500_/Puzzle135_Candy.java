/*
https://leetcode.com/problems/candy/description/

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:
    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?
Example 1:
    Input: [1,0,2]
    Output: 5
    Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:
    Input: [1,2,2]
    Output: 4
    Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
                 The third child gets 1 candy because it satisfies the above two conditions.
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle135_Candy {

    public static void main(String[] args) {
//        Solution1 s = new Puzzle135_Candy().new Solution1();
//        System.out.println(s.candy(new int[]{1, 0, 2}));

        Solution s1 = new Puzzle135_Candy().new Solution();
        System.out.println(s1.candy(new int[]{4, 2, 3, 4, 1}));
    }

    // Too fucking complicated, but works
    class Solution {
        public int candy(int[] ratings) {
            if (ratings.length == 1) {
                return 1;
            }
            int result = 0;
            int left = 0, right = ratings.length - 1;
            int extra = 0, prevAscLen = 0;
            while (left < right) {
                int leftBegin = left;
                while (left < right && ratings[left] > ratings[left + 1]) {
                    left++;
                }
                int descLen = left - leftBegin + 1;
                if (descLen > 1) {
                    if (prevAscLen > descLen) {
                        result += prevAscLen;
                        result += descLen * (descLen - 1) / 2;
                        prevAscLen = 0;
                    } else {
                        result += descLen * (descLen + 1) / 2;
                        prevAscLen = 0;
                    }
                    extra = 1;
                }

                leftBegin = left;
                while (left < right && ratings[left] < ratings[left + 1]) {
                    left++;
                }
                int ascLen = left - leftBegin + 1;
                if (ascLen > 1) {
                    prevAscLen = ascLen;
                    if (extra > 0) {
                        result += (ascLen) * (ascLen - 1) / 2;
                        result -= 1;
                        extra = 0;
                    } else {
                        result += (ascLen - 1) * ascLen / 2;
                    }
                }

                leftBegin = left;
                while (left < right && ratings[left] == ratings[left + 1]) {
                    left++;
                    if (left == right) {
                        result += 1;
                    }
                }
                int equalLen = left - leftBegin + 1;
                if (equalLen > 1) {
                    if (extra == 0 && prevAscLen == 0) {
                        result += 1;
                    }
                    if (equalLen > 2) {
                        result += equalLen - 2;
                    }
                    if (extra > 0) {
                        extra = 0;
                    }
                    if (prevAscLen > 0) {
                        result += prevAscLen;
                        prevAscLen = 0;
                    }
                }
            }
            return result + prevAscLen;
        }
    }

    // 1033ms
    class Solution1 {
        public int candy(int[] ratings) {
            int[] arr = new int[ratings.length];
            int exp = ratings.length;
            while (exp > 0) {
                for (int i = 0; i < ratings.length; i++) {
                    if (arr[i] == 0) {
                        if (i > 0 && ratings[i] > ratings[i - 1] && i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                            if (arr[i - 1] != 0 && arr[i + 1] != 0) {
                                arr[i] = Math.max(arr[i - 1], arr[i + 1]) + 1;
                                exp--;
                            }
                        } else if (i > 0 && ratings[i] > ratings[i - 1]) {
                            if (arr[i - 1] != 0) {
                                arr[i] = arr[i - 1] + 1;
                                exp--;
                            }
                        } else if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                            if (arr[i + 1] != 0) {
                                arr[i] = arr[i + 1] + 1;
                                exp--;
                            }
                        } else {
                            arr[i] = 1;
                            exp--;
                        }
                    }
                }
            }
            int sum = 0;
            for (int i : arr) {
                sum += i;
            }
            return sum;
        }
    }
}
