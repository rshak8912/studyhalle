package me.study.studyhalle.week5;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

@NoArgsConstructor
@Getter @Setter
public class BinaryTree {
    private Node root;
    private Queue<Node> queue;
    private int bfsCount;
    private int dfsCount;

    public BinaryTree(Node root) {
        this.root = root;
        queue = new LinkedList<>();
        this.bfsCount = 0;
        this.dfsCount = 0;
    }

    public void bfs(Node node) {
        if (node == null) {
            return;
        }
        if (queue.isEmpty()) {
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            Node peek = queue.peek();
            this.bfsCount++;
            System.out.print(peek.getValue() + " ");
            if (peek.getLeft() != null) {
                queue.add(peek.getLeft());
            }
            if (peek.getRight() != null) {
                queue.add(peek.getRight());
            }

            queue.poll();
            bfs(queue.peek());
        }
    }

    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        dfsCount++;
        dfs(node.getLeft());
        System.out.print(node.getValue() + " ");
        dfs(node.getRight());
    }

}
