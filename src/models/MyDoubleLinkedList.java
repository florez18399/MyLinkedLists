package models;

import java.util.Comparator;

public class MyDoubleLinkedList<T> {
	private DoubleNode<T> head;
	private Comparator<T> comparator;

	public MyDoubleLinkedList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public void add(DoubleNode<T> nodeToAdd) {
		if (head != null) {
			DoubleNode<T> actual = head;
			while (actual.getAfter() != null) {
				actual = actual.getAfter();
			}
			nodeToAdd.setBefore(actual);
			actual.setAfter(nodeToAdd);
		} else {
			head = nodeToAdd;
		}
	}

	/**
	 * Agrega un nodo doble después de otro especificado
	 * 
	 * @param infoBefore
	 *            Se agregará al siguiente del que contenga esta información
	 * @param infoToAdd
	 *            Contenido a agregar
	 */
	public void insertAfter(T infoBefore, T infoToAdd) {
		DoubleNode<T> nodeBefore = searchDoubleNode(infoBefore);
		if (nodeBefore != null) {
			DoubleNode<T> nodeToAdd = new DoubleNode<T>(nodeBefore.getAfter(), nodeBefore, infoToAdd);
			nodeBefore.setAfter(nodeToAdd);
			if (nodeToAdd.getAfter() != null) {
				nodeToAdd.getAfter().setBefore(nodeToAdd);
			}
		} else {
			throw new NullPointerException();
		}
	}

	/**
	 * Agrega un nodo doble antes de otro especificado
	 * 
	 * @param infoAfter
	 *            Se agregará al anterior del que contenga esta información
	 * @param infoToAdd
	 *            Contenido a agregar
	 */
	public void insertBefore(T infoAfter, T infoToAdd) {
		DoubleNode<T> nodeAfter = searchDoubleNode(infoAfter);
		if (nodeAfter != null) {
			DoubleNode<T> nodeToAdd = new DoubleNode<T>(nodeAfter, nodeAfter.getBefore(), infoToAdd);
			nodeAfter.setBefore(nodeToAdd);
			if (nodeToAdd.getBefore() != null) {
				nodeToAdd.getBefore().setAfter(nodeToAdd);
			} else {
				head = nodeToAdd;
			}
		} else {
			throw new NullPointerException();
		}
	}

	/**
	 * Agrega en la posición especificada
	 * 
	 * @param index
	 */
	public void addIn(int index, T infoToAdd) {
		DoubleNode<T> nodeInIndex = get(index);
		if (nodeInIndex != null) {
			DoubleNode<T> nodeToAdd = new DoubleNode<T>(nodeInIndex, nodeInIndex.getBefore(), infoToAdd);
			nodeInIndex.setBefore(nodeToAdd);
			if (nodeToAdd.getBefore() != null) {
				nodeToAdd.getBefore().setAfter(nodeToAdd);
			} else {
				head = nodeToAdd;
			}
		} else {
			throw new NullPointerException("La lista enlazada no tiene el índice especificado");
		}
	}

	private DoubleNode<T> searchDoubleNode(T infoToSearch) {
		DoubleNode<T> actual = head;
		while (actual != null) {
			if (comparator.compare(infoToSearch, actual.getInfo()) == 0) {
				return actual;
			}
			actual = actual.getAfter();
		}
		return null;
	}

	/**
	 * 
	 * @param index
	 *            Índice requerido
	 * @return El nodo doble que se encuntre en la posición especificada
	 */
	public DoubleNode<T> get(int index) {
		DoubleNode<T> actual = head;
		int count = 0;
		while (actual != null) {
			if (count == index) {
				return actual;
			} else {
				count++;
				actual = actual.getAfter();
			}
		}
		return null;
	}

	/**
	 * 
	 * @return El tamaño de la lista
	 */
	public int size() {
		int i = 0;
		DoubleNode<T> actual = head;
		while (actual != null) {
			i++;
			actual = actual.getAfter();
		}
		return i;
	}

	public void showLeftToRight() {
		System.out.println("------------");
		DoubleNode<T> actual = head;
		while (actual != null) {
			System.out.println(actual.getInfo());
			actual = actual.getAfter();
		}
		System.out.println("------------");
	}

	public void showRightToLeft() {
		System.out.println("------------");
		DoubleNode<T> actual = head;
		while (actual.getAfter() != null) {
			actual = actual.getAfter();
		}
		while (actual != null) {
			System.out.println(actual.getInfo());
			actual = actual.getBefore();
		}
		System.out.println("------------");
	}

	/**
	 * @return the head
	 */
	public DoubleNode<T> getHead() {
		return head;
	}

	/**
	 * @param head
	 *            the head to set
	 */
	public void setHead(DoubleNode<T> head) {
		this.head = head;
	}

}
