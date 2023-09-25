package service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

public class TService {
    interface service {
        default public Integer get() {
            int i = (int) (1 + Math.random() * 10);
            System.out.println(i);
            return i;
        }
    }

    public static class AService implements service {
    }

    public static class BService implements service {
    }

    public static class CService implements service {
    }

    public static Integer get() {
        ArrayList<CompletableFuture<Integer>> completableFutures = new ArrayList<>();
        ExecutorService service = ThreadPool.service;

        completableFutures.add(CompletableFuture.supplyAsync(() -> new AService().get(), service));

        completableFutures.add(CompletableFuture.supplyAsync(() -> new BService().get(), service));

        completableFutures.add(CompletableFuture.supplyAsync(() -> new CService().get(), service));

        Integer result = 0;
        for (CompletableFuture<Integer> completableFuture : completableFutures) {
            try {
                result += completableFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        completableFutures.iterator();

        return result;
    }

    public static void main(String[] args) {
        System.out.println("结果 = " + TService.get());
    }

}
