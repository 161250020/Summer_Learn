package 剑指offer;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 * */
public class 二叉搜索树的第k个结点 {
    //思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
    //所以，按照中序遍历顺序找到第k个结点就是结果。
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot==null||k<=0)return null;

        Stack<TreeNode> stack=new Stack<>();
        int count=0;//打印的节点的个数
        TreeNode node=pRoot;
        do{
            if (node!=null){
                stack.push(node);
                node=node.left;
            }
            else{
                node=stack.pop();
                count++;
                if (count==k)return node;
                node=node.right;
            }
        }while (node!=null||!stack.isEmpty());
        return null;
    }
}
