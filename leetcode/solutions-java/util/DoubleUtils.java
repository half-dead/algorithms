package util;

/**
 * @author half-dead
 */
class DoubleUtils {
    private static final double EPS = 1e-8;

    public static int compare(double a, double b) {
        if (a - b > EPS) return 1;
        else if (a - b < -EPS) return -1;
        else return 0;
    }

    public static boolean isInteger(double a) {
        return compare(floor(a), a) == 0;
    }

    public static double floor(double a) {
        return Math.floor(a + EPS);
    }

    public static double ceil(double a) {
        return Math.ceil(a - EPS);
    }
}
