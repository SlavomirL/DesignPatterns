package sec05Prototype.lec23_dontuseclonable;

import java.util.Arrays;

class Address implements Cloneable {
    public String streetName;
    public int houseNumber;

    public Address(String streetName, int houseNumber) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber=" + houseNumber +
                ", streetName='" + streetName + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Address(streetName, houseNumber); // deep copy mechanics
    }
}

class Person implements Cloneable {
    public String[] names;
    public Address address;

    public Person(String[] names, Address address) {
        this.address = address;
        this.names = names;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address=" + address +
                ", names=" + Arrays.toString(names) +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Person(names.clone(), (Address)address.clone());
    }
}

class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person john = new Person(new String[]{"john", "Smith"},
                new Address("London Road", 123));
        // what if there is another person living on the same address?

        // snippet below will not work because both reference the same object
/*        Person jane = john;
        jane.names[0] = "Jane";
        jane.address.houseNumber = 124;

        System.out.println(john);
        System.out.println(jane);*/

        // same thing but after implementing Cloneable clone() methods inside Person and Address
        // Cloneable is not recommended though if you need a deep copy
        Person jane = (Person)john.clone();
        jane.names[0] = "Jane";
        jane.address.houseNumber = 124;

        System.out.println(john);
        System.out.println(jane);
    }
}
