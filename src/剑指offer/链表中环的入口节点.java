package 剑指offer;

public class 链表中环的入口节点 {
    //给一个链表，
    //若其中包含环，请找出该链表的环的入口结点，
    //否则，输出null。
    /*
    思路：
    第一步： 找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，
    p2每次走二步，直到p1==p2找到在环中的相汇点。
    第二步： 找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,
    p1所经过节点数为x,设环中有r个节点, p2比p1多走 n (n >= 1)圈.
    有2x=nr+x; 可以看出p1实际走了n个环的步数，再让p2指向链表头部，
    p1位置不变，p1,p2每次走一步直到p1==p2; 此时p1和 p2指向环的入口.
    简单证明：
    设起点到相遇点距离为x，起点到入口点距离为y，环长度为r，
    则快慢指针相遇时，满足2x-x=nr，n为快指针在环中转的圈数。
    于是 x=nr 快慢指针相遇点距环入口点距离 x-y(正负没关系) 。
    相遇后，快指针从起点重新开始以步长为1速度开始走，
    经过距离y到达环入口点，
    慢指针走y步后距离环入口点距离为 x-y+y = x = nr，
    即走到了环入口点，两个指针相遇！
    详见链接：https://www.cnblogs.com/acm1314/p/7056463.html
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        //不成环
        if (pHead==null||pHead.next==null)return null;

        //设置两个指针
        ListNode p1=pHead;
        ListNode p2=pHead;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            if (p1==p2){//找到相交节点
                p2=pHead;
                while (p1!=p2){
                    p1=p1.next;
                    p2=p2.next;
                }
                if (p1==p2)
                    return p1;
            }
        }
        return null;//没有环
    }

}
