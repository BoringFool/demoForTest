import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Bank {
    private int count = 0;//用户存款
    private int countSave = 0;//用户存款
    private int countGet = 0;//用户存款
    private Lock operateLock;//接口锁


    //无参构造
    public Bank(){

    }

    //获取锁构造器
    public Bank(Lock operateLock){
        this.operateLock = operateLock;
    }

    //存钱
    public synchronized int save(int money){
        this.count += money;
        String name = Thread.currentThread().getName();
        System.out.println(name + ":存入" + money + "元,账户余额" + this.count);
        notifyAll();
        return this.count;
    }

    public int save(int money, Condition condition){
        operateLock.lock();
        try {
            this.count += money;
            this.countSave += money;
            condition.signalAll();//唤起所有消费者
            String name = Thread.currentThread().getName();
            System.out.println(name + ":存入" + money + "元,账户余额" + this.count);
            return this.count;
        }finally {
            operateLock.unlock();
        }
    }
    //取钱,返回余额
    public synchronized int get(int money){
        if(this.count < money){//账户余额不足，在窗口等着别人往账户存钱，取到为止
            try {
                wait();
            } catch (InterruptedException e) {//保安赶人，直接打劫，影响银行运营
                throw new RuntimeException(e);
            }
        }

        //取钱
        this.count -= money;
        String name = Thread.currentThread().getName();
        System.out.println(name + ":取出" + money + "元，账户余额-" + this.count);
        return this.count;
    }

    public int get(int money, Condition condition){
        operateLock.lock();
        try {
            //循环判断当前账户余额是否够取款，不够释放锁等待；足够则进行取款。
            for(;;){
                if(this.count < money){
                    condition.await();
                }else{
                    break;
                }
            }

            //取钱
            this.count -= money;
            this.countGet += money;
            String name = Thread.currentThread().getName();
            System.out.println(name + ":取出" + money + "元，账户余额-" + this.count);
            return this.count;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            operateLock.unlock();
        }
    }

    //账户余额
    public int banlance(){
        synchronized (this){
            return this.count;
        }
    }

    //账户操作记录
    public void operateRecord(){
        synchronized (this){
            System.out.println("总计存款：" + this.countSave);
            System.out.println("总计取款：" + this.countGet);
            System.out.println("账户余额：" + this.count);
        }
    }

    public synchronized void test(){
        try {
            System.out.println("获取到了线程池的线程!");
            wait();
            System.out.println("优先线程被唤醒了!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }





}
