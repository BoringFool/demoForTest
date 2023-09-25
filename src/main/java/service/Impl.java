package service;

import java.util.concurrent.LinkedBlockingQueue;

public class Impl {
    private static final LinkedBlockingQueue<Integer> LINKED_BLOCKING_QUEUE = new LinkedBlockingQueue<>(100);

    static class Provider implements Runnable {

        @Override
        public void run() {
            int count = 0;

            while (true) {
                try {
                    LINKED_BLOCKING_QUEUE.put(count);
                    System.out.println("++生产信息：" + count++);
                    Thread.sleep(100);

//                    if (count == 301)
//                        break;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            while (true) {
                try {
                    Integer element = LINKED_BLOCKING_QUEUE.take();
                    System.out.println("--" + name + "-消费信息：" + element);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Provider()).start();

        for (int i = 0; i < 20; i++) {
            new Thread(new Consumer(), "Thread-" + i).start();
        }
    }

}
