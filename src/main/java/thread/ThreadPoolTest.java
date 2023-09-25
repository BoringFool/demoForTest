package thread;

import common.ClassA;
import jdk.internal.org.objectweb.asm.commons.RemappingClassAdapter;

import java.lang.management.ThreadInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolTest {
    public static volatile int a = 0;
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        AtomicInteger var = new AtomicInteger(0);

//        ExecutorService service = Executors.newFixedThreadPool(2);
        ExecutorService service = new ThreadPoolExecutor(10, 10, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        ArrayList<CompletableFuture<String>> completableFutures = new ArrayList<>();




        CompletableFuture<String> stringCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            ThreadLocalVar.t.set(String.valueOf(var.getAndIncrement()));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ThreadLocalVar.t.get();
        }, service);

        completableFutures.add(stringCompletableFuture1);
        Thread thread = new Thread(() -> {
            ThreadLocalVar.t.set(String.valueOf(var.getAndIncrement()));
            String tt = ThreadLocalVar.t.get();

            CompletableFuture<String> stringCompletableFuture10 = CompletableFuture.supplyAsync(() -> {
                ThreadLocalVar.t.set(tt);
                try {
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return ThreadLocalVar.t.get();
            }, service);

            completableFutures.add(stringCompletableFuture10);
        });
        thread.start();



        CompletableFuture<String> stringCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
            ThreadLocalVar.t.set(String.valueOf(var.getAndIncrement()));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ThreadLocalVar.t.get();
        }, service);
        completableFutures.add(stringCompletableFuture2);

        CompletableFuture<String> stringCompletableFuture3 = CompletableFuture.supplyAsync(() -> {
            ThreadLocalVar.t.set(String.valueOf(var.getAndIncrement()));
            try {
                Thread.sleep(11000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ThreadLocalVar.t.get();
        }, service);
        completableFutures.add(stringCompletableFuture3);

        CompletableFuture<String> stringCompletableFuture4 = CompletableFuture.supplyAsync(() -> {
            ThreadLocalVar.t.set(String.valueOf(var.getAndIncrement()));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ThreadLocalVar.t.get();
        }, service);
        completableFutures.add(stringCompletableFuture4);

        CompletableFuture<String> stringCompletableFuture5 = CompletableFuture.supplyAsync(() -> {
            ThreadLocalVar.t.set(String.valueOf(var.getAndIncrement()));
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ThreadLocalVar.t.get();
        }, service);
        completableFutures.add(stringCompletableFuture5);

        CompletableFuture<String> stringCompletableFuture6 = CompletableFuture.supplyAsync(() -> {
            ThreadLocalVar.t.set(String.valueOf(var.getAndIncrement()));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ThreadLocalVar.t.get();
        }, service);
        completableFutures.add(stringCompletableFuture6);

        CompletableFuture<String> stringCompletableFuture7 = CompletableFuture.supplyAsync(() -> {
            ThreadLocalVar.t.set(String.valueOf(var.getAndIncrement()));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ThreadLocalVar.t.get();
        }, service);
        completableFutures.add(stringCompletableFuture7);

        CompletableFuture<String> stringCompletableFuture8 = CompletableFuture.supplyAsync(() -> {
            ThreadLocalVar.t.set(String.valueOf(var.getAndIncrement()));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ThreadLocalVar.t.get();
        }, service);
        completableFutures.add(stringCompletableFuture8);

        CompletableFuture<String> stringCompletableFuture9 = CompletableFuture.supplyAsync(() -> {
            ThreadLocalVar.t.set(String.valueOf(var.getAndIncrement()));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ThreadLocalVar.t.get();
        }, service);
        completableFutures.add(stringCompletableFuture9);



        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long time = System.currentTimeMillis();
        for (int i = 0; i < completableFutures.size(); i++){
            try {
                String s = completableFutures.get(i).get();
                System.out.println(i + "-" + s);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

         time = System.currentTimeMillis() - time;
        System.out.println(time);
        service.shutdown();
    }
}
