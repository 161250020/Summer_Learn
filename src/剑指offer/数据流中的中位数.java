package 剑指offer;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * */
public class 数据流中的中位数 {

    //记录由大到小的数据---更多的那一个优先队列（如果这两个优先队列的内容大小不一致）
    PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
    //记录由小到大的数据
    PriorityQueue<Integer> q=new PriorityQueue<>();

    public void Insert(Integer num) {
        if (p.isEmpty()||(num<=p.peek()))p.offer(num);
        else q.offer(num);

        if (p.size()==q.size()+2)q.offer(p.poll());
        if (p.size()+1==q.size())p.offer(q.poll());
    }

    public Double GetMedian() {
        return (p.size()==q.size())? (p.peek()+q.peek())/2.0 : p.peek()*1.0;
    }
}
