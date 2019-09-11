package exams.xiecheng;

import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static int num=1;
    static String s;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();

        int totalThread=3;
        CyclicBarrier cyclicBarrier=new CyclicBarrier(totalThread);
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<totalThread;i++){
            executorService.execute(()->{
                String c="_A";
                if (num==2)
                    c="_B";
                else if (num==3)
                    c="_C";
                num++;

                try {
                    cyclicBarrier.await();
                    s=s+c;
                    if (num==4)
                        System.out.println(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            });
        }
        executorService.shutdown();
    }


}
