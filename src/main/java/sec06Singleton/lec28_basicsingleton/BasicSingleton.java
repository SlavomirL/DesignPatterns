package sec06Singleton.lec28_basicsingleton;

class BasicSingleton {

    // private constructor
    private BasicSingleton() {

    }

    // create static final instance of singleton - the only instance that is ever exposed
    private static final BasicSingleton INSTANCE = new BasicSingleton();

    // provide access to that instance
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
}

class Demo {
    public static void main(String[] args) {

        // we cant do this
//        BasicSingleton cantInstantiate = new BasicSingleton();


        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(123);
        System.out.println(singleton.getValue());
    }
}
