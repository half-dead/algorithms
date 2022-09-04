package util;

import java.util.Random;

/**
 * @author half-dead
 */
class DataGen {
    public static Random random = new Random(0);

    public static String genString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch = (char) (random.nextInt(26) + 'a');
            sb.append(ch);
        }
        return sb.toString();
    }

    public static int[] genIntegers(int n, int bound) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(bound);
//            if (nums[i] == 0) {
//                i--;
//                continue;
//            }
        }
        return nums;
    }
}
