package multithreading.multiReadWords;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class MultiThreadsReadWords {
    // Создаем общую коллекцию для всех потоков
    private Map<String, Integer> resultMap = new TreeMap<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();

        MultiThreadsReadWords mt = new MultiThreadsReadWords();

        // Создаем файл, указывая путь к текстовому файлу на диске
        File text = new File("/home/l1s/test/wpp.txt");

        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());

        //кол-во ядер, которые будут использованы потоками
        int coreQty = Runtime.getRuntime().availableProcessors();

        //коллекция потоков
        List<T> threads = new ArrayList<>();
        for (int i = 0; i < coreQty; i++) {
            threads.add(mt.new T());
        }

        int it = 0;

        for (String line : lines) {
            // Для каждой строки
            String[] wordSplit =
                    line.toLowerCase() // Переводим в нижний регистр
                            .replaceAll("\\p{Punct}", " ") // Заменяем все знаки на пробел
                            .trim() // Убираем пробелы в начале и конце строки.
                            .split("\\s"); // Разбиваем строки на слова

            for (String s : wordSplit) {
                // Выбираем только непустые слова.
                if (s.length() > 0) {
                    threads.get(it).addWord(s.intern());
                    it++;
                    if (it > coreQty - 1) it = 0;
                }
            }
        }

        for (T t : threads)
            t.start();

        for (T t : threads)
            t.join();

        mt.printResults();

        long finish = System.currentTimeMillis();
        System.out.println("\nВремя выполнения: " + (finish - start));
    }

    private synchronized void addResults(Map<String, Integer> map) {
        for (String word : map.keySet()) {
            if (resultMap.containsKey(word))
                resultMap.merge(word, map.get(word), (val1, val2) -> val1 + val2);
            else
                resultMap.put(word, map.get(word));
        }
    }

    private synchronized void printResults() {
        List<Map.Entry<String, Integer>> topValues = new ArrayList<>(resultMap.entrySet());
        topValues.sort((o1, o2) -> -Integer.compare(o1.getValue(), o2.getValue()));

        System.out.println("\n TOP 10 слов:");
        for (int i = 0; i < 10; i++)
            System.out.println(topValues.get(i));
    }

    class T extends Thread {
        private Map<String, Integer> topWords = new TreeMap<>();
        private List<String> words = new ArrayList<>();

        public Map<String, Integer> getTopWords() {
            return topWords;
        }

        @Override
        public void run() {
            for (String word : words) {
                Integer count = topWords.get(word);

                if (count == null) count = 0;

                topWords.put(word, ++count);
            }

            addResults(topWords);
        }

        public void addWord(String word) {
            words.add(word);
        }
    }
}
