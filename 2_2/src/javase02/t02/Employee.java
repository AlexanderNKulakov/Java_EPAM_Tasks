package javase02.t02;

import static java.lang.System.out;
/**
 * Created by akulakov on 14.10.2015.
 */
public class Employee {
    private String name;
    private int numberOfPens;
    private int numberOfPencils;
    private int numberOfErasers;

    public Employee(String name) {
        this.name = name;
    }


    public void setNumberOfPens(int numberOfPens) {
        this.numberOfPens = numberOfPens;
    }

    public void setNumberOfPencils(int numberOfPencils) {
        this.numberOfPencils = numberOfPencils;
    }

    public void setNumberOfErasers(int numberOfErasers) {
        this.numberOfErasers = numberOfErasers;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPens() {
        return numberOfPens;
    }

    public int getNumberOfPencils() {
        return numberOfPencils;
    }

    public int getNumberOfErasers() {
        return numberOfErasers;
    }

    public int CalculateAllItemsPrice() {
        return numberOfPens*Pen.price + numberOfPencils*Pencil.price + numberOfErasers*Eraser.price;
    }


}
