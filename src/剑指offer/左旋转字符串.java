package 剑指offer;

public class 左旋转字符串 {
    /*
    汇编语言中有一种移位指令叫做循环左移（ROL），
    现在有个简单的任务，
    就是用字符串模拟这个指令的运算结果。
    对于一个给定的字符序列S，
    请你把其循环左移K位后的序列输出。
    例如，字符序列S=”abcXYZdef”,
    要求输出循环左移3位后的结果，
    即“XYZdefabc”。
     */
    //思路一：原理：YX = (X^T Y^T)^T
    //思路二：左旋字符串（循环左移字符串）：
    //  左移串长length位后和原来一样，所以正真需要左移的是n % str.length()位
    public String LeftRotateString(String str,int n) {
        if (str==null||str.length()==0) return str;

        int len=str.length();
        n%=len;
        char[] chars=str.toCharArray();
        //X^T：对X进行翻转，即：对0~n-1进行翻转
        reverse(chars,0,n-1);
        //Y^T：对Y进行翻转，即：对n~len-1进行翻转
        reverse(chars,n,len-1);
        //(X^T Y^T)^T：对整体的翻转后的字符串进行翻转
        reverse(chars,0,len-1);

        StringBuilder stringBuilder=new StringBuilder();
        for (char c:chars)
            stringBuilder.append(c);

        return stringBuilder.toString();
    }

    private void reverse(char[] chars, int start, int end) {
        for (int i=start,j=end;i<j;i++,j--){
            //这样子写更加容易理解：设置i和j，而不仅仅是i
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
        }
    }

}
