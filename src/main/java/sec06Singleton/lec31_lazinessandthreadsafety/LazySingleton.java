package sec06Singleton.lec31_lazinessandthreadsafety;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("Initializing lazy singleton");
    }

    // instead of having private static final BasicSingleton INSTANCE = new BasicSingleton(); which is instantiating of object immediately, we can use lazy singleton
    // lazy singleton sa vytvori len ked niekto naozaj potrebuje instanciu danej triedy
    // this approach introduces thread issue when two threads might init the instance which is NOK -
//    you can fix it by 1| using synchronized keyword in method signature OR
/*    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }*/

    // 2| double-checked locking
    public static LazySingleton getInstance() {
        if(instance == null) {
            synchronized (LazySingleton.class) {
                if(instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
