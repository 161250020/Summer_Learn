package 剑指offer;

public class 数组中的逆序对 {
    /**
     * 在数组中的两个数字，
     * 如果前面一个数字大于后面的数字，
     * 则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。
     * 并将P对1000000007取模的结果输出。
     * 即输出P%1000000007
     *
     * 输入描述：
     * 题目保证输入的数组中没有的相同的数字
     * 数据范围：
     * 	对于%50的数据,size<=10^4
     * 	对于%75的数据,size<=10^5
     * 	对于%100的数据,size<=2*10^5
     * */
    /*归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，
    合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面
    数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
    参考剑指Offer，但是感觉剑指Offer归并过程少了一步拷贝过程。
    还有就是测试用例输出结果比较大，对每次返回的count mod(1000000007)求余
    */
    public int InversePairs(int [] array) {
        if (array==null||array.length==0)return 0;

        //存储该次递归排序的结果
        //存储：array的start到end已排好序的内容
        int[] copy=new int[array.length];
        for (int i=0;i<array.length;i++){
            copy[i]=array[i];
        }

        int res=InverseNumber(array,copy,0,array.length-1);
        return res%1000000007;
    }

    private int InverseNumber(int[] array, int[] copy, int start, int end) {
        if (start>=end)
            return 0;

        int mid=(start+end)/2;
        int leftCount=InverseNumber(array,copy,start,mid);
        int rightCount=InverseNumber(array,copy,mid+1,end);

        //两个移动array中排好序的前后两个小数组的指针
        int i=mid;
        int j=end;
        int copyIndex=end;//copy数组的该次递归存储从end开始
        int count=0;//存储该次递归的计算的逆序对的总数
        while ((i>=start)&&(j>mid)){
            if (array[i]>array[j]){
                count+=j-mid;
                if (count>=1000000007)
                    count%=1000000007;
                copy[copyIndex--]=array[i--];
            }
            else {
                copy[copyIndex--]=array[j--];
            }
        }

        for (;i>=start;i--)
            copy[copyIndex--]=array[i];
        for (;j>mid;j--)
            copy[copyIndex--]=array[j];

        for (int k=start;k<=end;k++)
            array[k]=copy[k];

        return (leftCount+rightCount+count)%1000000007;
    }

}
