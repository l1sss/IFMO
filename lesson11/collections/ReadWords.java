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
        System.out.println("ВСЕГО СЛОВ В КНИГЕ: " + words.size());

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
                return - Integer.compare(o1.getKey(), o2.getKey());
            }
        });

        System.out.println("\n ГРУППИРОВКА СЛОВ ПО ДЛИНЕ БУКВ: ");
        for (int i = 0; i < topLength.size(); i++) {
            System.out.println(topLength.get(i));
        }

        //топ букв в %
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        Map<Character, Double> letters = new TreeMap<>();
        for (Character ch : alphabet) {
            letters.put(ch, 0.0);
        }

        int lettersCount = 0;

        for (String word : words) {
            char[] charWord = word.toCharArray();
            for (Character ch : charWord) {
                Double count = letters.get(ch);

                if (count == null) continue;

                letters.put(ch, ++count);
                lettersCount++;
            }
        }

        System.out.println("\nВСЕГО БУКВ В КНИГЕ: " + lettersCount);

        for (Map.Entry<Character, Double> pair : letters.entrySet()) {
            Double count = pair.getValue();
            pair.setValue(count / lettersCount * 100);
        }

        List<Map.Entry<Character, Double>> topLetters = new ArrayList<>(letters.entrySet());
        topLetters.sort((o1, o2) -> - Double.compare(o1.getValue(), o2.getValue()));

        System.out.println("\n ТОП БУКВ:\n");

        for (Map.Entry<Character, Double> pair : topLetters) {
            char letter = pair.getKey();
            double count = pair.getValue();
            System.out.print(letter + "= " + (int)count + "%;  ");
        }
    }
}