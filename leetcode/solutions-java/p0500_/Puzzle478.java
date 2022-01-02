package p0500_;

/**
 * @author half-dead
 */
public class Puzzle478 {

    public static void main(String[] args) {
        System.out.println(Math.sin(0));
        System.out.println(Math.sin(Math.PI / 2));
        System.out.println(Math.sin(Math.PI));
        System.out.println(Math.sin(Math.PI + Math.PI / 2));
        System.out.println(Math.sin(Math.PI * 2));
    }

    class Solution {
        double r, x, y;

        public Solution(double radius, double x_center, double y_center) {
            this.r = radius;
            this.x = x_center;
            this.y = y_center;
        }

        public double[] randPoint() {
            // 若圆a的半径是圆b的两倍，则面积是4倍，所以这里需要开根号
            // 如果是球体，则需要开立方根
            double len = Math.sqrt(Math.random()) * r;
            double degree = Math.random() * 2 * Math.PI;
            return new double[]{x + len * Math.cos(degree), y + len * Math.sin(degree)};
        }
    }
}
