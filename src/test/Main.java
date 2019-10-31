package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] agrs){
        new Main().movingCount(5,10,10);

    }
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] flag=new boolean[rows][cols];
        return movingCountCore(threshold, rows, cols, 0, 0, flag);
    }

    private int movingCountCore(int threshold, int rows, int cols, int i, int j, boolean[][] flag) {
        if (i<0||i>=rows||j<0||j>=cols)return 0;
        if (flag[i][j]||canVisited(threshold, i, j))return 0;
        flag[i][j]=true;
        return 1+movingCountCore(threshold,rows,cols,i-1,j,flag)
                +movingCountCore(threshold,rows,cols,i+1,j,flag)
                +movingCountCore(threshold,rows,cols,i,j-1,flag)
                +movingCountCore(threshold,rows,cols,i,j+1,flag);
    }
    private boolean canVisited(int threshold, int i, int j){
        int sum=0;
        while (i!=0){
            sum+=i%10;
            i/=10;
        }
        while (j!=0){
            sum+=j%10;
            j/=10;
        }
        System.out.println(i+"   "+j+"   "+sum);

        if (sum>threshold)return false;
        return true;
    }
}
