package javase04.t04;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Main {

    public SortedSet<Film> readSerializedData(String fileName) {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)) ) {

            return (SortedSet<Film>)ois.readObject();

        }catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void writeSerializedData(SortedSet<Film> dataToWrite, String fileName) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(dataToWrite);
            out.println("Коллекция успешно сохранена.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {


        Actor actor1 = new Actor("Alexander","Kulakov");
        Actor actor2 = new Actor("Sergey","Petrov");
        Actor actor3 = new Actor("Aleksey","Sidorov");

        Film film1 = new Film("StarWars");
        film1.addActor(actor1);
        film1.addActor(actor2);

        Film film2 = new Film("KingKong");
        film2.addActor(actor2);
        film2.addActor(actor3);


        SortedSet<Film> films = new TreeSet<Film>(new FilmComparator());
        films.add(film1);
        films.add(film2);


        Main logic = new Main();
        String fileName = "serialize.txt";

    //    SortedSet<Film> data = logic.readSerializedData(fileName);
     //   out.println("Текущее состояние коллекции:");
     //   out.println(data);

        Scanner scanner = new Scanner(System.in);

        out.println("0. Выйти и сохранить");

        Iterator<Film> iterator = films.iterator();
        int i = 1;
        while(iterator.hasNext()) {
            Film film = iterator.next();
            out.println(i++ + ". Редактировать запись " + film.toString());
        }

        int input = 0;
        while (scanner.hasNextInt()) {

            input = scanner.nextInt();
            if (input == 0) {

                logic.writeSerializedData(films, fileName);
                break;
            }
        }

    //    Actor actor4 = new Actor("Mihail", "Lagunov");
     //   film1.addActor(actor4);

    }
}
