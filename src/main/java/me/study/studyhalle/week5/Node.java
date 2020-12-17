package me.study.studyhalle.week5;

import lombok.*;

@NoArgsConstructor
@Getter @Setter
public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}


