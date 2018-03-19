package test;

import java.util.Comparator;

import org.junit.Test;
import models.MyLinkedList;
import models.Node;

public class TestMyLinkedList {

	@Test
	public void testAdd() {
		MyLinkedList<Integer> list = new MyLinkedList<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		list.addNode(new Node<Integer>(1));
		list.addNode(new Node<Integer>(2));
		list.addNode(new Node<Integer>(3));
		list.addNode(new Node<Integer>(4));

		list.showList();
		try {
			list.addIn(1, new Node<Integer>(0));
			list.addIn(3, new Node<Integer>(11));
			list.addIn(5, new Node<Integer>(21));
			list.addIn(7, new Node<Integer>(31));
			list.addIn(9, new Node<Integer>(41));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		list.showList();

		list.insertAfter(11, 100);
		list.insertAfter(0, 1000);
		list.insertAfter(4, 10000);
		list.showList();
		
		
		list.insertBefore(0, 7500);
		list.insertBefore(21, 87);
		list.insertBefore(10000, 456);
		list.insertBefore(4, 74);
		list.showList();
	}
}
