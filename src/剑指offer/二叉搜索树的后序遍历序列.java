package 剑指offer;

public class 二叉搜索树的后序遍历序列 {
    /**
     * 输入一个整数数组，
     * 判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。
     * 假设输入的数组的任意两个数字都互不相同。
     * */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0)
            return false;

        return judge(sequence,0,sequence.length-1);
    }

    public boolean judge(int[] sequence, int left, int right){
        if (left>=right)
            return true;

        int index=-1;//找到第一个大于right位置的值
        for (int i=left;i<right;i++){
            if (sequence[i]>sequence[right]){
                index=i;
            }
            //确认index以及index之后的数值是大于right位置的值的
            //index的位置的值已经确认是大于right位置的值的
            if ((index!=-1)&&(sequence[i]<sequence[right]))
                return false;
        }

        if (index==-1)//则该序列全部都是小于最后一个值的
            return judge(sequence,left,right-1);

        //对该序列的前后两部分数据分别进行二叉搜索树的后序遍历判断
        return judge(sequence,left,index-1)&&
                judge(sequence,index,right-1);
    }

}
