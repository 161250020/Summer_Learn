package 剑指offer;

public class 字符流中第一个不重复的字符 {
    /*
    请实现一个函数用来找出字符流中第一个只出现一次的字符。
    例如，当从字符流中只读出前两个字符"go"时，
    第一个只出现一次的字符是"g"。
    当从该字符流中读出前六个字符“google"时，
    第一个只出现一次的字符是"l"。
    PS:如果当前字符流没有存在出现一次的字符，返回#字符。
     */
    StringBuilder s=new StringBuilder();
    int[] charNum=new int[256];//一共有256个字符，2的8次方
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        s.append(ch);
        charNum[ch]+=1;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        String str=s.toString();
        for (int i=0;i<s.length();i++){
            if (charNum[s.charAt(i)]==1)
                return s.charAt(i);
        }
        return '#';
    }

}
