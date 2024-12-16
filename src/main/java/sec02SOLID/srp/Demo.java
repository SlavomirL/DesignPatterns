package sec02SOLID.srp;

public class Demo {

    public static void main(String[] args) throws Exception {
        Journal j = new Journal();
        j.addEntry("I cried today");
        j.addEntry("I ate aa bug");
        System.out.println(j);

        Persistence p = new Persistence();
        String filename = "/home/slobotka/udemy_learning/design_patterns/DesignPatterns/journal.txt"; // absolute path
        p.saveToFile(j, filename, true);

//        Runtime.getRuntime().exec("notepad.exe" + filename);  // works only on windows

    }
}
