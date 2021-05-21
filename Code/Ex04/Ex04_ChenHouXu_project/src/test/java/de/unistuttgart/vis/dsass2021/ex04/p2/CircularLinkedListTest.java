package de.unistuttgart.vis.dsass2021.ex04.p2;

import static org.junit.Assert.*;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class CircularLinkedListTest {
    @Test
    public void test(){
        CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();
        circularLinkedList.append(1);
        circularLinkedList.append(2);
        circularLinkedList.append(3);
        circularLinkedList.append(4);
        assertEquals(4, circularLinkedList.size());
        assertEquals(new Integer(1), circularLinkedList.get(0));
        assertEquals(new Integer(2), circularLinkedList.get(101));
        assertEquals(new Integer(4), circularLinkedList.get(-1));
    }
}
