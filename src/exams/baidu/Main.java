package exams.baidu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        int[] num=new int[n];
        ArrayList<ArrayList<Integer>> cal=new ArrayList<>();//计算num的第i个数对应的约数
        for (int i=0;i<n;i++){
            num[i]=i+1;
            cal.add(new ArrayList<Integer>());
            for (int k=1;k<=num[i];k++)
                if (num[i]%k==0){
                    cal.get(i).add(k);
                }
        }

        int[][] lcms=new int[n][n];
        int[][] gcds=new int[n][n];
        int maxMinus=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                int a=num[i];
                int b=num[j];

                int lcm=a*b;
                for (int z=lcm-1;z>0;z--){
                    if ((z%a==0)&&(z%b==0)){
                        lcm=z;
                    }
                }
                ArrayList<Integer> acal=cal.get(i);
                ArrayList<Integer> bcal=cal.get(j);
                int gcd=1;
                if (acal.size()<bcal.size()){
                    for (int z=acal.size()-1;z>=0;z--){
                        if (bcal.contains(acal.get(z))){
                            gcd=acal.get(z);
                            break;
                        }
                    }
                }
                else{
                    for (int z=bcal.size()-1;z>=0;z--){
                        if (acal.contains(bcal.get(z))){
                            gcd=bcal.get(z);
                            break;
                        }
                    }
                }

                maxMinus=Math.max(maxMinus,lcm-gcd);
            }
        }
        System.out.println(maxMinus);
    }
}
