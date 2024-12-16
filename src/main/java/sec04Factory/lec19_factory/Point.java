package sec04Factory.lec19_factory;

class Point {

    private double x, y;

    private Point(double a, double b) {
        this.x = a;
        this.y = b;
    }

    // factory has to be public static and nested inner class in order to keep Point constructor private
    public static class PointFactory {
        public static Point newCartesianPoint(double x, double y) {
            return new Point(x, y);
        }

        public static Point newPolarPoint(double rho, double theta) {
            return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
        }
    }

}

class Demo {
    public static void main(String[] args) {
        Point pointCart = Point.PointFactory.newCartesianPoint(2,3);
        Point pointPolar = Point.PointFactory.newPolarPoint(2,3);
    }
}
