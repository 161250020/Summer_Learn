package exams.huawei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int p= Integer.parseInt(sc.nextLine());

        //3条边为整数，设两条较小的边
        int small=p/3;//范围：1~p/3

        int count=0;//计算总数
        for (int i=small;i>0;i--){
            int big=(p-i)/2;//范围：small~(p-small)/2，第3条：p-small-big
            for (int j=big;j>=i;j--){
                int line3=p-i-j;
                if ((i*i+j*j)==(line3*line3)){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }

}
