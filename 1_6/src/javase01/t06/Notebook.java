package javase01.t06;

import java.util.Objects;

/**
 * ����� �������.
 * ��������� ������������ ������ �� ������ ����������������� ������, ���������� ��� ������ ��������� ������� � ������ ������.
 * ���������� ������ ������� ����������� � �������� ������ ������.
 */
public class Notebook {

    private int size;
    private RecordInTheNotebook start;
    private RecordInTheNotebook last;

    /**
     * ����������� ������ �������.
     */
    public Notebook() {
          size = 0;
    }

    /**
     * ��������� ����� ������ � �������
     * @param str ������, ������� ����� ��������
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
     * ������� ������ �� �������� �� �� ��������� ������.
     * ��� ��� ������ ������� �� �������� � ������, � ����������� � �������� ������, �� ����� �� �������������.
     * @param index ���������� ����� ������
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
     * ����������� ������ � ��������
     * @param index ���������� ����� ������, ������� ����� ���������������
     * @param newStr ����� �������� ������
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
     * ������� �� ����� ��� ������ � ��������.
     * ���������� ����� ������ ����������� � �������� ������ ������
     */
    public void PrintTheRecords() {
        RecordInTheNotebook current;
        int i = 1;

        for( current = start; current != null; current = current.next ) {
            System.out.println(i++ + " " + current.getString());
        }
    }
}
