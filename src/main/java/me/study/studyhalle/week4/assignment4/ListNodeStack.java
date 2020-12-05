package me.study.studyhalle.week4.assignment4;

import lombok.Getter;
import lombok.Setter;
import me.study.studyhalle.week4.assignment2.ListNode;

@Getter
@Setter
public class ListNodeStack {
    private ListNode top;

    public ListNodeStack() {
        this.top = null;
    }
    public void push(int data) {
        ListNode newNode = new ListNode(data);
        newNode.setNext(top);
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            return 0;
        } else {
            ListNode popNode = top;
            top = popNode.getNext();
            return popNode.getData();
        }
    }

    public boolean isEmpty() {
        return this.top == null;
    }


}
