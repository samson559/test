package assignment5;



import java.util.NoSuchElementException;

import junit.framework.TestCase;

public class TestLinkedStructures extends TestCase 
{
	private MyLinkedList<Integer> linkedList1;
	private MyLinkedList<Integer> linkedList2;
	private MyStack<Integer> stack1;
	
	protected void setUp() throws Exception 
	{
		linkedList1 = new MyLinkedList<Integer>();
		linkedList2 = new MyLinkedList<Integer>();
		stack1 = new MyStack<Integer>();
		
		for(int i = 0; i<6; i++)
			linkedList2.addLast(i);
		
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	/**
	 * test addFirst:
	 * general case
	 * 
	 */
	public void testAddFirst(){
		linkedList1.addFirst(1);
		assertEquals(1,linkedList1.size());
		assertEquals(1,(int)linkedList1.get(0));
	}
	/**
	 * test addFirst
	 * multi element case
	 * make sure head and tail point to the correct places.
	 * 
	 */
	public void testAddFirst2(){
		linkedList1.addFirst(5);
		linkedList1.addFirst(6);
		assertEquals(6,(int)linkedList1.getFirst());
		assertEquals(5,(int)linkedList1.getLast());
		
	}
	/**
	 * test addlast()
	 * general case
	 * ensure head and tail point to the same item.
	 * note: we have to assume the getters are working properly
	 */
	public void testAddLast(){
		linkedList1.addLast(5);
		assertEquals(5,(int)linkedList1.getFirst());
		assertEquals(5,(int)linkedList1.getLast());
		
	}
	/**
	 * test addlast()
	 * multiple elements case
	 * ensure head and tail point to the correct items.
	 * note: we have to assume the getters are working properly
	 */
	public void testaddLast2(){
		linkedList1.addLast(5);
		linkedList1.addLast(6);
		assertEquals(5,(int)linkedList1.getFirst());
		assertEquals(6,(int)linkedList1.getLast());
	}

	/**
	 * test add(index,object)
	 * general case
	 */
	public void testAdd(){
		linkedList1.addLast(0);
		linkedList1.addLast(2);
		
		linkedList1.add(1, 1);
		assertEquals(0,(int)linkedList1.get(0));
		assertEquals(1,(int)linkedList1.get(1));
		assertEquals(2,(int)linkedList1.get(2));
	}
	/**
	 * test add(index,object)
	 * corner case
	 */
	public void testAdd2(){
		linkedList1.addLast(0);
		linkedList1.add(0, 1);
		assertEquals(1,(int)linkedList1.get(0));
	}
	/**
	 * test add(index,object)
	 * fail case
	 */
	public void testAdd3(){
		try{
			linkedList1.add(0, 0);
			assertTrue("didn't throw exception",false);
		}
		catch(IndexOutOfBoundsException derp){
			assertTrue(true);
		}
	}

	/**
	 * test Get(index);
	 * general case: a few elements
	 */
	public void testGetIndex(){
		Integer[] results = new Integer[6];
		for(int i = 0; i<=5; i++){
			linkedList1.addLast(i);
			results[i] = i;
		}
		for(int i = 0; i<=5; i++){
			assertEquals(results[i],linkedList1.get(i));
		}
		
		
		
	}
	/**
	 * test get index:
	 * catch the expected exception (out of bounds)
	 */
	public void testGetIndex2(){
		try{
			linkedList1.get(0);
			assertTrue("failed to throw an exception", false);
		}
		catch(IndexOutOfBoundsException exc){
			assertTrue(true);
		}
	}
	/**
	 * test get
	 * get the tail
	 */
	public void testGetIndex3(){
		assertEquals(5, (int)linkedList2.get(6));
	}
	/**
	 * test remove last
	 * general case
	 */
	public void testremoveLast(){
		assertEquals(5,(int)linkedList2.removeLast());
		assertEquals(5,linkedList2.size());
		assertEquals(4,(int)linkedList2.get(4));
		
	}
	/**test removeLast
	 * fail case
	 */
	public void testremoveLast2(){
		try{
			linkedList1.removeLast();
			assertTrue(false);
		}
		catch(NoSuchElementException exc){
			assertTrue(true);
		}
	}
	/**
	 * test removelast
	 * corner case
	 */
	public void testremoveLast3(){
		linkedList1.addFirst(1);
		assertEquals(1,(int)linkedList1.removeLast());
		assertEquals(0,linkedList1.size());
	}
	/**
	 * test remove first
	 * general case
	 */
	public void testremoveFirst(){
		assertEquals(0,(int)linkedList2.removeFirst());
		assertEquals(1,(int)linkedList2.getFirst());
		assertEquals(5,linkedList2.size());
	}
	/**
	 * test remove first
	 * fail case
	 */
	public void testremoveFirst2(){
		try{
			linkedList1.removeFirst();
			assertFalse(false);
		}
		catch(NoSuchElementException exc){
			assertTrue(true);
		}
	}
	/**
	 * test remove first
	 * corner case
	 */
	public void testremoveFirst3(){
		linkedList1.addFirst(1);
		assertEquals(1,(int)linkedList1.removeFirst());
		assertEquals(0,linkedList1.size());
	}

	/**
	 * test remove:
	 * corner case: remove the head
	 * note: remove depends on remove first and remove la=st
	 */
	public void testRemove(){
		assertEquals(0,(int)linkedList2.remove(0));
		assertEquals(5,linkedList2.size());
		assertEquals(1,(int)linkedList2.get(0));
		assertEquals(2,(int)linkedList2.get(1));
	}
	/** test remove
	 * other corner case: removing the tail
	 */
	public void testremove2(){
		assertEquals(5,(int)linkedList2.remove(5));
		assertEquals(5,linkedList2.size());
		assertEquals(4,(int)linkedList2.getLast());
	}
	/**
	 * test remove:
	 * general case: removing an item from somewhere in the middle
	 */
	public void testremove3(){
		assertEquals(3,(int)linkedList2.remove(3));
		assertEquals(5,linkedList2.size());
		assertEquals(4, (int)linkedList2.get(3));
	}
	/**
	 * test remove
	 * fail case
	 */
	public void testremove4(){
		try{
			linkedList1.remove(60);
			assertTrue("failed to throw IOOB", false);
		}
		catch(IndexOutOfBoundsException exc){
			assertTrue(true);
		}
	}
	/**
	 * test indexOf
	 * general case
	 */
	public void testIndexOf(){
		assertEquals(3,linkedList2.indexOf(3));
	}
	/**test indexOf
	 * fail case
	 */
	public void testIndexOf2(){
		assertEquals(-1,linkedList1.indexOf(3984));
	}
	/**test IndexOf
	 * corner case 1
	 */
	public void testIndexOf3(){
		assertEquals(5,linkedList2.indexOf(5));
	}
	/**test IndexOf
	 * corner case 2
	 */
	public void testIndexOf4(){
		assertEquals(0,linkedList2.indexOf(0));
	}
	/** test last index of
	 * general case
	 * 
	 */
	public void testLastIndexOf(){
		linkedList1.addLast(1);
		linkedList1.addLast(1);
		linkedList1.addLast(1);
		for(int i = 2; i<7; i++){
			linkedList1.addLast(i);
		}
		assertEquals(2,linkedList1.lastIndexOf(1));
	}
	/**
	 * testlast indecs of
	 * fail case
	 */
	public void testLastIndexOf2(){
		assertEquals(-1,linkedList1.lastIndexOf(38495));
	}
	/**
	 * testlast indecs of
	 * corner cases
	 */
	public void testLastIndexOf3(){
		assertEquals(5,linkedList2.lastIndexOf(5));
		assertEquals(0,linkedList2.lastIndexOf(0));
	}
	/**
	 * test isempty
	 * general case
	 */
	public void testisEmpty(){
		assertTrue(linkedList1.isEmpty());
	}
	/**
	 * test isempty
	 * false case
	 */
	public void testisEmpty2(){
		linkedList1.addLast(1);
		assertFalse(linkedList1.isEmpty());
	}
	/**
	 * test clear
	 * general case
	 */
	public void testclear(){
		linkedList2.clear();
		assertTrue(linkedList2.isEmpty());
	}
	/**
	 * test clear
	 * empty case
	 */
	public void testclear2(){
		linkedList1.clear();
		assertTrue(linkedList1.isEmpty());
	}
	/**
	 * test clear
	 * corner case
	 */
	public void testclear3(){
		linkedList1.addFirst(1);
		linkedList1.clear();
		assertEquals(0,linkedList1.size());
	}
	/**
	 * test toarray
	 * general case
	 */
	public void testtoarray(){
		
		for(int i = 0; i<6; i++){
			assertEquals(linkedList2.toArray()[i],i);
		}
	}
	/**
	 * test toarray
	 * empty case
	 */
	public void testtoarray2(){
		assertEquals(linkedList1.toArray().length, 0);
	}
	/**
	 * test toarray
	 * corner case
	 */
	public void testtoarray3(){
		linkedList1.addFirst(0);
		assertEquals(linkedList1.toArray()[0], 0);
	}
	
	
	//-----------------------------------------------
	//-----------------------------------------------
	//-----------------THE STACK---------------------
	//-----------------------------------------------
	//-----------------------------------------------
	/** test clear
	 * empty case
	 */
	public void testClear(){
		stack1.clear();
		assertTrue(true);
	}
	/** test clear
	 * corner case
	 */
	public void testClear2(){
		stack1.push(4);
		stack1.clear();
		assertTrue(stack1.isEmpty());
	}
	/** test clear
	 * general case
	 */
	public void testClear3(){
		stack1.push(4);
		stack1.push(4);
		stack1.push(4);
		stack1.push(4);
		
		stack1.clear();
		assertTrue(stack1.isEmpty());
	}
	//is empty is working!
	/**
	 * test peek
	 * general case
	 */
	public void testPeek(){
		int i= 0;
		while(i<11){
			stack1.push(i);
			i++;
		}
		assertEquals(10,(int) stack1.peek());
		assertEquals(11,stack1.size());
	}
	/**
	 * test peek
	 *empty case
	 */
	public void testPeek2(){
		try{
			stack1.peek();
			assertTrue(false);
		}
		catch(NoSuchElementException exc){
			assertTrue(true);
		}
	}
	/**
	 * test peek
	 *corner case
	 */
	public void testPeek3(){
		stack1.push(8);
		assertEquals(8,(int)stack1.peek());
	}
	/**test pop
	 * corner case
	 */
	public void testPop1(){
		stack1.push(1);
		assertEquals(1,(int)stack1.pop());
		assertEquals(0, stack1.size());
		
	}
	/**test pop
	 * empty case
	 */
	public void testPop2(){
		try{
			stack1.pop();
			assertTrue(false);
		}
		catch(NoSuchElementException exc){
			assertTrue(true);
		}		
	}
	/**test pop
	 * general case
	 */
	public void testPop3()
	{
		for (int i = 0; i<10; i++)
			stack1.push(i);
		assertEquals(9,(int)stack1.pop());
		assertEquals(9, stack1.size());
		assertEquals(8, (int)stack1.peek());
	}
	//push be workin'
			
	
	
	
}
