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

        String path = "D:\\testfolder";
    //   String path = "D:\\testfolder\\file1.txt";


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

//        out.println(files.get(1));


        Scanner scanner = new Scanner(System.in);

        out.println();
        out.println("Меню:");
        out.println("0. Выйти");
        for( i = 0; i < files.size(); i++ ) {
            out.println((i+1) + ". Редактировать файл " + files.get(i));
        }
        out.println("Выберите пункт меню:");

        int input = 0;
        while (scanner.hasNextInt()) {

            input = scanner.nextInt();
            if (input == 0) {

//                logic.writeSerializedData(films, file3Name);
                break;
            }
            if( input > 0 && input <= files.size() ) {
                out.println(files.get(i-1));
                break;
            }
        }

     //   out.println(files);

        String path2 = "D:\\testfolder\\file1.txt";
        char[] buffer = new char[512];
        try( Reader r = new FileReader(path2)) {
            out.println("Прочитано " + r.read(buffer));
            out.println(buffer);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
