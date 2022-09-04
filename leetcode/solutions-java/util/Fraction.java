package util;

/**
 * @author half-dead
 */
class Fraction {
    long n, d;

    public Fraction(long n, long d) {
        if (d == 0) {
            this.n = Long.MAX_VALUE;
            this.d = 1;
            return;
        }
        long g = gcd(Math.abs(n), Math.abs(d));
        this.n = n / g;
        this.d = d / g;
        if (this.d < 0) {
            this.d = -this.d;
            this.n = -this.n;
        }
    }

    public void add(Fraction other) {
        long numerator = this.n * other.d + this.d * other.n;
        long denominator = this.d * other.d;
        long g = gcd(Math.abs(numerator), Math.abs(denominator));
        this.n = numerator / g;
        this.d = denominator / g;
        if (this.d < 0) {
            this.d = -this.d;
            this.n = -this.n;
        }
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Fraction) {
            Fraction anotherObject = (Fraction) anObject;
            return n == anotherObject.n && d == anotherObject.d;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) (n * 31 + d);
    }

    private long gcd(long x, long y) {
        return x != 0 ? gcd(y % x, x) : y;
    }
}
