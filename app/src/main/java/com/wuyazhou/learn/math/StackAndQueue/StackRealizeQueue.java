package com.wuyazhou.learn.math.StackAndQueue;

import java.util.Stack;

/**
 * @author wuyzh
 * */
public class StackRealizeQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void add(int i){
        stack1.push(i);
    }

    public int poll(){
        if (stack1.empty()&&stack2.empty()){
            throw  new RuntimeException("Queue is empty");
        }

        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
