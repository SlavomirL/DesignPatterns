package sec02SOLID.DIP.right;

import sec02SOLID.DIP.Person;

import java.util.List;

public interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}
