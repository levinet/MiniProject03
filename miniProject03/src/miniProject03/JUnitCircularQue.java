package miniProject03;

/**
 * 
 */


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 * Date: 28 February 2016
 * @author Megan and Thomas
 * 
 * This test class is designed to gain a code coverage of 90% in the CircularQueue
 * class by creating a variety of test methods for its functions
 * 
 *
 */

public class JUnitCircularQue {


	
	/**
	 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	
	
	
	/**
	 * This method test the creation of a Circular Queue method
	 * and when an invalid int (0) is passed to the constructor. This method also lists a 
	 * series of try/catch exception cases that cover exceptions in CircularQueue
	 * for the following methods: element(), addAll(),iterator(),remove(Object), removeAll(),
	 * retainAll(Collection), contains(Object), containsAll(Collection) 
	 * @throws Exception
	 */
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testCircularQueueConstructor() throws Exception {
	
	//Set up a circular constructor with capacity 5; expected value capacity 6
	CircularQueue t = new CircularQueue(5);
	assertEquals(6, t.getQueueCapacity());
	
	
	//Exception for entry of zero
	try {
		CircularQueue t2 = new CircularQueue(0);
		fail();
	} catch (Exception ex) {// Exception should occur here because we are passing an invalid capacity
		
	}
	
	//Exception for size entry of zero for element method
	try {
		CircularQueue t2 = new CircularQueue(1);
		t2.element();
		fail();
		} catch (Exception ex) {
			
		}
	//Test Exception for unwritten method addAll
	try {
		CircularQueue q = new CircularQueue(3);
		q.addAll(q);
		fail();
	} catch (Exception ex) {
		
	}
	
	//Test Exception for unwritten method iterator
	try {
		CircularQueue q = new CircularQueue(3);
		q.iterator();
		fail();
	} catch (Exception ex) {
		
	}
	
	//Test Exception for unwritten method remove(Object)
	try {
		CircularQueue q = new CircularQueue(2);
		q.add("A");
		q.remove("A");
		fail();
	} catch (Exception ex) {
		
	}
	
	//Test Exception for unwritten element removeAll();
	try {
		CircularQueue q = new CircularQueue(2);
		q.add("A");
		q.removeAll(q);
		fail();
	} catch (Exception ex) {
		
	}
	
	//Test Exception for unwritten method retainAll();
		try {
			CircularQueue q = new CircularQueue(2);
			q.add("A");
			q.retainAll(q);
			fail();
		} catch (Exception ex) {
			
		}
		
	//Test Exception for unwritten method contains(Object);
	try {
		CircularQueue q = new CircularQueue(2);
		q.add("A");
		q.contains("A");
		fail();
	} catch (Exception ex) {
		
	}
	//Test Exception for unwritten method containsAll(Collection<?>);
	try {
		CircularQueue q = new CircularQueue(2);
		q.add("A");
		q.containsAll(q);
		fail();
	} catch (Exception ex) {
		
	}
	

	}
	
	
	/**
	 * This method tests the size of an empty array
	 * @throws Exception
	 */	
	//Test Size Method for empty queue
	@Test
	public void testSize() throws Exception {
		
		CircularQueue t=new CircularQueue(5);
		assertEquals(0,t.size());
	}
	
	/**
	 * This method tests the False outcome of the isQueueFull function
	 * and the true outcome of the isEmpty() function
	 * @throws Exception
	 */
	//Test boolean method isQueueFull for empty queue
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testIsQueueFull() throws Exception{
		
		CircularQueue t=new CircularQueue(5);
		assertFalse(t.isQueueFull());
		assertTrue(t.isEmpty());
			
	}
	
	/**
	 * This method tests the isQueueFull function for a full array,
	 * as well as the following methods: false outcome for isEmpty(),
	 * element(), peek(), poll(), remove().
	 * @throws Exception
	 */
	
	//Test boolean method for isQueueFull for full queue
	@SuppressWarnings("rawtypes")
	@Test
	public void testIsQueueFull2() throws Exception{
		
	CircularQueue q= new CircularQueue(3);
		q.add("A");
		q.add("B");
		q.add("C");
		q.add("D");
		//Test isEmpty() method; assert to false
		assertFalse(q.isEmpty());
		//Test isQueueFull method; assert to true
		assertTrue(q.isQueueFull());
		//Test element() method
		assertEquals("D",q.element());
		//Test Peek Method
		assertEquals("D",q.peek());
		//Test Poll Method
		assertEquals("D",q.poll());
		//This will remove the last one, "C" since "D" is removed in q.poll previously
		q.remove();
		//Testing the remove method; the expected value is now two
		assertEquals(2,q.size());
		
		
	
	}
	
	/**
	 * This method tests the method getRemainingQueueSpace with empty size
	 * @throws Exception
	 */
	//Test amount of space in empty queue
	@Test
	public void testGetRemainingQueueSpace() throws Exception{
		
		CircularQueue t=new CircularQueue(5);
		assertEquals(6, t.getRemainingQueueSpace());
	}
	
	/**
	 * This method tests the method toArray by creating an array object 
	 * equal to .toArray() and comparing the second value of the two.
	 * @throws Exception
	 */
	//Test the toArray Method
	@SuppressWarnings("rawtypes")
	@Test
	
	public void testToArray() throws Exception{
		CircularQueue q= new CircularQueue(3);
		q.add("A");
		q.add("B");
		q.add("C");
		q.add("D");
		
		Object[] array=q.toArray();
		assertEquals("B",array[2]);
		
	}

}