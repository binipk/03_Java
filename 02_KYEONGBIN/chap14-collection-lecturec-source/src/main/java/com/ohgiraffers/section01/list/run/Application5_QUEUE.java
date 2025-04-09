package com.ohgiraffers.section01.list.run;

import java.util.Collections;
import java.util.PriorityQueue;

public class Application5_QUEUE {
    public static void main(String[] args) {

        // 오름차순 정렬 큐 (기본 정렬)
        PriorityQueue<String> queue = new PriorityQueue<>();

        // 내림차순 정렬 큐
        PriorityQueue<String> queue2 = new PriorityQueue<>(Collections.reverseOrder());

        // queue에 문자열 추가 (자동 오름차순 정렬)
        queue.offer("ad");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        queue.offer("f");

        // queue2에 문자열 추가 (자동 내림차순 정렬)
        queue2.offer("a");
        queue2.offer("b");
        queue2.offer("c");
        queue2.offer("d");
        queue2.offer("e");
        queue2.offer("f");

        // 큐 출력 (내부 힙 구조이므로 완벽히 정렬된 것처럼 안 보일 수 있음)
        System.out.println("오름차순 queue: " + queue);
        System.out.println("내림차순 queue2: " + queue2);

        /*
         * peek() : 큐의 첫 번째 요소 반환 (제거 X)
         * poll() : 큐의 첫 번째 요소 반환 + 제거
         */
        System.out.println("queue.peek(): " + queue.peek());
        System.out.println("queue.poll(): " + queue.poll());
        System.out.println("queue after poll: " + queue);
    }
}
