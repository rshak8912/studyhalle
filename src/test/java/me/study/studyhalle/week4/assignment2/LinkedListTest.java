package me.study.studyhalle.week4.assignment2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListTest {
    LinkedList linkedList;
    ListNode listNode;
    ListNode listNode2;
    ListNode listNode3;
    ListNode listNode4;
    ListNode unknown;
    ListNode unknown2;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList();
        listNode = new ListNode(1);
        listNode2 = new ListNode(2);
        listNode3 = new ListNode(3);
        listNode4 = new ListNode(4);
        unknown = new ListNode(4);
        unknown2 = new ListNode(5);
    }

    @DisplayName("연결리스트 add 동작 확인")
    @Test
    void linkedList_add() {
        ListNode head = linkedList.add(null, listNode, 1);
        linkedList.add(head, listNode2, linkedList.size(head) + 1);
        linkedList.add(head, listNode3, linkedList.size(head) + 1);

        // 3개의 노드를 추가하였으므로 사이즈는 3개
        assertThat(linkedList.size(head)).isEqualTo(3);
        // head 노드의 데이터는 1
        assertThat(head.getData()).isEqualTo(1);
    }

    @DisplayName("연결리스트 remove 동작 확인(첫번째 노드 삭제")
    @Test
    void linkedList_remove_first() {
        ListNode head = linkedList.add(null, listNode, 1);
        linkedList.add(head, listNode2, linkedList.size(head) + 1);
        linkedList.add(head, listNode3, linkedList.size(head) + 1);
        linkedList.add(head, listNode4, linkedList.size(head) + 1);

        head = linkedList.remove(head, 1);

        // 4개의 노드 중 1개를 추가하였으므로 사이즈는 3개
        assertThat(linkedList.size(head)).isEqualTo(3);
        // 1의 데이터를 가진 head 노드가 삭제 되었고 새로운 노드의 데이터는 2
        assertThat(head.getData()).isEqualTo(2);
    }

    @DisplayName("연결리스트 remove 동작 확인(중간 노드 삭제")
    @Test
    void linkedList_remove_middle() {
        ListNode head = linkedList.add(null, listNode, 1);
        linkedList.add(head, listNode2, linkedList.size(head) + 1);
        linkedList.add(head, listNode3, linkedList.size(head) + 1);
        linkedList.add(head, listNode4, linkedList.size(head) + 1);

        head = linkedList.remove(head, 2);
        // 4개의 노드 중 1개를 추가하였으므로 사이즈는 3개
        assertThat(linkedList.size(head)).isEqualTo(3);
        // 1 -> 2 -> 3 -> 4 에서 2가 삭제 되었으므로 헤드의 다음 노드이 데이터는 3
        assertThat(head.getNext().getData()).isEqualTo(3);
    }

    @DisplayName("연결리스트 remove 동작 확인(마지막 노드 삭제")
    @Test
    void linkedList_remove_last() {
        ListNode head = linkedList.add(null, listNode, 1);
        linkedList.add(head, listNode2, linkedList.size(head) + 1);
        linkedList.add(head, listNode3, linkedList.size(head) + 1);
        linkedList.add(head, listNode4, linkedList.size(head) + 1);

        head = linkedList.remove(head, 4);
        // 4개의 노드 중 1개를 추가하였으므로 사이즈는 3개
        assertThat(linkedList.size(head)).isEqualTo(3);
        // 1 -> 2 -> 3 -> 4 에서 4가 삭제 되었으므로 1부터 3까지 연결 되어있는지 값 확인
        assertThat(head.getData()).isEqualTo(1);
        assertThat(head.getNext().getData()).isEqualTo(2);
        assertThat(head.getNext().getNext().getData()).isEqualTo(3);


    }
    @DisplayName("연결리스트 contains 동작 확인")
    @Test
    void linkedList_contains() {
        ListNode head = linkedList.add(null, listNode, 1);
        linkedList.add(head, listNode2, linkedList.size(head) + 1);
        linkedList.add(head, listNode3, linkedList.size(head) + 1);

        // 3개의 노드를 추가하였으므로 사이즈는 3개
        assertThat(linkedList.size(head)).isEqualTo(3);

        head = linkedList.remove(head, 1);
        // 연결리스트에 포함되지 않은 노드
        assertThat(linkedList.contains(head, unknown)).isFalse();
        assertThat(linkedList.contains(head, listNode)).isFalse();
        assertThat(linkedList.contains(head, listNode2)).isTrue();
        assertThat(linkedList.contains(head, listNode3)).isTrue();
        assertThat(linkedList.contains(head, unknown2)).isFalse();

    }
}