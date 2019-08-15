package 剑指offer;

public class 替换空格 {
    /**
     * 请实现一个函数，
     * 将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * */
    //思路：从后往前插入；
    public String replaceSpace(StringBuffer str) {
        str=new StringBuffer(" hello");
        int spacenum=0;//记录字符串中一共有多少个空格
        for (int i=0;i<str.length();i++)
            if (str.charAt(i)==' ')
                spacenum++;

        //初始化为原来的字符串的最后一个字符
        int indexold=str.length()-1;
        //新的字符串长度=原来字符串的长度+会增加的字符数量
        int newlength=str.length()+spacenum*2;
        //初始化为新字符串的最后一个字符
        int indexnew=newlength-1;
        //重新定义StringBuffer的长度
        str.setLength(newlength);
        //indexold<indexnew以保证新添加的字符串不会覆盖未遍历到的字符
        for (;indexold>=0&&indexold<indexnew;indexold--){
            //遍历到的字符为空格
            if (str.charAt(indexold)==' '){
                str.setCharAt(indexnew--,'0');
                str.setCharAt(indexnew--,'2');
                str.setCharAt(indexnew--,'%');
            }
            else {//遍历到的字符不为空格
                str.setCharAt(indexnew--,str.charAt(indexold));
            }
        }

        return str.toString();
    }
}
