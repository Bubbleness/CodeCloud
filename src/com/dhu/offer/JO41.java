package com.dhu.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class JO41 {


}

class MovingAverage{

    Queue<Integer> queue;
    int size;
    double sum;

    public MovingAverage(int size) {

        queue = new LinkedList<>();
        this.size = size;
        sum = 0.0;
    }

    public double next(int val) {

        sum += val;
        if(queue.size() == size)
            sum -= queue.poll();
        queue.offer(val);
        return sum/queue.size();
    }
}
