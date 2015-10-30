package javase04.t01;

import java.io.FileWriter;
import java.io.IOException;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        try {


            F
            FileWriter fileWriter = new FileWriter("out.txt");

            fileWriter.write("string1");
            fileWriter.write("string2");

            fileWriter.close();


        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
