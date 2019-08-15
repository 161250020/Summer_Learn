package 剑指offer;

import java.util.ArrayList;
public class 旋转数组的最小数字 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，
     * 我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，
     * 输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
     * 该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * */
    //思路：https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba?answerType=1&f=discussion
    //选择“叫我皮卡丘”的牛友的思路解析
    //这里的实现：二分查找法
    public int minNumberInRotateArray(int [] array) {
        if (array.length==1)
            return array[0];

        int l=0;
        int r=array.length-1;
        while (l<=r){
            int mid=(l+r)/2;
            if (array[l]<array[r])
                return array[l];

            if (array[mid]>array[mid+1])
                return array[mid+1];

            if (array[mid]<array[mid-1])
                return array[mid];

            if (array[mid]>array[l])
                l=mid+1;
            else
                r=mid-1;
        }

        return 0;//数组大小为0，则返回0
    }

}
