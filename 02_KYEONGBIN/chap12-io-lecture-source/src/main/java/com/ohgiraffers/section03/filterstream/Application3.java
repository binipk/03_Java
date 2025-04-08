package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application3 {

    public static void main(String[] args) {

        // 1. DataOutputStream으로 파일에 다양한 자료형 쓰기
        DataOutputStream dout = null;

        try {
            dout = new DataOutputStream(
                    new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/score.txt"));

            dout.writeUTF("홍길동");
            dout.writeInt(95);
            dout.writeChar('A');

            dout.writeUTF("이순신");
            dout.writeInt(85);
            dout.writeChar('B');

            dout.writeUTF("김철수");
            dout.writeInt(78);
            dout.writeChar('C');

            System.out.println("파일에 데이터 쓰기 완료");

        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("파일 쓰기 중 오류 발생");
            throw new RuntimeException(e);
        } finally {
            if (dout != null) {
                try {
                    dout.close();
                } catch (IOException e) {
                    System.out.println("파일 출력 스트림 닫는 중 오류 발생");
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println(" ----------------------------------------------- ");

        // 2. DataInputStream으로 파일에서 자료형별로 읽기
        DataInputStream din = null;

        try {
            din = new DataInputStream(
                    new FileInputStream("src/main/java/com/ohgiraffers/section03/filterstream/score.txt"));

            while (true) {
                // 기록한 순서대로 읽기 (UTF → int → char)
                String name = din.readUTF();
                int score = din.readInt();
                char grade = din.readChar();

                System.out.println(name + ", " + score + ", " + grade);
            }

        } catch (EOFException e) {
            System.out.println("파일 읽기 완료");

        } catch (FileNotFoundException e) {
            System.out.println("읽을 파일을 찾을 수 없습니다.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("파일 읽기 중 오류 발생");
            throw new RuntimeException(e);
        } finally {
            if (din != null) {
                try {
                    din.close();
                } catch (IOException e) {
                    System.out.println("파일 입력 스트림 닫는 중 오류 발생");
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
