package sec04Factory.lec18_factorymethod;

enum CoordinateSystem {
    CARTESIAN,
    POLAR
}

class Point {

    private double x, y;

/*
//    approach A: not allowed to have the constructor with same name and same amount of same type arguments

public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double rho, double theta) {
        x = rho * Math.cos(theta);
        y = rho * Math.sin(theta);
    }*/

    // approach B: use enums - working but ugly
/*    public Point(double a, double b, CoordinateSystem cs) {
        switch (cs) {
            case CARTESIAN:
                this.x = a;
                this.y = b;
                break;
            case POLAR:
                x = a * Math.cos(b);
                y = a * Math.sin(b);
                break;
        }
    }*/

    // approach C - factory method:
    private Point(double a, double b) {
        this.x = a;
        this.y = b;
    }
    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
    }
}

class Demo {
    public static void main(String[] args) {
        Point pointCart = Point.newCartesianPoint(2,3);
        Point pointPolar = Point.newPolarPoint(2,3);
    }
}
