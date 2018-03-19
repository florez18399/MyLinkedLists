package test;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import models.MyProrityList;
import models.Node;

public class TestListPrority {

	@Test
	public void addTest() {
		MyProrityList<Integer> list = new MyProrityList<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		list.addNode(new Node<Integer>(845));
		list.addNode(new Node<Integer>(12));
		list.addNode(new Node<Integer>(985));
		list.addNode(new Node<Integer>(-12));
		list.addNode(new Node<Integer>(1));
		list.addNode(new Node<Integer>(45));
		list.addNode(new Node<Integer>(55));
		list.addNode(new Node<Integer>(41));
		list.addNode(new Node<Integer>(1000));
		list.addNode(new Node<Integer>(999));
		list.showList();
		System.out.println(list.size());
	}
}
