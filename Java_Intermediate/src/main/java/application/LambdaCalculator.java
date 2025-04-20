package application;

/*
사용자로부터 두 개의 숫자와 연산자를 입력받습니다.
람다 표현식을 사용하여 입력받은 숫자와 연산자에 따른 계산 기능을 구현합니다.
계산 결과를 출력합니다.
결과물로 사용자 입력을 받아 람다 표현식으로 구현된 계산 기능을 수행하는 스크린샷을 제출합니다.
 */


import utils.calculator.Operation;
import java.util.HashMap;
import java.util.Map;
/* Map은 인터페이스, HashMap은 구현 클래스
HashMap<K, V>는 Map 인터페이스를 구현한 클래스이며, 
Map의 기능을 실제로 사용할 수 있도록 구현한 것 중 하나
예시로, treemap, LinkedHashMap 등이 있음
*/
import java.util.Scanner;

public class LambdaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a, b = 0;
        char operator = 'a';
        
        System.out.println("첫번째 숫자를 입력해주세요: ");
        a = sc.nextDouble();

        System.out.println("(+, -, *, /) 중 연산자를 하나 입력해주세요: ");
        operator = sc.next().charAt(0);

        System.out.println("두번째 숫자를 입력해주세요: ");
        b = sc.nextDouble();

        Map<Character, Operation> operations = new HashMap<>();
        operations.put('+', (x,y)->x+y);
        operations.put('-', (x,y)->x-y);
        operations.put('*', (x,y)->x*y);
        operations.put('/', (x,y)-> (y!=0) ? x/y : Double.NaN);
        // Double.NaN: Not a Number(숫자가 아님)을 의미하는 특수한 값

        Operation operation = operations.get(operator);
        //인터페이스 타입 변수, 람다 표현식이 저장될 변수 = map 메소드명.get(매개변수)

        if (operation != null) {
            double result = operation.calculate(a, b);
            if (!Double.isNaN(result)) {
                System.out.println("계산 결과: " + result);
            } else {
                System.out.println("0으로 나눌 수 없습니다.");
            }
        } else {
            System.out.println("올바른 연산자를 입력하세요.");
        }

        sc.close();

    }
}
