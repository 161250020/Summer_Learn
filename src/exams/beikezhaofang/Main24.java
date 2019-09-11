package exams.beikezhaofang;

import java.util.Arrays;
import java.util.Scanner;

public class Main24 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());
        String line=sc.nextLine();
        String[] split=line.split(" ");
        int[] weights=new int[N];
        for (int i=0;i<N;i++){
            weights[i]=Integer.parseInt(split[i]);
        }

        //对重量进行排序
        Arrays.sort(weights);

        int sumA=0;
        int numA=0;
        int sumB=0;
        int numB=0;
        int pre=0;
        int lat=N-1;
        while (true){
            if (pre<=lat){
                if (sumA<sumB){
                    sumA+=weights[pre];
                    numA++;
                    pre++;
                }
                else if (sumA==sumB){
                    sumA+=weights[pre];
                    numA++;
                    pre++;
                    if (pre<=lat){
                        sumB+=weights[lat];
                        numB++;
                        lat--;
                    }
                    else
                        break;
                }
                else{
                    sumB+=weights[lat];
                    numB++;
                    lat--;
                }
            }
            else {
                break;
            }
        }
        sumA=Math.abs(sumA-sumB);
        numA=Math.abs(numA-numB);
        System.out.println(sumA+" "+numA);
    }

}
