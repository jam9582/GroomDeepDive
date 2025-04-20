package models.person;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary){
        this.name=name;
        this.salary=salary;
    }

    // alt + insert: 생성자, getter/setter 바로 만들기
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void printInfo(){
        System.out.println("직원의 이름: " + name + ", 급여: " + salary + " 만원");
    }


}
