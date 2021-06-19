package de.unistuttgart.vis.dsass2021.ex06.p4;

import static org.junit.Assert.*;

// START SOLUTION
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
// END SOLUTION

import org.junit.Test;


public class SorterTest {
	
	// START SOLUTION
	@Test
    public void testHeapSort(){
	    ISimpleList<Integer> simpleList = new SimpleList<>();
	    simpleList.append(new Integer(7));
        simpleList.append(new Integer(6));
        simpleList.append(new Integer(5));
        simpleList.append(new Integer(4));
        simpleList.append(new Integer(3));
        simpleList.append(new Integer(2));
        simpleList.append(new Integer(1));

        Sorter.heapSort(simpleList);

        for(int index = 0; index < simpleList.size(); index ++){
            System.out.println(simpleList.get(index));
        }
    }
	// END SOLUTION
	
}
