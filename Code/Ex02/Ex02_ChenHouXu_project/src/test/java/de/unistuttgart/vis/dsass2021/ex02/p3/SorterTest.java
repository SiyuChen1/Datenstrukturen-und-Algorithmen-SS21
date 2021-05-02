package de.unistuttgart.vis.dsass2021.ex02.p3;

import static org.junit.Assert.*;

import org.junit.Test;

import de.unistuttgart.vis.dsass2021.ex02.p3.ISimpleList;
import de.unistuttgart.vis.dsass2021.ex02.p3.Sorter;

import java.lang.reflect.Array;
import java.util.List;

public class SorterTest {

	// Add your test methods here
    @Test
    public void testSelectionSort(){
        SimpleList<Integer> simpleList = new SimpleList<Integer>();
        simpleList.append(1);
        simpleList.append(2);
        simpleList.append(3);
        simpleList.append(4);
        simpleList.append(5);
        simpleList.append(6);
        simpleList.append(7);
        simpleList.append(8);
        simpleList.append(9);
        simpleList.append(10);
        Sorter.selectionSort(simpleList);
        List<Integer> list = simpleList.getList();
        Integer[] expected = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        Integer[] real = new Integer[simpleList.size()];
        list.toArray(real);
        assertArrayEquals(expected, real);
    }

    @Test
    public void testInsertionSort(){
        SimpleList<Integer> simpleList = new SimpleList<Integer>();
        simpleList.append(1);
        simpleList.append(2);
        simpleList.append(3);
        simpleList.append(4);
        simpleList.append(5);
        simpleList.append(6);
        simpleList.append(7);
        simpleList.append(8);
        simpleList.append(9);
        simpleList.append(10);
        Sorter.insertionSort(simpleList);
        List<Integer> list = simpleList.getList();
        Integer[] expected = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        Integer[] real = new Integer[simpleList.size()];
        list.toArray(real);
        assertArrayEquals(expected, real);
    }

    @Test
    public void testBubbleSort(){
        SimpleList<Integer> simpleList = new SimpleList<Integer>();
        simpleList.append(1);
        simpleList.append(2);
        simpleList.append(3);
        simpleList.append(4);
        simpleList.append(5);
        simpleList.append(6);
        simpleList.append(7);
        simpleList.append(8);
        simpleList.append(9);
        simpleList.append(10);
        Sorter.bubbleSort(simpleList);
        List<Integer> list = simpleList.getList();
        Integer[] expected = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        Integer[] real = new Integer[simpleList.size()];
        list.toArray(real);
        assertArrayEquals(expected, real);
    }
}
