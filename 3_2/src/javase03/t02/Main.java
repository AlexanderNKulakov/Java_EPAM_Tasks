package javase03.t02;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.*;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input;
        out.println("Please, choose the language:");
        out.println("1. Eng");
        out.println("2. Rus");
        Locale locale = Locale.getDefault();
        String filename;

        input = scanner.nextInt();
        if( input == 1 ) {
            locale = new Locale("en");
            filename = "javase03.t02.AppResourceEn";
        }
        else {
            locale = new Locale("ru");
            filename = "javase03.t02.AppResourceRu";
        }

        ResourceProperty resourceProperty = new ResourceProperty(filename, locale);

        out.println("A list of questions:");
        Object[] arrayKeys = resourceProperty.getKeys().toArray();
        for( int i = 0; i < arrayKeys.length; i++ )
            out.println(i+1 + ". " + arrayKeys[i]);
   //     for( Object key : setKeys)
     //       out.println(key);

        out.println("Please, select the question:");
        input = scanner.nextInt();
        out.println("The answer:");
        out.println(resourceProperty.getValue((String)arrayKeys[input-1]));

    }
}
