package com.fuzailshaikh.linkedlist.common;

public class BiNode<T> implements INode<T> {
	private T data;
	private BiNode<T> next;
	private BiNode<T> previous;

	public BiNode(T data) {
		this.data = data;
	}

	public INode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(INode<T> node) {
		this.previous = (BiNode<T>) node;
	}

	@Override
	public INode<T> getNext() {
		return next;
	}

	@Override
	public void setNext(INode<T> node) {
		this.next = (BiNode<T>) node;
	}

	@Override
	public T getValue() {
		return data;
	}

	@Override
	public void setValue(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}