package me.study.studyhalle.week4.assignment2;

import lombok.*;

@Getter @Setter
@ToString
public class ListNode {
    private int data;

    private int position;

    private ListNode next;

    public ListNode() {
        this.data = 0;
        this.position = 1;
        this.next = null;
    }

    public ListNode(int data) {
        this.data = data;
        this.position = 1;
        this.next = null;
    }

    public ListNode(int data, int position) {
        this.data = data;
        this.position = position;
        this.next = null;
    }

    public ListNode(int data, int position, ListNode next) {
        this.data = data;
        this.position = position;
        this.next = next;
    }

}
