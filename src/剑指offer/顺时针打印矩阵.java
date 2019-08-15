package 剑指offer;

import java.util.ArrayList;

public class 顺时针打印矩阵 {
    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
    //例如，如果输入如下4 X 4矩阵：
    //1 2 3 4
    //5 6 7 8
    //9 10 11 12
    //13 14 15 16
    //则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

    //顺时针打印就是按圈数循环打印，
    //一圈包含两行或者两列，
    //在打印的时候会出现某一圈中只包含一行（不会是只包含一列！），
    //要判断从左向右打印和从右向左打印的时候是否会出现重复打印，
    //同样只包含一列时，
    //要判断从上向下打印和从下向上打印的时候是否会出现重复打印的情况
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list=new ArrayList<>();
        if (matrix==null||matrix.length==0)
            return list;

        int up=0,down=matrix.length-1;
        int left=0,right=matrix[0].length-1;
        while (true){//进行顺时针的打印
            //向右
            for (int i=left;i<=right;i++)
                list.add(matrix[up][i]);
            if (++up>down)
                break;
            //向下
            for (int i=up;i<=down;i++)
                list.add(matrix[i][right]);
            if (--right<left)
                break;
            //向左
            for (int i=right;i>=left;i--)
                list.add(matrix[down][i]);
            if (--down<up)
                break;
            //向上
            for (int i=down;i>=up;i--)
                list.add(matrix[i][left]);
            if (++left>right)
                break;
        }

        return list;
    }

}
