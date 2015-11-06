package javase04.t01;


import src.javase04.t01.ClassKeyWords;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;


public class Main {

    public static void main(String[] args) {

        ClassKeyWords classKeyWords = new ClassKeyWords();

        String inputFilename = "D://Java_EPAM_Tasks/src/main/resources/OfficeItem.java";
        String outputFilename = "result.txt";
        classKeyWords.work(inputFilename, outputFilename);

    }
}
