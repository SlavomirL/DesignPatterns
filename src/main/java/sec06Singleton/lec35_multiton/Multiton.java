package sec06Singleton.lec35_multiton;

import java.util.HashMap;

// we use multiton when we want to have finite number of instances + control over them + take advantage of lazy loading

enum Subsystem {
    PRIMARY,
    AUXILIARY,
    FALLBACK
}


class Printer {
    private static int instanceCount = 0;
    private Printer() {
        instanceCount++;
        System.out.println("A total of " + instanceCount + " instanced created so far");
    }

    private static HashMap<Subsystem, Printer> instances = new HashMap<>();

    public static Printer get(Subsystem ss) {
        // lazy loading + we cannot have more than 3 instances because there are only 3 types of Subsystem enum
        if(instances.containsKey(ss)) {
            return instances.get(ss);
        }


        Printer instance = new Printer();
        instances.put(ss, instance);
        return instance;
    }
}


public class Multiton {

    public static void main(String[] args) {
        Printer main = Printer.get(Subsystem.PRIMARY);
        Printer aux = Printer.get(Subsystem.AUXILIARY);

        // this wont create another instance because it already exists
        Printer aux2 = Printer.get(Subsystem.AUXILIARY);
    }
}
