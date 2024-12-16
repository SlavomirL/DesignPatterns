package sec08Bridge.lec44_bridge;

// if we had class Shape with multiple subclasses, ie. Circle, Square, Triangle etc.
// and also if we had multiple Rendering types like Vector, Raster etc.
// and then if we decided to combine them, we would have too many combinations, like VectorCircleRenderer, VectorSquareRenderer etc.

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

// what we can do instead is to use Bridge pattern - below:
// Bridge pattern is a mechanism that decouples an interface from an implementation
interface Renderer {
    void renderCircle(float radius);
}

class VectorRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle of radius " + radius);
    }
}

class RasterRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing pixels for a circle of radius " + radius);
    }
}


abstract class Shape {
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();

    public abstract void resize(float factor);
}


class Circle extends Shape {
    public float radius;

// option 1.    - see code in main method below
//    public Circle(Renderer renderer) {
//        super(renderer);
//    }

    // option 2. - annotation coming from google that specify which constructor to be used when creating a circle
    @Inject
        public Circle(Renderer renderer) {
        super(renderer);
    }

    public Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }

    @Override
    public void resize(float factor) {
        radius *= factor;
    }
}

// option 2. - when someone requests a renderer to be injected, we are going to create an instance of VectorRenderer
class ShapeModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Renderer.class).to(VectorRenderer.class);
    }
}

class Demo {
    public static void main(String[] args) {
        // option 1. - see constructor in Circle class above
//        RasterRenderer raster = new RasterRenderer();
//        VectorRenderer vector = new VectorRenderer();
//        Circle circle = new Circle(vector, 5);
//        circle.draw();
//
//        circle.resize(2);
//        circle.draw();

        // option 2 - typkovi toto funguje ale mne to hadze error. neskumal som preco
        Injector injector = Guice.createInjector(new ShapeModule());
        Circle instance = injector.getInstance(Circle.class);
        instance.radius = 3;
        instance.draw();

        instance.resize(2);
        instance.draw();

    }
}