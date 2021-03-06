package simpletasks;

/*
В американской армии считается несчастливым число 13, а в японской — 4. Перед
международными учениями штаб российской армии решил исключить номера боевой
техники, содержащие числа 4 или 13 (например, 40123, 13313, 12345 или 13040), чтобы не
смущать иностранных коллег. Если в распоряжении армии имеется 100 тыс. единиц боевой
техники и каждая боевая машина имеет номер от 00001 до 99999, то сколько всего номеров
придётся исключить?
 */
public class Task25 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 4; i < 99_999 ; i++) {
            int n1 = i % 10;
            int n2 = i / 10 % 10;
            int n3 = i / 100 % 10;
            int n4 = i / 1000 % 10;
            int n5 = i / 10_000 % 10;
            if (n1 == 4 || n2 == 4 || n3 == 4 || n4 == 4 || n5 == 4)
                count++;
            if(n2 == 1 && n1 == 3 || n3 == 1 && n2 == 3 || n4 == 1 && n3 == 3 || n5 == 1 && n4 == 3)
                count++;
        }
        System.out.println("Число исключенных номеров = " + count); //44921
    }
}
