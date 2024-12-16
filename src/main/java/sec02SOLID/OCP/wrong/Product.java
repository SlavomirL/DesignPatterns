package sec02SOLID.OCP.wrong;

import sec02SOLID.OCP.ocp.Color;
import sec02SOLID.OCP.ocp.Size;

public class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.color = color;
        this.name = name;
        this.size = size;
    }
}
