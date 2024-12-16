package sec06Singleton.lec30_staticblocksingleton;

import java.io.File;
import java.io.IOException;

class StaticBlockSingleton {

    private StaticBlockSingleton() throws IOException {
        System.out.println("Singleton is initializing");
        File.createTempFile(".", ".");
    }

    private static StaticBlockSingleton instance;


    // if you have constructor that might throw something, you have to use static block
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            System.err.println("failed to create singleton");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }


}
