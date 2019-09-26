package exams.tengxun;

import java.util.Scanner;

public class Main5 {
    public static int max=Integer.MIN_VALUE;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        int time=Integer.parseInt(sc.nextLine());

        //计算line里面含有的T的个数和F的个数
        int Tnum=0;
        int Fnum=0;
        for (int i=0;i<line.length();i++){
            if (line.charAt(i)=='T')
                Tnum++;
            else
                Fnum++;
        }
        if (time<=Tnum){
            System.out.println(Tnum+Fnum);
            return;
        }

        cal(line,time,0,0,1);
    }

    private static void cal(String line, int time,int index,int value,int flag) {
        if (index==line.length()){
            if (time==0){
                if (value>max){
                    max=value;
                }
            }
        }

        //遇到一个T，解决方案如下
        int lat=-1;
        for (int i=index;i<line.length();i++){
            if (line.charAt(i)=='T'){
                lat=i;
                break;
            }
        }

        //1：放过他
        int tFlag=0;
        if (flag==0)tFlag=1;
        else tFlag=0;
        if (lat==index){
            cal(line,time,index+1,value,tFlag);
        }
        else{
            //前面的value
            cal(line,time,index+1,value+flag*(lat-index),tFlag);
        }
        //2：将他前面的F转换成T
        //3：将他后面的F转换成T
        //4：将T转换成F
    }
}
