package javase01.t06;

/**
 * ����� ������ � ��������.
 * �������� ���� String ��� �������� ������ � ���� ������ �� ���� ���� ��� ���������� ����������������� ������
  * @author akulakov
 */
public class RecordInTheNotebook {
    private String s;
    public RecordInTheNotebook next;

    public void setString(String s) {
        this.s = s;
    }

    public String getString() {
        return s;
    }
}
