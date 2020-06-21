package test;

public class WaitNotifyTest2 {
      
    public static void main(String[] args) throws Exception {  
        final Sum2 sum=new Sum2();
          
      
          
        new Thread(new Runnable() {  
            @Override  
            public void  run() {  
                try {  
                    synchronized (sum) {  
                        System.out.println("thread1 get lock");  
                        sum.wait();//主动释放sum对象锁，等待唤醒  
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
                        sum.wait();  //主动释放sum对象锁，等待唤醒  
                        System.out.println(sum.total);  
                        System.out.println("thread2 release lock");  
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
                        System.out.println("thread3 get lock");  
                        sum.sum();  
                        sum.notifyAll();//唤醒其他等待线程（线程1,2）
                      //  sum.notify();//唤醒其他等待线程（只会唤醒线程1,2中的一个）
                        Thread.sleep(1000);
                        System.out.println("thread3 really release lock");  
                    }  
                      
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }).start();  
          
          
    }  
            
}  
  
class Sum2 {
    public Integer total=0;  
      
    public void  sum() throws Exception{  
        total=100;  
        Thread.sleep(5000);  
    }  
      
}  