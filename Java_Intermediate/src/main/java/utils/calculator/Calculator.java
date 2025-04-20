package utils.calculator;

public class Calculator {
    public static double calculate(double a, double b, char operator){
    /*
    static을 쓴 이유: 객체(Calculator calc = new Calculator();)를
    생성하지 않고도 메서드를 호출할 수 있도록 하기 위해서
    계산만 수행하는 유틸리티 메서드 역할을 하기 위해
    */
        switch (operator){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                if (b==0){
                    throw new ArithmeticException("0으로 나누면 값이 발산!");
                }//산술연산 중 발생하는 예외 처리
                return a/b;
            default :
                throw new IllegalArgumentException("연산자 입력이 잘못되었습니다.");
        } // 메소드에 잘못된 인자가 전달될 때 발생하는 예외
    }
}
