/**
 * @author Andrés Felipe Flórez Caro
 * @version 1.0
 * Estructuras de datos : Cola
 * 
 */
package models;

public class MyQueue<T> {

	private Node<T> head;

	public MyQueue() {

	}

	/**
	 * Método para desencolar, Saca el primer elemento de la cola, osea el primero
	 * que se agrego
	 * 
	 * @return
	 */
	public void enqueue(Node<T> node) {
		Node<T> nodeActual = head;
		if (head != null) {
			while (nodeActual.getNextNode() != null) {
				nodeActual = nodeActual.getNextNode();
			}
			nodeActual.setNextNode(node);
		} else {
			head = node;
		}
	}

	public int size() {
		int count = 0;
		Node<T> nodeActual = head;
		while (nodeActual != null) {
			count++;
			nodeActual = nodeActual.getNextNode();
		}
		return count;
	}

	public Node<T> dequeue() {
		Node<T> nodeToDequeue = head;
		head = head.getNextNode();
		return nodeToDequeue;
	}

	public Node<T> peek() {
		return head;
	}

	public boolean isEmpty() {
		return head == null ? true : false;
	}
}
