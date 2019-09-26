package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//多线程交叉打印
//https://blog.csdn.net/u011519624/article/details/79646306
//https://blog.csdn.net/whu_zcj/article/details/51518101
public class  PrintABC{
    private int status=1;
    private ReentrantLock lock=new ReentrantLock();
    private Condition ca=lock.newCondition();
    private Condition cb=lock.newCondition();
    private Condition cc=lock.newCondition();

    public void printA(){
        lock.lock();
        try{
            if(status!=1){
                ca.await();
            }
            System.out.print("A");
            status=2;
            cb.signal();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try{
            if(status!=2){
                ca.await();
            }
            System.out.print("B");
            status=3;
            cc.signal();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try{
            if(status!=3){
                ca.await();
            }
            System.out.print("C");
            status=3;
            ca.signal();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args){
        PrintABC print = new PrintABC();
        Thread threadA = new Thread(new RunnableA(print));
        Thread threadB = new Thread(new RunnableB(print));
        Thread threadC = new Thread(new RunnableC(print));
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class RunnableA implements Runnable{
    private PrintABC print;

    public RunnableA(PrintABC print) {super();this.print = print;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            print.printA();
        }
    }
}
class RunnableB implements Runnable{
    private PrintABC print;

    public RunnableB(PrintABC print) {
        super();
        this.print = print;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            print.printB();
        }
    }
}
class RunnableC implements Runnable{
    private PrintABC print;

    public RunnableC(PrintABC print) {
        super();
        this.print = print;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            print.printC();
        }
    }
}
