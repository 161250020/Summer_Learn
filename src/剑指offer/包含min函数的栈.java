package 剑指offer;

import java.util.Stack;

public class 包含min函数的栈 {
    //定义栈的数据结构，
    //请在该类型中实现一个能够得到栈中所含最小元素的min函数
    //（时间复杂度应为O（1））。
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();//辅助栈
    public void push(int node) {
        if (stack1.isEmpty()){
            stack1.push(node);
            stack2.push(node);
        }
        else {
            stack1.push(node);
            if (node<=stack2.peek())
                stack2.push(node);
        }
    }

    public void pop() {
        if (!stack1.isEmpty()){
            if (stack1.pop()==stack2.peek())
                stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

}
