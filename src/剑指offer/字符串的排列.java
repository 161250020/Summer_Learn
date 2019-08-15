package 剑指offer;

import java.util.*;

public class 字符串的排列 {
    /**
     * 输入一个字符串,
     * 按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,
     * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     *
     * 输入描述：
     * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
     * */
    //方法：非递归（字典序）+递归
    //法一：非递归
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list=new ArrayList<>();
        if (str==null||str.length()==0)
            return list;

        char[] chars=str.toCharArray();
        Arrays.sort(chars);//对char[]先进行排序成一个规则的数组
        list.add(String.valueOf(chars));//将排好序的字符串先添加进去
        int len=chars.length;
        while (true){
            int indexR=len-1;
            while (indexR>0&&(chars[indexR-1]>=chars[indexR]))
                indexR--;

            //数组中为倒序排列好了，于是退出循环
            if (indexR==0)
                break;

            //---字典序算法：https://www.cnblogs.com/darklights/p/5285598.html
            //---代表：这里的步骤是和上方链接当中的步骤类似
            //---找到indexA（list[a]的index）和indexB（list[b]的index）
            int indexA=indexR-1;
            int indexB=len-1;
            for (;indexB>indexA;indexB--){
                if (chars[indexB]>chars[indexA])
                    break;
            }
            //交换两个的值
            swap(chars,indexA,indexB);
            //---对list[a]后面的数据由小往大排列
            reverse(chars,indexA+1);
            //添加该排列进入list
            list.add(String.valueOf(chars));
        }
        return list;
    }

    public void reverse(char[] chars,int k){
        for (int i=k;i<chars.length;i++){
            for (int j=i+1;j<chars.length;j++){
                if (chars[j]<chars[i]){
                    swap(chars,i,j);
                }
            }
        }
    }

    //法二：递归
    public ArrayList<String> Permutation2(String str) {
        ArrayList<String> ret=new ArrayList<>();
        if (str!=null&&str.length()>0){
            Permutation2Helper(str.toCharArray(),0,ret);
            Collections.sort(ret);
        }

        return ret;
    }

    public void Permutation2Helper(char[] chars,int i,ArrayList<String> list){
        //i到了最后一个index，无法和后面的位置的值进行交换了
        if (i==chars.length-1)
            list.add(String.valueOf(chars));
        else {
            //递归去重：第i个数字和他后面的非重复数字进行交换
            Set<Character> charSet=new HashSet<Character>();
            for (int j=i;j<chars.length;j++){
                //这时候，j==i，即：第i位不交换的情况也是需要包含的
                if (!charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    //从后面一个不确定的index开始，继续进行交换
                    Permutation2Helper(chars,i+1,list);
                    swap(chars,i,j);
                }
            }
        }
    }

    public void swap(char[] cs,int i, int j){
        char temp=cs[i];
        cs[i]=cs[j];
        cs[j]=temp;
    }

}
