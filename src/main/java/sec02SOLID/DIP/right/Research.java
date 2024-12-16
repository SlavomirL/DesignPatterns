package sec02SOLID.DIP.right;

import sec02SOLID.DIP.Person;

import java.util.List;

public class Research {

    // right approach is that high level modules depend on abstraction - in this case RelationshipBrowser interface
    public Research(RelationshipBrowser browser) {
        List<Person> children = browser.findAllChildrenOf("John");
        for (Person child : children) {
            System.out.println("John has a child called " + child.name);
        }
    }
}
