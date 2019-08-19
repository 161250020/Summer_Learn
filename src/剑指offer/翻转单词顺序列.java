package 剑指offer;

public class 翻转单词顺序列 {
    //I am a student.
    //翻转后：student. a am I
    //如果是split，那么就太简单了，至少要有一个算法的思路啊
    //于是思路如下：
    //  对于字符串，先整体翻转，然后对于非空格的部分，再次进行局部翻转
    public String ReverseSentence(String str) {
        char[] chars=str.toCharArray();
        //进行整体字符串的翻转
        Reverse(chars,0,chars.length-1);
        //进行局部非空格字符串的翻转
        int i=0;
        while (i<str.length()){
            int start=-1,end=-1;
            //先找到start
            for (;i<str.length();i++){
                if (chars[i]!=' '){
                    start=i;
                    break;
                }
            }

            //再找到end
            for (;i<str.length();i++){
                if (chars[i]==' '){
                    end=i-1;
                    break;
                }
            }
            if (start!=-1&&end==-1)//如果i后面没有空格则直接翻转到最后一个字符
                end=chars.length-1;

            //翻转从start到end的字符串
            Reverse(chars,start,end);
        }

        //对char数组里面的内容进行连接，成为一个字符串
        StringBuilder stringBuilder=new StringBuilder();
        for (char c:chars)
            stringBuilder.append(c);

        return stringBuilder.toString();
    }

    private void Reverse(char[] chars, int start, int end) {
        for (int i=start,j=end;i<j;i++,j--){
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
        }
    }

}
