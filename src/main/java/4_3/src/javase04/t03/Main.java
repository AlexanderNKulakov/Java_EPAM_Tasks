package javase04.t03;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;


public class Main {

    public static void main(String[] args) throws Exception {

        String inputFilename = "D://Java_EPAM_Tasks/src/main/resources/input.txt";
        String outputFilename = "result.txt";

    //    StringBuilder inputData = new StringBuilder();
        String data = null;

        Scanner scanner = new Scanner( new FileReader(inputFilename));
        data = scanner.next();

        out.println(data);
        scanner.close();

        /*
        try (Reader r = new FileReader(inputFilename) ) {
   //     try (Reader r = BufferedReader(
        //        new InputStreamReader(
        //             new FileInputStream(inputFilename) ) ) ) {

 //              char[] buffer = new char[512];

//            while( r.ready() ) {
  //              out.println("Прочитано " + r.read(buffer) + " байт");
    //            inputData.append(buffer);
            }
        } catch (IOException e) {
            out.println("Ошибка ввода/вывода: " + e.toString());
        }
*/
      //  out.println(inputData.toString());


    //    String str = new String("test тест");

        try ( Writer w = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(outputFilename), "UTF-16") ) )  {

            w.write("тест test");

        } catch (IOException e) {
            out.println("Ошибка ввода/вывода: " + e.toString());
        }
    }

}
