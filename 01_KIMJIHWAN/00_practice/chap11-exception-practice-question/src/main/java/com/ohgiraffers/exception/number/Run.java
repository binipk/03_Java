package com.ohgiraffers.exception.number;

import java.util.Scanner;

public class Run{

    public static void main(String[] args) {
        Run run = new Run();
        run.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        NumberProcess np = new NumberProcess();

        System.out.print("1에서 100 사이의 배수가 될 정수를 입력하세요: ");
        int a = sc.nextInt();

        System.out.print("1에서 100 사이의 배수 인자가 될 정수를 입력하세요: ");
        int b = sc.nextInt();

        try {
            if (np.checkDouble(a, b)) {
                System.out.println(a + "는 " + b + "의 배수입니다..");
            } else {
                System.out.println(a + "는 " + b + "의 배수가 아닙니다.");
            }
        } catch (NumberRangeException e) {
            System.out.println(e.getMessage());
        }


    }
}
