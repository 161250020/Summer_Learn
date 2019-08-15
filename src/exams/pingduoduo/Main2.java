package exams.pingduoduo;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        String line=sc.nextLine();
        String[] strs=line.split(" ");
        int[] nums=new int[26];//存储26个英文字符在各个单词首尾出现的次数
        for (String s:strs){//对于每一个单词而言
            char pre=s.charAt(0);
            char lat=s.charAt(s.length()-1);
            nums[pre-'A']=nums[pre-'A']+1;
            nums[lat-'A']=nums[lat-'A']+1;
        }
        boolean flag=true;
        for (int i:nums){
            if (i%2!=0){
                flag=false;
                break;
            }
        }
        if (flag)
            System.out.println("true");
        else
            System.out.println("false");

    }
}
