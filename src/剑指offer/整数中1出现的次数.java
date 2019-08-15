package 剑指offer;

public class 整数中1出现的次数 {
    /**
     * 求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
     * eg：1~13的整数中1出现的次数：1、10、11、12、13
     * */
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n<=0)
            return 0;

        int count=0;
        for (long i=1;i<=n;i*=10){
            long diviver=i*10;
            count+=(n/diviver)*i+Math.min(
                    Math.max(n%diviver-i+1,0),
                    i
            );
        }

        return count;
    }

}
