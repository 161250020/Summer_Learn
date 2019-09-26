package exams.tengxun;

import java.util.Scanner;

public class Main2 {
    public static int min=Integer.MAX_VALUE;
    public static int num=0;
    public static int[] red;
    public static int[] green;
    public static int[] blue;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        num=Integer.parseInt(sc.nextLine());
        red=new int[num];
        green=new int[num];
        blue=new int[num];
        for (int i=0;i<num;i++){
            String[] s=sc.nextLine().split(" ");
            red[i]=Integer.parseInt(s[0]);
            green[i]=Integer.parseInt(s[1]);
            blue[i]=Integer.parseInt(s[2]);
        }

        //列出所有的可能，以及对应的代价
        cal("",0,0);
        System.out.println(min);
    }

    private static void cal( String curStr,int curIndex,int curCost) {
        if (curIndex==num){
            //计算当前的价值，更新min
            if (curCost<min)
                min=curCost;
            return;
        }

        //进行计算
        if (curIndex==0){
            curStr="r";
            cal(curStr,curIndex+1,red[curIndex]);
            curStr="g";
            cal(curStr,curIndex+1,green[curIndex]);
            curStr="b";
            cal(curStr,curIndex+1,blue[curIndex]);
        }
        else{
            //curStr上一个为r
            char c=curStr.charAt(curStr.length()-1);
            if (c=='r'){
                //为g
                cal(curStr+"g",curIndex+1,curCost+green[curIndex]);
                //为b
                cal(curStr+"b",curIndex+1,curCost+blue[curIndex]);
            }
            //为g
            else if (c == 'g') {
                //为r
                cal(curStr+"r",curIndex+1,curCost+red[curIndex]);
                //为b
                cal(curStr+"b",curIndex+1,curCost+blue[curIndex]);
            }
            //为b
            else{
                //为g
                cal(curStr+"g",curIndex+1,curCost+green[curIndex]);
                //为r
                cal(curStr+"r",curIndex+1,curCost+red[curIndex]);
            }

        }
    }
}
