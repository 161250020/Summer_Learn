package exams.huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    /**
     * 使用递归完成，
     * 设置递归的表达式为：dp[i]：以A[i]开头的相对位置相同的序列的长度
     * */
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num= Integer.parseInt(sc.nextLine());
        String[] As=sc.nextLine().split(" ");
        String[] Bs=sc.nextLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        ArrayList<Integer> B=new ArrayList<>();
        for (int i=0;i<num;i++){
            A.add(Integer.parseInt(As[i]));
            B.add(Integer.parseInt(Bs[i]));
        }

        int max=0;
        for(int start=0;start<A.size();start++){
            int len=dp(A,B,start);
        }

    }

    private static int dp(ArrayList<Integer> A, ArrayList<Integer> B, int start) {
        if (start>=A.size())
            return 0;

        if (start==(A.size()-1)){
            if (B.contains(A.get(start)))
                return 1;
            else
                return 0;
        }

        ArrayList<Integer> Acopy= (ArrayList<Integer>) A.clone();
        ArrayList<Integer> Bcopy= (ArrayList<Integer>) B.clone();

        int len=0;
        for(int pre=start+1;pre<A.size();pre++){
            len=Math.max(dp(A,B,pre),len);
        }
        return len;

    }
}
