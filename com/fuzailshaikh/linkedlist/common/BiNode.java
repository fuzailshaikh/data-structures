package com.fuzailshaikh.linkedlist.common;

public class BiNode<T> {
	public T data;
	public BiNode<T> next;
	public BiNode<T> previous;

	public BiNode(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}