package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * */
public class 按之字形顺序打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret=new ArrayList<>();

        if (pRoot==null)return ret;

        //存储奇数行的内容
        Stack<TreeNode> s1=new Stack<>();
        //存储偶数行的数据内容
        Stack<TreeNode> s2=new Stack<>();

        //初始化，存入第一行
        s1.push(pRoot);

        while (!(s1.isEmpty()&&s2.isEmpty())){
            ArrayList<Integer> arr=new ArrayList<>();//待存入ret的Array
            if (!s1.isEmpty()){//则当前行为奇数行
                while (!s1.isEmpty()){
                    TreeNode temp=s1.pop();
                    arr.add(temp.val);
                    if (temp.left!=null)s2.push(temp.left);
                    if (temp.right!=null)s2.push(temp.right);
                }
            }
            else{//当前行为偶数行
                while (!s2.isEmpty()){
                    TreeNode temp=s2.pop();
                    arr.add(temp.val);
                    if (temp.right!=null)s1.push(temp.right);
                    if (temp.left!=null)s1.push(temp.left);
                }
            }
            ret.add(arr);
        }

        return ret;
    }
}
