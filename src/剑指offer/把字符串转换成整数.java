package 剑指offer;

public class 把字符串转换成整数 {
    /*
    将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
    但是string不符合数字要求时返回0)，
    要求不能使用字符串转换整数的库函数。
    数值为0或者字符串不是一个合法的数值则返回0。
    输入描述:
        输入一个字符串,包括数字字母符号,可以为空
    输出描述:
        如果是合法的数值表达则返回该数字，否则返回0
     */

    /*
    * 看到一个乘以10的好方法：
    * res = (res << 1) + (res << 3)；
    * 即：res*10可以分解为：res左移一位（res*2），
    * 加上res左移3位（res*8）；
     * */
    public int StrToInt(String str) {
        if (str==null||str.length()==0)return 0;

        int len=str.length(),s=1;
        if (str.charAt(0)=='-')s=-1;
        int ret=0;//返回值
        for (int i=(str.charAt(0)=='-'||str.charAt(0)=='+')?1:0;
        i<len;i++){
            //含有非数字的字符，则返回0
            if (!(str.charAt(i)>='0'&&str.charAt(i)<='9'))
                return 0;
            //进行数字的相加
            //PS:对于ret<<3要记得加上()，否则就会计算错误！
            //因为：+和-的优先级比<<和>>的高
            ret=(ret<<1)+(ret<<3)+(str.charAt(i)-'0');
        }
        return ret*s;
    }

}
