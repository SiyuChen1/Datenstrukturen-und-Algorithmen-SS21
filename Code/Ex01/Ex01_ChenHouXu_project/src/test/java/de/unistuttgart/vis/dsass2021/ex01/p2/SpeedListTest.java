package de.unistuttgart.vis.dsass2021.ex01.p2;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * You should use this class to test your class {@link SpeedListTest}, using JUnit
 * assertions like {@link Assert#assertEquals(Object, Object)}. For additional
 * information on how to test your code with JUnit visit
 * http://www.vogella.com/tutorials/JUnit/article.html
 */

public class SpeedListTest {

	/**
	 * Just create additional tests by creating new methods according to this
	 * pattern.
	 */
	
	@Test
	public void testAppend() {
		SpeedList speedList = new SpeedList(3); //Initialize object of class
		speedList.append(1); // call method of this object what you want to test
		speedList.append(2);
		speedList.append(3);
		speedList.append(4);
		speedList.append(5);
		speedList.append(6);
		speedList.append(7);
		speedList.append(8);
		speedList.append(9);
		speedList.append(10);
		assertEquals(10, speedList.size());
	}

	@Test
	public void testPrepend(){
		SpeedList speedList = new SpeedList(3); //Initialize object of class
		speedList.prepend(1); // call method of this object what you want to test
		speedList.prepend(2);
		speedList.prepend(3);
		speedList.prepend(4);
		speedList.prepend(5);
		speedList.prepend(6);
		speedList.prepend(7);
		assertEquals(7, speedList.size());
	}

	@Test
	public void testGetElementAtPos(){
		SpeedList speedList = new SpeedList(3); //Initialize object of class
		speedList.prepend(1); // call method of this object what you want to test
		speedList.prepend(2);
		speedList.prepend(3);
		speedList.prepend(4);
		speedList.prepend(5);
		speedList.prepend(6);
		speedList.prepend(7);
		assertEquals(6, speedList.getElementAt(1));
		assertEquals(4, speedList.getElementAt(3));
		assertEquals(2, speedList.getElementAt(5));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetElementAtPosIndexOutOfBoundsException() {
		SpeedList speedList = new SpeedList(); //Initialize object of class
		speedList.prepend(1); // call method of this object what you want to test
		speedList.prepend(2);
		speedList.prepend(3);
		speedList.prepend(4);
		speedList.prepend(5);
		speedList.prepend(6);
		speedList.prepend(7);
		speedList.getElementAt(9);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testTwoGetElementAtPosIndexOutOfBoundsException() {
		SpeedList speedList = new SpeedList(); //Initialize object of class
		speedList.prepend(1); // call method of this object what you want to test
		speedList.prepend(2);
		speedList.prepend(3);
		speedList.prepend(4);
		speedList.prepend(5);
		speedList.prepend(6);
		speedList.prepend(7);
		speedList.getElementAt(-3);
	}

	@Test
	public void testGetPrevious(){
		SpeedList speedList = new SpeedList(3); //Initialize object of class
		speedList.prepend(1); // call method of this object what you want to test
		speedList.prepend(2);
		speedList.prepend(3);
		speedList.prepend(4);
		speedList.prepend(5);
		speedList.prepend(6);
		speedList.prepend(7);
		assertEquals(7, speedList.getPrevious(1));
		assertEquals(5, speedList.getPrevious(3));
		assertEquals(3, speedList.getPrevious(5));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetPreviousIndexOutOfBoundsException() {
		SpeedList speedList = new SpeedList(); //Initialize object of class
		speedList.prepend(1); // call method of this object what you want to test
		speedList.prepend(2);
		speedList.prepend(3);
		speedList.prepend(4);
		speedList.prepend(5);
		speedList.prepend(6);
		speedList.prepend(7);
		speedList.getPrevious(9);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testTwoGetPreviousIndexOutOfBoundsException() {
		SpeedList speedList = new SpeedList(); //Initialize object of class
		speedList.prepend(1); // call method of this object what you want to test
		speedList.prepend(2);
		speedList.prepend(3);
		speedList.prepend(4);
		speedList.prepend(5);
		speedList.prepend(6);
		speedList.prepend(7);
		speedList.getPrevious(-2);
	}

}
