package sec02SOLID.OCP.right;

import sec02SOLID.OCP.ocp.Size;
import sec02SOLID.OCP.wrong.Product;

public class SizeSpecification implements Specification<Product> {
    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}
