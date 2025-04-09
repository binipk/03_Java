package com.ohgiraffers.section01.list.run;

import java.util.Stack;

public class Application4_Stack {

    public static void main(String[] args) {

        /*
        * Stack is?
        * 후입선출? (LIFO) 의 자료구조로 push(), pop(), peek()
        * 등의 메소드를 활용하여 자료를 처리할 수 잇다.
        * */

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(9);
        stack.push(47);
        stack.push(9);
        stack.push(1);
        stack.push(1);

        System.out.println("stack: " + stack);

        System.out.println("peek: " + stack.peek()); // 맨 마지막 요소를 보여주는 것!

        System.out.println("stack: " + stack);

        System.out.println("search: " + stack.search(5)); // 없으면 -1 반환해주는 듯
        // 뒤에서 몇번째 위치한게 뭔지 보여줌 // stack은 뒤가 없음 // 스택은 쌓는거임 (위에서 두번째)
        // 중복되는 숫자는 내려오다가 첫번째 걸린거로 보여줌

        System.out.println("pop: " + stack.pop()); // 위에서부터 꺼냄
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
//        System.out.println("pop: " + stack.pop()); // 더이상 없는 값일 때 pop 하면 오류남
        System.out.println("stack: " + stack);


    }
}
