package lesson3;

public class Task26b {
    public static void main(String[] args) {
        String stext = "Hello world!";
        String skey = "secretKey";

        byte[] btext = stext.getBytes();
        byte[] bkey = skey.getBytes();

        crypt(btext, bkey);
        System.out.println(new String(btext));
        crypt(btext, bkey);
        System.out.println(new String(btext));
    }

    public static void crypt(byte[] txt, byte[] key) {
        for (int i = 0; i < txt.length; i++) {
            txt[i] ^= key[i % key.length];
        }
    }
}
