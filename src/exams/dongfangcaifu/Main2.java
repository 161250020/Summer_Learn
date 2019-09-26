package exams.dongfangcaifu;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        //异常情况输出-1

        Stack<Integer> s1=new Stack();
        Stack<Character> s2=new Stack();

        int sum=0;
        try{
            for (int i=0;i<line.length();i++){
                char c=line.charAt(i);
                if (c=='+'){
                    s2.push('+');
                }
                else if (c=='*'){
                    s2.push('*');
                }
                else if ((c>='0')&&(c<='9')){
                    String str=c+"";
                    for (int j=i+1;j<line.length();j++){
                        if ((line.charAt(j)>='0')&&(line.charAt(j)<='9'))str+=line.charAt(j);
                        else {
                            i=j-1;break;
                        }
                    }
                    s1.push(Integer.parseInt(str));
                    if ((!s2.empty())&&(s2.peek()=='*')){
                        s2.pop();
                        int n1=s1.pop();
                        int n2=s1.pop();
                        s1.push(n1*n2);
                    }
                }
                else{
                    sum=-1;
                    break;
                }
            }
            while (!s2.isEmpty()){
                int n1=s1.pop();
                int n2=s1.pop();
                s2.pop();
                s1.push(n1+n2);
            }
            if (!s1.isEmpty())sum=s1.pop();
        }catch (Exception e){
            sum=-1;
        }
        System.out.println(sum);
    }
}
