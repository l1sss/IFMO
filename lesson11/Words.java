package lesson11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by l1s on 08.04.17.
 */
public class Words {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/l1s/test/words.txt");
        List<String> lines = Files.readAllLines(file.toPath());

        Set<String> words = new HashSet<>();

        for (String tmp : lines) {
            for (String word : tmp.split(" ")) {
                words.add(word);
            }
        }

        for (String s : words) {
            System.out.println(s);
        }
    }
}
