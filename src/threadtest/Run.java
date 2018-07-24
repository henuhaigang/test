package threadtest;

//多个队形和一个对象是不同的方式
public class Run {

    public static void main(String[] args) {

        HasSelfPrivateNum numRef = new HasSelfPrivateNum();

        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
        ThreadA athread = new ThreadA(numRef);
        athread.start();

        ThreadB bthread = new ThreadB(numRef1);
        bthread.start();

    }

}

class HasSelfPrivateNum {

    private int num = 0;

    public synchronized void  addI(String username) {
        try {
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num=" + num);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}


class ThreadA extends Thread {

    private HasSelfPrivateNum numRef;

    public ThreadA(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }

}



 class ThreadB extends Thread {

    private HasSelfPrivateNum numRef;

    public ThreadB(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }

}