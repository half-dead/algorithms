package util;

/**
 * @author half-dead
 */
class LongCalculator extends Calculator<Long> {
    public Long parseNumber(String s) {
        return Long.parseLong(s);
    }

    public Long add(Long a, Long b) {
        return a + b;
    }

    public Long minus(Long a, Long b) {
        return a - b;
    }

    public Long multiply(Long a, Long b) {
        return a * b;
    }

    public Long divide(Long a, Long b) {
        return a / b;
    }
}
