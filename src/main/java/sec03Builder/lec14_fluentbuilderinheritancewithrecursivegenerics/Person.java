package sec03Builder.lec14_fluentbuilderinheritancewithrecursivegenerics;

// key takeaway: if you want a fluent interface to propagate  across inheritance hierarchy then you have to have recursive generic definition = <SELF extends ...<SELF>>

class Person {
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}


//we are saying that PersonBuilder is taking type argument but that type argument has to be some inheritor of PersonBuilder
//class PersonBuilder { - predtym som mal classu takto
class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

//    public PersonBuilder withName(String name) { - predtym takto
    public SELF withName(String name) {
        person.name = name;
//        return this; - predtym takto
        return self();
    }

    protected SELF self() {
        return (SELF) this;
    }

    public Person build() {
        return person;
    }
}


//class EmployeeBuilder extends PersonBuilder { - predtym som mal classu takto
class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {

    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}


class Demo {
    public static void main(String[] args) {
        EmployeeBuilder pb = new EmployeeBuilder();
        Person slavo = pb
                .withName("Slavo")
                .worksAt("it") // toto predtym nefungovalo lebo fluent builder + inheritance musis pomenit niektore veci v kode - vid hore
                .build();

        System.out.println(slavo);
    }
}
