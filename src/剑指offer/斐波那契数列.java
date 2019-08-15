package 剑指offer;

public class 斐波那契数列 {
    /**
     * 大家都知道斐波那契数列，
     * 现在要求输入一个整数n，
     * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     * */
    public int Fibonacci(int n) {
        if (n==0)
            return 0;
        else if (n==1)
            return 1;

        //初始化sum和one
        int sum=1;
        int one=0;
        for (int i=2;i<=n;i++){
            sum=sum+one;//sum为后一位
            one=sum-one;//one初始化为原来的sum
        }
        return sum;
    }

}
