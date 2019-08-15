package 剑指offer;

public class 调整数组顺序使奇数位于偶数前面 {
    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    //使得所有的奇数位于数组的前半部分，
    //所有的偶数位于数组的后半部分，
    //并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public void reOrderArray(int [] array) {
        if (array==null|| array.length==0)
            return;

        int i=0,j;
        while (i< array.length){
            //i的元素非为偶数，且未到最后一个
            while (i< array.length&&!isEven(array[i])){
                i++;
            }
            j=i+1;//i为找到的第一个偶数；j为找到的第一个奇数
            while (j< array.length&&isEven(array[j]))
                j++;
            if (j< array.length){
                int tmp=array[j];
                for (int j2=j-1;j2>=i;j2--){
                    array[j2+1]=array[j2];
                }
                array[i++]=tmp;//array[i]赋值为tmp，且i++
            }
            else //查找结束，没有奇数在偶数后面了
                break;
        }
    }

    boolean isEven(int n){
        if(n%2==0)
            return true;
        return false;
    }

}
