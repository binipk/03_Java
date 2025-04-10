package com.ohgiraffers.section02.enumtype;

public class Application1 {

    public static void main(String[] args) {

        Subjects subject1 = Subjects.JAVA;
        System.out.println(subject1);

        Subjects subject2 = Subjects.HTML;
        System.out.println(subject2);

        Subjects subject3 = Subjects.JAVA;
        System.out.println(subject3);

        // 열거타입으로 선언된 인스턴스는 싱글톤으로 관리되며 인스턴스가 각각 한개임을 보장함
        // 작성한 순서에 따라 각각은 다른 인스턴스가 생성되며, 최초 호출 시에 enum의 생성자를 활용해 생성된다.
        // (lazy singleton 개념)?

        if (subject1 == subject2) {
            System.out.println("Both subjects are equal");
        } else {
            System.out.println("Both subjects are not equal");
        }

        // 단일 인스턴스임을 보장하기에 == 비교가 가능하다 (동일 객체 비교가 가능함)
        if (subject1 == subject3) {
            System.out.println("It's a singleton+."); // 싱글톤? 하나의 주소? 같은거?
        }

        // 오버라이딩 되지 않은 toString() 또는 name() 메소드를 활용하여 필드명을 문자열로 변경하기 쉽다.
        System.out.println(Subjects.JAVA); // JAVA.toString (뒤에 toString 생략됨) 써도되긴함
        System.out.println(Subjects.JAVA.name());  // 이렇게 하면 toString이 자동으로 안생김

        // 이름 충돌 방지를 위해 접두사를 쓰지 않아도 Enum 타입별로 네임스페이스를 가진다.
//        Subjects.BackEnd javascript = Subjects.JAVASCRIPT;
//        System.out.println("javascript is " + javascript);
//        Subjects.FrontEnd javasctript2 = Subjects.JAVASCRIPT;
//        System.out.println("javascript is " + javasctript2);

        // values()를 이용하여 상수 값 배열을 반환받고 이를 활용하여 연속처리를 해줄 수 있다.
        Subjects[] subjects = Subjects.values();
        for (Subjects subject : subjects) {
            System.out.println(subject.toString());
            System.out.println(subject.name());
            System.out.println(subject.ordinal());
        }
    }




}
