package sec06Singleton.lec29_serializationproblems;

// 1st problem is with reflection - you can beat the private constructor with reflection and create more instances, which is against the whole idea of using singleton
// 2nd problem is with serialization - you will beat the singleton concept without maybe even realizing it by using serialization

import java.io.*;

class BasicSingleton implements Serializable {

    private BasicSingleton() {

    }

    private static final BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // tato metoda hovori ze ak sa ide diat serialization tak sa ma diat len na tejto instancii
    protected Object readResolve() {
        return INSTANCE;
    }
}

class Demo {

    static void saveToFile(BasicSingleton singleton, String filename) throws Exception {
        // serialization code
        try (
                FileOutputStream fileOut = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String filename) throws Exception {
        // deserialization code
        try (
                FileInputStream fileIn = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (BasicSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        BasicSingleton mainSingleton = BasicSingleton.getInstance();
        mainSingleton.setValue(111);

        String filename = "singleton.bin";
        saveToFile(mainSingleton, filename);

        mainSingleton.setValue(222);

        // this is a proof that we have multiple instances of BasicSingleton
//        when we add readResolve() method as shown above, we will have only one instance
        BasicSingleton singletonOther = readFromFile(filename);
        System.out.println(mainSingleton == singletonOther);
        System.out.println(mainSingleton.getValue());
        System.out.println(singletonOther.getValue());

    }
}
