package 剑指offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最小的K个数 {
    /**
     * 输入n个整数，找出其中最小的K个数。
     * 例如输入4,5,1,6,2,7,3,8这8个数字，
     * 则最小的4个数字是1,2,3,4.
     * */
    //虽然排序也是可以写成的，但是如果要找的k太少，
    //而input的数字太多，那么排序就不划算。
    //所以这里使用：最大堆---优先队列
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        if (k>input.length||k==0)
            return result;

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);//o2>o1
            }
        });

        for (int i=0;i<input.length;i++){
            if (maxHeap.size()!=k)
                maxHeap.offer(input[i]);
            else if (maxHeap.peek()>input[i]){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }

        //将最大堆里面的内容添加到返回数列当中
        for (Integer integer:maxHeap)
            result.add(integer);

        return result;
    }

}
