package sec02SOLID.OCP.ocp;

import sec02SOLID.OCP.right.AndSpecification;
import sec02SOLID.OCP.right.BetterFilter;
import sec02SOLID.OCP.right.ColorSpecification;
import sec02SOLID.OCP.right.SizeSpecification;
import sec02SOLID.OCP.wrong.Product;
import sec02SOLID.OCP.wrong.ProductFilter;

import java.util.List;

public class Demo {

    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List<Product> products = List.of(apple, tree, house);

        // wrong approach
        ProductFilter pf = new ProductFilter();
        System.out.println("Green products (old): ");
        pf.filterByColor(products, Color.GREEN).forEach(p -> System.out.println(" _ " + p.name + " is green"));

        //right approach - open for extension but closed for modification
        BetterFilter bf = new BetterFilter();
        System.out.println("Green products (new): ");
        bf.filter(products, new ColorSpecification(Color.GREEN)).forEach(p -> System.out.println(" _ " + p.name + " is green"));

        System.out.println("Large blue items");
        bf.filter(products,
                new AndSpecification<>(
                        new ColorSpecification(Color.BLUE),
                        new SizeSpecification(Size.LARGE)
                ))
                .forEach(p -> System.out.println(
                        " _ " + p.name + " is large and blue"));

    }
}
