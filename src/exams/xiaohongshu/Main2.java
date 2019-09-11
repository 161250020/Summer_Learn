package exams.xiaohongshu;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();

        Stack<Character> bytes=new Stack<>();//存字符和括号
        for (int i=0;i<line.length();i++){
            char c=line.charAt(i);
            if (c=='(')
                bytes.push('(');
            else if (c==')')
                bytes.pop();
            else {
                if ((!bytes.empty())&&(bytes.peek()=='(')){//不进行压栈/处理

                }
                else {
                    if ((!bytes.empty())&&(c=='<'))
                        bytes.pop();
                    else if (c!='<')
                        bytes.push(c);
                }
            }
        }

        String ret="";
        while (!bytes.empty()){
            ret=bytes.pop()+ret;
        }
        System.out.println(ret);
    }

}
