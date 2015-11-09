package javase05.t01;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * Created by akulakov on 06.11.2015.
 */
public class Menu {

    public void printFileMenu(ArrayList<File> files) {

        out.println();
        out.println("Меню:");
        out.println("0. Выйти");

        for( int i = 0; i < files.size(); i++ ) {
            out.println((i+1) + ". Редактировать файл " + files.get(i));
        }

    }

    public void printEditMenu() {
        out.println();
        out.println("Меню:");
        out.println("0. Выйти");
        out.println("0. Редактировать");
    }

    public String chooseFile(ArrayList<File> files) {

        out.println("Выберите пункт меню:");

        try (Scanner scanner = new Scanner(System.in)) {
            int i = scanner.nextInt();

            if (i == 0) {
                return "";
            }

            if (i > 0 && i <= files.size()) {
              //  out.println(files.get(i-1).getPath());
                return files.get(i-1).getPath();
            }

            throw new IndexOutOfBoundsException("Неверный пункт меню");

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String getFileContent(String fileName) {

        StringBuilder fileContent = new StringBuilder();

        char[] buffer = new char[512];

        try( Reader br = new BufferedReader(new FileReader(fileName))) {

            while( br.ready() ) {
                br.read(buffer);
                fileContent.append(buffer);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent.toString();
    }

    public void writeToFile(String fileName, String content) {

        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true)) ) {
            bw.write(content);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
