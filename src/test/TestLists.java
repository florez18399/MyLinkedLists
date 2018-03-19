package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.MyQueue;
import models.MyStack;
import models.Node;

public class TestLists {
	@Test
	public void testQueue() {
		MyQueue<Integer> queue = new MyQueue<>();
		assertEquals(true, queue.isEmpty());
		queue.enqueue(new Node<Integer>(1));
		queue.enqueue(new Node<Integer>(2));
		queue.enqueue(new Node<Integer>(3));
		queue.enqueue(new Node<Integer>(4));
		assertEquals(false, queue.isEmpty());
		System.out.println("Desencolar: " + queue.dequeue().getInfo());
		System.out.println("Desencolar: " + queue.dequeue().getInfo());
		System.out.println("Desencolar: " + queue.dequeue().getInfo());
		System.out.println("Desencolar: " + queue.dequeue().getInfo());

	}

	@Test
	public void testMyStack() {
		MyStack<Integer> stack = new MyStack<>();
		assertEquals(true, stack.isEmpty());
		stack.push(new Node<Integer>(1));
		stack.push(new Node<Integer>(2));
		stack.push(new Node<Integer>(3));
		stack.push(new Node<Integer>(4));
		assertEquals(false, stack.isEmpty());
		System.out.println("Desapilar: " + stack.pop().getInfo());
		System.out.println("Desapilar: " + stack.pop().getInfo());
		System.out.println("Desapilar: " + stack.pop().getInfo());
		System.out.println("Desapilar: " + stack.pop().getInfo());
	}
}
