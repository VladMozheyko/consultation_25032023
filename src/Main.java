
public class Main {

    /*
    План занятия
    1) НashTable
     */

    /*
    Теория
    Hash-функция - функция, которая возвращает численное представление объекта
    Map(Словарь) - множество содержащее в себе пары ключ-значение, т.е. по ключу можно получить значение
    HashMap - словарь, в котором хешируются ключи
     */
    int a;

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.insert(new DataItem(1));          // Вставка элемента в таблицу
        hashTable.displayTable();
        hashTable.insert(new DataItem(9));
        hashTable.displayTable();
        hashTable.delete(1);
        hashTable.displayTable();
        hashTable.insert(new DataItem(11));
        hashTable.displayTable();

        System.out.println("Элемент: "+hashTable.find(11).getData());
        hashTable.insert(new DataItem(11));
        hashTable.displayTable();

        
    }






}
