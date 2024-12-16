package sec04Factory.lec20_exercise;

/*You are given a class called Person . The person has two fields: id , and name .

Please implement a non-static PersonFactory that has a createPerson()  method that takes a person's name and returns a new instance of Person .

The id  of the person returned should be set as a 0-based index of the object created by that factory. So, the first person the factory makes should have id=0, second id=1 and so on.*/


class Person {

    public int id;
    public String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// toto treba prerobit aby metoda brala len String name parameter
//class PersonFactory {
//    public Person createPerson(int id, String name) {
//        return new Person(id, name);
//    }
//}

class PersonFactory {
    int personId;

    public Person createPerson(String name) {
        int id = this.personId;
        Person p = new Person(id, name);
        this.personId++;
        return p;
    }
}

class Demo {
    public static void main(String[] args) {
        PersonFactory pf = new PersonFactory();
//        Person personJ = pf.createPerson(0, "Jano");
//        Person personM = pf.createPerson(1 , "Miro");

        Person personJ = pf.createPerson("Jano");
        Person personM = pf.createPerson("Miro");

        System.out.println("personJ.name = " + personJ.name);
        System.out.println("personJ.id = " + personJ.id);
        System.out.println("personM.name = " + personM.name);
        System.out.println("personM.id = " + personM.id);
    }
}