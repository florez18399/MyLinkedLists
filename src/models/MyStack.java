/**
 * @author Andrés Felipe Flórez Caro
 * @version 1.0
 * Estructuras de datos : Pila
 * 
 */
package models;

public class MyStack<T> {
	private Node<T> head;

	public MyStack() {
	}

	public Node<T> pop() {
		Node<T> nodeToPop = head;
		head = head.getNextNode();
		nodeToPop.setNextNode(null);
		return nodeToPop;
	}

	public void push(Node<T> node) {
		if (head != null) {
			node.setNextNode(head);
			head = node;
		} else {
			head = node;
		}
	}

	public Node<T> peek() {
		return head;
	}

	public boolean isEmpty() {
		return head == null ? true : false;
	}

	public int size() {
		int count = 0;
		Node<T> nodeActual = head;
		while (nodeActual != null) {
			count++;
		}
		return count;
	}
}
