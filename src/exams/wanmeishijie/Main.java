package exams.wanmeishijie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int weight=Integer.parseInt(sc.nextLine());
        String[] weights0=sc.nextLine().split(" ");
        String[] values0=sc.nextLine().split(" ");
        int[] weights=new int[n];
        int[] values=new int[n];
        for (int i=0;i<n;i++){
            weights[i]=Integer.parseInt(weights0[i]);
            values[i]=Integer.parseInt(values0[i]);
        }

        //01背包问题---第i件物品，剩余weight
        int[][] cal=new int[n+1][weight+1];
        int max=Integer.MIN_VALUE;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=weight;j++){
                if (j<weights[i-1]){//无法放入
                    cal[i][j]=cal[i-1][j];
                }
                else{
                    cal[i][j]=Math.max(cal[i-1][j],cal[i-1][j-weights[i-1]]+values[i-1]);
                }
                max=Math.max(max,cal[i][j]);
            }
        }

        System.out.println(max);
    }
}
