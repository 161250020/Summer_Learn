package exams.zoom;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] inNums=sc.nextLine().split(",");
        float[] nums=new float[inNums.length];
        for (int i=0;i<inNums.length;i++)
            nums[i]=Float.parseFloat(inNums[i]);

        float max=1;
        float sum=1;
        for (int i=0;i<nums.length;i++){
            if (sum>0)sum*=nums[i];
            else sum=nums[i];
            if (sum>max)max=sum;
        }
        System.out.println(max);
    }

}
