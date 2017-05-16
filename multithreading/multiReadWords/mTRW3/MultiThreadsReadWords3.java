package multithreading.multiReadWords.mTRW3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by l1s on 04.05.17.
 */
public class MultiThreadsReadWords3 {
    private Map<String, Integer> resultMap = new TreeMap<>(); //результирующая мапа
    private BlockingQueue<String> lineQ = new LinkedBlockingQueue<>();
    private List<Future<Map<String, Integer>>> fList = new ArrayList<>();
    private static final String STOP = "STOP"; //стоп маркер

    public List<Future<Map<String, Integer>>> getfList() {
        return fList;
    }

    public void formatText(String path) throws IOException {

        File text = new File(path);
        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());

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
                    lineQ.offer(s.trim().intern());
                }
            }
        }

        lineQ.offer(STOP);
    }

    public void printResults() {
        List<Map.Entry<String, Integer>> topValues = new ArrayList<>(resultMap.entrySet());
        topValues.sort((o1, o2) -> -Integer.compare(o1.getValue(), o2.getValue()));

        System.out.println("\n TOP 10 слов:");
        for (int i = 0; i < 10; i++)
            System.out.println(topValues.get(i));
    }

    public void futureToMap() throws ExecutionException, InterruptedException {
        for(Future<Map<String, Integer>> map : fList){
            addResults(map.get());
        }
    }

    private synchronized void addResults(Map<String, Integer> map) {
        for (String word : map.keySet()) {
            if (resultMap.containsKey(word))
                resultMap.merge(word, map.get(word), (val1, val2) -> val1 + val2);
            else
                resultMap.put(word, map.get(word));
        }
    }

    public class SuperCallable implements Callable<Map<String, Integer>> {
        private Map<String, Integer> workerMap = new TreeMap<>();

        @Override
        public Map<String, Integer> call() {
            while (true) {
                String word = null;
                try {
                    word = lineQ.take();

                    if (word.equals(STOP)) {
                        lineQ.offer(word);
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Integer count = workerMap.get(word);

                if (count == null) count = 0;
                workerMap.put(word, ++count);
            }
            return workerMap;
        }
    }
}