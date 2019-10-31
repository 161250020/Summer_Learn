package exams.qiye360;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

class jiasudai implements Comparable<jiasudai>{
    int a;
    int t;

    @Override
    public int compareTo(jiasudai o) {
        return Integer.compare(o.a,a);
    }
}
public class Main1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        jiasudai[] j=new jiasudai[n];
        for (int i=0;i<n;i++){
            String[] temp=sc.nextLine().split(" ");
            j[i]=new jiasudai();
            j[i].a=Integer.parseInt(temp[0]);
            j[i].t=Integer.parseInt(temp[1]);
        }

        Arrays.sort(j);

        double sumL=0;
        int v0=0;
        for (int i=0;i<n;i++){
            sumL=sumL+(v0*j[i].t+0.5*j[i].a*j[i].t*j[i].t);
            v0=v0+j[i].a*j[i].t;
        }
        BigDecimal b=new BigDecimal(sumL);
        sumL=b.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(sumL);
    }
}
