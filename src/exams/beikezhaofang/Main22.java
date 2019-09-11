package exams.beikezhaofang;

import java.util.Scanner;

public class Main22 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        int n=Integer.parseInt(line);
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        //统计和
        int sum=0;
        for (int l=0;l<nums.length;l++){
            //区间以l开头
            int min=nums[l];//以l开头的最小的
            sum+=min;
            for (int r=l+1;r<nums.length;r++){
                //以r结尾
                if (nums[r]<min)
                    min=nums[r];
                sum+=min;
            }
        }

        System.out.println(sum);
    }

}