package exams.beikezhaofang;

import java.util.Arrays;
import java.util.Scanner;

public class Main21 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String line2=sc.nextLine();
        int n=Integer.parseInt(line.split(" ")[0]);
        int S=Integer.parseInt(line.split(" ")[1]);
        int[] c=new int[n];
        String[] strSplit=line2.split(" ");
        for(int i=0;i<n;i++){
            c[i]=Integer.parseInt(strSplit[i]);
        }

        /*
        //对c进行选择排序
        for (int i=0;i<c.length-1;i++){
            int minIndex=i;
            for (int j=i+1;j<c.length;j++){
                if (c[j]<c[minIndex])
                    minIndex=j;
            }
            //进行交换
            int temp=c[i];
            c[i]=c[minIndex];
            c[minIndex]=temp;
        }*/
        Arrays.sort(c);

        //进行计算
        int num=0;
        for(;num<c.length;){
            if (S>=c[num]){
                S-=c[num];
                num++;
            }
            else
                break;
        }

        System.out.println(num);
    }

}
