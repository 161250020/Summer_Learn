package exams.xiaomi;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String solution(String[] input) {
        StringBuilder s=new StringBuilder();
        for (int i=0;i<input.length;i++){
            String[] lines=input[i].split(" ");
            int[] ints=new int[lines.length];
            for (int j=0;j<lines.length;j++){
                ints[j]=Integer.parseInt(lines[j]);
            }

            for (int j=0;j<(lines.length-1);j++){
                if (ints[j]==ints[j+1]) {
                    ints[j] = ints[j] + ints[j + 1];
                    ints[j+1]=0;
                }
            }

            int printCount=0;
            for(int j=0;j<ints.length;j++){//非0的先输出
                if (ints[j]!=0){
                    s.append(ints[j]+" ");
                    printCount++;
                }
            }
            //输出0
            if (printCount!=ints.length){
                for (int j=0;j<(ints.length-printCount);j++)
                    s.append("0 ");
            }
            String s2=s.toString();
            s2=s2.substring(0,s2.length()-1);
            s2=s2+"\n";
            s=new StringBuilder(s2);

        }
        return s.toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = solution(_input);
        System.out.println(res);
    }
}
