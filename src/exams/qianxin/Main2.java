package exams.qianxin;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int level=Integer.parseInt(sc.nextLine());
        String[] splits=sc.nextLine().split(" ");//所有节点的值
        String[] nums=sc.nextLine().split(" ");//两个数字

        if (nums[0].equals("-1")||nums[1].equals("-1"))
            System.out.println("-1");

        int count=0;
        int index1=-1;
        int index2=-1;
        for (int i=0;i<splits.length;i++){
            if (splits[i].equals(nums[0])){
                count++;
                index1=i;
            }
            if (splits[i].equals(nums[1])){
                count++;
                index2=i;
            }

            if (count>=2)
                break;
        }
        if (count<2){
            System.out.println("-1");
        }
        else{
            //第i个节点的左右子结点为：2*i+1，2*i+2；
            //第i个节点的父节点为：(i-1)/2
            //存储的顺序：节点-父节点-f父节点的父节点-...，不含根节点
            ArrayList<Integer> array1=new ArrayList<>();
            ArrayList<Integer> array2=new ArrayList<>();

            for (int i=index1;i>0;i=(i-1)/2){
                array1.add(i);
            }
            for (int i=index2;i>0;i=(i-1)/2){
                array2.add(i);
            }

            //查找最近的index的值，如果最后index为-1，则最近的公共父节点为根节点
            int publicIndex=-1;
            for (int i=0;i<array1.size();i++){
                for (int j=0;j<array2.size();j++){
                    if (array1.get(i)==array2.get(j))
                        publicIndex=array1.get(i);

                    if (publicIndex!=-1)
                        break;
                }
                if (publicIndex!=-1)
                    break;
            }

            if (publicIndex==-1)
                System.out.println(splits[0]);
            else
                System.out.println(splits[publicIndex]);
        }
    }
}
