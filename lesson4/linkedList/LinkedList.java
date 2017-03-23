package lesson4.linkedList;

/**
 * Created by l1s on 22.03.17.
 */
public class LinkedList {
    Item head;//начало

//создание списка
    public void add(String s) {
        if(head == null)//если головы нет,
            head = new Item(s);//то созданный элемент будет головой списка
        else {
            Item last = head;//если голова есть, шагаем от головы
            while (true) {
                if (last.next() != null) last = last.next();//если следующего элемента нет,
                else break;                                 //значит мы реально в последнем элементе
            }
            last.next = new Item(s);//наш новый итем встаёт на первое пустое место
        }
    }

    public String get(int x) {
        Item tmp = head;//считаем от головы
        for (int i = 0; i < x; i++) {
            tmp = tmp.next;
        }
        return tmp.getValue();
    }


}
