package week3;

import java.lang.annotation.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Annotations
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String value() default "abc";
}

//@MyAnnotation("aaaaaaa")
class TestMyAnnotation {

    @MyAnnotation("myfield str")
    private String str;

    public static void main(String[] args) {
        Class<?> clazz = TestMyAnnotation.class;
//        Annotation[] annotations = clazz.getDeclaredAnnotations();
//        MyAnnotation myAnnotation = (MyAnnotation)annotations[0];
//        System.out.println(myAnnotation.value());

        Annotation[] annotations = clazz.getDeclaredFields()[0].getDeclaredAnnotations();
        MyAnnotation myAnnotation = (MyAnnotation)annotations[0];
        System.out.println(myAnnotation.value());
    }
}

/**
 * proxy
 */
interface MyCarWeek3 {
    void start();
    void stop();
}
class MyCarWeek3Impl implements MyCarWeek3 {
    public void start() {
        System.out.println("start");
    }
    public void stop() {
        System.out.println("stop");
    }

    //...
    public static MyCarWeek3 getMyCar() {
        return new MyCarWeek3Impl();
    }
}
/**
 * question:  how to add log in MyCarWeek3 class
 *      we want to insert same "before log", "after log" data in each method in MyCarWeek3 class
 */
class Solution1 extends MyCarWeek3Impl {
    @Override
    public void start() {
        System.out.println("before");
        super.start();
        System.out.println("after");
    }

    @Override
    public void stop() {
        System.out.println("before");
        super.stop();
        System.out.println("after");
    }
}

class Solution2 implements MyCarWeek3 {

    private final MyCarWeek3 myCarWeek3Impl;

    public Solution2(MyCarWeek3 myCarWeek3Impl) {
        this.myCarWeek3Impl = myCarWeek3Impl;
    }

    @Override
    public void start() {
        System.out.println("before");
        myCarWeek3Impl.start();
        System.out.println("after");
    }

    @Override
    public void stop() {
        System.out.println("before");
        myCarWeek3Impl.stop();
        System.out.println("after");
    }
}


/**
 *  Dynamic Proxy
 */
class DynamicProxyTest {
    public static void main(String[] args) {
        MyCarWeek3 car = (MyCarWeek3) Proxy.newProxyInstance(
                    DynamicProxyTest.class.getClassLoader(),
                    new Class[]{MyCarWeek3.class},
                    new MyInvocationHandler(new MyCarWeek3Impl())
                );
        car.start();
        car.stop();
    }
}

class MyInvocationHandler implements InvocationHandler {
    private final MyCarWeek3 myCarWeek3Impl;

    public MyInvocationHandler(MyCarWeek3 myCarWeek3Impl) {
        this.myCarWeek3Impl = myCarWeek3Impl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object res = method.invoke(myCarWeek3Impl, args);
        System.out.println("after");
        return res;
    }
}

/**
 * char Character, int Integer
 */
class OutBoxing {
    public static void main(String[] args) {
//        int a = 5;
//        Integer b = a;
//        int c = b;
//        System.out.println();
//
        Integer a = 1;
        Integer b = 1;
        Integer c = 200;
        Integer d = 200;
        System.out.println(a == b); // true
        System.out.println(c == d); // false
    }
}