package sec02SOLID.DIP.wrong;

import sec02SOLID.DIP.Person;
import sec02SOLID.DIP.Relationship;
import org.javatuples.*;
import java.util.ArrayList;
import java.util.List;

// low level module - because it is related to data storage - it  provides a list, doesnt contain any business logic
public class Relationships {
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }
}
