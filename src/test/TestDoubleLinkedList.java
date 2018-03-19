package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import models.DoubleNode;
import models.MyDoubleLinkedList;

public class TestDoubleLinkedList {	
	
	
	@Test
	public void testAdd() {
		MyDoubleLinkedList<Integer> doubleLinkedList = new MyDoubleLinkedList<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		doubleLinkedList.add(new DoubleNode<Integer>(5));
		doubleLinkedList.add(new DoubleNode<Integer>(7));
		doubleLinkedList.add(new DoubleNode<Integer>(84));
		doubleLinkedList.add(new DoubleNode<Integer>(45));
		doubleLinkedList.add(new DoubleNode<Integer>(41));
		doubleLinkedList.add(new DoubleNode<Integer>(46));
		doubleLinkedList.add(new DoubleNode<Integer>(3));
		doubleLinkedList.add(new DoubleNode<Integer>(2));
		doubleLinkedList.showLeftToRight();
		doubleLinkedList.showRightToLeft();
		assertEquals(doubleLinkedList.size(), 8);
		
		doubleLinkedList.insertAfter(5, 15);
		doubleLinkedList.insertAfter(2, 485);
		doubleLinkedList.insertAfter(41, 845);
		doubleLinkedList.showLeftToRight();
		
		doubleLinkedList.insertBefore(5, 45);
		doubleLinkedList.insertBefore(41, 100);
		doubleLinkedList.insertBefore(485, 78);
		doubleLinkedList.insertBefore(3, 475);
		doubleLinkedList.showLeftToRight();
		
		
		assertEquals(45, (int)doubleLinkedList.get(0).getInfo());
		assertEquals(5, (int)doubleLinkedList.get(1).getInfo());
		assertEquals(15, (int)doubleLinkedList.get(2).getInfo());
		assertEquals(7, (int)doubleLinkedList.get(3).getInfo());
		assertEquals(485, (int)doubleLinkedList.get(14).getInfo());
		
		doubleLinkedList.addIn(0, 84);
		doubleLinkedList.addIn(1, 14500);
		doubleLinkedList.addIn(16, 8500);
		doubleLinkedList.showLeftToRight();
 	}

}
