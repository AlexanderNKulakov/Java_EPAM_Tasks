package javase01.t06;

import java.util.Objects;

/**
 * Класс Блокнот.
 * Реализует динамический массив на основе однонаправленного списка, эффективен при частых удалениях записей в начале списка.
 * Порядковые номера записей вычисляются в процессе обхода списка.
 */
public class Notebook {

    private int size;
    private RecordInTheNotebook start;
    private RecordInTheNotebook last;

    /**
     * Конструктор класса Блокнот.
     */
    public Notebook() {
          size = 0;
    }

    /**
     * Добавляет новую запись в блокнот
     * @param str Строка, которую нужно добавить
     */
    public void AddNewRecord(String str) {
        if( start == null ) {
            start = new RecordInTheNotebook();
            last = start;
            last.setString(str);
        }
        else {
            last.next = new RecordInTheNotebook();
            last = last.next;
            last.setString(str);
        }
        size++;
    }

    /**
     * Удаляет запись из блокнота по ее порядкову номеру.
     * Так как номера записей не хранятся в списке, а вычисляются в процессе обхода, не нужно их пересчитывать.
     * @param index порядковый номер записи
     */
    public void DeleteTheRecord(int index) {
        if( index < 1 || index > size ) {
            System.out.println("Unable to delete: the number of record is out of range");
            return;
        }

        if( index == 1 ) {
            start = start.next;
            return;
        }

        RecordInTheNotebook current = start;
        int i = 1;
        while( i++ != index-1 ) {
            current = current.next;
        }

        current.next = current.next.next;
        size--;
    }

    /**
     * Редактирует запись в блокноте
     * @param index Порядковый номер записи, которую нужно отредактировать
     * @param newStr Новое значение записи
     */
    public void EditTheRecord(int index, String newStr) {
        if( index < 1 || index > size ) {
            System.out.println("Unable to edit: the number of record is out of range");
            return;
        }

        RecordInTheNotebook current = start;
        int i = 1;
        while( i++ != index ) {
            current = current.next;
        }
        current.setString(newStr);
    }


    /**
     * Выводит на экран все записи в блокноте.
     * Порядковый номер записи вычисляется в процессе обхода списка
     */
    public void PrintTheRecords() {
        RecordInTheNotebook current;
        int i = 1;

        for( current = start; current != null; current = current.next ) {
            System.out.println(i++ + " " + current.getString());
        }
    }
}
