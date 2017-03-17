package lesson3;
/*
Шифровка XOR'ом
 */
public class Task26 {
    public static void main(String[] args) {
        String text = "hello";
        byte key = 42;

        byte[] bytes = text.getBytes();

        crypt(bytes, key);

        System.out.println(new String(bytes));

        crypt(bytes, key);

        System.out.println(new String(bytes));
    }

    public static void crypt(byte[] bytes, byte key) {
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] ^= key;
        }
    }
}
