package com.ohgiraffers.section04.testapp.repository;

import com.ohgiraffers.section04.testapp.aggregate.BloodType;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;

// 데이터와 입출력(CRUD)을 위해 만들어지며 성공 또는 실패 여부를 반환
public class MemberRepository {

    private ArrayList<Member> memberList = new ArrayList<Member>();

//    최초에 생성될 객체의 생성자
//    1. 초기 회원 세명을 넣어둘 예정 (스트림을 활용한 객체 출력)
//    2. 파일로부터 회원 정보를 가져온다. (스트림을 활용한 객체 입력)
//    3. ArrayList를 활용해 가져온 회원정보를 저장

    public MemberRepository() {
        File file = new File("src/main/java/com/ohgiraffers/section04/testapp/db/memberDB.dat");

        // main을 실행할 때마다 덮어씌우는 문제를 방지하고자 파일이 없을 때만 초기 세팅이 되도록 조건문을 작성

        if(!file.exists()) { // exists()의 동작 >>> true: 파일이 있을 때, false : 파일이 없을 때
            // 파일이 해당 경로에 없을 경우이면 새롭게 만들고 추가
            ArrayList<Member> defaultMembers = new ArrayList<>();
            defaultMembers.add(new Member(1, "User01", "pass01", 20, new String[]{"발레", "수영"}, BloodType.A));
            defaultMembers.add(new Member(2, "User02", "pass02", 10, new String[]{"피아노", "작곡"}, BloodType.AB));
            defaultMembers.add(new Member(3, "User03", "pass03", 15, new String[]{"바이올린", "작사"}, BloodType.B));

            saveMembers(file, defaultMembers);

        }

        // 파일로부터 회원 객체들을 입력받아  memberList에 쌓기
        loadMember(file);

//        for(Member member : memberList) {
//            System.out.println("Member: " + member);
//        }

    }

    private void loadMember(File file) {

        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while(true) {
                memberList.add((Member) ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("회원정보 모두 로딩됨...");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 멤버 저장 기능용
     * @param file 파일 정보
     * @param members 저장할 멤버 정보
     */

    private void saveMembers(File file, ArrayList<Member> members) {

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

            for(Member member : members) {
                out.writeObject(member);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public ArrayList<Member> selectAllMembers() {
        return memberList;
    }
    //    public void findUser(int i) {
//
//        Member mem = null;
//        for (Member member : memberList) {
//            if (member.getMembNo() == i) {
//                mem = member;
//            }
//        }

    public Member selectMember(int membNo) {
        for (Member member : memberList) {
            if (member.getMembNo() == membNo) return member;
        }
        return null;
    }

    public int insertMember(Member newMember) {
        memberList.add(newMember);
        // 보통 값이 잘 들어갔는지 정수로 알려주기 때문데 int임
        MyObjectOutput moo = null;
        int result = -1;

        try {
            moo = new MyObjectOutput(new BufferedOutputStream(
                    new FileOutputStream("src/main/java/com/ohgiraffers/section04/testapp/db/memberDB.dat", true)));
            // 파일로 새로운 회원 객체 출력 (기존 회원에 추가)
            moo.writeObject(newMember);

            // 파일 출력이 성공하면 회원을 관리하는 컬렉션에도 추가 (최신화)
            memberList.add(newMember);

            // 객체 한 개 insert 성공을 의미하는 int값
            result = 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(moo != null) {
                try {
                    moo.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }
    
    // insert 를 하기 위해 회원번호를 발생시키는데 사용되는 마지막 회원의 번호 추출 기능
    public int selectLastMemberNo() {
        // 마지막 회원을 조회해서 그 회원의 회원번호를 확인 (항상 맞음)
        Member lastMember = memberList.get(memberList.size() -1);
        return lastMember.getMembNo();

        // return memberList.size();
        // 이렇게 쓰는게 틀리지는 않는데 항상 맞지도 않음 // 갯수가 중간에 빠지는 것도 있기 때문에
        // 컬렉션의 크기가 곧 회원번호이므로 마지막 회원의 번호는 컬렉션의 크기

    }

    public int updateMember(Member reform) {
        for (int i = 0 ; i < memberList.size(); i++) {
            Member iMember = memberList.get(i);
            if(iMember.getMembNo() == reform.getMembNo()) {
                System.out.println("===== 수정 전 기존 회원 정보와 비교 =====");
                System.out.println("reform : " + reform);
                System.out.println("iMember : " + iMember);
                System.out.println("=====================================");

                memberList.set(i, reform);

                File file = new File("src/main/java/com/ohgiraffers/section04/testapp/db/memberDB.dat");
                // 나중에는 설정값으로 다 빼버림
                saveMembers(file, memberList);

                if(!iMember.equals(reform))return 1;
            }
            return 0;
        }
        return 0;
    }

    public int deleteMember(int removeMember) {

        // 현재 회원 번호를 부여할 때, memberList의 size()를 기준으로 마지막 회원 번호를 결정하고 있습니다.
        // 이 방식은 회원 객체를 실제로 삭제(hard delete)하지 않고,
        // 탈퇴 여부를 나타내는 속성 값만 수정하는 방식(soft delete)을 사용해야만 가능한 구조입니다.
        //
        // 만약 hard delete(실제 회원 객체를 리스트에서 제거)를 하게 되면,
        // memberList의 size가 줄어들어 회원 번호 중복 등의 문제가 발생할 수 있습니다.
        //
        // 하드 삭제를 안전하게 구현하려면:
        // 1. remove() 메서드를 사용하여 특정 회원 객체를 리스트에서 제거하고,
        // 2. 변경된 리스트를 ObjectOutputStream을 활용해 파일에 다시 저장(덮어쓰기)해야 합니다.
        //
        // 따라서 현재 구조에서는 soft delete 방식이 더 안전하며,
        // 추후 번호 관리 방식을 개선한다면 hard delete도 고려할 수 있습니다.
        //
        // soft delete 시
        // int result = -1;
        //
        // for(Member mem : memberList) {
        //     if(mem.getMembNo() == removeMember) {
        //         mem.setId(null);
        //     }
        // }
        // result = 1;
        // return result;

        // hard delete 시
        for (int i = 0 ; i < memberList.size(); i++) {

            if(memberList.get(i).getMembNo() == removeMember) {
                memberList.remove(i);

                File file = new File("src/main/java/com/ohgiraffers/section04/testapp/db/memberDB.dat");
                saveMembers(file, memberList);

                return 1;
            }
        }
        return 0;


    }

}

