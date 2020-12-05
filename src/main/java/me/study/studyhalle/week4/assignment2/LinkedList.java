package me.study.studyhalle.week4.assignment2;

import lombok.Data;

@Data
public class LinkedList {
    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        nodeToAdd.setPosition(position); // 더해질 노드에 위치 값 저장
        if (head == null) {              // 헤드가 null 일 경우, head는 더해질 노드가 헤드가 된다.
            head = nodeToAdd;
        } else {
            ListNode tempNode = head;               // 연결리스트를 탐색할 노드
            while (tempNode.getNext() != null) {   // 다음 노드가 null이 아닐 때 까지 순회하면서
                tempNode = tempNode.getNext();     // 계속 이동해 나간다.
            }
            tempNode.setNext(nodeToAdd);           // next pointer가 null 일 경우 더해질 노드를 설정해준다.
        }
        return head;
    }

    public ListNode remove(ListNode head, int positionToRemove) {
        if (head == null || size(head) == 1 || positionToRemove > size(head)) { // 연결 리스트의 크기가 0, 1, 삭제할 위치가 실제 연결리스트 크기보다 큰 경우, 삭제할 노드의 위치와 관계 없이 null을 반환하여 삭제 된 것으로 간주
            head = null;
            return head;
        }
        ListNode prevNode = head;
        ListNode tempNode = head.getNext();

        if (positionToRemove == prevNode.getPosition()) {
            head = prevNode.getNext();
            prevNode.setNext(null);
        } else {
            while (tempNode != null) {
                if (positionToRemove == tempNode.getPosition()) {
                    // 마지막 노드를 삭제하는 경우
                    if (tempNode.getNext() == null) {
                        prevNode.setNext(null);
                    } else {
                        prevNode.setNext(tempNode.getNext());
                        tempNode.setNext(null);
                    }
                    break;
                } else {
                    prevNode = tempNode;
                    tempNode = tempNode.getNext();
                }
            }
        }
        return head;
    }

    public boolean contains(ListNode head, ListNode nodeToCheck) {
        boolean isContains = false;
        ListNode tempNode = head;
        if (tempNode == nodeToCheck) {
            return true;
        }
        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
            if (tempNode == nodeToCheck) {
                isContains = true;
            }
        }
        if (isContains) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * @ head 노드를 받아서 연결리스트의 크기를 출력하는 메서드.
     * @ 해당 메서드를 사용하여 노드의 position을 연결리스트의 끝에 놓는 목적으로 사용한다.
     * */
    public int size(ListNode head) {
        int size = 0;
        ListNode tempNode = head;
        if (head != null) {
            size++;
            while (tempNode.getNext() != null) {
                size++;
                tempNode = tempNode.getNext();
            }
        }
        return size;
    }
}
