package models;

public class DoubleNode<T> {
	private DoubleNode<T> after;
	private DoubleNode<T> before;
	private T info;

	public DoubleNode(DoubleNode<T> after, DoubleNode<T> before, T info) {
		this.after = after;
		this.before = before;
		this.info = info;
	}

	public DoubleNode(T info) {
		this.info = info;
	}

	/**
	 * @return the after
	 */
	public DoubleNode<T> getAfter() {
		return after;
	}

	/**
	 * @param after
	 *            the after to set
	 */
	public void setAfter(DoubleNode<T> after) {
		this.after = after;
	}

	/**
	 * @return the before
	 */
	public DoubleNode<T> getBefore() {
		return before;
	}

	/**
	 * @param before
	 *            the before to set
	 */
	public void setBefore(DoubleNode<T> before) {
		this.before = before;
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
