import java.util.ArrayList;
//TODO Нужны методы: для отображения всех элементов, для вставки и удаления элемента и сам hash
public class HashTable {

    private DataItem[] hashArray;                           // Декларирую(объявляю) массив, для хранения значение таблицы
    private int size;                                       // Размер массива, хранящего значения
    private DataItem nonItem;                               // Удаленный элемент. ЗАМЕЧАНИЕ В КНИГЕ ОПЕЧАТКА - ЭТУ ПЕРЕМЕННУЮ ПРОПУСТИЛИ

    /**
     * Конструктор для создания таблицы
     * @param size - размер самой таблицы
     */
    public HashTable(int size) {
        this.size = size;
        hashArray = new DataItem[size];
        nonItem = new DataItem(-1);                        // Ключ удаленного элемента(в книге его пропустили)
    }

    public void displayTable(){
        System.out.println("Таблица: ");
        for (int i = 0; i < size; i++) {
            if(hashArray[i] == null){
                System.out.println("Element is null");
            }
            else {
                System.out.println(hashArray[i].getData() + " ");
            }
        }
    }

    private int hashFunc(int key){
        return key%size;                                    // Возвращаем хеш ключа, путем вычисления остатка от деления ключа на размер таблицы(массива)
    }

    /**
     * Вставка в таблицу элемента
     * @param dataItem вставляемый элемент
     */
    public void insert(DataItem dataItem){
        int data = dataItem.getData();                      // Получаем вставляемый элемент - его значение для хеширования
        int hashValue = hashFunc(data);                     // хешируем вставляемый элемент
        while (hashArray[hashValue] != null &&              // Проверяем до тех пор, пока не найдем свободную позицию, т.к. которая равна null или равна -1(т.е. помечена как удаленная
                hashArray[hashValue].getData() !=- 1){
            ++hashValue;                                    // Если элемент занят, меняем(увеличиваем на 1) ключ элемента
            hashValue %= size;                              // Присваиваем хешу, новое значение(остаток от деления на размер массива, но уже увеличенного ранее элемента)
        }
        hashArray[hashValue] = dataItem;                    // Вставляем элемент в вычисленную позицию
    }

    /**
     * Метод удаляет элемент, удаляет, если нашел
     * @param key удаляемое значение
     * @return значение удаленного элемента или null
     */
    public DataItem delete(int key){
        int hashValue = hashFunc(key);                      // Получаем хеш, удаляемого значения
        while (hashArray[hashValue] != null){               // Проходим по массиву, пока нейдем пустой элемент
            if (hashArray[hashValue].getData() == key) {    // Получаем из массива значение его элемента и сравниваем с удаляемым
                DataItem temp = hashArray[hashValue];       // Если совпали элементы, запоминаем элемент, чтобы его вернуть
                hashArray[hashValue] = nonItem;             // Помечаем элемент как nonItem(удаляенный)
                return temp;                                // Возвращаем удаленный элемент
            }
            ++hashValue;                                    // Если не совпало значение, увеличиваем увеличиваем элемент на 1
            hashValue %=size;                               // и находим его новый хеш(остаток от деления нового значения на размер массива)
        }
         return null;                                       // Если ничего не нашли, возвращаем null
    }

    /**
     * Метод ищет элемент в таблице
     * @param key искомый элемент
     * @return найденный элемент или null
     */
    public DataItem find(int key){
        int hashValue = hashFunc(key);                     // Находим хеш-значение
        while (hashArray[hashValue] != null){              // В цикле проверяем все элементы неравные null
            if(hashArray[hashValue].getData() == key){     // Если элемент равен искомому значению, возвразаем его
                return hashArray[hashValue];
            }
            else {
                ++hashValue;                               // Если нет, то увеличиваем на единицу и ищем новый хеш
            }
            hashValue %= size;                             // Находим сам хеш
        }
        return null;                                       // Если ничего не нашли, возвращаем null
    }

}
