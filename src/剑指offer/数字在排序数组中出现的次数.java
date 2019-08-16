package 剑指offer;

public class 数字在排序数组中出现的次数 {
    //统计一个数字在排序数组中出现的次数。
    //看到有序：二分查找，可以：递归/循环来实现，
    //查找的目标是k第一次和最后一次出现的index
    public int GetNumberOfK(int [] array , int k) {
        int length=array.length;
        if (length==0)
            return 0;

        int firstK=getFirstK(array,k,0,array.length-1);
        int lastK=getLastK(array,k,0,array.length-1);

        if (firstK!=-1&&lastK!=-1){
            return lastK-firstK+1;
        }

        return 0;
    }

    private int getFirstK(int[] array, int k, int start, int end) {
        if (start>end)
            return -1;

        int mid=(start+end)/2;
        if (array[mid]>k)
            return getFirstK(array,k,start,mid-1);
        else if (array[mid]<k)
            return getFirstK(array,k,mid+1,end);
        else if ((mid-1>=0)&&(array[mid-1]==k)){
            //这时候array[mid]==k!
            return getFirstK(array,k,start,mid-1);
        }
        else{//这时候array[mid]==k!
            return mid;//即：这是数组中第一个出现的k
        }
    }

    private int getLastK(int[] array, int k, int start, int end) {
        if (start>end)
            return -1;

        int mid=(start+end)/2;
        if (array[mid]>k)
            return getLastK(array,k,start,mid-1);
        else if (array[mid]<k)
            return getLastK(array,k,mid+1,end);
        else if ((mid+1<=end)&&(array[mid+1]==k)){
            //这时候array[mid]==k!
            return getLastK(array,k,mid+1,end);
        }
        else{//这时候array[mid]==k!
            return mid;//即：这是数组中第一个出现的k
        }
    }

}
