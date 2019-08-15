package 剑指offer;

public class 二进制中1的个数 {
    public int NumberOf1(int n) {
//        int count = 0;
//        while(n!= 0){
//            count++;
//            n = n & (n - 1);
//        }
//        return count;
        int count=0;
        int flag=1;
        while (flag!=0){
            if ((n&flag)!=0)
                count++;
            flag=flag<<1;//flag左移一位
        }
        return count;
    }
}
