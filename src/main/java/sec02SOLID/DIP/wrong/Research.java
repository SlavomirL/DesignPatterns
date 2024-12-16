package sec02SOLID.DIP.wrong;

// high level module - it allows us to perform certain operations on low level constructs
public class Research {

    // this constructor takes low level module which is violation of DIP
//    public Research(Relationships relationships) {
//        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
//        relations.stream()
//                .filter(x -> x.getValue0().name.equals("John") && x.getValue1() == Relationship.PARENT)
//                .forEach(ch -> System.out.println("John has a child called " + ch.getValue2().name
//                ));
//    }
}
