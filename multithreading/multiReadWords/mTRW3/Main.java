package multithreading.multiReadWords.mTRW3;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by l1s on 10.05.17.
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        MultiThreadsReadWords3 mt = new MultiThreadsReadWords3();

        mt.formatText("/home/l1s/test/wpp.txt");

        int coreQty = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(coreQty);

        for (int i = 0; i < coreQty; i++) {
            mt.getfList().add(pool.submit(mt.new SuperCallable()));
        }

        pool.shutdown();

        mt.futureToMap();

        mt.printResults();

        long finish = System.currentTimeMillis();
        System.out.println("TimeCounter: " + (finish - start));
    }
}