package com.ohgiraffers.section02.functionalinterface;

import java.time.LocalTime;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;

/* JDK 8에서 빈번하게 사용되는 함수적 인터페이스를 표준 API로 제공하고 있다.
 *  Consumer : 리턴값이 없는 accept() 메소드를 가지고 있다.
 *  Supplier : 매개변수가 없고 리턴 값이 있는 getXXX() 메소드를 가지고 있다.
 *  Function : 매개변수와 리턴값이 있는 applyXXX() 메소드를 가지고 있다. (매개변수를 리턴값으로 매핑하는 역할)
 *  Operator : Function과 똑같이 applyXXX() 메소드를 가지고 있다. 차이점은 매개변수로 연산을 한 후 통일타입으로 리턴한다.
 *  Predicate : 매개변수와 boolean 값을 반환하는 testXXX()를 가지고 있다. (매개변수를 활용하여 boolean 반환)
 * */
public class Application1 {

    public static void main(String[] args) {

        // 매개 변수 없고, 리턴값도 없는 람다
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
        r.run();

        Runnable runnable = () -> System.out.println("Hello");
        runnable.run();

        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s + " is entered");
            }
        }; c.accept("Hello");

        Consumer<String> consumer = (str) -> System.out.println(str + " is entered");
        consumer.accept("hello World");

        BiConsumer<String, LocalTime> biconsumer = (str1 , time)
        ->System.out.println(str1 + " is entered at " + time);
        biconsumer.accept("Mr.Hong", LocalTime.now());

        IntConsumer intConsumer = num ->System.out.println("You entered " + num);
        intConsumer.accept(1);

        ObjIntConsumer<Random> objIntConsumer =
                (random, bound)
                        -> System.out.println("The random number occurs since "
                        + random + "to" + bound + " : " + random.nextInt(bound));


    }
}
