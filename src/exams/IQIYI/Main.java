package exams.IQIYI;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static int sum=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());//N
        String[] AisStrs=sc.nextLine().split(" ");//有N-1个数字
        int[] Ais=new int[N-1];
        for (int i=0;i<N-1;i++){
            Ais[i]=Integer.parseInt(AisStrs[i]);
        }
        HashSet<Integer> nums=new HashSet<>();
        int lastNum=0;
        for (int i=1;i<=N;i++){
            nums.add(i);
            lastNum=i;
            cal(Ais,0,nums,lastNum,N);//计算当前index为N-1时候的符合情况的个数
            nums.remove(i);
        }

        System.out.println(sum);
    }

    private static void cal(int[] ais, int start, HashSet<Integer> nums, int lastNum, int N) {
        //已经到达最后一步
        if (start==N-2){
            if (ais[start]==0){//pi<pi+1
                for (int i=1;i<=N;i++){
                    if ((!nums.contains(i))&&(lastNum<i)){
                        sum++;
                        sum =sum%(1000000007);
                    }
                }
            }
            else {
                for (int i=1;i<=N;i++){
                    if ((!nums.contains(i))&&(lastNum>i)){
                        sum++;
                        sum =sum%(1000000007);
                    }
                }
            }
            return;
        }

        //中间步骤
        if (ais[start]==0){//pi<pi+1
            for (int i=1;i<=N;i++){
                if ((!nums.contains(i))&&(lastNum<i)){
                    nums.add(i);
                    cal(ais,start+1,nums,i,N);
                    nums.remove(i);
                }
            }
        }
        else {////pi>pi+1
            for (int i=1;i<=N;i++){
                if ((!nums.contains(i))&&(lastNum>i)){
                    nums.add(i);
                    cal(ais,start+1,nums,i,N);
                    nums.remove(i);
                }
            }
        }
    }
}
