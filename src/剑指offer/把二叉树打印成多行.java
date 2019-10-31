package 剑指offer;

import java.util.ArrayList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * */
public class 把二叉树打印成多行 {
    //这里使用递归的方法来完成，非递归的层次遍历的方法这里就不再赘述了
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret=new ArrayList<>();

        if (pRoot==null)return ret;

        deep(ret,1,pRoot);
        return ret;
    }

    private void deep(ArrayList<ArrayList<Integer>> ret, int depth, TreeNode pRoot) {
        if (ret.size()<depth)ret.add(new ArrayList<>());
        ret.get(depth-1).add(pRoot.val);

        if (pRoot.left!=null)
            deep(ret,depth+1,pRoot.left);
        if (pRoot.right!=null)
            deep(ret,depth+1,pRoot.right);
    }


}
