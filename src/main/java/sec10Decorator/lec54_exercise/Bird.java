//package sec10Decorator.lec54_exercise;
//
///*
//*
//* The following code scenario shows a Dragon  which is both a Bird  and a Lizard .
//
//Complete the Dragon 's interface (there's no need to extract any interfaces!). Take special care when implementing setAge() !
//* */
//
//class Bird
//{
//    public int age;
//
//    public String fly()
//    {
//        return age < 10 ? "flying" : "too old";
//    }
//}
//
//class Lizard
//{
//    public int age;
//
//    public String crawl()
//    {
//        return (age > 1) ? "crawling" : "too young";
//    }
//}
//
//class Dragon
//{
//    private int age;
//    public void setAge(int age)
//    {
//        // todo
//    }
//    public String fly()
//    {
//        // todo
//    }
//    public String crawl()
//    {
//        // todo
//    }
//}