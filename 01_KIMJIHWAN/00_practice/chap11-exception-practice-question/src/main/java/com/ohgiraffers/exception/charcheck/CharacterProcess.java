package com.ohgiraffers.exception.charcheck;

public class CharacterProcess {

    public static void main(String[] args) throws CharCheckException {
        CharacterProcess p = new CharacterProcess();

        p.countAlpha("Hello world");
    }

    public CharacterProcess() {
    }

    public int countAlpha(String s) throws CharCheckException {
        int count = 0;

        if (s.indexOf(' ') > -1) {
            throw new CharCheckException("체크할 문자열 안에 공백을 포함할 수 없습니다.");
        }

        // else가 없어도 이 아래 코드는 위 if문이 정상일 때 작동
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}