package P4;

import java.util.*;
import java.io.*;

public class AnimalList<E> implements Iterable<Animal> , Serializable {

	
	private int size ;
	
	private Node<Animal> head;
	private Node<Animal> tail;
	
	  public int size() {
		  return size ;
	  }
	
	  public boolean isEmpty() {
		  return(size ==0 );
	  }
	
	  public void addFirst(Animal animal) {
		  Node<Animal> node = new Node<>(animal);
		  
		  if(isEmpty()) {
			  head = tail = node;
		  }
		 
		  else {
		  
		  
		  
		  node.next = head;
		  head = node ;
		  
		  }
		  size++ ;
	  }
	
	public void addLast(Animal animal) {
		Node<Animal> n = new Node<>(animal);
		
		if(isEmpty()) {
			head = tail = n ;
		}
		
		else {
			
			
			
		tail.next = n ;
		tail = n ;
		}
		size++ ;
	}
	
	
	public void add( int index , Animal animal) {
		
		
		Node<Animal> current = new Node<>(animal);
		
		Node<Animal> actual = new Node<>(animal);
		
		
		
		
		if(isEmpty()) {
			head = tail = null ;
		}
		else {
			current = head;
			if(index<0 || index >= size) {
				throw new IndexOutOfBoundsException();
			}
			
			else if(index == 0) {
				addFirst(animal);
			}
			else if(index == size -1) {
				addLast(animal);
			}
			else {
				
				for(int i =1 ;i<index ;i++) {
					current = current.next;
				}
				
				actual.next = current.next;
				current.next = actual ;
				
				
			}
			
		}
		
		size++ ;
	}
	
	
	
	public Animal removeFirst() {
		
		
		
		
		if(isEmpty()) {
			return null ;
		}
		
		else {
			
			
			Animal n = head.element;
			
			if(size == 1) {
				head = tail = null ;
			}
			else {
			
			head = head.next;
			
			}
			size--;
			
			return n;
			
			
			
		}
		
		
	}
	
	
	
	public Animal removeLast() {
		
		Node<Animal> current = head ;
		
		if(isEmpty()) {
			return null ;
		}
		
		else {
			
			
			Animal n = tail.element;
			
			
			if(size == 1) {
				head = tail =null ;
				
			}
			else {
				for(int i = 1;i<size-1;i++) {
					current = current.next;
				}
				current.next = null;
			   tail = current ;
			}
			size--;
			return n ;
		}
		
	}
	
	
	public Animal remove(int index) {
		
		Animal n = null ;
		
		if(index<0 || index>= size) {
			throw new IndexOutOfBoundsException();
		}
		
		else if(index ==0) {
			 return removeFirst();
		}
		else if(index == size-1) {
			return removeLast();
		}
		else {
			
			Node<Animal> current = head ;
			
			for(int i =1;i<index;i++) {
				current = current.next;
			}
			 n = current.next.element;
			
			current.next = current.next.next;
			
			
			
			
			
			
		}
		
		size--;
		return n ;
		
		
	}
	
	public Animal getFirst() {
		
		 Node<Animal> n = head ;
			
			Animal an = n.element;
		
		if(isEmpty()) {
			return null;
		}
		
		else {
			return an ;
		}
		 
	}
	
	public Animal getLast() {
		
		Node<Animal> n = tail ;
		
		Animal an = n.element;
	
	if(isEmpty()) {
		return null;
	}
	
	else {
		return an ;
	}
	 
		
	}
	
