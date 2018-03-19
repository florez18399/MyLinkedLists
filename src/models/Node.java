/**
 * @author Andrés Felipe Flórez Caro
 * @version 1.0
 * Estructuras de datos : Nodo, elemento necesario para la estructuración las diferentes listas
 * 
 */
package models;

public class Node<T> {

	private T info;
	private Node<T> nextNode;

	public Node(T info, Node<T> nextNode) {
		this.info = info;
		this.nextNode = nextNode;
	}

	/**
	 * @return the nextNode
	 */
	public Node<T> getNextNode() {
		return nextNode;
	}

	public Node(T info) {
		this.info = info;
	}

	/**
	 * @param nextNode
	 *            the nextNode to set
	 */
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	/**
	 * @return the info
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * @param info
	 *            the info to set
	 */
	public void setInfo(T info) {
		this.info = info;
	}

}
