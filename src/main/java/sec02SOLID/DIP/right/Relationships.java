package sec02SOLID.DIP.right;

import sec02SOLID.DIP.Person;
import sec02SOLID.DIP.Relationship;
import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;

public class Relationships implements RelationshipBrowser {

    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
                .filter(x -> Objects.equals(x.getValue0().name, name) && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }
}
