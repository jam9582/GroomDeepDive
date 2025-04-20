package application;

/*
직원 클래스를 작성하고, 이름과 급여를 저장하는 멤버 변수를 가집니다.
관리자 클래스를 작성하고, 직원 클래스를 상속받습니다.
관리자의 직책을 저장하는 멤버 변수를 추가합니다.
직원 클래스와 관리자 클래스에서 오버라이딩된 메서드를 호출하여 결과를 출력합니다.
결과물로 직원과 관리자 객체를 생성하고 오버라이딩된 메서드를 호출하여 출력하는 스크린샷을 제출합니다.
 */

import models.person.*;

public class EmployeeManager {
    public static void main(String[] args) {
        Employee employee = new Employee(" 권재은", 30.0);
        Manager manager = new Manager("미래의 권재은", 1000.0, "멋쟁이 관리자");
        employee.printInfo();
        manager.printInfo();
    }
}
