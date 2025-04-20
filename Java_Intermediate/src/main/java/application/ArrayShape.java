package application;

/*
도형 클래스를 작성하고, 도형의 종류와 면적을 저장하는 멤버 변수를 가집니다.
다양한 도형 객체(원, 사각형, 삼각형 등)를 생성하고 도형 배열에 저장합니다.
도형 배열의 각 도형 객체에 대해 면적을 계산하여 출력합니다.
결과물로 다양한 도형 객체를 생성하고 배열에 저장한 뒤, 각 도형의 면적을 출력하는 스크린샷을 제출합니다.
 */

import models.shape.*;

import java.util.Scanner;


public class ArrayShape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Shape[] array = new Shape[3];

        System.out.println("원의 반지름을 입력해주세요: ");
        double a = sc.nextDouble();
        double b = 0;
        array[0] = new Circle(a);

        System.out.println("사각형의 두 변의 길이를 입력해주세요: ");
        a = sc.nextDouble();
        b = sc.nextDouble();
        array[1] = new Rectangle(a, b);

        System.out.println("삼각형의 한 변과 높이를 입력해주세요: ");
        a = sc.nextDouble();
        b = sc.nextDouble();
        array[2] = new Triangle(a, b);

        for (Shape i : array){
            System.out.println(i.getName() + "의 면적은 " + i.getArea());
        }
        sc.close();
    }
}
