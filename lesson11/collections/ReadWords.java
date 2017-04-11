package lesson11.collections;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/**
 * Created by xmitya on 07.04.17.
 */
public class ReadWords {
    public static void main(String[] args) throws IOException {
        // Создаем файл, указывая путь к текстовому файлу на диске
        File text = new File("/home/l1s/test/wp.txt");

        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());

        // Создаем пустую коллекцию для слов.
        List<String> words = new ArrayList<>();

        for (String line : lines) {
            // Для каждой строки
            String[] wordSplit =
                    line.toLowerCase() // Переводим в нижний регистр
                            .replaceAll("\\p{Punct}", " ") // Заменяем все знаки на пробел
                            .trim() // Убираем пробелы в начале и конце строки.
                            .split("\\s"); // Разбиваем строки на слова

            for (String s : wordSplit) {
                // Выбираем только непустые слова.
                if (s.length() > 0)
                    words.add(s.trim());
            }
        }

        //считаем кол-во слов в книге
        System.out.println("ВСЕГО СЛОВ: " + words.size());

        //топ n слов, которые встречаются чаще всего
        Map<String, Integer> topWords = new TreeMap<>();

        for (String word : words) {
            Integer count = topWords.get(word);

            if (count == null) count = 0;

            topWords.put(word, ++count);
        }

        //сортируем наши пары (слово, кол-во повторений)
        List<Map.Entry<String, Integer>> topValues = new ArrayList<>(topWords.entrySet());
        topValues.sort((o1, o2) -> -Integer.compare(o1.getValue(), o2.getValue()));

        System.out.println("\n TOP 10 слов:");
        for (int i = 0; i < 10; i++) {
            System.out.println(topValues.get(i));
        }

        //группируем слова по их длине
        Map<Integer, Set<String>> wordsLength = new TreeMap<>();
        for (String s : words) {
            Set<String> set = wordsLength.get(s.length());

            if (set == null)
                set = new TreeSet<>();

            set.add(s);

            wordsLength.put(s.length(), set);
        }

        List<Map.Entry<Integer, Set<String>>> topLength = new ArrayList<>(wordsLength.entrySet());
        topLength.sort(new Comparator<Map.Entry<Integer, Set<String>>>() {
            @Override
            public int compare(Map.Entry<Integer, Set<String>> o1, Map.Entry<Integer, Set<String>> o2) {
                return -Integer.compare(o1.getKey(), o2.getKey());
            }
        });

        System.out.println("\n ГРУППИРОВКА СЛОВ ПО ДЛИНЕ БУКВ: ");
        for (int i = 0; i < topLength.size(); i++) {
            System.out.println(topLength.get(i));
        }
    }
}