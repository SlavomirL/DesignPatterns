package sec06Singleton.lec33_enumbasedsingleton;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


// the takeaway is:
// even though you can use enum to create a singleton, you cannot effectively serialize it because all the fields will not get serialize + you cannot inherit from it. you still can use it if you are ok with these constraints
enum EnumBasedSingleton {
    INSTANCE;

    // constructor for enum is always private so no need to specify it
    EnumBasedSingleton() {
        value = 42;
    }

    // during enum serialization, only the name of instance is serialized but not the value (fields)
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


class Demo {
    static void saveToFile(EnumBasedSingleton singleton, String filename) throws Exception {
        // serialization code
        try (
                FileOutputStream fileOut = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
        }
    }

    static EnumBasedSingleton readFromFile(String filename) throws Exception {
        // deserialization code
        try (
                FileInputStream fileIn = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (EnumBasedSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        String filename = "myfile.bin";

//        EnumBasedSingleton singleton = EnumBasedSingleton.INSTANCE;
//        singleton.setValue(111);
//        saveToFile(singleton,filename);

        EnumBasedSingleton singleton2 = readFromFile(filename);
        System.out.println(singleton2.getValue());


    }
}