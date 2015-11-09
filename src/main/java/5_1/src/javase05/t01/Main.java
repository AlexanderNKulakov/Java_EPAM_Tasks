package javase05.t01;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        String path = "E:\\testfolder";

        File folder = new File(path);

        ArrayList<File> files = new ArrayList<File>();

        out.println("Список файлов в папке " + path);
        int i = 1;
        // Если это каталог
        if (folder.isDirectory()) {
            for (File f : folder.listFiles()) {
                out.println(i + ". " + f.toString());
                files.add(f);
                i++;
            }
        }



        Menu menu1 = new Menu();

        menu1.printFileMenu(files);

        String fileNameChosen = menu1.chooseFile(files);

        out.println("Содержимое файла: " + fileNameChosen + ":");
        out.println(menu1.getFileContent(fileNameChosen));

        menu1.writeToFile(fileNameChosen,"new data");
        //   out.println(files);


    }
}
