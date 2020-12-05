package me.study.studyhalle.week4.assignment4;

import me.study.studyhalle.week4.assignment3.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ListNodeStackTest {
    @DisplayName("연결리스트로 구현한 스택 동작 확인")
    @Test
    void listNodeStack() {
        Stack stack = new Stack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertThat(stack.pop()).isEqualTo(5);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);

        // 빈 스택일 경우 0을 반환하도록 구현.
        assertThat(stack.pop()).isEqualTo(0);

    }

}