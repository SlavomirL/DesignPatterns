package sec06Singleton.lec34_monostate;

class ChiefExecutiveOffice {

    // by using this approach there can in fact be many instances but all of them map to the same (once instance of) fields - not the ideal approach because its not obvious for other users that we uses singleton
    // you leave class as it is but you mark the fields static + change the setters - will create singleton
    private static String name;
    private static int age;

    @Override
    public String toString() {
        return "ChiefExecutiveOffice{" +
                "name='" + name + '\'' +
                "age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        ChiefExecutiveOffice.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ChiefExecutiveOffice.name = name;
    }
}


class Demo {
    public static void main(String[] args) {
        ChiefExecutiveOffice ceo = new ChiefExecutiveOffice();
        ceo.setName("Adam Smith");
        ceo.setAge(55);

        // this will output Adam Smith 55 even though we havent set name and age for ceo2
        ChiefExecutiveOffice ceo2 = new ChiefExecutiveOffice();
        System.out.println(ceo2);

    }
}