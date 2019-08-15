package 剑指offer;

import java.util.Stack;
public class 用两个栈实现队列 {

    /**
     * 用两个栈来实现一个队列，
     * 完成队列的Push和Pop操作。
     * 队列中的元素为int类型。
     * */

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size()<=0){
            while(stack1.size()!=0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
        //这样写就不用管stack1中是否有元素入stack2了，
        //因为每一种情况在原本的stack2中都已经包含了
    }

}
