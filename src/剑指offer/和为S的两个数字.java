package 剑指offer;

import java.util.ArrayList;

public class 和为S的两个数字 {
    //输入一个递增排序的数组和一个数字S，
    //在数组中查找两个数，使得他们的和正好是S，
    //如果有多对数字的和等于S，输出两个数的乘积最小的。
    //输出描述:
    //对应每个测试案例，输出两个数，小的先输出。
    /*
    数列满足递增，设两个头尾两个指针i和j，
    若ai + aj == sum，就是答案（相差越远乘积越小）
    若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
    若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
    PS：有这样一种说法：
        相差越远乘积越小，
        所以最开始出现的符合条件的两个数字，他们乘积最小，
        如果我是每一对都比较了一下，那么会超时！！！
        递增的数组或许是很大的，所以必须使用上面的说法！
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> ret=new ArrayList<>();

        if (array.length<2) return ret;

        int low=0,high=array.length-1;
        while (low<high){
            int cur=array[low]+array[high];
            if (cur==sum){
                ret.add(array[low]);
                ret.add(array[high]);
                break;
            }
            else if (cur<sum){
                low++;
            }
            else {
                high--;
            }
        }
        return ret;
    }

}
