package 剑指offer;


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class 复杂链表的复制 {
    /**
     * 输入一个复杂链表
     * （每个节点中有节点值，以及两个指针，
     * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。
     * （注意，输出结果中请不要返回参数中的节点引用，
     * 否则判题程序会直接返回空）
     * */
    public RandomListNode Clone(RandomListNode pHead){
         if (pHead==null)
             return null;

         //复制
         RandomListNode curNode=pHead;
         while (curNode!=null){
             RandomListNode node=new RandomListNode(curNode.label);
             node.next=curNode.next;
             curNode.next=node;
             curNode=node.next;
         }
         //遍历链表
         curNode=pHead;
         while (curNode!=null){
             RandomListNode node=curNode.next;
             if (curNode.random!=null)
                 node.random=curNode.random.next;
             curNode=node.next;
         }
         //拆分
         RandomListNode cloneHead=pHead.next;
         RandomListNode tmp;
         curNode=pHead;
         while (curNode.next!=null){
             tmp=curNode.next;
             curNode.next=tmp.next;
             curNode=tmp;
         }

         return cloneHead;
    }

}
