package exams.zhaoshangyinhang;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//这道题目其实是Dijkstra算法
public class Main2 {
    StringBuilder stringBuilder=new StringBuilder();
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        int num=Integer.parseInt(sc.nextLine());
        int[][] lens=new int[num+1][num+1];
        for (int i=0;i<num-1;i++){
            String[] spl=sc.nextLine().split(" ");
            int u=Integer.parseInt(spl[0]);
            int v=Integer.parseInt(spl[0]);
            int c=Integer.parseInt(spl[0]);
            lens[u][v]=c;
        }

       for (int i=1;i<=num;i++){
           int max=dij(i,lens);
       }

    }

    private static int dij(int startIndex, int[][] lens) {
        Set<Integer> fixedPoints=new TreeSet<>();
        int[] fixedLen=new int[lens.length];
        fixedPoints.add(startIndex);
        int lastAccurate=1;
        int lastNum=lens[startIndex][1];
        for (int i=2;i<lens[startIndex].length;i++){
            if (lens[startIndex][i]<lastNum&&lens[startIndex][i]!=0){
                lastAccurate=i;
                lastNum=lens[startIndex][i];
                fixedLen[lastAccurate]=lastNum;
            }
        }

        for (;;){//从这一行开始
            for (int j=1;j<lens[lastAccurate].length;j++){
                //找到最近的那个点
                if (lens[lastAccurate][j]!=0){//可以抵达到j
                    if (fixedLen[j]==0)
                        fixedLen[j]=lastNum+lens[lastAccurate][j];
                    else
                        fixedLen[j]=Math.min(lastNum+lens[lastAccurate][j],fixedLen[j]);
                }
            }

            //这一行的所有的最小的都找到了
        }
    }
}
