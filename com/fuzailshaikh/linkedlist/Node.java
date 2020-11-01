package com.fuzailshaikh.linkedlist;

public class Node<T> {
	protected T data;
	protected Node<T> next;

	public Node(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}