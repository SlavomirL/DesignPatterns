package sec06Singleton.lec32_innerstaticsingleton;

class InnerStaticSingleton {

//    this approach guarantees that there will be only one instance whatever happens - no need to take care of thread safety
    private InnerStaticSingleton() {}

    public InnerStaticSingleton getInstane() {
        return Implem.INSTANCE;
    }


    // inner class Implem
    private static class Implem {

        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();

    }
}
