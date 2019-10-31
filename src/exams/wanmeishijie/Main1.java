package exams.wanmeishijie;

import java.util.HashSet;
import java.util.Scanner;

/*
0 1 12 -1 -1 -1
-1 0 9 3 -1 -1
-1 -1 0 -1 5 -1
-1 -1 4 0 13 15
-1 -1 -1 -1 0 4
-1 -1 -1 -1 -1 0
 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] line=sc.nextLine().split(" ");
        int n=line.length;
        int[][] nums=new int[n][n];
        for (int i=0;i<n;i++)nums[0][i]=Integer.parseInt(line[i]);
        for (int i=1;i<n;i++){
            String[] line2=sc.nextLine().split(" ");
            for (int j=0;j<n;j++)
                nums[i][j]=Integer.parseInt(line2[j]);
        }

        //dijkstra
        HashSet<Integer> set=new HashSet<>();
        for (int i=1;i<n;i++){//对于nums[i]的值进行判断
            int minIndex=0;
            for (int j=1;j<n;j++){
                if ((nums[0][j]!=0)&&(nums[0][j]!=-1)&&(!set.contains(j))){
                    if (minIndex==0){
                        minIndex=j;
                    }
                    else{
                        minIndex=(nums[0][j]<nums[0][minIndex])?j:minIndex;
                    }
                }
            }
            if (minIndex!=0)set.add(minIndex);
            else break;

            //更新nums[0]的值，以minIndex行为基准
            for (int j=0;j<n;j++){
                if ((nums[minIndex][j]!=0)&&(nums[minIndex][j]!=-1)){
                    //可以从minIndex到j
                    int sum=nums[0][minIndex]+nums[minIndex][j];//从0到j
                    if (nums[0][j]!=-1){
                        nums[0][j]=Math.min(nums[0][j],sum);
                    }
                    else{
                        nums[0][j]=sum;
                    }
                }
            }
        }

        for (int i=1;i<n;i++)System.out.println(nums[0][i]);

    }
}
