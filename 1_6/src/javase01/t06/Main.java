package javase01.t06;


public class Main {

    public static void main(String[] args) {

          Notebook notebook = new Notebook();

          notebook.AddNewRecord("record1");
          notebook.AddNewRecord("record2");
          notebook.AddNewRecord("record3");
          notebook.AddNewRecord("record4");
          notebook.AddNewRecord("record5");

          notebook.PrintTheRecords();
          System.out.println();

          notebook.DeleteTheRecord(3);
          notebook.PrintTheRecords();
          System.out.println();

          notebook.DeleteTheRecord(1);
          notebook.PrintTheRecords();
          System.out.println();

          notebook.EditTheRecord(2, "newrecord!");
          notebook.PrintTheRecords();


    }
}
