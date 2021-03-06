package test;

public class OddEvenByWaitNotify {
    private static final Object lock = new Object();
    private static int count = 0;
    private static final int MAX_COUNT = 100;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (count <= MAX_COUNT) {
                    synchronized (lock) {
                        try {
                            System.out.println(Thread.currentThread().getName() + ": " + count++);
                            lock.notify();
                            // 如果任务还没结束 就让出锁 自己休眠
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread2.start();
        thread1.start();

    }
}