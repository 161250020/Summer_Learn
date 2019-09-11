package exams.IQIYI;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static int Awin=0;//A赢的次数
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] numsStr=sc.nextLine().split(" ");
        int n=Integer.parseInt(numsStr[0]);//红球数量
        int m=Integer.parseInt(numsStr[1]);//蓝球数量

        if (n==0){
            System.out.println("0.00000");
        }
        else {
            int[] trys=new int[m+n];//以奇数代表红球，偶数代表蓝球
            int st1=1;
            int st2=2;
            for (int i=0;i<n;i++){
                trys[i]=st1;
                st1+=2;
            }
            for (int i=n;i<n+m;i++){
                trys[i]=st2;
                st2+=2;
            }
            Arrays.sort(trys);

            //对trys进行字典序排列
            //假设一次性拿球结束，之后再进行结果的分析
            cal(trys,trys.length);

            int num=1;//总局数
            for (int i=1;i<=trys.length;i++)
                num*=i;

            double d=Awin*1.0/num;
            DecimalFormat decimalFormat=new DecimalFormat("0.00000");
            System.out.println(decimalFormat.format(d));
        }

    }

    private static void cal(int[] trys,int n) {
        int num=1;//计算有多少个情况
        int a=0,b=0;
        for (int i=1;i<=n;i++)
            num*=i;

        while ((num--)>0){
            for (int i=0;i<n;++i){
                //已完成一次排序，进行结果的处理
                if ((i%3==0)&&(trys[i]%2==1)){//该局为A摸球
                    Awin++;
                    break;
                }
                if ((i%3==1)&&(trys[i]%2==1)){//该局为A摸球
                    break;
                }
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
