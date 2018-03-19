package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import models.MyCircularList;
import models.Node;

public class TestCirculaList {

	@Test
	public void testAdd() {
		MyCircularList<Integer>circularList = new MyCircularList<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		}); 
		
		circularList.addNode(new Node<Integer>(58));
		circularList.addNode(new Node<Integer>(74));
		circularList.addNode(new Node<Integer>(75));
		circularList.addNode(new Node<Integer>(65));
		circularList.addNode(new Node<Integer>(14));
		circularList.addNode(new Node<Integer>(84));
//		circularList.showList();
		assertEquals(6, circularList.size());
		
	}
}
