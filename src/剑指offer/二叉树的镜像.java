package 剑指offer;

import java.util.Stack;

public class 二叉树的镜像 {
    //操作给定的二叉树，将其变换为源二叉树的镜像。
    //这是非递归的方法，还有类似前序遍历的递归方法
    public void Mirror(TreeNode root) {
        if (root==null)
            return;

        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tree=stack.pop();
            TreeNode left=tree.left;
            tree.left=tree.right;
            tree.right=left;

            if (tree.left!=null)
                stack.push(tree.left);
            if (tree.right!=null)
                stack.push(tree.right);
        }
    }

}
