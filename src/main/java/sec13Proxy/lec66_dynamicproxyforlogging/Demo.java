package sec13Proxy.lec66_dynamicproxyforlogging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

// a dynamic proxy is a proxy constructed at runtime as opposed to compile time
interface Human {
    void walk();
    void talk();
}

class Person implements Human {
    @Override
    public void talk() {
        System.out.println("I am talking");
    }

    @Override
    public void walk() {
        System.out.println("I am walking");
    }
}


// by using this approach we can intercept invokation of every single method, and before it gets invoked, we can perform some additional processing, ie. logging
class LoggingHandler implements InvocationHandler {
    private final Object target;
    private Map<String, Integer> calls = new HashMap<>();

    public LoggingHandler(Object target) {
        this.target = target;
    }


    //invoke method is the idea that you get to invoked a particular method (2nd arg) with a particular set of arguments (3rd arg)
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();

        if(name.contains("toString")) {
            return calls.toString();
        }

        // merge je Map metoda ktora hovori ze do klucu name uloz hodnotu 1 ak tam doteraz nic nebolo alebo pripocitaj k existujucej hodnote ak nejaka bola)
        calls.merge(name, 1, Integer::sum);

        return method.invoke(target, args);
    }
}


class Demo {

    @SuppressWarnings("unchecked")
public static <T> T withLogging(T target, Class<T> interfaceToReceive) {
    // target in this case is the object on which the logging is required
    return (T) Proxy.newProxyInstance(
            interfaceToReceive.getClassLoader(),
            new Class<?>[] {interfaceToReceive},
            new LoggingHandler(target)
    );
}

    public static void main(String[] args) {
        Person person = new Person();
        Human logged = withLogging(person, Human.class);
        logged.talk();
        logged.walk();
        logged.walk();
        System.out.println(logged);
    }
}
