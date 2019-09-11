package exams.beikezhaofang;

import java.util.Scanner;

public class Main23 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        int kind=Integer.parseInt(line.split(" ")[0]);
        long s_bag=Long.parseLong(line.split(" ")[1]);
        if ((kind==0)||(s_bag==0)){
            System.out.println(0);
        }
        else {
            int[] nums=new int[kind];
            int[] s_beike=new int[kind];
            for(int i=0;i<kind;i++){
                String temp=sc.nextLine();
                String[] temps=temp.split(" ");
                nums[i]=Integer.parseInt(temps[0]);
                s_beike[i]=Integer.parseInt(temps[1]);
            }

            //对背包进行装贝壳
            int pack_num=0;
            for (int i=0;i<kind;i++){
                //尽量装第i种贝壳
                while ((nums[i]>0)&&(s_beike[i]<=s_bag)){
                    pack_num++;
                    nums[i]=nums[i]-1;
                    s_bag-=s_beike[i];
                }
            }

            System.out.println(pack_num);
        }

    }

}
