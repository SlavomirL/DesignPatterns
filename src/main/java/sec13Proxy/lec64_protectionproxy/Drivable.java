package sec13Proxy.lec64_protectionproxy;

interface Drivable {
    void drive();
}


class Car implements Drivable {
    protected Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void drive() {
        System.out.println("A car is being driven");
    }
}


class Driver {
    public int age;

    public Driver(int age) {
        this.age = age;
    }
}


class CarProxy extends Car {
    public CarProxy(Driver driver) {
        super(driver);
    }

    @Override
    public void drive() {
        if(driver.age >= 16) {
            super.drive();
        } else {
            System.out.println("Driver too young");
        }
    }
}


class Demo {
    public static void main(String[] args) {
        Car car = new Car(new Driver(12));
        car.drive();

//        if you want to use proxy, you can do it without any special modifications:
        Car carProxy = new CarProxy(new Driver(12));
        carProxy.drive();

    }
}