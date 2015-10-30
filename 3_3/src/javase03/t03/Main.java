package javase03.t03;

import static java.lang.System.out;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void printTokens(String[] tokens) {
        for( String str : tokens )
            out.print(str + "|");
    }

    public static void main(String[] args) {

        String inputString = "гамма-коллапсары образуют семь гамма-трубок (Рис. 3), в каждой из семи гамма-трубок по семь элементарных трубок, всего в электроне (позитроне) 49 элементарных трубок, сорок девятая трубка расположена в центре. Последовательное электрическое взаимодействие элементарных (кулоновских) зарядов противоположного знака полярности в коллапсарах называется элементарными трубками.</div>\n" +
                "<div>Один положительный и один отрицательный элементарные (кулоновские) заряды ";

    //    Pattern p = Pattern.compile(".+Рис. \\d.+");
        Pattern p = Pattern.compile("Рис. \\d");
     //   Matcher m = p.matcher("gfghf папа па Рис. 1 парп роп о Рис. 2 рпроо р");
        printTokens(p.split(inputString));
    //    out.println(m.matches());
     //   out.println(m.find());
       // out.println(m.groupCount());
      //  out.println(m.regionEnd());
    }
}
