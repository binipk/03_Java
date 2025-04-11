package com.ohgiraffers.section01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application2 {

    public static void main(String[] args) {

        List<String> sL = new ArrayList<>(Arrays.asList("Java", "Mysql", "jdbc", "html", "css"));

        System.out.println("========== foreach");
        for(String s: sL) {
            System.out.println(s + " : " + Thread.currentThread().getName());
        }

        System.out.println("========== normal stream");
        sL.forEach(Application2::print);
        sL.forEach(Application2::print);

        System.out.println("========== paralle stream");
        sL.parallelStream().forEach(Application2::print);
        sL.parallelStream().forEach(Application2::print);

    }

    private static void print(String s) {
        System.out.println((s + " : " + Thread.currentThread().getName()));
    }
}
