package javase01.t06;

/**
 * Класс Запись в блокноте.
 * Содержит поле String для хранения записи и поле ссылку на само себя для реализации однонаправленного списка
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
