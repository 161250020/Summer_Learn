package 剑指offer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 * */
public class 机器人的运动范围 {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] flag=new boolean[rows][cols];
        return movingCountCore(threshold, rows, cols, 0, 0, flag);
    }

    private int movingCountCore(int threshold, int rows, int cols, int i, int j, boolean[][] flag) {
        if (i<0||i>=rows||j<0||j>=cols)return 0;
        if ((!flag[i][j])&&canVisited(threshold, i, j)){
            flag[i][j]=true;
            return 1+movingCountCore(threshold,rows,cols,i-1,j,flag)
                    +movingCountCore(threshold,rows,cols,i+1,j,flag)
                    +movingCountCore(threshold,rows,cols,i,j-1,flag)
                    +movingCountCore(threshold,rows,cols,i,j+1,flag);
        }
        return 0;
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
        if (sum>threshold)return false;
        return true;
    }
}
