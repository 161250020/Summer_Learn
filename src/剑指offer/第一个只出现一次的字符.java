package 剑指offer;

import java.util.LinkedHashMap;

public class 第一个只出现一次的字符 {
    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
     * 中找到第一个只出现一次的字符,
     * 并返回它的位置,
     * 如果没有则返回 -1（需要区分大小写）.
     * */
    /**
     * 思路一：
     //在nowcode上面没有找到比较好的算法思路：都是map
     //但是思考到map当中插入是否是有序的问题，
     //于是查了一下（之后选择使用LinkedHashMap）：
     * HashMap是无序的（只是说不是你插入时的顺序）；
     * LinkedHashMap是有序的（按你插入的顺序）；
     * TreeMap 是按key排序的；
     *
     //但是：也可以这么去验证：————————
     再次遍历原来的字符串的每一个字符，
     看看原来的字符在map当中的value是多少，为1则break；
     PS：我觉得这个方法很不错，一开始没想到来着！
     然后后来看到是要返回位置，于是知道必须以这个方法来解决了；
     * */
    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
        for (int i=0;i<str.length();i++){
            if (map.containsKey(str.charAt(i))){
                int num=map.get(str.charAt(i));
                map.put(str.charAt(i),++num);//这里写成了num++，下次要注意！
            }
            else {
                map.put(str.charAt(i),1);
            }
        }

        for (int i=0;i<str.length();i++)
            if (map.get(str.charAt(i))==1)
                return i;

        return -1;
    }

    /**
     * 思路二：
     * 使用ASCII码对应：
     * A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122，
     * 存到相对应的数组里面就好了。
     * */
     public int FirstNotRepeatingChar2(String str){
         int[] nums=new int[58];
         for (int i=0;i<str.length();i++)
             nums[str.charAt(i)-'A']+=1;

         for (int i=0;i<str.length();i++)
             if (nums[str.charAt(i)-'A']==1)
                 return i;

         return -1;
     }

}
