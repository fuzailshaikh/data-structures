package com.fuzailshaikh.linkedlist.common;

public class Node<T> implements INode<T> {
	private T data;
	private Node<T> next;

	public Node(T data) {
		this.data = data;
	}

	@Override
	public INode<T> getNext() {
		return next;
	}

	@Override
	public void setNext(INode<T> node) {
		this.next = (Node<T>) node;
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