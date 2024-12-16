package sec02SOLID.OCP.wrong;

import sec02SOLID.OCP.ocp.Color;
import sec02SOLID.OCP.ocp.Size;

import java.util.List;
import java.util.stream.Stream;

public class ProductFilter {
    // creating three methods for this is fine if we have only color and size. if we had 10 criterias, it would be problematic
    // in other words, we are breaking the open-close principle OCP

    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream().filter(p -> p.size == size);
    }

    public Stream<Product> filterByColorAndSize(List<Product> products, Color color, Size size) {
        return products.stream().filter(p -> p.size == size && p.color == color);
    }
}
