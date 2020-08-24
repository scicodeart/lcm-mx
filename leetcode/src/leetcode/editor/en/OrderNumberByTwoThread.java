package leetcode.editor.en;

public class OrderNumberByTwoThread implements Runnable
{


    int i = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        OrderNumberByTwoThread t = new OrderNumberByTwoThread();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();

    }
}
