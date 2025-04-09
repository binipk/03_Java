package com.ohgiraffers.section01.set.run;

import java.util.HashSet;
import java.util.Iterator;

public class Application1 {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();

        set.add(new String("java"));
        set.add(new String("mysqlDB"));
        set.add(new String("servlet"));
        set.add(new String("spring"));
        set.add(new String("html"));

        //set 에 넣는 순서는 랜덤임
        System.out.println("set: " + set);

        set.add("java");
        set.add(new String("java"));
        System.out.println("set: " + set); // 중복안됨

        Iterator<String> iterator = set.iterator();

        while(iterator.hasNext()) { // 꺼낼게 있나요?
            System.out.println(iterator.next());
        }

        Object[] array = set.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("size: " + set.size());
        System.out.println("Contains: " + set.contains(new String("java")));

        set.clear();

        System.out.println("clear: " + set);
        System.out.println("isEmpty: " + set.isEmpty());
    }

}
