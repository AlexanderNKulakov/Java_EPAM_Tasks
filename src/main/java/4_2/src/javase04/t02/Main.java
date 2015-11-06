package javase04.t02;

import static java.lang.System.out;

public class Main {


    public static void main(String[] args) {

        ClassKeyWords classKeyWords = new ClassKeyWords();

        String inputFilename = "D://Java_EPAM_Tasks/src/main/resources/OfficeItem.java";
        String outputFilename = "result.txt";

        classKeyWords.readFileToMap(inputFilename);
        classKeyWords.evaluateCounters();
        classKeyWords.writeMapToFile(outputFilename);

    }
}
