package 剑指offer;

public class 两个链表的第一个公共结点 {
    //输入两个链表，找出它们的第一个公共结点。
    /*
    解题思路：
    找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走
    （因为2个链表用公共的尾部）
    */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1=lengthOfListNode(pHead1);
        int len2=lengthOfListNode(pHead2);
        if (len1>len2){//pHead1长
            pHead1=walkStep(pHead1,len1-len2);
        }
        else if (len1<len2){//pHead2长
            pHead2=walkStep(pHead2,len2-len1);
        }
        else {
            if (pHead1==pHead2)return pHead1;
            else return null;
        }

        while (pHead1!=null){
            if (pHead1==pHead2)return pHead1;
            pHead1=pHead1.next;
            pHead2=pHead2.next;
        }
        return null;
    }

    private ListNode walkStep(ListNode pHead, int len) {
        for (int i=0;i<len;i++)
            pHead=pHead.next;

        return pHead;
    }

    private int lengthOfListNode(ListNode pHead) {
        int len=0;
        while (pHead!=null){
            len++;
            pHead=pHead.next;
        }
        return len;
    }


}
