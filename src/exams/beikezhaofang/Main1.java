package exams.beikezhaofang;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        //输入
        Scanner sc = new Scanner(System.in);
        int num= Integer.parseInt(sc.nextLine());
        String strNums=sc.nextLine();
        String[] nums=strNums.split(" ");

        //比较绝对值大小，记录差值最小的那一组
        int preIndex=0;
        int latIndex=0;
        long abs=Long.MAX_VALUE;
        for (int i=0;i<nums.length-1;i++){//比较第i和i+1的绝对值
            long preNum= Long.parseLong(nums[i]);
            long latNum= Long.parseLong(nums[i+1]);

            if(Math.abs(preNum-latNum)<abs){
                preIndex=i;
                latIndex=i+1;
                abs=Math.abs(preNum-latNum);
            }
        }

        System.out.println(nums[preIndex]+" "+nums[latIndex]);
    }

}
