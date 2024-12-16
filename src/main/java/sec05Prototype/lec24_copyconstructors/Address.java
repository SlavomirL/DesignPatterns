package sec05Prototype.lec24_copyconstructors;

class Address {

    public String streetAddress, city, country;

    public Address(String streetAddress, String city, String country) {
        this.city = city;
        this.country = country;
        this.streetAddress = streetAddress;
    }

    // copy constructor
    public Address(Address other) {
        // it calles the above constructor by using 'this' keyword but it uses arguments from other
        this(other.streetAddress, other.city, other.country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

class Employee {
    public String name;
    public Address address;

    public Employee(String name, Address address) {
        this.address = address;
        this.name = name;
    }

    // copy constructor
    public Employee(Employee other) {
        name = other.name;
        address = new Address(other.address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "address=" + address +
                ", name='" + name + '\'' +
                '}';
    }
}


class Demo {
    public static void main(String[] args) {
        Employee john = new Employee("John", new Address("123 London Road", "London", "UK"));
        Employee chris = new Employee(john);
        chris.name = "Chris";
        chris.address.city = "Reading";
        System.out.println(john);
        System.out.println(chris);

    }
}