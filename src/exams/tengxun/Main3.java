package exams.tengxun;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=Integer.parseInt(sc.nextLine());
        String[] ss=sc.nextLine().split(" ");
        int[] lens=new int[num];
        for (int i=0;i<num;i++){
            lens[i]=Integer.parseInt(ss[i]);
        }

        Arrays.sort(lens);
        String s="";
        int pre=0;
        int lat=0;
        if (num%2==0){//为偶数个
            pre=lens[--num];
            lat=lens[--num];
            s=pre+" "+lat;
        }
        else{
            pre=lens[--num];
            lat=pre;
            s=pre+"";
        }
        for (;num>=1;){
            s=s+" "+lens[--num];
            s=lens[--num]+" "+s;
        }
        System.out.println(s);

    }
}
