package exams.IQIYI;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static int sumMeet=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());//N
        String[] AisStrs=sc.nextLine().split(" ");//有N-1个数字
        int[] Ais=new int[N-1];
        for (int i=0;i<N-1;i++){
            Ais[i]=Integer.parseInt(AisStrs[i]);
        }

        int[] trys=new int[N];
        for (int i=1;i<=N;i++){
            trys[i-1]=i;
        }
        cal(Ais,trys,trys.length);

        System.out.println(sumMeet);
    }

    private static void cal(int[] Ais, int[] trys, int n) {
        int num=1;//计算有多少个情况
        int a=0,b=0;
        for (int i=1;i<=n;i++)
            num*=i;

        while ((num--)>0){
            //已完成一次排序，进行结果的处理，看是否符合情况
            boolean can=true;
            for (int i=0;i<Ais.length;i++){
                if ((Ais[i]==0)&&(trys[i]>=trys[i+1]))
                    can=false;
                if ((Ais[i]==1)&&(trys[i]<=trys[i+1]))
                    can=false;
            }
            if (can){
                sumMeet++;
                sumMeet=sumMeet%(1000000007);
            }

            for (int i=n-1;i>0;--i){//从右往左找到第一个左小于右的数
                if (trys[i-1]<trys[i]){
                    a=i-1;
                    break;
                }
            }
            for (int j=n-1;j>a;--j){//从右往左，找出第一个大于trys[a]的数
                if (trys[j]>trys[a]){
                    b=j;
                    break;
                }
            }

            //交换a和b的值
            int temp=trys[a];
            trys[a]=trys[b];
            trys[b]=temp;

            //对a后面的数据进行从小到大的排列
            Arrays.sort(trys,a+1,n);
        }

        return;
    }
}
