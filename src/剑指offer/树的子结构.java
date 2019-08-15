package 剑指offer;

public class 树的子结构 {
        //输入两棵二叉树A，B，判断B是不是A的子结构。
        //（ps：我们约定空树不是任意一个树的子结构）
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //已提前处理空树问题，后面的代码就不需要烦恼了
        if(root1==null||root2==null)
            return false;

        return IsSubtree(root1,root2)
                ||HasSubtree(root1.left,root2)
                ||HasSubtree(root1.right,root2);
    }

    private boolean IsSubtree(TreeNode root1,TreeNode root2){
        if (root2==null)
            return true;
        if (root1==null)//root2不为null，而root1为null
            return false;

        //root1和root2都不为null
        if (root1.val==root2.val){
            return IsSubtree(root1.left,root2.left)&&
                    IsSubtree(root1.right,root2.right);
        }
        else
            return false;
    }

}
