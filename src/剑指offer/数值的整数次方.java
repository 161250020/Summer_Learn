package 剑指offer;

public class 数值的整数次方 {
    //给定一个double类型的浮点数base和int类型的整数exponent。
    //求base的exponent次方。
    public double Power(double base, int n) {
        double res=1,curr=base;
        int exponent;
        if (n>0)
            exponent=n;
        else if (n<0){
            if (base==0)
                throw new RuntimeException("分母不能为0。");
            exponent=-1*n;
        }
        else {
            if (base==0)
                throw new RuntimeException("基数和指数同时为0，无意义。");
            return 1;
        }

        while (exponent!=0){
            if ((exponent&1)==1){
                res*=curr;
            }
            curr*=curr;//翻倍
            exponent>>=1;//右移一位
        }
        return n>0?res:(1/res);
    }

}
