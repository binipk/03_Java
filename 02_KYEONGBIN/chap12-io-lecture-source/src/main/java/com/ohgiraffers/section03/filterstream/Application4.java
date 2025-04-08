package com.ohgiraffers.section03.filterstream;

import com.ohgiraffers.section03.filterstream.dto.MemberDTO;

import java.io.*;

public class Application4 {

    public static void main(String[] args) {

        // 1. MemberDTO 객체 배열 생성
        MemberDTO[] outputMembers = {
                new MemberDTO("user01", "pass01", "홍길동", "hong345@ohgiraffers.com", 25, '남', 1250.7),
                new MemberDTO("user02", "pass02", "유관순", "korea123@ohgiraffers.com", 16, '여', 1750.7),
                new MemberDTO("user03", "pass03", "이순신", "leesoonsin123@ohgiraffers.com", 35, '남', 3250.7)
        };

        ObjectOutputStream objOut = null;

        try {
            // 2. 객체를 파일에 저장할 출력 스트림 생성 (버퍼 보조 스트림 사용)
            objOut = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObjStream.txt")
                    )
            );

            // 3. 파일 존재 여부 확인 출력
            File file = new File("src/main/java/com/ohgiraffers/section03/filterstream/testObjStream.txt");
            System.out.println("파일 존재 여부: " + file.exists());

            // 4. 객체를 파일에 순차적으로 저장
            for (MemberDTO member : outputMembers) {
                objOut.writeObject(member);
            }

            objOut.flush();  // 버퍼에 남은 데이터를 강제로 밀어냄
            System.out.println("객체 쓰기 완료");

        } catch (IOException e) {
            System.out.println("파일 쓰기 중 오류 발생");
            throw new RuntimeException(e);

        } finally {
            if (objOut != null) {
                try {
                    objOut.close();
                } catch (IOException e) {
                    System.out.println("출력 스트림 닫는 중 오류 발생");
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println(" --------------------------------------------------------------------");

        // 5. 역직렬화를 통해 객체 배열 읽기
        ObjectInputStream objIn = null;

        try {
            objIn = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObjStream.txt")));

            while (true) {
                MemberDTO member = (MemberDTO) objIn.readObject();
                System.out.println(member);
            }

        } catch (EOFException e) {
            System.out.println("파일 읽기 완료");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (objIn != null) {
                try {
                    objIn.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
