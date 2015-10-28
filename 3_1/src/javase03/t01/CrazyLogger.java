package javase03.t01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.System.out;
/**
 * Created by akulakov on 27.10.2015.
 */
public class CrazyLogger {

    private StringBuilder stringBuilder;

    public CrazyLogger() {
        stringBuilder = new StringBuilder();
    }

    public void addMessage(String message) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy : HH-mm");
        stringBuilder.append("[" + simpleDateFormat.format(date) + " - " + message + "]");
    }

    public List<String> searchMessage(String searchPhrase) {

        if( searchPhrase.length() == 0 ) return null;

        int positionSearchPhrase = 0;
        int positionStartRecord = 0;
        int positionEndRecord = 0;

        List<String> listResult = new ArrayList<String>();

        try {
            while ((positionSearchPhrase = stringBuilder.indexOf(searchPhrase, positionSearchPhrase)) != -1) {
                positionStartRecord = stringBuilder.lastIndexOf("[", positionSearchPhrase);
                positionEndRecord = stringBuilder.indexOf("]", positionSearchPhrase);
                listResult.add(stringBuilder.substring(positionStartRecord, positionEndRecord + 1));
                positionSearchPhrase = positionEndRecord + 1;
            }
        } catch( StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return listResult;
    }

}
