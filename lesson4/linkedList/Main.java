package lesson4.linkedList;

/**
 * Created by l1s on 22.03.17.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("Кирилл");
        list.add("не");
        list.add("любит");
        list.add("есть");
        list.add("в");
        list.add("Маке");
        list.remove("не");
        list.print();
    }
}
