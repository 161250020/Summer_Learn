package 剑指offer;

import java.util.ArrayList;

public class 和为S的连续正数序列 {
    //输出所有和为S的连续正数序列。
    //序列内按照从小至大的顺序，
    //序列间按照开始数字从小到大的顺序
    //PS：为连续正数序列，则初始化的时候，plow和phigh是不一样的，因为要连续！
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret=new ArrayList<>();

        int plow=1,phigh=2;
        while (phigh>plow){
            int cur=(phigh+plow)*(phigh-plow+1)/2;

            if (cur==sum){
                ArrayList<Integer> list=new ArrayList<>();
                for (int i=plow;i<=phigh;i++)list.add(i);
                ret.add(list);
                plow++;
            }
            else if (cur>sum){
                plow++;
            }
            else {
                phigh++;
            }
        }
        return ret;
    }

}
