package 剑指offer;

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class 从尾到头打印链表 {
    //第一就是利用栈先入后出的特性完成。
    //第二就是存下来然后进行数组翻转。
    //第三是利用递归。
    /**
     * 方法一：链表从尾到头输出，利用递归实现，
     * 不使用库函数直接printf输出的时候用递归比较好，
     * 所以这里不是最优的选择
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode==null)
            return new ArrayList<Integer>();

        //为最后一个节点
        if (listNode.next==null){
            ArrayList<Integer> ret=new ArrayList<>();
            ret.add(listNode.val);
            return ret;
        }
        else {
            ArrayList<Integer> ret=printListFromTailToHead(listNode.next);
            ret.add(listNode.val);
            return ret;
        }
    }

}
