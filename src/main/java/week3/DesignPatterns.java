package week3;

/**
 * Singleton
 *  1. use only on obj instance in jvm / memory / heap
 *  2. reuse same instance
 *  3. save memory space
 */
class EagerLoadingSingleton {
    private static final EagerLoadingSingleton instance = new EagerLoadingSingleton();

    private EagerLoadingSingleton() {}

    public static EagerLoadingSingleton getInstance() {
        return instance;
    }
}

class LazyLoadingSingleton {
    private static volatile LazyLoadingSingleton instance;

    private LazyLoadingSingleton() {}

    public static LazyLoadingSingleton getInstance() {
        //T1, T2, T3, T4
        if(instance == null) {
            //T1, T2, T4
            synchronized (LazyLoadingSingleton.class) {
                if(instance == null) {
                    instance = new LazyLoadingSingleton();
                }
            }
        }
        //t3
        return instance;
    }

}

enum EnumSingleton {
    MyInstance;
}

/**
 * Factory
 *  1. lose coupling
 *  2. hide initialization
 */
class MyCarFactory {
    public static MyCarWeek3 getMyCar() {
        return new MyCarWeek3Impl();
    }
}

/**
 * Builder
 */
class MyCar {
    private String color;

    public MyCar(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
class MyCarBuilder1 {
    private String color;

    public MyCarBuilder1 setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public String toString() {
        return "MyCarBuilder1{" +
                "color='" + color + '\'' +
                '}';
    }

    public MyCar build() {
        return new MyCar(color);
    }

    public static void main(String[] args) {
        MyCar myCar = new MyCarBuilder1().setColor("white").build();
    }
}

/**
 * stream().map(Function fun)
 */

@FunctionalInterface
interface StrategyPattern {
    int calculate(int a, int b);
}
class Calculator {
    public int calculate(int a, int b, StrategyPattern strategyPattern) {
        return strategyPattern.calculate(a, b);
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.calculate(1, 2, (a, b) -> a * b));
    }
}


/**
 *   Spring Boot + Server
 *   Spring MVC
 *   Rest API
 *
 *   tomorrow 10:00 CDT
 *
 */

