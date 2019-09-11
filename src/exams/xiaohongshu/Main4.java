package exams.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

class value implements Comparable<value>{
    int x;
    int h;
    public value(int x,int h){
        this.x=x;
        this.h=h;
    }

    @Override
    public int compareTo(value o) {
        if (this.x>o.x)
            return 1;
        else if (this.x<o.x)
            return -1;
        else {
            if (this.h>=o.h)
                return 1;
            else
                return -1;
        }
    }
}

//本题为：leetcode 354的变形：https://blog.csdn.net/zhuanli555/article/details/80769251
//可以使用动态规划来写---本题的解决方案
//也可以使用其他的解法来完成：对h降序排列的原因：在同一个w下只会选择一个h，而不会因为h的大小顺序的问题，在同一个w下选择了多个h（此时不会兼顾w的问题）
public class Main4 {
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());
        value[] values=new value[N];
        for (int i=0;i<N;i++){
            String[] nums=sc.nextLine().split(" ");
            value v=new value(Integer.parseInt(nums[0]),Integer.parseInt(nums[1]));
            values[i]=v;
        }
        //对N件宝物按照X先进行排序，如果X相同，就按H进行排序
        Arrays.sort(values);

        int[] count=new int[N];//第N件宝物卖出的最大数量
        int max=0;
        if (N>0){
            count[0]=1;
            max=1;
            for (int i=1;i<N;i++) {//假设第i件宝物卖出
                value v=values[i];
                int tempMax=-1;
                for (int j=0;j<i;j++){//他之前卖出的价值小于该宝物的values里面的count
                    value v2=values[j];
                    if ((v.x>=v2.x)&&(v.h>=v2.h)){
                        tempMax=Math.max(tempMax,count[j]);
                    }
                }
                if (tempMax==-1)
                    count[i]=1;
                else {
                    count[i]=tempMax+1;
                    max=Math.max(max,count[i]);
                }
            }
            System.out.println(max);
        }
        else {
            System.out.println(0);
        }
    }
}
