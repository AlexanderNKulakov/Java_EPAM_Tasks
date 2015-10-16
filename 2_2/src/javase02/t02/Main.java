package javase02.t02;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        Employee employee1 = new Employee("Kulakov");
        employee1.setNumberOfPens(3);
        employee1.setNumberOfPencils(1);
        employee1.setNumberOfErasers(1);

        Employee employee2 = new Employee("Petrov");
        employee2.setNumberOfPens(4);
        employee2.setNumberOfPencils(3);
        employee2.setNumberOfErasers(2);


        out.println("All items price of employee " + employee1.getName() + " is " + employee1.CalculateAllItemsPrice());

        out.println("All items price of employee " + employee2.getName() + " is " + employee2.CalculateAllItemsPrice());



    }
}
