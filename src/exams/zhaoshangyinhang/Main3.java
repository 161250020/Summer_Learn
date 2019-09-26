package exams.zhaoshangyinhang;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int[] num=new int[s.length()];
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c!='?'){
                num[i]=Integer.parseInt(c+"");
            }
            else{
                num[i]=-1;
            }
        }//进行初始化

        //全排列算法

    }
}
