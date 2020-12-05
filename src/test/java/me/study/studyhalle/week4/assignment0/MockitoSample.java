package me.study.studyhalle.week4.assignment0;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

public class MockitoSample {
    @Test
    void sample() {
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn("first");
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(999));
    }
}
