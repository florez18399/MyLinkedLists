package models;

import java.util.Comparator;

public class MyCircularList<T> extends MyLinkedList<T> {
	private Comparator<T> comparator;

	public MyCircularList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public void addNode(Node<T> newNode) {
		if(getHead() != null) {
			Node<T> actual = getHead();
			while(comparator.compare(actual.getNextNode().getInfo(), getHead().getInfo()) != 0) {
				actual = actual.getNextNode();
			}
			newNode.setNextNode(getHead());
			actual.setNextNode(newNode);
		}else {
			setHead(newNode);
			getHead().setNextNode(getHead());
		}
	}
	
	
	@Override
	public int size() {
		Node<T> actual = getHead();
		int count = getHead() != null ? 1:0;
		actual = actual.getNextNode();
		while(comparator.compare(getHead().getInfo(), actual.getInfo()) != 0) {
			count++;
			actual = actual.getNextNode();
		}
		return count;
	}
	
	
	@Deprecated
	public void addIn(int position, Node<T> newNode) {
		// TODO Auto-generated method stub
		super.addIn(position, newNode);
	}
	
	
	@Deprecated
	public void showList() {
		super.showList();
	}
}
