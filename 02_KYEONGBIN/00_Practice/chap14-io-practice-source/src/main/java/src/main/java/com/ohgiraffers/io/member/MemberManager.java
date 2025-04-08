package src.main.java.com.ohgiraffers.io.member;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MemberManager {

    private Member[] members;

    public void readMembers() {

        String filePath = "src.main.java.com.ohgiraffers.io.member.members.ser";

        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src.main.java.com.ohgiraffers.io.member.members.ser")));
//              ois = new ObjectInputStream(new FileInputStream("src.main.java.com.ohgiraffers.io.member.membersser"));
//            while (true) {
//                System.out.println(ois.readObject());
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }


}
