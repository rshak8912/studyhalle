package me.study.studyhalle.week5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BinaryTreeTest {
    BinaryTree binaryTree;
    Node node1;
    Node node2;
    Node node3;
    Node node4;
    Node node5;
    Node node6;
    Node node7;
    Node node8;
    Node node9;
    Node node10;
    Node node11;
    Node node12;
    Node node13;
    Node node14;
    Node node15;
    Node node16;

    @BeforeEach
    void setUp() {
        node1 = new Node(1);
        node2 = new Node(2);
        node3 = new Node(3);
        node4 = new Node(4);
        node5 = new Node(5);
        node6 = new Node(6);
        node7 = new Node(7);
        node8 = new Node(8);
        node9 = new Node(9);
        node10 = new Node(10);
        node11 = new Node(11);
        node12 = new Node(12);
        node13 = new Node(13);
        node14 = new Node(14);
        node15 = new Node(15);
        node16 = new Node(16);

        binaryTree = new BinaryTree(node1);

        Node root = binaryTree.getRoot();
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node4.setLeft(node8);
        node4.setRight(node9);
        node5.setLeft(node10);
        node5.setRight(node11);
        node6.setLeft(node12);
        node6.setRight(node13);
        node7.setLeft(node14);
        node7.setRight(node15);
        node8.setLeft(node16);
    }
    @AfterEach
    void afterEach() {
        binaryTree.setBfsCount(0);
        binaryTree.setDfsCount(0);
    }

    @DisplayName("bfs 방식으로 순회 테스트 - 루트부터 시작해서 모든 노드 탐색 - 순회한 노드의 총 갯수는 16이다")
    @Test
    void bfs() {
        Node root = binaryTree.getRoot();
        binaryTree.bfs(root);
        assertThat(binaryTree.getBfsCount()).isEqualTo(16);
    }

    @DisplayName("bfs 방식으로 순회 테스트 - 2부터 시작해서 모든 노드 탐색 - 순회한 노드의 총 갯수는 8이다")
    @Test
    void bfs2() {
        binaryTree.bfs(node2);
        assertThat(binaryTree.getBfsCount()).isEqualTo(8);
    }

    @DisplayName("bfs 방식으로 순회 테스트 - 16부터 시작해서 모든 노드 탐색 순회한 노드의 총 갯수는 1이다(자기 자신 뿐)")
    @Test
    void bfs3() {
        binaryTree.bfs(node16);
        assertThat(binaryTree.getBfsCount()).isEqualTo(1);
    }

    @DisplayName("dfs 방식으로 순회 테스트 - 모든 노드 탐색 - 순회한 노드의 총 갯수는 16이다")
    @Test
    void dfs() {
        Node root = binaryTree.getRoot();
        binaryTree.dfs(root);
        assertThat(binaryTree.getDfsCount()).isEqualTo(16);
    }

    @DisplayName("dfs 방식으로 순회 테스트 - 2부터 시작해서 중위 순회 탐색 - 순회한 노드의 총 갯수는 8이다")
    @Test
    void dfs2() {
        binaryTree.dfs(node2);
        assertThat(binaryTree.getDfsCount()).isEqualTo(8);
    }

    @DisplayName("dfs 방식으로 순회 테스트 - 16부터 시작해서 중위 순회 탐색 - 순회한 노드의 총 갯수는 1이다(자기 자신 뿐)")
    @Test
    void dfs3() {
        binaryTree.dfs(node16);
        assertThat(binaryTree.getDfsCount()).isEqualTo(1);
    }


}