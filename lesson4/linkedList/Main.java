package lesson4.linkedList;

/**
 * Created by l1s on 22.03.17.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.add("Кирилл");
        list1.add("любит");
        list1.add("есть");
        list1.add("в");
        list1.add("Маке");
        list1.print();

        System.out.println();

        LinkedList list2 = new LinkedList();
        list2.add("Кирилл");
        list2.add("любит");
        list2.add("в");
        list2.add("есть");
        list2.add("Маке");
        list2.print();

        System.out.println();

        System.out.println(list1.hashCode() == (list2.hashCode()));
    }
}
