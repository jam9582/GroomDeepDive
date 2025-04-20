package application;

/*
도형 추상 클래스를 작성하고, 면적을 계산하는 추상 메서드를 선언합니다.
도형 인터페이스를 작성하고, 면적을 계산하는 메서드를 선언합니다.
추상 클래스와 인터페이스를 구현한 구체적인 도형 클래스(원, 사각형, 삼각형 등)를 작성합니다.
다양한 도형 객체를 생성하고, 각 도형의 면적을 계산하여 출력합니다.
결과물로 추상 클래스와 인터페이스를 이용하여 다양한 도형 객체를 생성하고 면적을 계산하여 출력하는 스크린샷을 제출합니다.
 */
import models.shape.*;

import java.util.Scanner;

/* 인터페이스:
추상 메서드만 선언 가능, 다중 상속 가능,
모든 변수는 기본적으로 public static final, 모든 메서드는 기본적으로 public absrtact(default, static 메서드는 예외),
객체 생성 불가능(new 사용 불가), implements(구현 키워드)로 사용
 */

/* 추상 메서드:
추상/일반 메서드 모두 가질 수 있음, 단일 상속만 가능(extends 키워드 사용),
필드(멤버 변수) 선언 가능, 생성자 가질 수 있음(객체 생성은 불가능(new 사용 불가), but 자식 클래스에서 super()로 호출 가능),
 */

/*Shape rectangle/Circle/Triangle에서 앞에 클래스를 Shape 안쓰고 여기있는 AbstractShape 쓸거면 아래처럼 해야함
괜히 더 복잡해져서 비추

public abstract class AbstractShape extends Shape {
    public AbstractShape(String name) { // 부모클래스에 매개변수를 받는 생성자만 존재하기 때문에 이거 써야함
        super(name);  // 기본 생성자가 없으면 자식 클래스에서 부모 생성자를 반드시 호출해야 함, super(name);
    }


아니면 package models.shape; 에서 
package models.shape; 이렇게 기본 생성자 추가해주면 public abstract class AbstractShape extends Shape 이거만 해줘도 됨
기본 생성자가 있으면 자식 클래스에서 부모 생성자를 명시적으로 호출하지 않아도 자동으로 super();가 호출됨
}*/

public class AbstractShape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b;

        System.out.println("사각형의의 각 변의 길이를 입력해주세요: ");
        a=sc.nextDouble();
        b=sc.nextDouble();
        Shape rectangle = new Rectangle(a, b); //Shpae를 AbstractShape라고 하면 에러남
        System.out.println("사각형의 면적: " + rectangle.getArea());

        System.out.println("삼각형의 한 변의 길이와 높이를 입력해주세요: ");
        a=sc.nextDouble();
        b=sc.nextDouble();
        Shape triangle = new Triangle(a, b);
        System.out.println("삼각형의 면적: " + triangle.getArea());

        System.out.println("원의 반지름을 입력해주세요: ");
        a=sc.nextDouble();
        Shape circle = new Circle(a);
        System.out.println("원의 면적: " + circle.getArea());
    }
}