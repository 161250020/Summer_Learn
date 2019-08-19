package 剑指offer;

public class 扑克牌顺子 {
    //一副扑克牌，里面有2个大王,2个小王(一副牌原本是54张，现在是56张)，
    //随机从中抽出了5张牌,看看能不能抽到顺子，
    //大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13，
    //为了方便起见,你可以认为大小王是0。
    //思路：
    //max 记录：最大值
    //min 记录：最小值
    //min ,max 都不记0
    //满足条件 1 max - min <5（因为要为顺子，且只有5张牌，所以这个条件一定要成立）
    //         2 除0外没有重复的数字(牌)
    //         3 数组长度为5
    //如果max-min<5，则数组中数字的范围就限制了，
    //又没有重复数字，则其余非min~max的数字就是以0代替的，
    //也是合理的。
    public boolean isContinuous(int [] numbers) {
        int len=numbers.length;
        if (len!=5)
            return false;

        int max=-1;//进行初始化
        int min=14;
        int[] d=new int[14];//存储14种牌的数量
        for (int i=0;i<len;i++){
            d[numbers[i]]++;
            if (numbers[i]==0)
                continue;
            if (d[numbers[i]]>1)//为对子
                return false;
            if (numbers[i]>max)
                max=numbers[i];
            if (numbers[i]<min)
                min=numbers[i];
        }
        if (max-min<5)
            return true;
        return false;
    }

}
