/**
 * @author Andrés Felipe Flórez Caro
 * @version 1.0
 * Estructuras de datos : Lista de prioridad, Requiere un comparador 
 * 
 */
package models;

import java.util.Comparator;

public class MyProrityList<T> extends MyLinkedList<T> {
	private Comparator<T> comparator;

	public MyProrityList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public MyProrityList() {
	}

	public void addNode(Node<T> nodeToAdd) {
		if (getHead() != null) {
			if (comparator.compare(getHead().getInfo(), nodeToAdd.getInfo()) < 0) {
				nodeToAdd.setNextNode(getHead());
				setHead(nodeToAdd);
				return;
			} else {
				Node<T> nodeActual = new Node<T>(null, getHead());
				while (nodeActual.getNextNode() != null) {
					if (comparator.compare(nodeActual.getNextNode().getInfo(), nodeToAdd.getInfo()) < 0) {
						nodeToAdd.setNextNode(nodeActual.getNextNode());
						nodeActual.setNextNode(nodeToAdd);
						return;
					}
					nodeActual = nodeActual.getNextNode();
				}
				nodeActual.setNextNode(nodeToAdd);
			}
		} else {
			setHead(nodeToAdd);
		}
	}

	@Deprecated
	public void addIn(int position, Node<T> newNode) {
	}
	
	@Deprecated
	public void insertAfter(T infoBefore, T infoToAdd) {
	}
	
	@Deprecated	
	public void insertBefore(T infoNext, T infoToAdd) {
	}
	
	
	@Override
	public int size() {
		return super.size();
	}
	
	

	public void showList() {
		System.out.println("--------------------------");
		Node<T> node = getHead();
		while (node != null) {
			System.out.println(node.getInfo());
			node = node.getNextNode();
		}
		System.out.println("--------------------------");
	}
}
