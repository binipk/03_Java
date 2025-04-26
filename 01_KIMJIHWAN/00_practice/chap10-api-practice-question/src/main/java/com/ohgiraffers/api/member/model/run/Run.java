package com.ohgiraffers.api.member.model.run;

import com.ohgiraffers.api.member.model.vo.Member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

public class Run {

    public static void main(String[] args) {

        String str = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
        StringTokenizer token = new StringTokenizer(str,"|");
        //String[] arr = data.split("\\|"); //split하는 경우, 정규표현식 | 메타문자이므로 escaping처리 필수

        Member[] members = new Member[token.countTokens()];  // Token 클래스
        int i = 0;

        /* hasMoreTokens
        현재 위치 이후에 실제로 토큰이 존재하는지 확인한다.
        구분자만 있고, 문자열 끝에 도달했다면 false를 반환한다.
         */
        while(token.hasMoreTokens()){
            //2. , 기준으로 분리
            String memberStr =  token.nextToken();
            String[] mStr = memberStr.split(",");

            //2.1 분리한데이터를 Member에 담기
            Member m = new Member();

            // 하나하나 씩 대입
            //2.1.1 String타입은 그냥 대입
            //2.1.2 int타입은 Integer.parseInt로 형변환
            //2.1.3 LocalDate타입은 19900905를 parsing해서 년월일 정보 얻은후 LocalDate에 대입
            m.setMemberNo(Integer.parseInt(mStr[0]));
            m.setMemberName(mStr[1]);
            m.setHeight(Integer.parseInt(mStr[2]));
            m.setWeight(Integer.parseInt(mStr[3]));
            LocalDate birth = LocalDate.parse(mStr[4], DateTimeFormatter.ofPattern("yyyyMMdd"));
            m.setBirth(birth);

            //3.1 Member배열에 추가
            members[i++] = m;
        }

        //3.2 Member정보 열람
        for(Member m : members) {
            System.out.println(m.information());
        }
    }
}
