package com.ohgiraffers.section01.polymorphism;

public class Application3 {

    public static void main(String[] args) {

        Application3 app3 = new Application3();

        Animal animal1 = new Rabbit();
        Animal animal2 = new Tiger();

        System.out.println("animal1");
        app3.feed(animal1);  // feed -> 이 클래스의 feed 메소드를 호출 -> .eat() -> 동적바인딩 -> Animal로 선언했기 때문에 Animal 클래스를 상속받은 Rabbit 타입의 메소드를 호출 (동적바인딩)
        System.out.println("animal2");
        app3.feed(animal2);  // Animal로 선언했기 때문에 Animal 클래스를 상속받은 Tiger 타입의 메소드를 호출 (동적바인딩)

        Rabbit animal3 = new Rabbit();
        Tiger animal4 = new Tiger();

        System.out.println("animal3");
        app3.feed(animal3);  // => 업캐스팅이라고 볼 수 없음 / 묵시적 업캐스팅 (자식이 부모로) ?
        System.out.println("animal4");
        app3.feed(animal4);  // => 업캐스팅이라고 볼 수 없음 / 묵시적 업캐스팅 (자식이 부모로) ?
        /*
        * 위의 두 경우는 어떤 메소드가 호출되느냐에 따라 업캐스팅으로 볼 수도 있고, 아닐 수도 있음
        * 만약 animal의 feed가 호출되면 업캐스팅, 아니면 단순 메소드 호출
        * 이를 확실하게 싶은 경우 ?
        * 1) 확실한 업캐스팅 -> 명시적 업캐스팅이 나음
        * 2) app3.feed(new Rabbit()); 이런 방식으로 쓰면 -> rabbit의 feed 적용
        * 3) app3.feed((Rabbit(animal)); 이런 방식으로 쓰면 -> 다운 캐스팅이 일어나 rabbit의 feed 적용
        * */

        System.out.println("명시적 업캐스팅 animal3");
        app3.feed((Animal)animal3);  // 명시적 업캐스팅 (자식이 부모로)  // 그러나 동적바인딩으로 인해 토끼의 메소드 호출

        System.out.println("app3.feed(new Rabbit()) 예시");
        app3.feed(new Rabbit());   // 이런 애들은 확실히 rabbit의 feed를 씀 (만약 rabbit의 feed가 없다면 자연스럽게 업캐스팅)

    }

    public void feed (Rabbit rabbit) {
        System.out.println("토끼 feed");
    }

    public void feed (Tiger tiger) {
        System.out.println("호랑이 feed");
    }

    public void feed (Animal animal) {
        animal.eat();
    }

}



