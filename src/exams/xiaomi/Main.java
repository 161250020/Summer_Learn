package exams.xiaomi;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(int[] arr) {
        if (arr.length==0||arr.length==1){
            return 0;
        }
        else {
            //总移动距离最小的数列为：正序/倒序排列
            ArrayList<Integer> temp=new ArrayList<>();
            ArrayList<Integer> temp2=new ArrayList<>();
            for (int i=0;i<arr.length;i++){
                temp.add(arr[i]);
                temp2.add(arr[i]);
            }
            Arrays.sort(arr);

            //进行正序排列
            int moveNum=0;//移动的次数
            for (int i=0;i<arr.length;i++){//进行的次数
                int maxLen=Math.abs(0-temp.indexOf(arr[0]));//第0个的差值
                int maxIndex=0;
                for(int j=1;j<arr.length;j++){
                    if (Math.abs(j-temp.indexOf(arr[j]))>maxLen){
                        maxLen=Math.abs(j-temp.indexOf(arr[j]));
                        maxIndex=j;
                    }
                }
                if (maxLen!=0){
                    moveNum++;
                    int index=temp.indexOf(arr[maxIndex]);
                    temp.remove(index);
                    temp.add(i,arr[maxIndex]);
                }
                else
                    break;
            }

            //进行倒序排列
            int moveNum2=0;//移动的次数
            for (int i=0;i<arr.length;i++){//进行的次数
                int max=temp2.get(i);
                for(int j=i+1;j<temp2.size();j++){
                    max=(temp2.get(j)>max)?temp2.get(j):max;
                }
                if (max!=temp2.get(i)){
                    moveNum2++;
                }
                int index=temp2.indexOf(max);
                temp2.remove(index);
                temp2.add(i,max);
            }

            return moveNum>moveNum2?moveNum2:moveNum;
        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = solution(_arr);
        System.out.println(String.valueOf(res));

    }
}
