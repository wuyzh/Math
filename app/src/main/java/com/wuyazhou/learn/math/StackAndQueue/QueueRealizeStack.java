package com.wuyazhou.learn.math.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;
/**
 * @author wuyzh
 * */
public class QueueRealizeStack {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int i){
        queue1.add(i);
    }

    public int pop(){
        if (queue1.isEmpty()&&queue2.isEmpty()){
            throw new RuntimeException("Stack is empty!");
        }
        if (queue1.isEmpty()){
            while (!queue2.isEmpty()){
                queue1.add(queue2.poll());
            }
        }
        if (queue1.size()!= 1){
            while (queue1.size()!=1){
                queue2.add(queue1.poll());
            }
        }
        return queue1.poll();
    }
}
