package exams.tengxun;

import java.util.Scanner;

public class Main4 {
    public static int min=Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int num=Integer.parseInt(sc.nextLine());
        String[] ss=sc.nextLine().split(" ");
        double[] lens=new double[num];
        for (int i=0;i<num;i++)
            lens[i]=Double.parseDouble(ss[i]);

        cal(lens,0);
        System.out.println(min);
    }

    private static void cal(double[] lens, int curTime) {
        boolean flag=true;
        for (int i=0;i<lens.length;i++){
            if (lens[i]>0){
                flag=false;
                break;
            }
        }
        if (flag){
            if (curTime<min){
                min=curTime;
            }
            return;
        }

        double[] temp=new double[lens.length];
        for (int i=0;i<lens.length;i++)temp[i]=lens[i];
        int index=-1;
        for (int i=0;i<lens.length;i++)
            if (lens[i]!=0){
                index=i;
                break;
            }
        //从第一个非0开始横向刷
        if (lens[index]>=1){
            for (int i=index;i<lens.length;i++){
                if (lens[i]>=1){
                    lens[i]-=1;
                }
                else{
                    break;
                }
            }
        }//否则只能纵向刷
        cal(lens,curTime+1);
        //纵向刷
        temp[index]=0;
        cal(temp,curTime+1);
    }
}
