package de.unistuttgart.vis.dsass2021.ex03.p1;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import de.unistuttgart.vis.dsass2021.ex03.p1.ISimpleListIterable;
import de.unistuttgart.vis.dsass2021.ex03.p1.SimpleList;

public class SimpleListTest {

    @Test
    public void testIterator(){
        SimpleList<Integer> simpleList = new SimpleList<>();

        // Add Elements
        simpleList.append(1);
        simpleList.append(2);
        simpleList.append(3);
        simpleList.append(4);
        simpleList.append(5);
        simpleList.append(6);

        // Get the iterator
        Iterator<Integer> it = simpleList.iterator();

        assertEquals(new Integer(1), it.next());
        assertEquals(new Integer(2), it.next());
        assertEquals(new Integer(3), it.next());
        assertEquals(new Integer(4), it.next());
        assertEquals(new Integer(5), it.next());
        assertEquals(new Integer(6), it.next());

    }

    @Test
    public void testSkippingIterator(){
        SimpleList<Integer> simpleList = new SimpleList<>();

        // Add Elements
        simpleList.append(1);
        simpleList.append(2);
        simpleList.append(3);
        simpleList.append(4);
        simpleList.append(5);
        simpleList.append(6);
        simpleList.append(7);
        simpleList.append(8);
        simpleList.append(9);

        // Get the iterator
        Iterator<Integer> it = simpleList.skippingIterator(5);

        assertEquals(new Integer(1), it.next());
        assertEquals(new Integer(6), it.next());

    }
}
