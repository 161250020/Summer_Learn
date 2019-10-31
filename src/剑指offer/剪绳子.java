package 剑指offer;

/**
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。?(PS：不是应该是k[0]~k[m-1]吧？)
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * */
public class 剪绳子 {
    //使用动态规划完成，完成之前需要分析---什么时候的绳长不再是自身的长度是最大值
    //动态规划求解问题的四个特征：
    //①求一个问题的最优解；
    //②整体的问题的最优解是依赖于各个子问题的最优解；
    //③小问题之间还有相互重叠的更小的子问题；
    //④从上往下分析问题，从下往上求解问题；
    public int cutRope(int target) {
        if (target==2)return 1;
        if (target==3)return 2;

        int[] dp=new int[target+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;

        for (int i=4;i<=target;i++){
            int res=0;
            for (int j=1;j<=i/2;j++){//一半的即可，不然计算的次数就会是多了
                res=Math.max(res, dp[j]*dp[i-j]);
            }
            //对于非target的值，可以加上一种情况：i本身的长度
            //那么这个时候，i本身的长度如果更大，就可以更新为其本身的长度
            //虽然似乎i>=4之后，就不会出现i本身的长度更大的情况了
            if ((i!=target)&&(res<i))
                res=i;
            dp[i]=res;
        }
        return dp[target];
    }

}
