package exams.tengxun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=Integer.parseInt(sc.nextLine());
        if (num==0)return;
        int[] lens=new int[num];
        String[] ss=new String[num];
        for (int i=0;i<num;i++){
            lens[i]=Integer.parseInt(sc.nextLine());
            ss[i]=sc.nextLine();
        }

        //进行处理
        for (int i=0;i<num;i++){
            if (ss[i].length()<11){
                System.out.println("NO");
                continue;
            }
            //对第i个进行处理
            //首先保证第一个数字为8
            int index=-1;
            for (int j=0;j<lens[i];j++){
                if (ss[i].charAt(j)=='8'){
                    index=j;
                    break;
                }
            }
            if ((index==-1)||((index!=-1)&&(lens[i]-index<11))){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }
    }
}
