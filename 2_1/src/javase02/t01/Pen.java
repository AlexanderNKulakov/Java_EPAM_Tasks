package javase02.t01;

/**
 * Created by akulakov on 09.10.2015.
 */
public class Pen {

    private String producerName;
    private Color color;
    private int price;



    public Pen(String producerName, Color color, int price) {
        this.producerName = producerName;
        this.color = color;
        this.price = price;
    }


    public boolean equals(Object obj) {
        if( this == obj )
            return true;

        if( obj == null )
            return false;

        if( getClass() != obj.getClass() )
            return false;

        Pen pen = (Pen)obj;
        if( producerName != pen.producerName )
            return false;

        if( color != pen.color )
            return false;

        if( price != pen.price )
            return false;

        return true;
    }

    public int hashCode() {
        return price*(color.hashCode()+producerName.hashCode());
    }

    public String toString() {
        return getClass().getName() + "@" + "producerName: " + producerName + ", color: " + color + ", price: " + price;
    }

    protected void Finalize() {
        System.out.println("Finalize");
    }

    public static void setIncreaseCoef(int newIncreaseCoef) {
      //  increaseCoef = newIncreaseCoef;
        //PrintSalary();
    }
}
