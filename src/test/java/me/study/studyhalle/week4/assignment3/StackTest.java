package me.study.studyhalle.week4.assignment3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @DisplayName("스택 동작 테스트")
    @Test
    void stack () {
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