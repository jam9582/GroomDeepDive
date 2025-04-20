package application;

/*
사용자로부터 두 개의 숫자와 연산자를 입력받는 계산기 프로그램을 작성합니다.
사용자 입력 값이 잘못되었을 때 예외 처리를 구현하여 적절한 오류 메시지를 출력합니다.
예외 처리가 동작하는 것을 확인할 수 있도록 프로그램을 실행하고 결과를 확인합니다.
결과물로 사용자 입력 값이 잘못되었을 때 예외 처리가 동작하는 스크린샷을 제출합니다.
 */

import java.util.Scanner;
import utils.calculator.Calculator;

public class ExceptionCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double a, b;
        char operator;


        try{
            System.out.println("첫번째 숫자를 입력하세요: ");
            a = sc.nextDouble();

            System.out.println("( + , - , * , / ) 중 하나의 연산자를 입력하세요: ");
            operator = sc.next().charAt(0);

            System.out.println("두번째 숫자를 입력하세요: ");
            b = sc.nextDouble();

            double result = Calculator.calculate(a,b,operator);
            System.out.println("결과: " + result);
        }
        catch (ArithmeticException e){
            System.out.println("저런! " + e.getMessage());
        }
        catch (IllegalArgumentException e){
            System.out.println("저런! " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("예상치 못한 오류가 발생했습니다" + e.getMessage());
        } // 여기 e.message()만 내가 따로 설정을 안해줘서 null 값 나옴
        finally{ //예외 발생 여부와 상관없이 무조건 실행되는 코드 , 여기 안 넣고 try안에 넣으면 예외 발생 시 안 sc 안 닫음
            sc.close();
        }
    }
}
