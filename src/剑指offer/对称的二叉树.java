package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * */
public class 对称的二叉树 {
    //递归的方法
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot==null)return true;
        else return sub(pRoot.left,pRoot.right);
    }
    boolean sub(TreeNode left, TreeNode right){
        if (left==null&&right==null)return true;
        if (left==null||right==null)return false;
        return left.val==right.val
                &&sub(left.left, right.right)
                &&sub(left.right, right.left);
    }

    //非递归的方法几乎是一样的，都是一对对的抛出需要一样的TreeNode，
    // 区别在于stack为从后面一对对抛出，queue为从前面一对对抛出
    //非递归的方法---栈
    boolean isSymmetrical1(TreeNode pRoot)
    {
        if (pRoot==null)return true;

        Stack<TreeNode> s=new Stack();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while (!s.isEmpty()){
            TreeNode right=s.pop();
            TreeNode left=s.pop();
            if (right==null&&left==null)continue;
            if (right==null||left==null)return false;
            if (right.val!=left.val)return false;
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }

    //非递归的方法---队列
    boolean isSymmetrical2(TreeNode pRoot)
    {
        if (pRoot==null)return true;

        Queue<TreeNode> s=new LinkedList<>();
        s.offer(pRoot.left);
        s.offer(pRoot.right);
        while (!s.isEmpty()){
            TreeNode right=s.poll();
            TreeNode left=s.poll();
            if (right==null&&left==null)continue;
            if (right==null||left==null)return false;
            if (right.val!=left.val)return false;
            s.offer(left.left);
            s.offer(right.right);
            s.offer(left.right);
            s.offer(right.left);
        }
        return true;
    }
}
