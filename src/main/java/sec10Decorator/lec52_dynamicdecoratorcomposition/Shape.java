package sec10Decorator.lec52_dynamicdecoratorcomposition;

interface Shape {

    String info();
}


class Circle implements Shape {
    private float radius;

    public Circle() {
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return "A circle of radius " + radius;
    }

}


class Square implements Shape {
    private float side;

    public Square() {
    }

    public Square(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "A square with side " + side;
    }
}


// if you already have defined classes, ie. Square and Circle and you want to add new attribute to it, ie. color, in order to respect OCP, you do not really want to modify those classes but rather use decorator
class ColoredShape implements Shape {
    private Shape shape;
    private String color;

    public ColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}


class TransparentShape implements Shape {
    private Shape shape;
    private int transparency;

    public TransparentShape(Shape shape, int transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape.info() + " has " + transparency + "% transparency";
    }
}

// instead of modifying old classes, you create decorators (new classes) that:
// - take your original object in the constructor
// - aggregate it in the private variable
// - provide additional info

class Demo {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println(circle.info());

        ColoredShape blueSquare = new ColoredShape(new Square(20), "blue");
        System.out.println(blueSquare.info());

        TransparentShape transparentColoredCircle = new TransparentShape(
                new ColoredShape(
                        new Circle(5),
                        "green"),
                50);
        System.out.println(transparentColoredCircle.info());
    }
}