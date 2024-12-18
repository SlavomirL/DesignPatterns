//package sec13Proxy.lec67_exercise;
//
//
///*
//* You are given the Person  class and asked to write a ResponsiblePerson  proxy that does the following:
//
//Allows person to drink unless they are younger than 18 (in that case, return "too young")
//Allows person to drive unless they are younger than 16 (otherwise, "too young")
//In case of driving while drink, returns "dead"
//*
//* */
//
//class Person
//{
//    private int age;
//
//    public Person(int age)
//    {
//        this.age = age;
//    }
//
//    public int getAge()
//    {
//        return age;
//    }
//
//    public void setAge(int age)
//    {
//        this.age = age;
//    }
//
//    public String drink() { return "drinking"; }
//    public String drive() { return "driving"; }
//    public String drinkAndDrive() { return "driving while drunk"; }
//}
//
//class ResponsiblePerson
//{
//    private Person person;
//
//    public ResponsiblePerson(Person person)
//    {
//        // todo
//    }
//}