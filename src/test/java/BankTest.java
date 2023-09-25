import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankTest {
    public static void main(String[] args) {
//        {
//            Bank bank = new Bank();
//            normalThread(bank);
//        }

//        {
//            ExecutorService executor = Executors.newFixedThreadPool(10, r -> {
//                ThreadGroup group = new ThreadGroup("多用户操作");
//                return new Thread(group, r);
//            });
//
//            Lock lock = new ReentrantLock();
//            Condition condition = lock.newCondition();
//            Bank bank = new Bank(lock);
//
////        lockThread(bank, condition);
//            lockThread(executor, bank, condition);
//        }

//        {
//            //两个操作线程池
//            ThreadPoolExecutor executorSave = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(100), r -> new Thread(r, "存款用户"));
//            ThreadPoolExecutor executorGet = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(100), r -> new Thread(r, "取款用户"));
//
//            Lock lock = new ReentrantLock();
//            Condition condition = lock.newCondition();
//            Bank bank = new Bank(lock);
//
//            lockThreadOperate(executorGet, bank,condition, false);
//            lockThreadOperate(executorSave, bank,condition, true);
//        }

        {
            Lock lock = new ReentrantLock();
            Condition condition = lock.newCondition();

            Thread a = new Thread(()->{
                while (true){
                    lock.lock();
                    try {
                        System.out.println("A");
                        condition.signalAll();
                        condition.await();

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }
                }
            });

            Thread b = new Thread(()->{
                while (true){
                    lock.lock();
                    try {
                        System.out.println("B");
                        condition.signalAll();
                        condition.await();


                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }
                }
            });

            a.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            b.start();

        }


    }

    /**
     * synchronized一般线程测试
     *
     * @param bank 锁对象
     */
    static void normalThread(Bank bank) {
        Thread saveThread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            bank.save(1);
        }, "存款操作");

        Thread getThread = new Thread(() -> bank.get(1), "取款操作");

        getThread.start();
        saveThread.start();
    }

    /**
     * LOCK 操作测试
     *
     * @param bank          锁对象
     * @param lockCondition 锁条件
     */
    static void lockThread(Bank bank, Condition lockCondition) {
        Thread save = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            bank.save(500, lockCondition);
        });

        Thread get = new Thread(() -> {
            bank.get(200, lockCondition);
            bank.get(200, lockCondition);
            bank.get(100, lockCondition);
        });

        get.start();
        save.start();
    }

    /**
     * LOCK 多个线程操作
     *
     * @param executor
     * @param bank
     * @param lockCondition
     */
    static void lockThread(ExecutorService executor, Bank bank, Condition lockCondition) {
        ConcurrentLinkedQueue<Integer> totalSave = randomSplit(5000, 100, false);//总金额随机分成100分存
        ConcurrentLinkedQueue<Integer> totalGet = randomSplit(2500, 100, false);//总金额随机分成100份取

        //存取钱线程
        for (int i = 0; i < 200; i++) {
            if (i % 2 == 0) {
                executor.execute(() -> {
                    try {
                        //随机间隔，让线程增加交替
                        Thread.sleep((long) (Math.random() * 1000));
                        //判断队列是否为空
                        int money = totalSave.isEmpty() ? 0 : totalSave.poll();
                        //存钱
                        bank.save(money, lockCondition);
                    } catch (InterruptedException e) {
                        System.out.println("executor = " + executor + ", bank = " + bank + ", lockCondition = " + lockCondition + ":银行关门禁止操作！");
                    }
                });
            } else {
                executor.execute(() -> {
                    try {
                        //随机间隔，让线程增加交替
                        Thread.sleep((long) (Math.random() * 500));
                        //判断队列是否为空
                        int money = totalGet.isEmpty() ? 0 : totalGet.poll();
                        //取钱
                        bank.get(money, lockCondition);
                    } catch (InterruptedException e) {
                        System.out.println("executor = " + executor + ", bank = " + bank + ", lockCondition = " + lockCondition + ":银行关门禁止操作！");
                    }
                });
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }

            //循环确认线程全部停止后，查询操作记录。
            for (; ; ) {
                if (executor.isTerminated()) {
                    bank.operateRecord();
                    break;
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 分开存取操作
     *
     * @param executor
     * @param bank
     * @param lockCondition
     * @param operateType   操作类型：true-存；false-取
     */
    static void lockThreadOperate(ExecutorService executor, Bank bank, Condition lockCondition, Boolean operateType) {
        ConcurrentLinkedQueue<Integer> total = randomSplit(5000, 100, false);//总金额随机分成100份

        //存取钱线程
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
//                try {
                    //随机间隔，让线程增加交替
//                    Thread.sleep((long) (Math.random() * 1000));
                    //判断队列是否为空
                    int money = total.isEmpty() ? 0 : total.poll();
                    if (operateType) {
                        //存钱
                        bank.save(money, lockCondition);
                    } else {
                        //取钱
                        bank.get(money, lockCondition);
                    }
//                } catch (InterruptedException e) {
//                    System.out.println("executor = " + executor + ", bank = " + bank + ", lockCondition = " + lockCondition + ":银行关门禁止操作！");
//                }
            });
        }

//        executor.shutdown();
//        try {
//            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
//                executor.shutdownNow();
//            }
//
//            //循环确认线程全部停止后，查询操作记录。
//            for (; ; ) {
//                if (executor.isTerminated()) {
//                    bank.operateRecord();
//                    break;
//                }
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }

    /**
     * 将一个数num随机分成n份
     *
     * @param flag 是否可以为0
     */
    public static ConcurrentLinkedQueue<Integer> randomSplit(int num, int n, boolean flag) {
        //随机抽取n-1个小于sum的数
        List<Integer> list = new ArrayList<>();
        //将0和sum加入到里list中
        list.add(0);
        //判断生成的正整数集合中是否允许为0，true元素可以为0  false元素不可以为0
        if (!flag) {
            num = num - n;
        }
        list.add(num);

        int temp = 0;
        for (int i = 0; i < n - 1; i++) {
            temp = (int) (Math.random() * num);
            list.add(temp);
        }
        Collections.sort(list);

        ConcurrentLinkedQueue<Integer> nums = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < n; i++) {
            int r = list.get(i + 1) - list.get(i);
            if (!flag) {
                r += 1;
            }

            nums.offer(r);
        }
        return nums;
    }


}
