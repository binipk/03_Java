package src.main.java.com.ohgiraffers.io.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberObjectIOTest {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        calc.sumToNumber(1, 2);

        System.out.println("두 수의 합은 : " + calc.sumToNumberReturn(1, 2));

        Member m = new Member();
        m.setUserName("홍길동");

        System.out.println("The usr name is : " + m.getUserName());

        List<String> strList = new ArrayList<String>();
        strList.add("test");

        String test1 = strList.set(0, "test1");
        System.out.println("test1 = " + test1);

        m.setUserPwd("test123");
        System.out.println(m.getUserPwd());

    }






}
