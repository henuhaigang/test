package test;

/**
 * program result:
 * thread3 get lock
 * thread3 really release lock
 * thread2 get lock
 * thread1 get lock
 *
 * 三个线程，线程3先拥有sum对象的锁，然后通过sum.notify()方法通知等待sum锁的线程去获得锁，但是这个时候线程1,2并没有处于wait()导致的阻塞状态，
 * 而是在synchronized方法块处阻塞了，所以，这次notify()根本没有通知到线程1,2。然后线程3正常结束，释放掉sum锁，这个时候，
 * 线程1就立刻获得了sum对象的锁（通过synchronized获得），然后调用sum.wait()方法释放掉sum的锁，线程2随后获得了sum对象的线程锁（通过synchronized获得），
 * 这个时候线程1,2都处于阻塞状态，但是悲催的是，这之后再也没有线程主动调用sum.notify()或者notifyAll()方法显示唤醒这两个线程，所以程序阻塞
 */
public class WaitNotifyTest {

    public static void main(String[] args) throws Exception {  
        final Sum2 sum=new Sum2();
          
        new Thread(new Runnable() {  
            @Override  
            public void  run() {  
                try {  
                    synchronized (sum) {  
                        System.out.println("thread3 get lock");  
                        sum.sum();  
                        sum.notifyAll(); //此时唤醒没有作用，没有线程等待  
                        Thread.sleep(2000);  
                        System.out.println("thread3 really release lock");  
                    }  
                      
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }).start();  
          
        new Thread(new Runnable() {  
            @Override  
            public void  run() {  
                try {  
                    synchronized (sum) {  
                        System.out.println("thread1 get lock");  
                        sum.wait();//主动释放掉sum对象锁  
                        System.out.println(sum.total);  
                        System.out.println("thread1 release lock");  
                    }  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }).start();  
          
        new Thread(new Runnable() {  
            @Override  
            public void  run() {  
                try {  
                    synchronized (sum) {  
                        System.out.println("thread2 get lock");  
                        sum.wait();  //释放sum的对象锁，等待其他对象唤醒（其他对象释放sum锁）  
                        System.out.println(sum.total);  
                        System.out.println("thread2 release lock");  
                    }  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }).start();  
    }  
            
}  
  
class Sum{  
    public Integer total=0;  
      
    public void  sum() throws Exception{  
        total=100;  
        Thread.sleep(5000);  
    }  
      
}  