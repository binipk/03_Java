package com.ohgiraffers.section01.set.run;

import java.util.*;

public class Application2 {
    public static void main(String[] args) {

        /*
         * 📌 LinkedHashSet 특징
         * ✅ 중복을 허용하지 않음 (No duplicates)
         * ✅ 입력한 순서를 유지함 (Keeps insertion order)
         */

        // Set 인터페이스 타입으로 LinkedHashSet 생성
        Set<String> lSet = new LinkedHashSet<>();

        // 요소 추가 (Add elements)
        lSet.add("ramen");
        lSet.add("pork");
        lSet.add("chicken");
        lSet.add("gimbab");

        // 전체 출력 (전체 Set을 출력하면 순서가 유지됨)
        System.out.println("lSet = " + lSet);

        // 개별 요소 출력 (Using Iterator)
        Iterator<String> iterator = lSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }

        Map <Integer, String> imap = new HashMap<Integer, String>();
        imap.put(1, "java");
        imap.put(2, "c");

//        imap.keySet();
//        System.out.println(imap.keySet());

        Set set = imap.keySet();
        Iterator iterator1 = set.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }


        Properties p = new Properties();
        p.load();
        p.store();
        p.setProperty(new String("key"), "value");
        p.getProperty(new String("key"));
    }
}
