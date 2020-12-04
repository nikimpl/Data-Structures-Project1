//implementation of interface IntQueue

import java.util.NoSuchElementException;
import java.io.PrintStream;

public class IntQueueImpl implements IntQueue{
	
	private int elements; //the amount of elements on the queue
    private Node head, tail;
    
	//class which creates nodes for the queue
    private class Node{
        int item;
        Node next;
        Node(int item){
            this.item = item;
            next = null;
        }
    }
	
	//constructor of class IntQueueImpl
    IntQueueImpl(int maxN){
         head = null;
         tail = null;
    }
	
    public boolean isEmpty(){
        return head == null;
    }
	
    public void put(int item){
         Node oldtail = tail;
         tail = new Node(item);
         if(isEmpty()) head = tail;
         else oldtail.next = tail;
         elements++;

    }
	
    public int get(){
        if(isEmpty())
            throw new NoSuchElementException("The queue is empty.");
        
        int v = head.item;
        head = head.next;
        elements--;
        return v;
        
        
    }
    
    public int peek(){
        if ( isEmpty() )
        throw new NoSuchElementException("The queue is empty.");

        return head.item;
        
    }
    
    public void printQueue(PrintStream stream){
		Node n = head;
		while(n!=null) {
			stream.println(n);
			n = n.next;
		}
	}
	
    public int size(){
        return elements;

    } 
}