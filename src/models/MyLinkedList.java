/**
 * @author Andrés Felipe Flórez Caro
 * @version 1.0
 * Estructuras de datos : Lista simplemente enlazada, Requiere un comparador 
 * 
 */
package models;

import java.util.Comparator;

public class MyLinkedList<T> {

	private Node<T> head;
	private Comparator<T> comparator;

	public MyLinkedList() {
	}

	public MyLinkedList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public MyLinkedList(Node<T> head) {
		this.head = head;
	}

	public void addNode(Node<T> newNode) {
		Node<T> nodeActual = head;
		if (nodeActual != null) {
			while (nodeActual.getNextNode() != null) {
				nodeActual = nodeActual.getNextNode();
			}
			nodeActual.setNextNode(newNode);
		} else {
			addToHead(newNode);
		}
	}

	private void addToHead(Node<T> newNode) {
		newNode.setNextNode(head);
		head = newNode;
	}

	/**
	 * Agrega un nodo en una posicion especifica
	 * 
	 * @param Posición
	 *            requerida
	 * @throws Exception
	 */
	public void addIn(int position, Node<T> newNode) {
		if (position != 1) {
			if (position <= size()) {
				Node<T> nodeActual = head;
				int count = 1;
				while (count < position - 1) {
					nodeActual = nodeActual.getNextNode();
					count++;
				}
				Node<T> nodeNext = nodeActual.getNextNode();
				nodeActual.setNextNode(newNode);
				nodeActual.getNextNode().setNextNode(nodeNext);
			}
		} else {
			addToHead(newNode);
		}
	}

	public void removeNode(T info) {
		System.out.println("Removiendo: " + info);
		Node<T> nodeActual = head;
		if (!info.equals(head.getInfo())) {
			while (comparator.compare(nodeActual.getNextNode().getInfo(), info) == 0) {
				System.out.println("Comparación: " + info + ":" + nodeActual.getNextNode().getInfo());
				nodeActual = nodeActual.getNextNode();
			}
			nodeActual.setNextNode(nodeActual.getNextNode().getNextNode());
		} else {
			head = head.getNextNode();
		}
	}

	/**
	 * Método para agregar antes de un nodo especifico
	 */
	public void insertBefore(T infoNext, T infoToAdd) {
		System.out.println("Insertará antes");
		Node<T> nodeActual = head;
		boolean isAdded = false;
		if (comparator.compare(infoNext, head.getInfo()) == 0) {
			System.out.println("Agrego a la cabeza");
			Node<T> node = new Node<T>(infoToAdd, head);
			head = node;
		} else {
			while (nodeActual != null && !isAdded) {
				if (comparator.compare(nodeActual.getNextNode().getInfo(), infoNext) == 0) {
					Node<T> nodeToAdd = new Node<T>(infoToAdd);
					nodeToAdd.setNextNode(nodeActual.getNextNode());
					nodeActual.setNextNode(nodeToAdd);
					isAdded = true;
				}
				nodeActual = nodeActual.getNextNode();
			}
			if (!isAdded) {
				throw new NullPointerException();
			}
		}
	}

	/**
	 * Método para agregar después de un nodo especifico
	 */
	public void insertAfter(T infoBefore, T infoToAdd) {
		Node<T> nodeActual = head;
		boolean isAdded = false;
		if (head == null) {
			head = new Node<T>(infoToAdd);
		} else {
			while (nodeActual != null && !isAdded) {
				if (comparator.compare(nodeActual.getInfo(), infoBefore) == 0) {
					Node<T> node = nodeActual.getNextNode();
					nodeActual.setNextNode(new Node<T>(infoToAdd));
					nodeActual.getNextNode().setNextNode(node);
					isAdded = true;
				}
				nodeActual = nodeActual.getNextNode();
			}
			if (!isAdded) {
				throw new NullPointerException();
			}
		}
	}

	/**
	 * @return El tamaño de la lista enlazada
	 */
	public int size() {
		int size = 0;
		Node<T> nodeActual = head;
		while (nodeActual != null) {
			size++;
			nodeActual = nodeActual.getNextNode();
		}
		return size;
	}

	public void showList() {
		System.out.println("--------------------");
		Node<T> nodeActual = head;
		while (nodeActual != null) {
			System.out.println(nodeActual.getInfo());
			nodeActual = nodeActual.getNextNode();
		}
		System.out.println("--------------------");
	}

	public void clear() {
		head = null;
	}

	public boolean contains(T content) {
		Node<T> nodeActual = head;
		while (nodeActual != null) {
			if (comparator.compare(nodeActual.getInfo(), content) == 0) {
				return true;
			}
			nodeActual = nodeActual.getNextNode();
		}
		return false;
	}

	public Node<T> get(int index) {
		if (index <= size()) {
			if (index == 1) {
				return head;
			} else {
				int count = 1;
				Node<T> nodeActual = head;
				while (count < index) {
					nodeActual = nodeActual.getNextNode();
					count++;
				}
				return nodeActual;
			}
		} else {
			return null;
		}
	}

	/**
	 * @return the head
	 */
	public Node<T> getHead() {
		return head;
	}

	/**
	 * @param head
	 *            the head to set
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}
}
