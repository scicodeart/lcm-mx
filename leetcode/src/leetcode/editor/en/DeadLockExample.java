package leetcode.editor.en;
import java.util.concurrent.TimeUnit;

public class DeadLockExample {

    public static void main(String[] args) {
        deadLock();
    }



    private static void deadLock(){
        Object lock1 = new Object();
        Object lock2 = new Object();
        // 线程一拥有 lock1 试图获取 lock2

        new Thread(()->{
            synchronized (lock1){
                System.out.println("get lock1 successfully");

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // try to get lock2
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }).start();

        new Thread(()->{
            synchronized (lock2){
                System.out.println("get lock2 successfully");

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // try to get lock2
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }).start();
    }

}
