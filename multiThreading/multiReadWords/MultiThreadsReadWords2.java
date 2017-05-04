package multiThreading.multiReadWords;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by l1s on 04.05.17.
 */
public class MultiThreadsReadWords2 {
    private BlockingQueue<String> lineQueue = new LinkedBlockingQueue<>(); // общая коллекция с заданиями
    private Queue<Map<String, Integer>> resultQueue = new ConcurrentLinkedQueue<>(); //результирующая очередь
    private Map<String, Integer> resultMap = new TreeMap<>(); //результирующая мапа
    private static final String STOP = "STOP"; //стоп маркер

    public static void main(String[] args) throws IOException, InterruptedException {
        long start = System.currentTimeMillis(); //начало работы програмы

        MultiThreadsReadWords2 mt = new MultiThreadsReadWords2();

        File text = new File("/home/l1s/test/wpp.txt");

        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());

        //кол-во ядер = кол-во потоков
        int coreQty = Runtime.getRuntime().availableProcessors();

        List<Worker> threads = new ArrayList<>();
        for (int i = 0; i < coreQty; i++) {
            threads.add(mt.new Worker());
        }

        for (Worker w : threads)
            w.start();

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
                    mt.lineQueue.offer(s.trim().intern());
                }
            }
        }

        mt.lineQueue.offer(STOP);

        for (Worker w : threads)
            w.join();

        // НИЖЕ ПРИВЕДЁН ПРИМЕР УЖАСНОГО КОДА
        for (Map<String, Integer> map : mt.resultQueue) {
            for (String word : map.keySet()) {
                if (mt.resultMap.containsKey(word))
                    mt.resultMap.merge(word, map.get(word), (val1, val2) -> val1 + val2);
                else
                    mt.resultMap.put(word, map.get(word));
            }
        }

        mt.printResults();

        long finish = System.currentTimeMillis();//конец работы программы
        System.out.println("\nВремя выполнения: " + (finish - start));
    }

    private void printResults() {
        List<Map.Entry<String, Integer>> topValues = new ArrayList<>(resultMap.entrySet());
        topValues.sort((o1, o2) -> -Integer.compare(o1.getValue(), o2.getValue()));

        System.out.println("\n TOP 10 слов:");
        for (int i = 0; i < 10; i++)
            System.out.println(topValues.get(i));
    }

    class Worker extends Thread {
        private Map<String, Integer> workerMap = new TreeMap<>();

        @Override
        public void run() {
            while (!isInterrupted()) {
                String word = null;
                try {
                    word = lineQueue.take();

                    if (word.equals(STOP)) {
                        lineQueue.offer(word);
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Integer count = workerMap.get(word);

                if (count == null) count = 0;
                workerMap.put(word, ++count);
            }

            resultQueue.add(workerMap);
        }
    }
}