package sec05Prototype.lec25_exercise;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
//
//    public Point(Point other) {
//        this(other.x, other.y);
//    }

    protected Object deepClone() {
        return new Point(x,y);
    }
}

class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

//    public Line(Line other) {
//        this.start = new Point(other.start);
//        this.end = new Point(other.end);
//    }

//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return new Line((Point)start.clone(), (Point)end.clone());
//    }

    public Line deepCopy() {
        return new Line((Point)start.deepClone(), (Point)end.deepClone());
    }
}




