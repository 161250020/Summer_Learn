package 剑指offer;

public class 链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null||k<=0)
            return null;

        ListNode pre=head;
        ListNode last=head;
        for (int i=1;i<k;i++)
            if (pre.next!=null)
                pre=pre.next;
            else
                return null;

        while (pre.next!=null){
            pre=pre.next;
            last=last.next;
        }
        return last;
    }

}
