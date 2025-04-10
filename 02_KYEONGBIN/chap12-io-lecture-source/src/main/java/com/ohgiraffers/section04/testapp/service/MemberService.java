package com.ohgiraffers.section04.testapp.service;


import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.repository.MemberRepository;

import java.util.ArrayList;

// 트랜잭션 처리 (성공 실패에 따른 commit/rollback) 및 회원관련 비즈니스 로직 처리
public class MemberService {

    private final MemberRepository mr = new MemberRepository();

//    public MemberService() {
//        this.mr = new MemberRepository();
//    }

    public void findAllMembers() {
        ArrayList<Member> findMembers = mr.selectAllMembers();
        for (Member member :findMembers) {
            System.out.println(member);
        }
    }

//    /***
//     * 회원번호로 회원찾기 기능
//     * @param i 회원번호
//     */

    public void findMember(int membNo) {

        Member selectedMember = mr.selectMember(membNo);
        if (selectedMember != null) {
            System.out.println("조회된 회원은 : " + selectedMember.getId() + " 아이디 회원");
        } else {
            System.out.println("그런 회원은 없네요~~~");

        }
    }

    public void registMember(Member newMember) {

        int lastMemberNo = mr.selectLastMemberNo();
        newMember.setMembNo(lastMemberNo + 1);

        int result = mr.insertMember(newMember);
        if (result == 1) {
            System.out.println(newMember.getId() + "님 환영합니다.😊");
        }
    }

    public Member findMemberForMod(int memNo) {

        Member selectedMember = mr.selectMember(memNo);
        if (selectedMember != null) {
            Member newInstance = new Member();
            newInstance.setMembNo(selectedMember.getMembNo());
            newInstance.setId(selectedMember.getId());
            newInstance.setPwd(selectedMember.getPwd());
            newInstance.setAge(selectedMember.getAge());

            String[] copiedHobbies = selectedMember.getHobbies().clone();
            newInstance.setHobbies(copiedHobbies);
            newInstance.setBloodType(selectedMember.getBloodType());

            System.out.println("조회된 회원은 : " + newInstance.getId() + "아이디 회원");

            return newInstance;  // ✅ 누락된 return 추가!
        } else {
            System.out.println("그런 회원은 없습니다.");
        }
        return null;
    }


    public void modifyMember(Member reform) {

        int result = mr.updateMember(reform);

        if (result == 1) {
            System.out.println("수정 성공!");
            return;
        }
        System.out.println("수정 내역 없음");
    }

    public void removeMember(int removeMemberNo) {
        int result = mr.deleteMember(removeMemberNo);

        if (result == 1) {
            System.out.println("다시 돌아오세요~~!");
            return;
        }
        System.out.println("회원번호가 틀렸나 봐요...");
    }
}
