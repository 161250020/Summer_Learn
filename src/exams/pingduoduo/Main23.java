package exams.pingduoduo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main23 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n= Integer.parseInt(sc.nextLine());
        if (n==0)
            System.out.println("0.00");

        String[] Xs0=sc.nextLine().split(" ");
        int[] Xs=new int[Xs0.length];
        for (int i=0;i<Xs0.length;i++){
            Xs[i]=Integer.parseInt(Xs0[i]);
        }
        Arrays.sort(Xs);
        int maxNum=Xs[Xs.length-1];
        int[] number=new int[maxNum+1];

        //每次投的概率
        long sum=1;
        for (int i=0;i<Xs.length;i++){
            sum*=Xs[i];
        }
        double p=1.0/sum;

        //所有投递轮的和
        ArrayList<Integer> allBigs=new ArrayList<>();
        cal(allBigs,1,0, Xs);
        int allBigSum=0;
        for (int i:allBigs)
            allBigSum+=i;

        p=p*allBigSum;
        //保留到小数点后两位
        System.out.println(String.format("%.2f",p));
    }

    private static void cal(ArrayList<Integer> allBigs, int max,int index, int[] Xs) {
        if (Xs.length==index){//结束了统计
            allBigs.add(max);
            return;
        }
        else {
            //对于第index个骰子而言
            //可以投出的数字
            for (int i=1;i<=Xs[index];i++){
                if (i>max)
                    cal(allBigs,i,index+1,Xs);
                else{
                    cal(allBigs,max,index+1,Xs);
                }
            }
        }
    }
}
