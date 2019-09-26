package exams.yuanfudao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        String[] line=sc.nextLine().split(" ");
        int N=Integer.parseInt(line[0]);
        int M=Integer.parseInt(line[1]);
        int matrix[][]=new int[N][M];
        for (int i=0;i<N;i++){
            String[] tempSpl=sc.nextLine().split(" ");
            for (int j=0;j<M;j++){
                matrix[i][j]= Integer.parseInt(tempSpl[j]);
            }
        }

        ArrayList<Integer> ret=printMatrix(matrix);
        StringBuilder stringBuilder=new StringBuilder();
        for (int i:ret){
            stringBuilder.append(i+" ");
        }
        String toPrint=stringBuilder.toString();
        toPrint=toPrint.substring(0,toPrint.length()-1);
        System.out.println(toPrint);
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list=new ArrayList<>();
        if (matrix==null||matrix.length==0)
            return list;

        int up=0,down=matrix.length-1;
        int left=0,right=matrix[0].length-1;
        while (true){//进行逆时针的打印
            //向下
            for (int i=up;i<=down;i++)
                list.add(matrix[i][left]);
            if (++left>right)
                break;
            //向右
            for (int i=left;i<=right;i++)
                list.add(matrix[down][i]);
            if (--down<up)
                break;
            //向上
            for (int i=down;i>=up;i--)
                list.add(matrix[i][right]);
            if (--right<left)
                break;
            //向左
            for (int i=right;i>=left;i--)
                list.add(matrix[up][i]);
            if (++up>down)
                break;
        }

        return list;
    }
}
