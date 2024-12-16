package sec02SOLID.DIP;

import sec02SOLID.DIP.right.Relationships;
import sec02SOLID.DIP.right.Research;

public class Demo {

    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);

    }
}
