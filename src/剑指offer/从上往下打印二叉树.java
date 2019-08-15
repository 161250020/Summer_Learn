package 剑指offer;

import java.util.ArrayList;

public class 从上往下打印二叉树 {
    //从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    //这就是层次遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //思路是用arraylist模拟一个队列来存储相应的TreeNode
        ArrayList<Integer> ret=new ArrayList<>();
        ArrayList<TreeNode> treeNodes=new ArrayList<>();//模拟Queue

        if (root==null)
            return ret;

        treeNodes.add(root);
        while (treeNodes.size()!=0){
            TreeNode temp=treeNodes.remove(0);
            ret.add(temp.val);
            if (temp.left!=null)
                treeNodes.add(temp.left);
            if (temp.right!=null)
                treeNodes.add(temp.right);
        }
        return ret;
    }

}