	public Animal get(int index) {
		
		Animal n = null;
		
		if(index<0 || index>= size) {
			throw new IndexOutOfBoundsException();
		}
		else if(index ==0) {
			 return getFirst();
		}
		else if(index == size-1) {
			return getLast();
		}
		else {
			
			Node<Animal> current = head ;
			
			for(int i =1;i<index;i++) {
				current = current.next;
			}
			 n = current.next.element;
			
		}
		return n ;
		
	}
	
	
      public Animal set(int index , Animal animal) {
		
		
		
		if(index<0 || index>= size) {
			throw new IndexOutOfBoundsException();
		}
		else {
			
			Node<Animal> actual = new Node<>(animal);
			
			Node<Animal> current = head ;
			
			if(index == 0) {
				
				Animal n = head.element ;
				actual.next = head.next;
				
				head = actual ;
				return n ;
			}
			
			if(index == size-1) {
				for(int i =1;i<index;i++) {
					current = current.next;
				}
				Animal n = tail.element;
				current.next = actual; 
				tail = actual ;
						return n ;
			}
			else {
				
			for(int i =1;i<index;i++) {
				current = current.next;
			}
			Animal n = current.next.element;
			actual.next = current.next.next;
			current.next = actual;
			
			return n ;
		}
		}
		
	}
	
	public String toString() {
		
		String s = "";
		
		Node<Animal> current = head ;
		
		while(current!= null) {
		 String test= current.element.toString();
			
			s += test +"\n"  ;
			current = current.next;
		}
		
		return s ;
	}
	
	public Iterator <Animal> iterator(){
		
		return new MyIterator();
		
	}
	
	public AnimalList getHungryAnimals() {
		AnimalList animal = new AnimalList();
		
		Node<Animal> current = head ;
		
		int count = 0;
		
		while(current != null ) {
			
			if(current.element.getEnergy() < 50) {
				
				animal.addLast(current.element);
				count++ ;
			}
			
			
			current = current.next ;
		}
		
		if(count ==0) {
			return null ;
		}
		else {
		return animal ;
		}
	}
	
	
	
	public AnimalList getStarvingAnimals() {
		
		
          AnimalList animal = new AnimalList();
		
		Node<Animal> current = head ;
		
		int count = 0;
		
		while(current != null ) {
			
			if(current.element.getEnergy() < 17) {
				
				animal.addLast(current.element);
				count++ ;
			}
			
			
			current = current.next ;
		}
		
		if(count ==0) {
			return null ;
		}
		else {
		return animal ;
		}
		
	}
	
	public AnimalList getAnimalsInBarn() {
		
             AnimalList animal = new AnimalList();
		
		Node<Animal> current = head ;
		
		int count = 0;
		
		while(current != null ) {
			
			if((head.element.getX()>=450)&&(head.element.getX()<=550)&&(head.element.getY()>=50)&&(head.element.getY()<=150)) {
				
				animal.addLast(head.element);
				count++ ;
			}
			
			
			current = current.next ;
		}
		
		if(count ==0) {
			return null ;
		}
		else {
		return animal ;
		}
		
		
		
	}
	
	
	
	
	public double getRequiredFood() {
		
		double sum = 0;
		
		Node<Animal> current = head ;
		
		while(current != null) {
			
			if(current.element.getEnergy()<100) {
				double left = 100-current.element.getEnergy();
				
				sum+=left ;
				
				
			}
			
			
			current = current.next;
		}
		
		return sum ;
		
		
	}
	
	
	
	/* public AnimalList getByType(Class a) {
		
		
		
		AnimalList animal = new AnimalList();
		
		Node<Animal> current = head ;
		
		
			
			if(a.isInstance(current.element) ) {
				
				while(current != null) {
					
						animal.addLast(current.element);
						
					current= current.next;
				}
				
				
				
			}
			
			
			return animal ;
			
		}
		
		*/
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static class Node<Animal> implements Serializable{
		
		Animal element ;
		
		Node<Animal> next ;
		
		public Node(Animal a) {
			element = a ;
		}
     		
		
	}
	
	public class MyIterator implements Iterator<Animal>{

		
		private Node<Animal> animalNode = head ;
		
		public boolean hasNext() {
		
			return(animalNode != null );
		}


		public Animal next() {
			
			Animal a = animalNode.element;
			
			animalNode =animalNode.next;
			
			return a ;
		}
		
		
	}
	

}
