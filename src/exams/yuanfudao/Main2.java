package exams.yuanfudao;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        String[] spl=sc.nextLine().split(" ");
        int n=Integer.parseInt(spl[0]);
        int s=Integer.parseInt(spl[1]);
        int[] a=new int[n];
        String[] spl2=sc.nextLine().split(" ");
        for (int i=0;i<spl2.length;i++)a[i]=Integer.parseInt(spl2[i]);

        int left=0,right=0;
        int max=0;
        int curSum=0;
        while (true){
            if (right>=a.length)break;

            if ((left==right)&&(a[left]<s)){
                curSum+=a[left];
                right++;
            }
            else{
                curSum+=a[right];
                if (curSum<=s)right++;
                else{
                    max=(max>(right-left+1))?max:(right-left);
                    curSum-=a[left];
                    left++;
                    right++;
                }
            }
        }

        System.out.println(max);
    }
}
