package 剑指offer;

public class 删除链表中重复的结点 {
    /*
    在一个排序的链表中，
    存在重复的结点，请删除该链表中重复的结点，
    重复的结点不保留，返回链表头指针。
    例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */
    /*
    思路：
    非递归的代码：
    1. 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
    2.设置 pre ，last 指针， pre指针指向当前确定不重复的那个节点，
    而last指针相当于工作指针，一直往后面搜索。
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode first=new ListNode(-1);
        first.next=pHead;

        ListNode pre=first;
        ListNode last=first.next;
        while (last!=null){
            //该节点值重复
            if (last.next!=null&&last.val==last.next.val){
                //找到最后一个相同结点
                while (last.next!=null&&last.val==last.next.val){
                    last=last.next;
                }
                //pre的下一个先等于下一个不和当前last值相等的值
                //之后如果该pre的下一个值也是重复的，
                //会继续更新pre的下一个值
                pre.next=last.next;
                last=last.next;
            }
            else {
                //如果pre的下一个值不是重复的，
                //就pre指向pre的下一个值
                pre=pre.next;
                last=last.next;
            }
        }

        return first.next;
    }

}
