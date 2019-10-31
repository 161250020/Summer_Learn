package 剑指offer;

/**
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;//父节点

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class 二叉树的下一个结点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode==null)return null;
        if (pNode.right!=null){
            //找到右子树的最左边的元素
            pNode=pNode.right;
            while (pNode.left!=null)pNode=pNode.left;
            return pNode;
        }
        while (pNode.next!=null){
            if (pNode.next.left==pNode)return pNode.next;
            //找到上一个的将当前节点作为左节点的节点
            pNode=pNode.next;
        }
        return null;
    }
}
