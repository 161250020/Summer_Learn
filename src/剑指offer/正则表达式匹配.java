package 剑指offer;

public class 正则表达式匹配 {
    /*
    请实现一个函数用来匹配包括'.'和'*'的正则表达式。
    模式中的字符'.'表示任意一个字符，
    而'*'表示它前面的字符可以出现任意次（包含0次）。
    在本题中，匹配是指字符串的所有字符匹配整个模式。
    例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
    但是与"aa.a"和"ab*a"均不匹配
     */
    public boolean match(char[] str, char[] pattern){
        if (str==null||pattern==null)return false;

        int strIndex=0,patternIndex=0;
        return matchCore(str,strIndex,pattern,patternIndex);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex==str.length&&patternIndex==pattern.length)return true;
        //pattern先到尾，str没有匹配完，匹配失败
        if (strIndex!=str.length&&patternIndex==pattern.length)return false;

        //模式第二个是*，且字符串第一个跟模式第一个匹配，分3中匹配模式；
        //如果不匹配，模式后移两位
        if (patternIndex+1<pattern.length&&pattern[patternIndex+1]=='*'){
            if ((strIndex!=str.length&&pattern[patternIndex]==str[strIndex])
            ||(strIndex!=str.length&&pattern[patternIndex]=='.')){
                return matchCore(str,strIndex,pattern,patternIndex+2)//模式后移两位，视为x*匹配0个字符
                        ||matchCore(str,strIndex+1,pattern,patternIndex+2)//视为模式匹配1个字符
                        ||matchCore(str,strIndex+1,pattern,patternIndex);//*匹配1个，再匹配str中的下一个
            }
            else {
                return matchCore(str,strIndex,pattern,patternIndex+2);
            }
        }
        else {
            //模式第二个不是*，且字符串第一个更模式第一个匹配，则都后移一位，否则直接返回false
            if ((strIndex!=str.length&&pattern[patternIndex]==str[strIndex])
                    ||(strIndex!=str.length&&pattern[patternIndex]=='.'))
                return matchCore(str,strIndex+1,pattern,patternIndex+1);
            else
                return false;
        }
    }

}
