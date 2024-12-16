package sec03Builder.lec15_facetedbuilder;

// when you need to use multiple builders (because of complicated object) - you can give them a common interface (class - ie. PersonBuilder in this case)
class Person {

//    address
    public String streetAddress, postcode, city;

//    employment
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

// builder facade
class PersonBuilder {
    protected Person person = new Person();

    public Person build() {
        return person;
    }

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }
}


class PersonAddressBuilder extends PersonBuilder {

    public PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder at(String streetAddress) {
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder withPostcode(String postcode) {
        person.postcode = postcode;
        return this;
    }

    public PersonAddressBuilder inCity(String city) {
        person.city = city;
        return this;
    }
}


class PersonJobBuilder extends PersonBuilder {

    public PersonJobBuilder(Person person) {
    this.person =person;
    }

    public PersonJobBuilder worksAt(String company) {
        person.companyName = company;
        return this;
    }

    public PersonJobBuilder atPosition(String position) {
        person.position = position;
        return this;
    }

    public PersonJobBuilder earnings(int annualIncome) {
        person.annualIncome = annualIncome;
        return this;
    }
}

class Demo {

    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person person = pb
                .lives()
                    .at("123 London Road")
                    .inCity("London")
                    .withPostcode("SW12BC")
                .works()
                    .worksAt("eset")
                    .atPosition("sw developer")
                    .earnings(50000)
                .build();

        System.out.println(person);
    }
}