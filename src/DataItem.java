public class DataItem {
    private int data;                  // Данные

    /**
     * Конструктор для инициализации данных нашей таблицы
     * @param data сами данные, которые будут в записи
     */
    public DataItem(int data) {
        this.data = data;
    }

    /**
     * Аксессор(геттеры)
     * @return значение поля таблицы
     */
    public int getData() {
        return data;
    }
}
