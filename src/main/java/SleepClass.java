public class SleepClass {

    public synchronized void sleep() throws InterruptedException {
        try {
            System.out.println("executed！");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("interrupted！");
            throw e;
        }

        System.out.println("Continue to run！");
    }
}
