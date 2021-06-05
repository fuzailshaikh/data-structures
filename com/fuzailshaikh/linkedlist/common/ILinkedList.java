package com.fuzailshaikh.linkedlist.common;

public interface ILinkedList<T> {
	INode<T> getHead();

	void addNodeInEnd(INode<T> node);
	void addNodeInFront(INode<T> node);
	boolean removeNode(INode<T> node);
	int indexOf(T data);
	int size();

	default boolean contains(T data) {
		return indexOf(data) != -1;
	}
}
