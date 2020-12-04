//implementation of interface StringStack

import java.util.NoSuchElementException;
import java.io.PrintStream;

public class StringStackImpl implements StringStack{

    private int elements; //the amount of elements on the stack
	private Node head;

	//class which creates nodes for the stack
    private class Node{
        String item;
        Node next;
        Node(String item, Node next){
            this.item = item;
            this.next = next;
        }    
    }
    
	//constructor of class StringStackImpl
    StringStackImpl(int maxN){ head = null;}

    public boolean isEmpty(){
        return head == null;
    }


    public void push(String item){
        head = new Node(item, head);
        elements++;


    }
    public String pop(){
        if ( isEmpty() )
            throw new NoSuchElementException("The list is empty.");
        
        String v = head.item;
        head = head.next;
        elements--;
        return v;
    }
	
    public String peek(){
        if ( isEmpty() ){
            throw new NoSuchElementException("The list is empty.");
        }

        return head.item;
    }

    public void printStack(PrintStream stream){
		Node n=head;
		while(n!=null) {
			stream.println(n);
			n = n.next;
		}
	}

    public int size(){
        return elements;
    }
}

