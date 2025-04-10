package com.ohgiraffers.section04.testapp.run;

import com.ohgiraffers.section04.testapp.aggregate.BloodType;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.service.MemberService;

import java.util.Scanner;

public class Application {

    private static final MemberService ms = new MemberService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String menu = """
                ========== 회원 관리 프로그램 ==========
                1. 모든 회원 정보 보기
                2. 회원 찾기
                3. 회원 가입
                4. 회원 정보 수정
                5. 회원 탈퇴
                0. 프로그램 종료
                메뉴를 선택해주세요: """;

        while(true) {
            System.out.print(menu);
            int input = sc.nextInt();

            switch(input) {
                case 1:
                    ms.findAllMembers();
                    break;
                case 2:
                    ms.findMember(chooseMemNo());
                    break;
                case 3:
                    ms.registMember(signUp());
                    break;
                case 4:
                    Member selected = ms.findMemberForMod(chooseMemNo());
                    if (selected == null) {
                        System.out.println("해당 회원이 존재하지 않습니다.");
                        break;
                    }
                    ms.modifyMember(reform(selected));
                    break;
                case 5:
                    ms.removeMember(chooseMemNo());
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }

    private static int chooseMemNo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("회원 번호를 입력하세요: ");
        return sc.nextInt();
    }

    private static Member signUp() {
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력하세요: ");
        String id = sc.nextLine();

        System.out.print("패스워드를 입력하세요: ");
        String pwd = sc.nextLine();

        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();

        System.out.print("입력할 취미 개수를 입력하세요(숫자로 1 이상): ");
        int length = sc.nextInt();
        sc.nextLine();

        String[] hobbies = new String[length];
        for (int i = 0; i < hobbies.length; i++) {
            System.out.print((i + 1) + "번째 취미를 입력하세요: ");
            hobbies[i] = sc.nextLine();
        }

        System.out.print("혈액형을 입력하세요(A, AB, B, O): ");
        String bloodType = sc.nextLine().toUpperCase();
        BloodType bt;

        switch (bloodType) {
            case "A": bt = BloodType.A; break;
            case "AB": bt = BloodType.AB; break;
            case "B": bt = BloodType.B; break;
            case "O": bt = BloodType.O; break;
            default:
                System.out.println("유효하지 않은 혈액형입니다. A로 설정됩니다.");
                bt = BloodType.A;
        }

        Member newMember = new Member(id, pwd, age, hobbies);
        newMember.setBloodType(bt);

        return newMember;
    }

    private static Member reform(Member selected) {
        Scanner sc = new Scanner(System.in);
        Member modifiedMember = selected;

        while (true) {
            System.out.println("==== 수정 서브 메뉴 ====");
            System.out.println("1. 패스워드");
            System.out.println("2. 나이");
            System.out.println("3. 취미");
            System.out.println("4. 혈액형");
            System.out.println("5. 메인 메뉴로 돌아가기");
            System.out.print("내용을 선택하세요: ");
            int chooseNo = sc.nextInt();
            sc.nextLine();

            switch (chooseNo) {
                case 1:
                    System.out.print("수정할 패스워드를 입력하세요: ");
                    modifiedMember.setPwd(sc.nextLine());
                    break;
                case 2:
                    System.out.print("수정할 나이를 입력하세요: ");
                    modifiedMember.setAge(sc.nextInt());
                    sc.nextLine(); // 버퍼 비우기
                    break;
                case 3:
                    modifiedMember.setHobbies(resetHobbies());
                    break;
                case 4:
                    modifiedMember.setBloodType(resetBloodType());
                    break;
                case 5:
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    return modifiedMember;
                default:
                    System.out.println("번호를 다시 입력해주세요.");
            }
        }
    }

    private static String[] resetHobbies() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 취미 개수를 입력하세요 (숫자로 1 이상): ");
        int length = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        String[] hobbies = new String[length];
        for(int i = 0; i < length; i++) {
            System.out.print((i + 1) + "번째 취미를 입력하세요: ");
            hobbies[i] = sc.nextLine();
        }

        return hobbies;
    }

    private static BloodType resetBloodType() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 혈액형을 입력하세요(A, AB, B, O): ");
        String bloodType = sc.nextLine().toUpperCase();

        switch (bloodType) {
            case "A": return BloodType.A;
            case "AB": return BloodType.AB;
            case "B": return BloodType.B;
            case "O": return BloodType.O;
            default:
                System.out.println("유효하지 않은 혈액형입니다. A로 설정됩니다.");
                return BloodType.A;
        }
    }
}
