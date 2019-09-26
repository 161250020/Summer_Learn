package exams.duxiaoman;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static int min=Integer.MAX_VALUE;
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        String[] spl=sc.nextLine().split(" ");
        int N=Integer.parseInt(spl[0]);
        int A=Integer.parseInt(spl[1]);
        int B=Integer.parseInt(spl[2]);
        int C=Integer.parseInt(spl[3]);
        String[] spl2=sc.nextLine().split(" ");
        int[] a=new int[N+1];
        for (int i=0;i<spl2.length;i++){
            a[i+1]=Integer.parseInt(spl2[i]);
        }

        ArrayList<Integer> path=new ArrayList<>();
        cal(1,N,A,B,C,a,0,path);

        System.out.println(min);
    }

    private static void cal(int start_i, int n, int a, int b, int c, int[] a1,int curCost,ArrayList<Integer> path) {
        if (start_i==n&&curCost<min){
            min=curCost;
            return;
        }

        //3个选择
        if (!path.contains(start_i)){
            curCost+=a;
            path.add(start_i);
            cal(a1[start_i],n,a,b,c,a1,curCost,path);
            path.remove(new Integer(start_i));
            curCost-=a;
        }

        if ((a1[start_i]>1)){
            curCost+=b;
            a1[start_i]-=1;
            path.add(start_i);
            cal(start_i,n,a,b,c,a1,curCost,path);
            path.remove(new Integer(start_i));
            a1[start_i]+=1;
            curCost-=b;
        }

        if ((a1[start_i]<n)){
            curCost+=c;
            a1[start_i]+=1;
            path.add(start_i);
            cal(start_i,n,a,b,c,a1,curCost,path);
            path.remove(new Integer(start_i));
            a1[start_i]-=1;
            curCost-=c;
        }
    }
}
