package assignment5;

import java.util.NoSuchElementException;

/**
 * Represents a generic doubly linked list.
 * 
 * @author Paymon Saebi/ Erich Newey 
 * @param <E> - the type of elements contained in the linked list
 */
public class MyLinkedList<E> implements List<E> 
{
	//Instance variables
	int size;
	Node head;
	Node tail;
	
	/**
	 * Constructor.  Creates a blank linked list.
	 */
	public MyLinkedList() 
	{
		size=0;
		head=null;
		tail=null;
	}
	
	/**
	 * @param element - The element to add at the beginning of the list.
	 *  
	 * Inserts the specified element at the beginning of the list.
	 * O(1) for a doubly-linked list.
	 */
	public void addFirst(E element) 
	{
		Node n = new Node(element);
		
		if (head == null)
		{
			head = n;
			tail = n;
		}
		else if (size == 1)
		{
			n.next = head;
			head = n;
			tail.prev = n;
		}
		else 
		{
			n.next = head;
			n.next.prev = n;
			head = n;
		}
		
		size++;
	}
	
	/**
	 * @param element - The element to add at the end of the list.
	 * 
	 * Inserts the specified element at the end of the list.
	 * O(1) for a doubly-linked list.
	 */
	public void addLast(E o) 
	{
		Node n = new Node(o);
		
		if (tail == null)
		{
			head = n;
			tail = n;
		}
		else if (size == 1)
		{
			n.prev = tail;
			tail = n;
			head.next= n;
		}
		else
		{
			n.prev = tail;
			//edits
			tail.next = n;
			tail = n;
		}
		
		size++;
	}

	/**
	 * Inserts the specified element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range.
	 * O(N) for a doubly-linked list.
	 */
	public void add(int index, E element) throws IndexOutOfBoundsException 
	{
		Node n = new Node(element);
		if (index > size - 1)
			throw new IndexOutOfBoundsException();
		
		Node spot = null;
		//if the given index is less than half of the size of this list...
		if (index <= size / 2)
		{
			//start from the head
			spot = head;
			//and go forward
			for (int i=0; i < index; i++)
				spot = spot.next;
		
		}
		else//go from tail and work back
		{
			spot = tail;
			for (int i=size-1; i >index; i--)
				spot = spot.prev;
		}
		if(size==1){//we can assume we are trying to add at 0 because we passed the test index>size-1. 1-1=0 the only thing that would pass this test is 0
			//1/2 rounds to 1 which is greater than 0.
			n.next= tail;
			tail.prev = n;
			head = n;
		}
		
		//Insert the node into the list
		n.prev = spot.prev;
		n.next = spot.next;
		//this is broken
		if(spot.next!=null)
			spot.next.prev = n;
		if(spot.prev!=null)
			spot.prev.next = n;
		size++;
		
	}

	/**
	 * Returns the first element in the list.
	 * Throws NoSuchElementException if the list is empty.
	 * O(1) for a doubly-linked list.
	 */
	public E getFirst() throws NoSuchElementException 
	{
		if (head == null)
			throw new NoSuchElementException();
		
		E item = head.data;			
		return item;		
	}

	/**
	 * Returns the last element in the list.
	 * Throws NoSuchElementException if the list is empty.
	 * O(1) for a doubly-linked list.
	 */
	public E getLast() throws NoSuchElementException 
	{
		if (tail == null)
			throw new NoSuchElementException();
		
		E item = tail.data;			
		return item;
	}

	/**
	 * Returns the element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range.
	 * O(N) for a doubly-linked list.
	 */
	public E get(int index) throws IndexOutOfBoundsException 
	{
		if (index > size - 1)
			throw new IndexOutOfBoundsException();
		
		Node spot = null;
		if (index <= size / 2)
		{
			spot = head;
			for (int i=0; i < index; i++)
				spot = spot.next;
		
		}
		else
		{
			spot = tail;
			for (int i=size-1; i > index; i--)
				spot = spot.prev;
		}
		
		E item = spot.data;		
		return item;
	}

	/**
	 * Removes and returns the first element from the list.
	 * Throws NoSuchElementException if the list is empty.
	 * O(1) for a doubly-linked list.
	 */
	public E removeFirst() throws NoSuchElementException 
	{		
		if (head == null)
			throw new NoSuchElementException();
		
		E item = head.data;
		head = head.next;
		if(size>1)
			head.prev = null;
		size--;
		
		return item;		
	}

	/**
	 * Removes and returns the last element from the list.
	 * Throws NoSuchElementException if the list is empty.
	 * O(1) for a doubly-linked list.
	 */
	public E removeLast() throws NoSuchElementException 
	{		
		if (tail == null)
			throw new NoSuchElementException();
		
		E item = tail.data;
		tail = tail.prev;
		if(size>1)
			tail.next = null;
		size--;
		
		return item;
	}

	/**
	 * Removes and returns the element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range.
	 * O(N) for a doubly-linked list.
	 */
	public E remove(int index) throws IndexOutOfBoundsException 
	{		
		if (index > size - 1)
			throw new IndexOutOfBoundsException();
		
		Node spot = null;
		if (index <= size / 2)
		{
			spot = head;
			for (int i=0; i < index; i++)
				spot = spot.next;
		
		}
		else
		{
			spot = tail;
			for (int i=size-1; i > index; i--)
				spot = spot.prev;
		}
			
		E item = spot.data;
		/*if the given index is equivalent to either end, we need to
		 * change head or tail pointers. Using .equals() tests for strict equality
		 * i.e. equivalent memory addresses. 
		 */
		if(spot.equals(head)){
			removeFirst();
		}
		
		else if(spot.equals(tail)){
			removeLast();
		}
		else if(spot.prev !=null){
			spot.prev.next = spot.next;
			size--;
		}
		else if(spot.next != null){
			spot.next.prev = spot.prev;
			size--;
		}
		return item;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in the list, 
	 * or -1 if this list does not contain the element.
	 * O(N) for a doubly-linked list.
	 */
	public int indexOf(E element) 
	{		
		Node n = head;
		for (int i=0; i < size; i++)
		{
			if (n.data.equals(element))
				return i;
			n = n.next;
		}
		
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element.
	 * O(N) for a doubly-linked list.
	 */
	public int lastIndexOf(E element) 
	{		
		Node n = tail;
		for (int i=size-1; i >= 0; i--)
		{
			if (n.data.equals(element))
				return i;
			n = n.prev;
		}
		
		return -1;
	}

	/**
	 * Returns the number of elements in this list.
	 * O(1) for a doubly-linked list.
	 */
	public int size() 
	{
		return size;
	}

	/**
	 * Returns true if this collection contains no elements.
	 * O(1) for a doubly-linked list.
	 */
	public boolean isEmpty() 
	{
		if (size == 0)
			return true;
		return false;
	}
	
	/**
	 * Removes all of the elements from this list.
	 * O(1) for a doubly-linked list.
	 */
	public void clear() 
	{
		if(size == 0){
			return;
		}
		head.next = head = null;
		tail.prev = tail = null;
		size = 0;
	}
	
	/**
	 * Returns an array containing all of the elements in this list in proper sequence 
	 * (from first to last element).
	 * O(N) for a doubly-linked list.
	 */
	public Object[] toArray() 
	{				
		Object[] result = new Object[size];
		Node n = head;
		
		for (int i = 0; i < size; i++)
		{
			result[i] = n.data;
			n = n.next;
		}
		
		return result;
	}

	private class Node 
	{		
		E data;
		Node next;
		Node prev;
		
		public Node(E element)
		{
			data = element;
			next = null;
			prev = null;
		}		
	}	
}
