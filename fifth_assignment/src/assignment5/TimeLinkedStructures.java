package assignment5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


/**
 * 
 * @author Dylan Noaker
 * this is a template that I will use for timing things.
 * I can't currently conceive a way to "extend" this class but it 
 * sure will be helpful to have all of this copied down somewhere. 
 *
 */
public class TimeLinkedStructures {
	private static MyStack<Integer> stack1 = new MyStack<Integer>();
	private static ArrayList<Integer> list1 = new ArrayList<Integer>();
	private static LinkedList<Integer> truLink = new LinkedList<Integer>();
	private static MyLinkedList<Integer> myLink = new MyLinkedList<Integer>();
	/*1=best
	 * 2=avg
	 * 3=worst
	 */
	private static int typeOfTest = 2;
	
	private static final int start = 100000;
	private static final int end = 1000001;
	private static final int increment = 25000;
	private final static int timesToLoop = 25000;
	
	private static Random rand;
	private static long t1,tmid,tfinal,tfull,tempty;
	private static double tactual1,tactual2;

	public void TimingSuite() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//print samples for excel
		for(int i = start; i<end; i+=increment){
	    	   System.out.println(i);
	       }
		//TODO call timing functions
		System.out.println("time addfirst vs add0");
		  //timeMyListAddFirst();
		  //timeArrListAdd0();
		  System.out.println("time gets");
		//timeMyListGet();
		//timearrlistGet();
		  System.out.println("time removes");
		//timeMyListremovei();
		//timearrListremovei();
		  System.out.println("time stack functions");
		timeStackPush();
		timeStackPeek();
		timeStackPop();

	}
	/**
	 * times my add first method by adding then removing an item
	 */
	public static void timeMyListAddFirst(){
		System.out.println("timing my list add first \n");
		for(int index = start; index<end; index+=increment){
			myLink = generateCaseMyList(index);
			t1 = System.nanoTime();
			while(System.nanoTime() - t1>1000000000){
				//warmup
			}
			t1 = System.nanoTime();
			for(int i = 0; i<timesToLoop; i++){
				
				myLink.addFirst(8);
				myLink.removeFirst();
				
			}
			tmid = System.nanoTime();
			//time overhead
			for(int i = 0; i<timesToLoop; i++){
				//TODO time overhead
				myLink.removeFirst();
			}
			// calculate and print average time
			tfinal = System.nanoTime();
			tfull = tmid-t1;
			tempty = tfinal-tmid;
			tactual1 = (tfull-tempty)/timesToLoop;
			System.out.println(tactual1/1000000);
		}
	}
	/**
	 * times java's add(0,element) method by adding then removing an item
	 */
	public static void timeArrListAdd0(){
		System.out.println("timing Arrlist add first \n");
		
		for(int index = start; index<end; index+=increment){
			list1 = generateCaseArrlist(index);
			t1 = System.nanoTime();
			while(System.nanoTime() - t1>1000000000){
				//warmup
			}
			t1 = System.nanoTime();
			for(int i = 0; i<timesToLoop; i++){
				
				list1.add(0, 8);
				list1.remove(list1.size()-1);
			}
			tmid = System.nanoTime();
			//time overhead
			for(int i = 0; i<timesToLoop; i++){
				//TODO time overhead
				list1.remove(list1.size()-1);
			}
			// calculate and print average time
			tfinal = System.nanoTime();
			tfull = tmid-t1;
			tempty = tfinal-tmid;
			tactual1 = (tfull-tempty)/timesToLoop;
			System.out.println(tactual1/1000000);
		}
	}
	/**
	 * times my get function at the end of the list
	 */
	public static void timeMyListGet(){
		System.out.println("timing my get at index function");
		for(int index = start; index<end; index+=increment){
			myLink = generateCaseMyList(index);
			t1 = System.nanoTime();
			while(System.nanoTime() - t1>1000000000){
				//warmup
			}
			t1 = System.nanoTime();
			for(int i = 0; i<timesToLoop; i++){
				//	
				myLink.get(index-1);
			}
			tmid = System.nanoTime();
			//time overhead
			for(int i = 0; i<timesToLoop; i++){
				//myLink = generateCaseMyList(index);
			}
			// calculate and print average time
			tfinal = System.nanoTime();
			tfull = tmid-t1;
			tempty = tfinal-tmid;
			tactual1 = (tfull-tempty)/timesToLoop;
			System.out.println(tactual1/1000000);
		}
	}
	/**
	 * times java's arraylist get function at the end of the list
	 * Prints the time in MILLISECS
	 */
	public static void timearrlistGet(){
		System.out.println("timing java's arraylist get");
		for(int index = start; index<end; index+=increment){
			list1 = generateCaseArrlist(index);
			t1 = System.nanoTime();
			while(System.nanoTime() - t1>1000000000){
				//warmup
			}
			t1 = System.nanoTime();
			for(int i = 0; i<timesToLoop; i++){
				//
				list1.get(index-1);
			}
			tmid = System.nanoTime();
			//time overhead
			for(int i = 0; i<timesToLoop; i++){
				//list1 = generateCaseArrlist(index);
			}
			// calculate and print average time
			tfinal = System.nanoTime();
			tfull = tmid-t1;
			tempty = tfinal-tmid;
			tactual1 = (tfull-tempty)/timesToLoop;
			System.out.println(tactual1/1000000);
		}
	}
	/**
	 * times my remove by removing then adding an item
	 */
	public static void timeMyListremovei(){
		System.out.println("timing my list remove \n");
		for(int index = start; index<end; index+=increment){
			myLink = generateCaseMyList(index);
			t1 = System.nanoTime();
			while(System.nanoTime() - t1>1000000000){
				//warmup
			}
			t1 = System.nanoTime();
			for(int i = 0; i<timesToLoop; i++){
				
				myLink.remove(index/2);
				myLink.addFirst(2);
				
			}
			tmid = System.nanoTime();
			//time overhead
			for(int i = 0; i<timesToLoop; i++){
				//TODO time overhead
				myLink.addFirst(2);
			}
			// calculate and print average time
			tfinal = System.nanoTime();
			tfull = tmid-t1;
			tempty = tfinal-tmid;
			tactual1 = (tfull-tempty)/timesToLoop;
			System.out.println(tactual1/1000000);
		}
	}
	/**
	 * times java's remove by removing then adding an item
	 */
	public static void timearrListremovei(){
		System.out.println("timing arr list remove \n");
		for(int index = start; index<end; index+=increment){
			list1 = generateCaseArrlist(index); 
			t1 = System.nanoTime();
			while(System.nanoTime() - t1>1000000000){
				//warmup
			}
			t1 = System.nanoTime();
			for(int i = 0; i<timesToLoop; i++){
				
				list1.remove(index/2);
				list1.add(0,2);
				
			}
			tmid = System.nanoTime();
			//time overhead
			for(int i = 0; i<timesToLoop; i++){
				//TODO time overhead
				list1.add(0,2);
			}
			// calculate and print average time
			tfinal = System.nanoTime();
			tfull = tmid-t1;
			tempty = tfinal-tmid;
			tactual1 = (tfull-tempty)/timesToLoop;
			System.out.println(tactual1/1000000);
		}
	}
	/**
	 * times push by pushing then popping an item ensuring consistent
	 * size
	 */
	public static void timeStackPush(){
		System.out.println("timing Stack Push \n");
		for(int index = start; index<end; index+=increment){
			stack1 = generateCaseStack(index);
			t1 = System.nanoTime();
			while(System.nanoTime() - t1>1000000000){
				//warmup
			}
			t1 = System.nanoTime();
			for(int i = 0; i<timesToLoop; i++){
				stack1.push(5);
				stack1.pop();
			}
			tmid = System.nanoTime();
			//time overhead
			for(int i = 0; i<timesToLoop; i++){
				//TODO time overhead
				stack1.pop();
			}
			// calculate and print average time
			tfinal = System.nanoTime();
			tfull = tmid-t1;
			tempty = tfinal-tmid;
			tactual1 = (tfull-tempty)/timesToLoop;
			System.out.println(tactual1/1000000);
		}
	}
	/**
	 * times the peek method
	 */
	public static void timeStackPeek(){
		System.out.println("timing Stack Peek \n");
		for(int index = start; index<end; index+=increment){
			stack1 = generateCaseStack(index);
			t1 = System.nanoTime();
			while(System.nanoTime() - t1>1000000000){
				//warmup
			}
			t1 = System.nanoTime();
			for(int i = 0; i<timesToLoop; i++){
				stack1.peek();
				
			}
			tmid = System.nanoTime();
			//time overhead
			for(int i = 0; i<timesToLoop; i++){
				//TODO time overhead
			}
			// calculate and print average time
			tfinal = System.nanoTime();
			tfull = tmid-t1;
			tempty = tfinal-tmid;
			tactual1 = (tfull-tempty)/timesToLoop;
			System.out.println(tactual1/1000000);
		}

		
	}
	/**
	 * times pop by popping then pushing an item ensuring consistent
	 * size
	 */
	public static void timeStackPop(){
		System.out.println("timing Stack POP \n");
		for(int index = start; index<end; index+=increment){
			stack1 = generateCaseStack(index);
			t1 = System.nanoTime();
			while(System.nanoTime() - t1>1000000000){
				//warmup
			}
			t1 = System.nanoTime();
			for(int i = 0; i<timesToLoop; i++){
				stack1.pop();
				stack1.push(5);
			}
			tmid = System.nanoTime();
			//time overhead
			for(int i = 0; i<timesToLoop; i++){
				//TODO time overhead
				stack1.push(5);
			}
			// calculate and print average time
			tfinal = System.nanoTime();
			tfull = tmid-t1;
			tempty = tfinal-tmid;
			tactual1 = (tfull-tempty)/timesToLoop;
			System.out.println(tactual1/1000000);
		}	
	}
	/**
	 * lever function
	 * ARRLIST
	 * @param size
	 * @return ArrayList with appropriate data
	 */
	public static ArrayList<Integer> generateCaseArrlist(int size)
	{
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		switch(typeOfTest){
			case 1:
				for(int i = 0; i<size; i++){
					arr1.add(i);
				}
				break;
			case 2:
				for (int i = size; i>=0; i--)
					arr1.add(i);
				break;
			case 3:
				for(int i = 0; i<size; i++)
					arr1.add(rand.nextInt());
				break;
		}
		return arr1;
	}
	/**
	 * lever function
	 * MY LIST
	 * @param size
	 * @return My List with appropriate data
	 */
	public static MyLinkedList<Integer> generateCaseMyList(int size)
	{
		MyLinkedList<Integer> arr1 = new MyLinkedList<Integer>();
		switch(typeOfTest){
			case 1:
				for(int i = 0; i<size; i++){
					arr1.addFirst(i);
				}
				break;
			case 2:
				for (int i = size; i>=0; i--)
					arr1.addFirst(i);
				break;
			case 3:
				for(int i = 0; i<size; i++)
					arr1.addFirst(rand.nextInt());
				break;
		}
		return arr1;
	}
	/**
	 * lever function
	 * true linked list
	 * @param size
	 * @return linked list with appropriate data
	 */

	public static LinkedList<Integer> generateCasetrulist(int size)
	{
		LinkedList<Integer> arr1 = new LinkedList<Integer>();
		switch(typeOfTest){
			case 1:
				for(int i = 0; i<size; i++){
					arr1.addFirst(i);
				}
				break;
			case 2:
				for (int i = size; i>=0; i--)
					arr1.addFirst(i);
				break;
			case 3:
				for(int i = 0; i<size; i++)
					arr1.addFirst(rand.nextInt());
				break;
		}
		return arr1;
	}
	public static MyStack<Integer> generateCaseStack(int size)
	{
		MyStack<Integer> arr1 = new MyStack<Integer>();
		switch(typeOfTest){
			case 1:
				for(int i = 0; i<size; i++){
					arr1.push(i);
				}
				break;
			case 2:
				for (int i = size; i>=0; i--)
					arr1.push(i);
				break;
			case 3:
				for(int i = 0; i<size; i++)
					arr1.push(rand.nextInt());
				break;
		}
		return arr1;
	}
}



