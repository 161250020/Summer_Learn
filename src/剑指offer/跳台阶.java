package 剑指offer;

public class 跳台阶 {
    //本质上还是斐波那契数列，所以迭代也可以求
    //dp(i) = dp(i-2) + dp(i-1)
    public int JumpFloor(int target) {
        if (target<=2)
            return target;

        int pre2=1,pre1=2;
        for (int i=3;i<=target;i++){
            int cur=pre1+pre2;
            pre2=pre1;
            pre1=cur;
        }
        return pre1;
    }

}
