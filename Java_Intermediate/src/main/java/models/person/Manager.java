package models.person;

public class Manager extends Employee {
    private String position;

    public Manager(String name, double salary, String posistion) {
        super(name, salary);
        this.position = posistion;
    }

    public String getPosistion() {
        return position;
    }

    @Override
    public void printInfo(){
        System.out.println("직원의 이름: " + getName() + ", 직책: " + position + ", 급여: " + getSalary() + " 만원");
    }
}
