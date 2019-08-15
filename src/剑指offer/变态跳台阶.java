package 剑指offer;

public class 变态跳台阶 {
    /**
     * 一只青蛙一次可以跳上1级台阶，
     * 也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * */
    public int JumpFloorII(int target) {
        /*
        //法一：迭代的变种
        if (target<=2)
            return target;

        int[] dp=new int[target+1];//0号不使用
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=target;i++){
            for (int j=i-1;j>=1;j--)
                dp[i]+=dp[j];
            dp[i]++;
        }
        return dp[target];
        */
        if (target<0)
            return 0;
        else if (target==0||target==1)
            return 1;
        else
            return 2*JumpFloorII(target-1);
    }

}
