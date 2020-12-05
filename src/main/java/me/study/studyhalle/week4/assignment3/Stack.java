package me.study.studyhalle.week4.assignment3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Stack {
    private int[] stack;
    private int top;
    private int size;

    public Stack(int size) {
        top = -1;
        stack = new int[size];
        this.size = size;
    }

    public void push(int data) {
        stack[++top] = data;
    }

    public int pop () {
        if (isEmpty()) {
            return 0;
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
    public int peek() {
        if (isEmpty()) {
            return 0;
        } else {
            return stack[top];
        }
    }
}
