package com.example.basic.thread;


//notify different with notifyAll
//notify only wake up one thread
//notify wake up all threads
public class NotificationDemo {

    private volatile boolean go=false;

    public static void main(String[] args) throws InterruptedException {
        final NotificationDemo test=new NotificationDemo();

        Runnable waitTest=new Runnable() {
            @Override
            public void run() {
                try {
                    test.shouldGo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" finished Execution");
            }
        };

        Runnable notifyTask=new Runnable() {
            @Override
            public void run() {
                test.go();
                System.out.println(Thread.currentThread().getName()+ "finished Execution");
            }
        };

        Thread t1=new Thread(waitTest,"WT1");
        Thread t2=new Thread(waitTest,"WT2");
        Thread t3=new Thread(waitTest,"WT3");
        Thread t4=new Thread(waitTest,"WT4");

        t1.start();
        t2.start();
        t3.start();

        //pause to ensure all waiting thread started successfully
        Thread.sleep(200);

        //starting notifying thread
        t4.start();

    }

    /*
     * wait and notify can only be called from synchronized method or bock
     */
    private synchronized void shouldGo() throws InterruptedException {
        while(go != true){
            System.out.println(Thread.currentThread()
                    + " is going to wait on this object");
            wait(); //release lock and reacquires on wakeup
            System.out.println(Thread.currentThread() + " is woken up");
        }
        go = false; //resetting condition
    }

    /*
     * both shouldGo() and go() are locked on current object referenced by "this" keyword
     */
    private synchronized void go() {
        while (go == false){
            System.out.println(Thread.currentThread()
                    + " is going to notify all or one thread waiting on this object");

            go = true; //making condition true for waiting thread
            //notify(); // only one out of three waiting thread WT1, WT2,WT3 will woke up
            notifyAll(); // all waiting thread  WT1, WT2,WT3 will woke up
        }

    }
}
