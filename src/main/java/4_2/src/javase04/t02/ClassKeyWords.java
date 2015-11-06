package javase04.t02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

/**
 * Created by akulakov on 01.11.2015.
 */
public class ClassKeyWords {

    private Map<String,Integer> mapKeyWords;

    private StringBuilder inputData;

    public ClassKeyWords() {

        inputData = new StringBuilder();

        mapKeyWords = new HashMap<String,Integer>();
        mapKeyWords.put("abstract", 0);
        mapKeyWords.put("continue", 0);
        mapKeyWords.put("enum", 0);
        mapKeyWords.put("for", 0);
        mapKeyWords.put("instanceof", 0);
        mapKeyWords.put("new", 0);
        mapKeyWords.put("public", 0);
        mapKeyWords.put("return", 0);
        mapKeyWords.put("switch", 0);
        mapKeyWords.put("transient", 0);
        mapKeyWords.put("catch", 0);
        mapKeyWords.put("extends",0);
        mapKeyWords.put("int", 0);
        mapKeyWords.put("package", 0);
        mapKeyWords.put("short", 0);
        mapKeyWords.put("synchronized", 0);
        mapKeyWords.put("try", 0);
        mapKeyWords.put("boolean",0);
        mapKeyWords.put("char", 0);
        mapKeyWords.put("do", 0);
        mapKeyWords.put("final", 0);
        mapKeyWords.put("if", 0);
        mapKeyWords.put("interface", 0);
        mapKeyWords.put("private", 0);
        mapKeyWords.put("this", 0);
        mapKeyWords.put("void", 0);
        mapKeyWords.put("break", 0);
        mapKeyWords.put("class", 0);
        mapKeyWords.put("double", 0);
        mapKeyWords.put("finally", 0);
        mapKeyWords.put("implements", 0);
        mapKeyWords.put("long", 0);
        mapKeyWords.put("protected", 0);
        mapKeyWords.put("strictfp", 0);
        mapKeyWords.put("throw", 0);
        mapKeyWords.put("throws", 0);
        mapKeyWords.put("volatile", 0);
        mapKeyWords.put("byte", 0);
        mapKeyWords.put("const", 0);
        mapKeyWords.put("else", 0);
        mapKeyWords.put("float", 0);
        mapKeyWords.put("import", 0);
        mapKeyWords.put("native", 0);
        mapKeyWords.put("public", 0);
        mapKeyWords.put("super", 0);
        mapKeyWords.put("while",0);
        mapKeyWords.put("static", 0);
    }

    public void readFileToMap(String inputFilename) {

        try ( Reader br = new BufferedReader(new FileReader(inputFilename)) ) {

            char[] buffer = new char[512];

            while( br.ready() ) {

                out.println("Прочитано " + br.read(buffer) + " байт");
                inputData.append(buffer);

            }
        } catch (IOException e) {
            out.println("Ошибка ввода/вывода: " + e.toString());
        }
    }


    public void evaluateCounters() {

        Pattern pattern;
        Matcher matcher;
        String currentKey;
        int counter = 0;

        for( Map.Entry<String,Integer> entry : mapKeyWords.entrySet()  ) {

            //   out.println(entry.getKey() + " " + entry.getValue());
            currentKey = entry.getKey();
            pattern = Pattern.compile(currentKey);
            matcher = pattern.matcher(inputData);

            counter = 0;

            while (matcher.find()) {
                counter++;
            }

            mapKeyWords.put(currentKey, counter);
        }
    }

    public void writeMapToFile(String outputFilename) {

        String record = null;

        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilename)) ) {

            for(Map.Entry<String,Integer> entry : mapKeyWords.entrySet() ) {

                if( entry.getValue() > 0 ) {
                    record = entry.getKey() + " " + entry.getValue() + "\n";
                    bw.write(record);
                }
            }

            out.print("The result has been writen succesfully");

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
