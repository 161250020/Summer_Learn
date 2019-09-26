package exams.zhaoshangyinhang;

import java.util.Scanner;

public class Main {
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int[] nums=new int[s.length()];
        for (int i=0;i<nums.length;i++){
            nums[i]=1;
        }

        int[] curIndex=new int[3];
        int[] temp=new int[s.length()];
        for (;curIndex[0]!=1;){
            //对数组进行运算
            for (int i=0;i<s.length();i++){
                char c=s.charAt(i);
                int teNum=nums[i];
                temp[i]-=teNum;
                if (c=='R'){
                    temp[i+1]+=teNum;
                }
                else{
                    temp[i-1]+=teNum;
                }
            }

            //对curIndex+1
            curIndex[curIndex.length-1]+=1;
            for (int j=curIndex.length-1;j>=0;j--){
                if (curIndex[j]>=10){
                    curIndex[j]-=10;
                    curIndex[j-1]+=1;
                }
                else {
                    break;
                }
            }

            //重新赋值num
            for (int i=0;i<nums.length;i++)
                nums[i]+=temp[i];
        }

        StringBuilder str=new StringBuilder();
        for (int i=0;i<nums.length;i++)
            str.append(nums[i]+" ");
        String toPrint=str.toString();
        toPrint.substring(0,toPrint.length()-1);
        System.out.println(toPrint);
    }
}
