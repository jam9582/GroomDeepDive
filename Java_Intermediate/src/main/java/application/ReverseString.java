package application;

/*
사용자로부터 문자열을 입력받습니다.
입력받은 문자열을 뒤집어 출력합니다.
입력받은 문자열의 대소문자를 변환하여 출력합니다.
결과물로 사용자가 입력한 문자열을 뒤집고 대소문자를 변환하여 출력하는 스크린샷을 제출합니다.
 */

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("영어 대소문자로 문자열을 입력해주세요: ");
        String  sentence = sc.nextLine();

        String  reverse = new StringBuilder(sentence).reverse().toString();
        // .toString() 안하면 stringbuilder 타입으로 반환됨,
        // 근데 이거 안 쓰고 바로 sout(reverse) 해도 프린트 잘 되는데, 그 이유는 내부적으로 알아서 obj.toString() 을 호출하기 때문

        StringBuilder swap = new StringBuilder();
        for (char ch : reverse.toCharArray()) { // 향상된 for-each문
            if (Character.isUpperCase(ch)) {
                swap.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                swap.append(Character.toUpperCase(ch));
            } else {
                swap.append(ch);
            }
        }
        System.out.println("순서를 뒤집고 대소문자를 변환한 문자열: " + swap);

        sc.close();
    }
}